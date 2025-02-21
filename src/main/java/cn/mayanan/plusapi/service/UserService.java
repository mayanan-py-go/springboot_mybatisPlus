package cn.mayanan.plusapi.service;

import cn.mayanan.plusapi.mapper.UserMapper;
import cn.mayanan.plusapi.model.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    // 分页查询
    public Page<User> getUserPage(Integer pageNum, Integer pageSize) {
        // 创建分页对象
        Page<User> page = new Page<>(pageNum, pageSize);
        // 查询条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age", 18);
        // 分页查询
        return userMapper.selectPage(page, queryWrapper);
    }
}









