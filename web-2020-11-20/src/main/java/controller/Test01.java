package controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

/**
 * @author shkstart
 * @create 2020-11-20 15:09
 */
@Controller
public class Test01 {
    @Autowired
    UserService userService;

    @RequestMapping("login.do")
    public void test01(){
        System.out.println(userService);
    }

//    @Test
//    public void test(){
//        System.out.println(userService);
//    }
}
