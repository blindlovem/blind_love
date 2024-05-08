package com.example.loveapp.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.sql.Date;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuyu6
 * @since 2023-05-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_user")
public class User implements Serializable {

    //private static final long serialVersionUID = 1L;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 微信号
     */
    @TableField(value = "wechat_id")
    private String wechatId;

    /**
     * 性别
     */
    private String sex;

    /**
     * 性取向
     */
    @TableField(value = "sexual_orie")
    private String sexualOrie;//sexualOrie;

    /**
     * 所在位置
     */
    private String location;

    /**
     * 爱好
     */
    private String hobbies;

    /**
     * 性格
     */
    private String personality;

    /**
     * 照片
     */
    @TableField(value = "photo_path")
    private String photoPath;

    /**
     * 主键
     */
    //@TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 创建时间
     */
    @TableField(value = "created_at")
    private String createdAt;

    /**
     * 更新时间
     */
    @TableField(value = "updated_at")
    private String updatedAt;

    /**
     * 期望性格
     */
    private String expectation;

    /**
     * 期望位置 TODO 此处可能有错，注意数据库
     */
    private String locationOrie;

    /**
     * 生辰八字
     */
    private String bazi;

    @TableLogic
    private Integer deleted;

    @Version
    private Integer version;

    private Date birthday;

    private Integer age;

    private String url;



}
