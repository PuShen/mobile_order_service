package wxp.service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import wxp.service.dao.DesknoDAO;
import wxp.service.dao.FoodDAO;
import wxp.service.dao.LabelDAO;
import wxp.service.dao.OrderDetailsDAO;
import wxp.service.entity.Food;
import wxp.service.entity.OrderOverView;
import wxp.service.util.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")

@Api(value = "首页视图API")
public class IndexViewController {
    @Autowired
    private FoodDAO foodDAO;

    @Autowired
    private LabelDAO labelDAO;

    @Autowired
    private DesknoDAO desknoDAO;

    @Autowired
    private OrderDetailsDAO orderDetailsDAO;

    @Value("${web.upload-path}")
    private String imageLocation;

    @GetMapping(path = "/index")
    @ApiOperation(value = "获取首页视图")
    public ModelAndView getIndexView(){
        long recordNum=foodDAO.getFoodNum();
        long pageNum;
        if (recordNum%5==0&&recordNum/5!=0){
            pageNum=recordNum/5;
        }else if (recordNum%5!=0){
            pageNum=recordNum/5+1;
        }else {
            pageNum=1;
        }
        ModelAndView mv=new ModelAndView("index");
        mv.addObject("page","food_show.jsp");
        mv.addObject("foodlist",foodDAO.getFoodOfPage(0,5));
        mv.addObject("recordNum",recordNum);
        mv.addObject("pageNum",pageNum);
        return mv;
    }

    @GetMapping(path = "/index/foodlist")
    @ApiOperation(value = "获取菜单查询的视图")
    public ModelAndView getFoodListView(){
        long recordNum=foodDAO.getFoodNum();
        long pageNum;
        if (recordNum%5==0&&recordNum/5!=0){
            pageNum=recordNum/5;
        }else if (recordNum%5!=0){
            pageNum=recordNum/5+1;
        }else {
            pageNum=1;
        }
        ModelAndView mv=new ModelAndView("food_show");
        mv.addObject("foodlist",foodDAO.getFoodOfPage(0,5));
        mv.addObject("recordNum",recordNum);
        mv.addObject("pageNum",pageNum);
        return mv;
    }

    @GetMapping(path = "/index/stock")
    @ApiOperation(value = "获取菜单库存的视图")
    public ModelAndView getFoodStock(){
        long recordNum=foodDAO.getFoodNum();
        long pageNum;
        if (recordNum%5==0&&recordNum/5!=0){
            pageNum=recordNum/5;
        }else if (recordNum%5!=0){
            pageNum=recordNum/5+1;
        }else {
            pageNum=1;
        }
        ModelAndView mv=new ModelAndView("stock_manage");
        mv.addObject("foodlist",foodDAO.getFoodOfPage(0,5));
        mv.addObject("recordNum",recordNum);
        mv.addObject("pageNum",pageNum);
        return mv;
    }

    @GetMapping(path = "/index/foodpage")
    @ApiOperation(value = "获取菜单查询分页的视图")
    public ModelAndView getFoodListView(@RequestParam int pageNum,
                                        @RequestParam int perNum){
        int startNum=(pageNum-1)*perNum;
        int endNum=perNum;
        ModelAndView mv=new ModelAndView("table_page");
        mv.addObject("foodlist",foodDAO.getFoodOfPage(startNum,endNum));
        return mv;
    }

    @GetMapping(path = "/index/foodpaginationlist")
    @ApiOperation(value = "获取菜单查询分页的视图")
    public ModelAndView getFoodStock(@RequestParam int pageNum,
                                        @RequestParam int perNum){
        int startNum=(pageNum-1)*perNum;
        int endNum=perNum;
        ModelAndView mv=new ModelAndView("list_page");
        mv.addObject("foodlist",foodDAO.getFoodOfPage(startNum,endNum));
        return mv;
    }

    @GetMapping(path = "/index/addfood")
    @ApiOperation(value = "获取菜品添加的视图")
    public ModelAndView getAddFoodView(){
        ModelAndView mv=new ModelAndView("food_add");
        mv.addObject("label",labelDAO.getLabelList());
        return mv;
    }

