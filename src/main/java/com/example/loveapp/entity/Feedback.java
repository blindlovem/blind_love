package com.example.loveapp.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("feedback")
public class Feedback {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "user_id")
    private String userId;

    @TableField(value = "word_id")
    private Integer wordId;

    @TableField(value = "islike")
    private Integer islike;
}
