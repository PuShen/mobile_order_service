package wxp.service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
