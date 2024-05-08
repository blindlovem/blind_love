package com.example.loveapp.controller;


import com.example.loveapp.entity.Blindbox;
import com.example.loveapp.entity.Pickrecord;
import com.example.loveapp.entity.Romantic;
import com.example.loveapp.entity.User;
import com.example.loveapp.service.IBlindboxService;
import com.example.loveapp.service.IPickrecordService;
import com.example.loveapp.service.IRomanticService;
import com.example.loveapp.service.IUserService;
import com.example.loveapp.util.age.AgeMatch;
import com.example.loveapp.util.bazi.details.WuXingApp;
import com.example.loveapp.util.constellation.ConstellationMatch;
import com.example.loveapp.util.location.LocationMatch;
import com.example.loveapp.util.nature.PersonalityMatch;
import com.example.loveapp.util.sex.SexMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * <p>
 *  前端控制器  提供匹配功能，匹配成功则自动保存记录！！
 * </p>
 *
 * @author yuyu6
 * @since 2023-05-02
 */
@RestController
@RequestMapping("/pickrecord")
public class PickrecordController {

    @Autowired
    IUserService userService;
    @Autowired
    IPickrecordService pickrecordService;

    @Autowired
    private IBlindboxService blindboxService;

    public static User u;

    /**
     * 点击查看显示
     * TODO 需要完善！
     * 寻缘：匹配，选出一个最佳对象(根据算法)
     *
     * @return 合适
     */
//    @GetMapping
//    public User findBestMatches(@RequestBody Pickrecord pickrecord){
//
//
//        List<User> userList = userService.selectAll();
//        String id = pickrecord.getPicker_id();
//        User user = userService.getById(id);
//
//        //保证匹配过的不会重复匹配到同一个人！
//        List<Pickrecord> pickeds = pickrecordService.selectAllByPicked_idById(id);
//        List<String> edIds = new ArrayList<>();
//        for (Pickrecord x : pickeds){
//            edIds.add(x.getPicked_id());
//        }
//
//        //更新列表
//        userList.removeIf(x -> edIds.contains(x.getId()));
//
//        //先进行性别匹配
//        List<User> sexMatchedList = SexMatch.findMatchedUsers(user, userList);
//        System.out.println(sexMatchedList);
//        //年龄匹配
//        List<User> ageMatchedList = AgeMatch.findMatchingUsers(user, sexMatchedList);
//        System.out.println(ageMatchedList);
//        //位置匹配
//        List<User> locationMatchedList = LocationMatch.findMatches(user, ageMatchedList);
//        System.out.println(locationMatchedList);
//        //性格匹配
//        List<User> personalMatchedList = PersonalityMatch.getBestMatches(user, locationMatchedList);
//        System.out.println(personalMatchedList);
//        String method = pickrecord.getMethod(); //基本匹配、星座匹配、//八字五行匹配
//        if (method.equals("基本匹配")){
//            user = personalMatchedList.get(0);
//        }else if (method.equals("星座匹配")){
//            List<User> users = ConstellationMatch.matchUsers(user, personalMatchedList);
//            user = users.get(0);
//        }else {
//            //1、五行匹配
//            List<User> matchesByBaZi = WuXingApp.findMatchesByBaZi(user, personalMatchedList);
//            user = matchesByBaZi.get(0);
//            // TODO 进行八字匹配
//        }
//
//     return user;
//    }


    /**
     *
     * 寻缘：匹配，选出一个最佳对象(根据算法)
     * 保存匹配记录
     * @param pickrecord 记录
     * @return 成功
     */
    @PostMapping
    public User findBestMatches(@RequestBody Pickrecord pickrecord){
        List<Blindbox> blindboxes = blindboxService.selectAll();
//        /System.out.println(blindboxes);
        HashSet<String> set = new HashSet<String>();

        for (Blindbox b : blindboxes){
            set.add(b.getUserId());
        }
//保证寻找的对象都是投缘过的
        List<String> usa = new ArrayList<>(set);

        //System.out.println(usa);


        List<User> userList = userService.selectAll();
       // System.out.println(userList);

        userList.removeIf(u -> !usa.contains(u.getId()));
        //System.out.println(userList);

        String id = pickrecord.getPickerId();
        System.out.println(id);
        User user = userService.getById(id);
        System.out.println(user);

        //保证匹配过的不会重复匹配到同一个人！
        List<Pickrecord> pickeds = pickrecordService.selectAllByPicker_idById(id);
        List<String> edIds = new ArrayList<>();
        for (Pickrecord x : pickeds){
            edIds.add(x.getPickedId());
        }

        //更新列表
        userList.removeIf(x -> edIds.contains(x.getId()));
        //System.out.println(userList);

        System.out.println(user);
        //先进行性别匹配
        List<User> sexMatchedList = SexMatch.findMatchedUsers(user, userList);
        //System.out.println(sexMatchedList);
        //年龄匹配
        List<User> ageMatchedList = AgeMatch.findMatchingUsers(user, sexMatchedList);
        //System.out.println(ageMatchedList);
        //位置匹配
        List<User> locationMatchedList = LocationMatch.findMatches(user, ageMatchedList);
        //System.out.println(locationMatchedList);
        //性格匹配
        List<User> personalMatchedList = PersonalityMatch.getBestMatches(user, locationMatchedList);
        //System.out.println(personalMatchedList);
        String method = pickrecord.getMethod(); //基本匹配、星座匹配、//八字五行匹配
        if (method.equals("基本匹配")){
            user = personalMatchedList.get(0);
        }else if (method.equals("星座匹配")){
            List<User> users = ConstellationMatch.matchUsers(user, personalMatchedList);
            user = users.get(0);
        }else {
            //1、五行匹配
            List<User> matchesByBaZi = WuXingApp.findMatchesByBaZi(user, personalMatchedList);
            user = matchesByBaZi.get(0);
            // TODO 进行八字匹配
        }



        //TODO 此处设置时间！
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String format = dateTime.format(dateTimeFormatter);

        pickrecord.setCreateAt(format);
        pickrecord.setPickedId(user.getId());

        pickrecordService.save(pickrecord);
        return user;
    }



//    //查询所有匹配记录
//    @GetMapping("/{id}")
//    public List<Pickrecord> selectAllByPicked_idById(@PathVariable String id){
//        List<Pickrecord> pickrecords = pickrecordService.selectAllByPicker_idById(id);
//
//        return pickrecords;
//    }

    @Autowired
    IRomanticService romanticService;

    /**
     * 查询id对应的情话内容
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Romantic selectWordById(@PathVariable Integer id){
        return romanticService.getById(id);
    }
}

