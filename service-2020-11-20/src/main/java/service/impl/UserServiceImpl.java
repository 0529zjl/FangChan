package service.impl;

import com.kgc.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;
import pojo.UserExample;
import service.UserService;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-11-20 15:00
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> selectByExample(UserExample example) {
        return userMapper.selectByExample(example);
    }

    @Override
    public User selectUser(UserExample example) {
        List<User> users = userMapper.selectByExample(example);
        if (users.size() > 0 && users != null){
            return users.get(0);
        } else {
            return null;
        }
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }
}
