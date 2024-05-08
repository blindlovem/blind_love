package com.example.loveapp.util.sex;


import com.example.loveapp.entity.User;

import java.util.List;
import java.util.stream.Collectors;

//性别匹配
public class SexMatch {

    /**
     * 根据用户性取向进行合适匹配
     * @param user
     * @param allUsers
     * @return
     */
    public static List<User> findMatchedUsers(User user, List<User> allUsers) {

        String expectedGender = getExpectedGender(user);
        System.out.println(allUsers);
        System.out.println(expectedGender);

//        for (User u:allUsers){
//            System.out.println(u.getSex());
//        }
        allUsers.removeIf(u -> !u.getSex().equals(expectedGender));


//        return allUsers.stream()
//                .filter(u -> u.getSex().equals(expectedGender))
//                .collect(Collectors.toList());

        allUsers.removeIf(u -> !u.getSexualOrie().equals(user.getSexualOrie()));

        System.out.println(allUsers);
        return allUsers;
    }

    /**
     * 得到用户期望的性别
     * @param user
     * @return
     */
    private static String getExpectedGender(User user) {
        String sexualOrientation = user.getSexualOrie();//用户性取向
        String gender = user.getSex(); //用户性别
        if (sexualOrientation.equals("同性")) { //前端用户选择：“异性”“同性”
            return gender;
        } else {
            return gender.equals("男") ? "女" : "男"; //前端个人性别 填写男/女
        }
    }

}