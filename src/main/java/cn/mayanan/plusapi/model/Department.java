package cn.mayanan.plusapi.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("department")
public class Department {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("name")
    private String name;
}








