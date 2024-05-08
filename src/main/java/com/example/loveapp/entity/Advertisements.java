package com.example.loveapp.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("advertisements")
public class Advertisements implements Serializable{


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String title;

    private String description;

    @TableField(value = "imageurl")
    private String imageUrl;

    @TableField(value = "clickcount")
    private Integer clickCount;

    @TableField(value = "purchaseurl")
    private String purchaseUrl;

    @Version
    private Integer version;

    private Double price;
}