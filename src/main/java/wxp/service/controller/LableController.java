package wxp.service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wxp.service.dao.LabelDAO;
import wxp.service.entity.Label;

import java.util.List;

@RestController
@RequestMapping("/label")
@Api(value = "基础标签信息API")
public class LableController {
    @Autowired
    private LabelDAO labelDAO;

    @RequestMapping(path = "/labellist")
    @ApiOperation(value = "获取标签列表")
    public ResponseEntity<List<Label>> getDesknoList(){
        return new ResponseEntity<List<Label>>(labelDAO.getLabelList(), HttpStatus.OK);
    }
}
