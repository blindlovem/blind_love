package com.example.loveapp.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@TableName("tb_pickrecord")
public class Pickrecord implements Serializable {

   // private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 寻找者
     */
    @TableField(value = "picker_id")
    private String pickerId;

    /**
     * 被寻找者
     */
    @TableField(value = "picked_id")
    private String pickedId;

    /**
     * 创建时间
     */
    @TableField(value = "create_at")
    private String createAt;

    /**
     * 订单金额
     */
    private String money;

    /**
     * 选用匹配算法
     */
    private String method;    //TODO 数据库此处设计不合理

    @Version
    private Integer version;

    @TableLogic
    private Integer deleted;


}
