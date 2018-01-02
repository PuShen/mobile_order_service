package wxp.service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wxp.service.dao.DesknoDAO;

import java.util.List;

@RestController
@RequestMapping("/deskno")
@Api(value = "基础桌号信息API")
public class DesknoController {
    @Autowired
    private DesknoDAO desknoDAO;

    @GetMapping(path = "/desknolist")
    @ApiOperation(value = "获取桌号列表")
    public ResponseEntity<List<String>> getDesknoList(){
        return new ResponseEntity<List<String>>(desknoDAO.getDesknoList(), HttpStatus.OK);
    }
}
