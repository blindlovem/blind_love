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
 * 提供一个按钮，当用户点击时，会随机找出三句情话，用户进行选择
 * </p>
 *
 * @author yuyu6
 * @since 2023-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_sendword")
public class Sendword implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 发送用户
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 情话
     */
    @TableField(value = "word_id")
    private Integer wordId;

    /**
     * 用户选择情话记录
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 接收用户
     */
    @TableField(value = "received_id")
    private String receivedId;



}
