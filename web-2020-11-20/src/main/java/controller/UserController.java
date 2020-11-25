package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Real_estateExample;
import pojo.User;
import pojo.UserExample;
import service.Real_estateService;
import service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author shkstart
 * @create 2020-11-20 15:00
 */
@Controller
public class UserController {
    @Resource
    UserService userService;
    @Resource
    Real_estateService real_estateService;

    @RequestMapping("login/{cardId}/{password}.do")
    @ResponseBody
    public User login(@PathVariable("cardId") String cardId, @PathVariable("password") String password, HttpSession session) {
        System.out.println("进入");
        UserExample example = new UserExample();
        example.createCriteria().andCardidEqualTo(cardId).andPasswordEqualTo(password);
        if (userService.selectUser(example) != null) {
            session.setAttribute("user", userService.selectUser(example));
        }
        System.out.println(userService.selectUser(example));
        return userService.selectUser(example);
    }

    @RequestMapping("check/{carId}/{name}/{password}.do")
    @ResponseBody
    public Integer check(@PathVariable("carId") String carId, @PathVariable("name") String name, @PathVariable("password") String password) {
        User user = new User(carId, name, password);
        user.setCreatetime(new Date());
        return userService.insertSelective(user);
    }

    @RequestMapping("list.do")
    public String list(String type, String content, String pageNum, String pageSize, Model model) {
        Integer num = 1;
        Integer size = 3;
        if(pageNum != null){
            num = Integer.parseInt(pageNum);
        }
        if(pageSize != null){
            size = Integer.parseInt(pageSize);
        }
        if (type == null || content == "") {
            model.addAttribute("pageList",real_estateService.selectReal(null, num, size));
            return "index02";
        }
        Real_estateExample example = new Real_estateExample();
        if (Integer.parseInt(type) == 2) {
            example.createCriteria().andCardidLike("%"+content+"%");
            model.addAttribute("pageList",real_estateService.selectReal(example,num,size));
            return "index02";
        } else {
            example.createCriteria().andProjectnameLike("%"+content+"%");
            model.addAttribute("pageList",real_estateService.selectReal(example,num,size));
            return "index02";
        }
    }
}
