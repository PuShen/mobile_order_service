package wxp.service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wxp.service.dao.DesknoDAO;
import wxp.service.entity.Desk;

import java.util.List;

@RestController
@RequestMapping("/deskno")
@Api(value = "基础桌号信息API")
public class DesknoController {
    @Autowired
    private DesknoDAO desknoDAO;

    @RequestMapping(path = "/desknolist")
    @ApiOperation(value = "获取桌号列表")
    public ResponseEntity<List<Desk>> getDesknoList(){
        return new ResponseEntity<List<Desk>>(desknoDAO.getDesknoList(), HttpStatus.OK);
    }

    @PostMapping(path = "/insertdeskno")
    @ApiOperation(value = "插入桌号")
    public ResponseEntity<String> insertDeskno(@RequestParam String no,
                                               @RequestParam String capacity){
        Desk desk=new Desk();
        desk.setRestaurant("麦家小馆");
        desk.setNo(no);
        desk.setCapacity(Integer.parseInt(capacity));
        if (desknoDAO.insertDeskno(desk)==1){
            return new ResponseEntity<String>("OK",HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("插入失败！",HttpStatus.OK);
        }
    }

    @PostMapping(path = "/deletedeskno")
    @ApiOperation(value = "删除桌号")
    public ResponseEntity<String> deleteDeskno(@RequestParam String no){
        if (desknoDAO.deleteDeskno(no)==1){
            return new ResponseEntity<String>("OK",HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("删除失败！",HttpStatus.OK);
        }
    }
}
