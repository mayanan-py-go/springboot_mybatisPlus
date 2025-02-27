package cn.mayanan.plusapi.controller;


import cn.mayanan.plusapi.model.User;
import cn.mayanan.plusapi.controller.LoginRequest;
import cn.mayanan.plusapi.service.UserService;
import cn.mayanan.plusapi.utils.JwtUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // 获取所有用户
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // 根据ID获取用户
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    // 添加用户
    @PostMapping
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "用户添加成功";
    }

    // 更新用户
    @PutMapping("/{id}")
    public String updateUser(@PathVariable Integer id, @RequestBody User user) {
        user.setId(id);
        userService.updateUser(user);
        return "用户更新成功";
    }

    // 删除用户
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "用户删除成功";
    }

    // 分页查询
    @GetMapping("/page")
    public Page<User> getUserPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        // getRecords: 获取当前页的数据
        // getTotal: 获取总记录数
        // return userService.getUserPage(pageNum, pageSize).getRecords();
        return userService.getUserPage(pageNum, pageSize);
    }

    // 用户登录
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        boolean success = userService.login(loginRequest.getName(), loginRequest.getPassword());
        System.out.println("success");
        System.out.println(success);
        if (success) {
            // 登录成功，生成token
            String token = JwtUtil.genAccessToken(loginRequest.getName());
            System.out.println("token: " + token);
            return new LoginResponse("success", token);
        } else {
            return new LoginResponse("fail", null);
        }
    }

    // 用户和部门关联查询
    @GetMapping("/userAndDepartment")
    public User getUserAndDepartment(@RequestParam Integer id) {
        User user = userService.getUserAndDepartment(id);
        System.out.println("===================");
        System.out.println(user);
        System.out.println("===================");
        return user;
    }
    // 查询多个用户以及对应的部门数据
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }
}










