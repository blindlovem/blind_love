package com.example.loveapp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 展示表：我要爆照。用户可以选择是否公开自己进行爆照
 * </p>
 *
 * @author yuyu6
 * @since 2023-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_showself")
public class Showself implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 展示用户
     */
    @TableField(value = "user_id")
    private String user_id;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Integer id;

    /**
     * 详细信息
     */
    private String dept;

    /**
     * 开始时间
     */
    private String show_time;

    /**
     * 持续时间，最大为1天
     */
    private String dur_time;


}
