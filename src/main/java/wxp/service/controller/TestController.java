package wxp.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static wxp.service.util.util.constructId;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping(path = "/test")
    public String test(){
        System.out.println("测试接口畅通！");
        List<String> list=new ArrayList<>();
        list.add("小炒肉");
        list.add("麦家小馆");
        return constructId(list);
    }

}
