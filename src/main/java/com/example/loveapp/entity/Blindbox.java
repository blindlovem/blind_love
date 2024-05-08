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
@TableName("tb_blindbox")
public class Blindbox implements Serializable {

    //private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

//    private Integer user_id;
//
//    private String create_at;

    @TableField(value = "user_id")
    private String userId;

    @TableField(value = "create_at")
    private String createAt;

    /**
     * 被选择的次数
     */
    private Integer selected;

    @TableLogic
    private Integer deleted;

    @Version
    private Integer version;


}
