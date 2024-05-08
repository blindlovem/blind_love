package com.example.loveapp.util.age;

import com.example.loveapp.entity.User;

import java.util.ArrayList;
import java.util.List;

//年龄匹配
public class AgeMatch {

    /**
     * 30以下年龄差距不超过10；30以上不超过15
     * @param user 寻缘用户
     * @param userList 待查找的全部用户
     * @return 返回年龄合适的用户集合
     */
    public static List<User> findMatchingUsers(User user, List<User> userList) {
        //结果集
        List<User> matchingUsers = new ArrayList<>();

        //便利全部用户
        for (User otherUser : userList) {
            //排除自己
            if (user.getId().equals(otherUser.getId())) {
                continue;
            }
            //计算年龄差
            int ageDifference = Math.abs(user.getAge() - otherUser.getAge());
            if (otherUser.getAge() > 30 && ageDifference > 15) {
                continue;
            } else if (ageDifference > 10) {
                continue;
            }

            matchingUsers.add(otherUser);
        }

        return matchingUsers;
    }
}
