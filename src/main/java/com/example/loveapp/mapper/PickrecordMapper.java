package com.example.loveapp.mapper;

import com.example.loveapp.entity.Pickrecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.loveapp.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yuyu6
 * @since 2023-05-02
 */
@Mapper
public interface PickrecordMapper extends BaseMapper<Pickrecord> {

    @Select("select * from tb_pickrecord,tb_user where tb_pickrecord.picker_id = #{id} and tb_pickrecord.picked_id = tb_user.id")
    public List<User> selectuserById(String id);


    //查询某个人所有匹配记录
    @Select("select * from tb_pickrecord where picker_id = #{id}")
    public List<Pickrecord> selectAllByPicker_idById(String id);

    /**
     * 得到用户选择的算法
     * @param id 1
     * @return 1
     */



}
