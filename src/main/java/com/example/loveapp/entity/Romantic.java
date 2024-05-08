package com.example.loveapp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 情话表：每天提供用户3句话，用户可以选择其中的1句发送出去。 提供功能：用户可以提供情话给我们，当相似度低于0.6一下加入。
 * </p>
 *
 * @author yuyu6
 * @since 2023-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_romantic")
public class Romantic implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 情话表主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 每一句情话内容
     */
    private String dept;

    /**
     * 状态：1为中文，0为英文
     */
    private Integer status;

    private String tag;

}
