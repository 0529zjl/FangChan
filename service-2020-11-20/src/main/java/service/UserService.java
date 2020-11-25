package service;

import pojo.User;
import pojo.UserExample;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-11-20 15:00
 */
public interface UserService {
    List<User> selectByExample(UserExample example);

    User selectUser(UserExample example);

    int insertSelective(User record);
}
