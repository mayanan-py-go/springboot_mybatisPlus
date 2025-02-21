package cn.mayanan.plusapi.service;

import cn.mayanan.plusapi.mapper.UserMapper;
import cn.mayanan.plusapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    // 获取所有用户
    public List<User> getAllUsers() {
        return userMapper.selectList(null);
    }

    // 根据ID查询用户
    public User getUserById(Integer id) {
        return userMapper.selectById(id);
    }

    // 添加用户
    public void addUser(User user) {
        userMapper.insert(user);
    }

    // 更新用户
    public void updateUser(User user) {
        userMapper.updateById(user);
    }

    // 删除用户
    public void deleteUser(Integer id) {
        userMapper.deleteById(id);
    }
}
