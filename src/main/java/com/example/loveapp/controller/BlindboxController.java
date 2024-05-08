package com.example.loveapp.controller;


import com.example.loveapp.entity.Blindbox;
import com.example.loveapp.service.IBlindboxService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器  投缘使用！！！！
 *
 *  提供：添加记录；查询记录；删除记录。
 *
 *
 * </p>
 *
 * @author yuyu6
 * @since 2023-05-02
 */
@RestController
@RequestMapping("/blindbox")
public class BlindboxController {
    @Autowired
    private IBlindboxService blindboxService;

    /**
     * 添加投递的盲盒记录
     * @param blindbox 待添加
     * @return 返回是否成功
     */
    @PostMapping
    public boolean save(@RequestBody Blindbox blindbox){
     return blindboxService.save(blindbox);
    }

    /**
     * 查询用户id对应的投递记录
     * @param id 指定用户
     * @return  返回列表：投递记录
     */
    @GetMapping("/{id}")
    public List<Blindbox> selectById(@PathVariable String id){
        return blindboxService.selectById(id);
    }


    /**
     * 删除指定的盲盒（根据盲盒id删除）即：删除一条投递记录
     * @param id 指定
     * @return  成功否
     */
    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Integer id){
        return blindboxService.removeById(id);
    }



}

