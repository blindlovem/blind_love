package com.example.loveapp.util.location;

import com.example.loveapp.entity.User;

import java.util.ArrayList;
import java.util.List;

//位置匹配
public class LocationMatch {
    //TODO 在数据库user表中添加一个期望位置字段

    /**
     * 根据用户期望地点匹配
     * @param targetUser
     * @param allUsers
     * @return
     */
    public static List<User> findMatches(User targetUser, List<User> allUsers) {
        String userLocation = targetUser.getLocation();
        String location_orie = targetUser.getLocationOrie();//无所谓、附近

        if (location_orie.equals("无所谓")){
            return allUsers;
        }else {
            List<User> matches = new ArrayList<>();
            for (User user : allUsers) {
                if (userLocation.equals(user.getLocation())){
                    matches.add(user);
                }
            }
            if (matches.isEmpty()){
                return allUsers;
            }
            return matches;
        }
    }
}
