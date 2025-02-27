package cn.mayanan.plusapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.mayanan.plusapi.model.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    // 自定义方法（如果有的话）

    // 获取单个用户以及对应的部门数据
    User getUseById(int id);
    // 查询多个用户以及对应的部门数据
    List<User> getUsers();
}
