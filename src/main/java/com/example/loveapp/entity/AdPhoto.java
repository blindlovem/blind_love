package com.example.loveapp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

//TODO :此处要在数据库中加入相应字段
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ad_photo")
public class AdPhoto {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    @TableField(value = "ad_id")
    private String adId;


    @TableField(value = "photo_path")
    private String photoPath;
}
