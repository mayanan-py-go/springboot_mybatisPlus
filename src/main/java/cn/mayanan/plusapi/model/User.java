package cn.mayanan.plusapi.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("user02")  // 映射数据库表
public class User {
    @TableId(type= IdType.AUTO)  // 主键
    private Integer id;
    @TableField("name")  // 映射数据库的字段名
    private String name;
    @TableField("age")
    private Integer age;
    @TableField("password")
    private String password;
    @TableField(exist = false)  // 表示该字段不是数据库表中的字段
    private Department depart;  // 部门信息
}

