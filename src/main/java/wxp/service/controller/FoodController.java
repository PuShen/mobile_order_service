package wxp.service.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import wxp.service.dao.FoodDAO;
import wxp.service.entity.Food;

import java.util.List;

@RestController
@RequestMapping("/food")
@Api(value = "基础菜单信息API")
public class FoodController {
    @Autowired
    private FoodDAO foodDAO;

    @GetMapping(path = "/foodlist")
    @ApiOperation(value = "获取菜单列表")
    public ResponseEntity<List<Food>> getFoodList(){
        return new ResponseEntity<List<Food>>(foodDAO.getFoodList(), HttpStatus.OK);
    }

    @GetMapping(path = "/index")
    @ApiOperation(value = "获取菜单列表的视图")
    public ModelAndView getFoodListView(){
        ModelAndView mv=new ModelAndView("index");
        mv.addObject("foodlist",foodDAO.getFoodList());
        return mv;
    }

    @GetMapping(path = "/insertfood")
    @ApiOperation(value = "插入菜品")
    public String insertFood(@RequestParam String name,
                             @RequestParam String imageUrl,
                             @RequestParam String practice,
                             @RequestParam String description,
                             @RequestParam String price,
                             @RequestParam String number,
                             @RequestParam String restaurant){
        Food food=new Food();
        food.setName(name);
        food.setImageUrl(imageUrl);
        food.setPractice(practice);
        food.setDescription(description);
        food.setPrice(Double.parseDouble(price));
        food.setNumber(Integer.parseInt(number));
        food.setRestaurant(restaurant);
        if (foodDAO.insertFood(food)==1){
            return "OK";
        }else {
            return "error";
        }
    }
}
