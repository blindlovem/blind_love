package com.example.loveapp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.loveapp.entity.Romantic;
import com.example.loveapp.mapper.RomanticMapper;
import com.example.loveapp.service.IRomanticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * <p>
 * 情话表：每天提供用户3句话，用户可以选择其中的1句发送出去。 提供功能：用户可以提供情话给我们，当相似度低于0.6一下加入。 服务实现类
 * </p>
 *
 * @author yuyu6
 * @since 2023-05-18
 */
@Service
public class RomanticServiceImpl extends ServiceImpl<RomanticMapper, Romantic> implements IRomanticService {

    @Autowired
    RomanticMapper romanticMapper;

    /**
     * 根据随机生成的三个id
     * 查询得到三局情话
     * @return
     */
    public List<Romantic> getThrWords() {
        Random random = new Random();
        int x = random.nextInt(41);
        int y, z;
        int t = random.nextInt(41);
        while (t == x){
            t = random.nextInt(41);
        }
        y = t;
        while (t == y){
            t = random.nextInt(41);
        }
        z = t;

        return romanticMapper.getThrWords(x,y,z);
    }
}
