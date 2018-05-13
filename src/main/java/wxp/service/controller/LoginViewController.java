package wxp.service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wxp.service.dao.UserDao;
import wxp.service.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")

@Api(value = "登陆页视图API")
public class LoginViewController {
    @Autowired
    private UserDao userDao;

    @GetMapping(path = "/login")
    @ApiOperation(value = "获取首页视图")
    public String getLoginView(){
        return "login";
    }

    @PostMapping(path = "/validate")
    @ApiOperation(value = "登陆验证")
    public ResponseEntity<String> validate(@RequestParam String username,
                                           @RequestParam String password,
                                           HttpServletRequest request){
        List<User> users=userDao.getUserByUsername(username);
        if (users.size()==0){
            return new ResponseEntity<String>("用户名错误", HttpStatus.OK);
        } else {
            if (!users.get(0).getPassword().equals(password)){
                return new ResponseEntity<String>("密码错误", HttpStatus.OK);
            } else {
                request.getSession().setAttribute("username",username);
                return new ResponseEntity<String>("OK", HttpStatus.OK);
            }
        }
    }
}
