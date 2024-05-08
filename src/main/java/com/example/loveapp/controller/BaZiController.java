package com.example.loveapp.controller;


import com.example.loveapp.service.IUserService;
import com.example.loveapp.util.bazi.fuben.BaZi;
import com.example.loveapp.util.bazi.fuben.LuozhuangTanZao;
import com.example.loveapp.util.bazi.fuben.LuozhuangshenshaHehun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 实现八字算命控制
 */

@RestController
@RequestMapping("/bazi")
public class BaZiController {

    @Autowired
    IUserService userService;



    @GetMapping("/{id}")
    public ResponseEntity<Map<String, List<String>>> getBaziById(@PathVariable String id) throws ParseException {
        Map<String, List<String>> response = new HashMap<>();

        Date birthday =  userService.getById(id).getBirthday();
        String bazi = userService.getById(id).getBazi();

        // 格式化生日
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedBirthday = dateFormat.format(birthday);

        // 格式化八字
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH");
        String formattedBazi = String.format("%02d", Integer.parseInt(bazi));

        // 合并生日和八字
        String mergedString = formattedBirthday + " " + formattedBazi;

        SimpleDateFormat dateFormat1Format = new SimpleDateFormat("yyyy-MM-dd HH");
        java.util.Date parsedDate = dateFormat1Format.parse(mergedString);

        Calendar cal = Calendar.getInstance();
        cal.setTime(parsedDate);

        LuozhuangTanZao test = new LuozhuangTanZao();
        String bazi1 = test.paipan(mergedString);
        List<String> resultList1 = new ArrayList<>();
        resultList1.add(bazi1);
        response.put("result1", resultList1);

        LuozhuangshenshaHehun t = new LuozhuangshenshaHehun();
        String bazi2 = t.ceyixia(mergedString);
        List<String> resultList2 = new ArrayList<>();
        resultList2.add(bazi2);
        response.put("result2", resultList2);

        BaZi lunar = new BaZi(cal);
        String a1 = "【" + lunar.toString() + "】";
        String a2 = "【" + lunar.getYearGanZhi(cal.get(Calendar.HOUR_OF_DAY) / 2) + "】";
        String a3 = "【" + lunar.animalsYear() + "】";

        List<String> resultList3 = new ArrayList<>();
        resultList3.add(a1);
        response.put("result3", resultList3);

        List<String> resultList4 = new ArrayList<>();
        resultList4.add(a2);
        response.put("result4", resultList4);

        List<String> resultList5 = new ArrayList<>();
        resultList5.add(a3);
        response.put("result5", resultList5);

        return ResponseEntity.ok(response);
    }

}
