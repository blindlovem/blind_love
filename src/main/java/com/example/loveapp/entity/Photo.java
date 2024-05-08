package com.example.loveapp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

//TODO :此处要在数据库中加入相应字段
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_photo")
public class Photo {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;
    private String description;
    private String path;

    @TableField(value = "user_id")
    private String userId;
}
