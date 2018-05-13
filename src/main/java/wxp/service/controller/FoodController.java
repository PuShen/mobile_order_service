package wxp.service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wxp.service.dao.DesknoDAO;
import wxp.service.dao.FoodDAO;
import wxp.service.dao.OrderDetailsDAO;
import wxp.service.entity.Desk;
import wxp.service.entity.Food;
import wxp.service.entity.Order;
import wxp.service.entity.OrderDetails;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/food")
@Api(value = "基础菜单信息API")
public class FoodController {
    @Autowired
    private FoodDAO foodDAO;

    @Autowired
    private DesknoDAO desknoDAO;

    @Autowired
    private OrderDetailsDAO orderDetailsDAO;

    @Value("${web.upload-path}")
    private String imageLocation;

    @RequestMapping(path = "/foodlist")
    @ApiOperation(value = "获取菜单列表")
    public ResponseEntity<List<Food>> getFoodList(){
        return new ResponseEntity<List<Food>>(foodDAO.getFoodList(), HttpStatus.OK);
    }

    @RequestMapping(path = "/foodOfId")
    @ApiOperation(value = "获取ID组的菜品")
    public ResponseEntity<List<Food>> getFoodOfId(@RequestParam String idList){
        List<String> list= Arrays.stream(idList.split(",")).collect(Collectors.toList());
        return new ResponseEntity<List<Food>>(foodDAO.getFoodOfId(list), HttpStatus.OK);
    }

    @RequestMapping(path = "/foodById")
    @ApiOperation(value = "根据ID获取菜品信息")
    public ResponseEntity<Food> getFoodById(@RequestParam String id){
        List<Food> foods=foodDAO.getFoodById(id);
        if (foods.size()>=1){
            return new ResponseEntity<Food>(foodDAO.getFoodById(id).get(0), HttpStatus.OK);
        } else {
            return new ResponseEntity<Food>(new Food(), HttpStatus.OK);
        }
    }

    @RequestMapping(path = "/food")
    @ApiOperation(value = "获取特定标签下的菜品")
    public ResponseEntity<List<Food>> getFood(@RequestParam String labelId,
                                              @RequestParam int pageNum,
                                              @RequestParam int perNum){
        int startNum=(pageNum-1)*perNum;
        int endNum=perNum;
        return new ResponseEntity<List<Food>>(foodDAO.getFood(labelId,startNum,endNum), HttpStatus.OK);
    }

    @RequestMapping(path = "/placeOrder")
    @ApiOperation(value = "发起订单")
    public ResponseEntity<String> placeOrder(@RequestBody Order order){
        System.out.println(order.toString());
        Food[] foods=order.getOrderData();
        List<String> idList=Arrays.stream(foods).map(Food::getId).collect(Collectors.toList());
        List<Food> foodList=foodDAO.getFoodOfId(idList);
        List<Desk> deskList=desknoDAO.getDesknoList();
        Date date=new Date();

        //数据检验
        if (!deskList.stream().map(Desk::getNo).collect(Collectors.toList()).contains(order.getPosition())){
            return new ResponseEntity<>("不存在该桌号，请检查二维码",HttpStatus.OK);
        }
        for(Food food:foods){
            List<Food> list=foodList.stream().filter(data->data.getId().equals(food.getId())).collect(Collectors.toList());
            if (list.size()>0){
                int number=list.get(0).getNumber();
                if (food.getVareCount()>number){
                    return new ResponseEntity<>(food.getName()+"库存不足",HttpStatus.OK);
                }

            } else {
                return new ResponseEntity<>("该页面数据已失效，请刷新页面",HttpStatus.OK);
            }

        }

        //数据更新
        for (Food food:foods){
            Food baseFood=foodList.stream().filter(data->data.getId().equals(food.getId())).collect(Collectors.toList()).get(0);
            if (foodDAO.updateFoodNum(food.getId(),baseFood.getNumber()-food.getVareCount())!=1){
                return new ResponseEntity<>("点餐失败，请重试",HttpStatus.OK);
            }
            OrderDetails orderDetails=new OrderDetails();
            orderDetails.setName(food.getName());
            orderDetails.setNo(order.getPosition());
            orderDetails.setNum(food.getVareCount());
            orderDetails.setPractice(food.getPractice());
            orderDetails.setRestaurant(food.getRestaurant());
            orderDetails.setTotalPrice(food.getPrice()*food.getVareCount());
            orderDetails.setTime(date);
            if (orderDetailsDAO.insertOrderDetails(orderDetails)!=1){
                return new ResponseEntity<>("订单纪录插入失败，请重试",HttpStatus.OK);
            }
            System.out.println(orderDetails.toString());
        }
        return new ResponseEntity<>("OK",HttpStatus.OK);
    }
}