    @PostMapping(path = "/index/insertfood")
    @ApiOperation(value = "插入菜品")
    public ResponseEntity<String> insertFood(@RequestParam String name,
                                             @RequestParam("imageUrl") MultipartFile imageUrl,
                                             @RequestParam String labelId,
                                             @RequestParam String practice,
                                             @RequestParam String description,
                                             @RequestParam String price){
        System.out.println("name:"+name+"\timageUrl:"+imageUrl.getOriginalFilename()+"\tpractice:"+practice+"\tdescription:"+description+"\tprice:"+price);
        String fileName= util.getUniqueFileName();
        Food food=new Food();
        food.setName(name);
        food.setImageUrl("/"+fileName);
        food.setPractice(practice);
        food.setDescription(description);
        food.setPrice(Double.parseDouble(price));
        food.setNumber(0);
        food.setRestaurant("麦家小馆");
        List<String> templist=new ArrayList<>();
        templist.add(food.getName());
        templist.add(food.getRestaurant());
        food.setId(util.constructId(templist));
        food.setLabelId(labelId);
        String imageUploadStatus="";
        if (!imageUrl.isEmpty()){
            BufferedOutputStream out=null;
            try {
                File file=new File(imageLocation+fileName);
                while (file.exists()){
                    fileName= util.getUniqueFileName();
                    file=new File(imageLocation+fileName);
                }
                out=new BufferedOutputStream(new FileOutputStream(file));
                out.write(imageUrl.getBytes());
                out.flush();
                imageUploadStatus="OK";
            } catch (IOException e) {
                imageUploadStatus="error:图片上传失败"+e.getMessage();
            } finally {
                if (out!=null){
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            food.setImageUrl("/"+fileName);
        }else {
            imageUploadStatus="error:找不到图片文件";
        }
        String insertStatus="";
        if (foodDAO.insertFood(food)==1){
            insertStatus="OK";
        }else {
            insertStatus="error:插入失败";
        }
        if ("OK".equals(imageUploadStatus)&&"OK".equals(insertStatus)){
            return new ResponseEntity<String>("OK",HttpStatus.OK);
        } else {
            return new ResponseEntity<String>(insertStatus,HttpStatus.OK);
        }
    }

    @PostMapping(path = "/index/deletefood")
    @ApiOperation(value = "根据ID删除菜品")
    public ResponseEntity<String> deleteFood(@RequestParam String id,
                                             @RequestParam String imageUrl){
        File file=new File(imageLocation+imageUrl.substring(1,imageUrl.length()));
        if (file.exists()){
            file.delete();
        }
        if (foodDAO.deleteFood(id)==1){
            return new ResponseEntity<String>("OK",HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("删除失败",HttpStatus.OK);
        }
    }

    @PostMapping(path = "/index/updatefood")
    @ApiOperation(value = "根据ID菜品修改")
    public ResponseEntity<String> updateFood(@RequestParam String id,
                                             @RequestParam String name,
                                             @RequestParam String imgUrl,
                                             @RequestParam("imageUrl") MultipartFile imageUrl,
                                             @RequestParam String labelId,
                                             @RequestParam String practice,
                                             @RequestParam String description,
                                             @RequestParam String price){

        System.out.println("name:"+name+"\timageUrl:"+imageUrl.getOriginalFilename()+"\tpractice:"+practice+"\tdescription:"+description+"\tprice:"+price);
        String fileName= util.getUniqueFileName();
        Food food=new Food();
        food.setName(name);
        food.setImageUrl(imgUrl);
        food.setPractice(practice);
        food.setDescription(description);
        food.setPrice(Double.parseDouble(price));
        food.setNumber(0);
        food.setRestaurant("麦家小馆");
        food.setId(id);
        food.setLabelId(labelId);
        String imageUploadStatus="";
        if (!imageUrl.isEmpty()){
            File imgFile=new File(imageLocation+imgUrl.substring(1,imgUrl.length()));
            if (imgFile.exists()){
                imgFile.delete();
            }
            BufferedOutputStream out=null;
            try {
                File file=new File(imageLocation+fileName);
                while (file.exists()){
                    fileName=util.getUniqueFileName();
                    file=new File(imageLocation+fileName);
                }
                out=new BufferedOutputStream(new FileOutputStream(file));
                out.write(imageUrl.getBytes());
                out.flush();
                imageUploadStatus="OK";
            } catch (IOException e) {
                imageUploadStatus="error:图片上传失败"+e.getMessage();
            } finally {
                if (out!=null){
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            food.setImageUrl("/"+fileName);
        }else {
            imageUploadStatus="OK";
        }
        String insertStatus="";
        if (foodDAO.updateFood(food)==1){
            insertStatus="OK";
        }else {
            insertStatus="error:插入失败";
        }
        if ("OK".equals(imageUploadStatus)&&"OK".equals(insertStatus)){
            return new ResponseEntity<String>("OK",HttpStatus.OK);
        } else {
            return new ResponseEntity<String>(insertStatus,HttpStatus.OK);
        }
    }

    @GetMapping(path = "/index/updatefoodview")
    @ApiOperation(value = "获取菜品更新视图")
    public ModelAndView getUpdateFoodView(@RequestParam String id){
        List<Food> foods=foodDAO.getFoodById(id);
        if (foods.size()>=1){
            ModelAndView mv=new ModelAndView("food_update");
            mv.addObject("label",labelDAO.getLabelList());
            mv.addObject("food",foods.get(0));
            return mv;
        } else {
            ModelAndView mv=new ModelAndView("error");
            mv.addObject("error","该菜品已经不在库中");
            return mv;
        }
    }

    @PostMapping(path = "/index/updatefoodnumber")
    @ApiOperation(value = "根据ID更新库存")
    public ResponseEntity<String> updateFoodNum(@RequestParam String id,
                                                @RequestParam int number){
        if (foodDAO.updateFoodNum(id,number)==1){
            return new ResponseEntity<>("OK",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("库存重置失败",HttpStatus.OK);
        }
    }

    @GetMapping(path = "/index/deskno")
    @ApiOperation(value = "获取桌号展示视图")
    public ModelAndView getDesknoView(){
        int perNum=15;
        long recordNum=desknoDAO.getDesknoNum();
        long pageNum;
        if (recordNum%perNum==0&&recordNum/perNum!=0){
            pageNum=recordNum/perNum;
        }else if (recordNum%perNum!=0){
            pageNum=recordNum/perNum+1;
        }else {
            pageNum=1;
        }
        ModelAndView mv=new ModelAndView("deskno_show");
        mv.addObject("desknolist",desknoDAO.getDesknoOfPage(0,perNum));
        mv.addObject("recordNum",recordNum);
        mv.addObject("pageNum",pageNum);
        return mv;
    }

    @GetMapping(path = "/index/desknopaginationlist")
    @ApiOperation(value = "获取桌号查询分页的视图")
    public ModelAndView getDesknoView(@RequestParam int pageNum,
                                     @RequestParam int perNum){
        int startNum=(pageNum-1)*perNum;
        int endNum=perNum;
        ModelAndView mv=new ModelAndView("grid_page");
        mv.addObject("desknolist",desknoDAO.getDesknoOfPage(startNum,endNum));
        return mv;
    }

    @GetMapping(path = "/index/adddeskno")
    @ApiOperation(value = "获取桌号添加的视图")
    public ModelAndView getAddDesknoView(){
        ModelAndView mv=new ModelAndView("deskno_add");
        return mv;
    }

    @GetMapping(path = "/index/orderpaginationlist")
    @ApiOperation(value = "获取订单展示分页的视图")
    public ModelAndView getOrderView(@RequestParam int pageNum,
                                     @RequestParam int perNum){
        int startNum=(pageNum-1)*perNum;
        int endNum=perNum;
        ModelAndView mv=new ModelAndView("list_order");
        mv.addObject("orderlist",orderDetailsDAO.selectOrder(startNum,endNum));
        return mv;
    }

    @GetMapping(path = "/index/order")
    @ApiOperation(value = "获取订单展示的视图")
    public ModelAndView getOrderView(){
        int perNum=5;
        long recordNum=orderDetailsDAO.getOrderNum();
        long pageNum;
        if (recordNum%perNum==0&&recordNum/perNum!=0){
            pageNum=recordNum/perNum;
        }else if (recordNum%perNum!=0){
            pageNum=recordNum/perNum+1;
        }else {
            pageNum=1;
        }
        ModelAndView mv=new ModelAndView("order_show");
        mv.addObject("orderlist",orderDetailsDAO.selectOrder(0,perNum));
        mv.addObject("recordNum",recordNum);
        mv.addObject("pageNum",pageNum);
        return mv;
    }
}
