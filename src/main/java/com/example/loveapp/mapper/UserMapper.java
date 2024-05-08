package com.example.loveapp.mapper;

import com.example.loveapp.entity.Blindbox;
import com.example.loveapp.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yuyu6
 * @since 2023-05-02
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
