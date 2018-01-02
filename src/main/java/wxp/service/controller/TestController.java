package wxp.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/test")
public class TestController {

    /*@GetMapping(path = "/index")
    public ModelAndView test(){
        ModelAndView mv=new ModelAndView("index");
        return mv;
    }*/

}
