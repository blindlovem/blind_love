package com.example.loveapp.entity;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("collection")
public class Collection {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "user_id")
    private String userId;

    @TableField(value = "ad_id")
    private Integer adId;

    @TableField(value = "create_at")
    private String createAt;

    @TableLogic
    private Integer deleted;
}
