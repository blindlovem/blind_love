package com.example.loveapp.util.constellation;

import com.example.loveapp.entity.User;
import org.jetbrains.annotations.Contract;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//星座匹配
public class ConstellationMatch {
    /** 星座匹配分值 */
    private static Map<String, String> constellationScoreMap = new HashMap<>();

    /**
     * 初始化星座匹配分数
     * 1水瓶座 2双鱼座 3白羊座 4金牛座 5双子座 6巨蟹座 7狮子座 8处女座 9天秤座 10天蝎座 11射手座 12摩羯座
     * 每个key以两星座编号用-分隔；分值分两个，第一个分数为前男后女时的匹配分数，第二个分数前女后男时的分数
     */
    static {
        //1水瓶座
        constellationScoreMap.put("1-1", "87,87");
        constellationScoreMap.put("1-2", "69,60");
        constellationScoreMap.put("1-3", "88,72");
        constellationScoreMap.put("1-4", "66,72");
        constellationScoreMap.put("1-5", "99,91");
        constellationScoreMap.put("1-6", "74,58");
        constellationScoreMap.put("1-7", "84,78");
        constellationScoreMap.put("1-8", "55,64");
        constellationScoreMap.put("1-9", "95,96");
        constellationScoreMap.put("1-10", "57,51");
        constellationScoreMap.put("1-11", "78,82");
        constellationScoreMap.put("1-12", "57,69");
        //2双鱼座
        constellationScoreMap.put("2-1", "60,69");
        constellationScoreMap.put("2-2", "88,88");
        constellationScoreMap.put("2-3", "79,71");
        constellationScoreMap.put("2-4", "81,78");
        constellationScoreMap.put("2-5", "48,46");
        constellationScoreMap.put("2-6", "97,93");
        constellationScoreMap.put("2-7", "62,61");
        constellationScoreMap.put("2-8", "84,65");
        constellationScoreMap.put("2-9", "64,74");
        constellationScoreMap.put("2-10", "92,99");
        constellationScoreMap.put("2-11", "44,54");
        constellationScoreMap.put("2-12", "77,82");
        //3白羊座
        constellationScoreMap.put("3-1", "72,88");
        constellationScoreMap.put("3-2", "71,79");
        constellationScoreMap.put("3-3", "90,90");
        constellationScoreMap.put("3-4", "68,75");
        constellationScoreMap.put("3-5", "79,82");
        constellationScoreMap.put("3-6", "52,47");
        constellationScoreMap.put("3-7", "97,94");
        constellationScoreMap.put("3-8", "61,65");
        constellationScoreMap.put("3-9", "85,85");
        constellationScoreMap.put("3-10", "60,70");
        constellationScoreMap.put("3-11", "92,99");
        constellationScoreMap.put("3-12", "43,58");
        //4金牛座
        constellationScoreMap.put("4-1", "41,66");
        constellationScoreMap.put("4-2", "78,81");
        constellationScoreMap.put("4-3", "75,68");
        constellationScoreMap.put("4-4", "88,88");
        constellationScoreMap.put("4-5", "76,72");
        constellationScoreMap.put("4-6", "82,75");
        constellationScoreMap.put("4-7", "56,45");
        constellationScoreMap.put("4-8", "91,97");
        constellationScoreMap.put("4-9", "74,57");
        constellationScoreMap.put("4-10", "80,78");
        constellationScoreMap.put("4-11", "70,61");
        constellationScoreMap.put("4-12", "97,93");
        //5双子座
        constellationScoreMap.put("5-1", "91,99");
        constellationScoreMap.put("5-2", "46,48");
        constellationScoreMap.put("5-3", "82,79");
        constellationScoreMap.put("5-4", "72,76");
        constellationScoreMap.put("5-5", "89,89");
        constellationScoreMap.put("5-6", "78,71");
        constellationScoreMap.put("5-7", "79,81");
        constellationScoreMap.put("5-8", "76,57");
        constellationScoreMap.put("5-9", "98,93");
        constellationScoreMap.put("5-10", "68,69");
        constellationScoreMap.put("5-11", "81,70");
        constellationScoreMap.put("5-12", "70,86");
        //6巨蟹座
        constellationScoreMap.put("6-1", "58,74");
        constellationScoreMap.put("6-2", "93,97");
        constellationScoreMap.put("6-3", "47,52");
        constellationScoreMap.put("6-4", "75,82");
        constellationScoreMap.put("6-5", "71,78");
        constellationScoreMap.put("6-6", "89,89");
        constellationScoreMap.put("6-7", "69,61");
        constellationScoreMap.put("6-8", "88,84");
        constellationScoreMap.put("6-9", "58,66");
        constellationScoreMap.put("6-10", "97,92");
        constellationScoreMap.put("6-11", "65,70");
        constellationScoreMap.put("6-12", "80,87");
        //7狮子座
        constellationScoreMap.put("7-1", "78,84");
        constellationScoreMap.put("7-2", "61,62");
        constellationScoreMap.put("7-3", "94,97");
        constellationScoreMap.put("7-4", "45,56");
        constellationScoreMap.put("7-5", "81,79");
        constellationScoreMap.put("7-6", "61,69");
        constellationScoreMap.put("7-7", "87,87");
        constellationScoreMap.put("7-8", "66,72");
        constellationScoreMap.put("7-9", "88,81");
        constellationScoreMap.put("7-10", "65,45");
        constellationScoreMap.put("7-11", "98,92");
        constellationScoreMap.put("7-12", "59,77");
        //8处女座
        constellationScoreMap.put("8-1", "64,55");
        constellationScoreMap.put("8-2", "65,84");
        constellationScoreMap.put("8-3", "65,61");
        constellationScoreMap.put("8-4", "97,91");
        constellationScoreMap.put("8-5", "57,76");
        constellationScoreMap.put("8-6", "84,88");
        constellationScoreMap.put("8-7", "72,66");
        constellationScoreMap.put("8-8", "89,89");
        constellationScoreMap.put("8-9", "77,48");
        constellationScoreMap.put("8-10", "84,81");
        constellationScoreMap.put("8-11", "58,72");
        constellationScoreMap.put("8-12", "92,95");
        //9天秤座
        constellationScoreMap.put("9-1", "96,95");
        constellationScoreMap.put("9-2", "74,64");
        constellationScoreMap.put("9-3", "85,85");
        constellationScoreMap.put("9-4", "57,74");
        constellationScoreMap.put("9-5", "93,98");
        constellationScoreMap.put("9-6", "66,58");
        constellationScoreMap.put("9-7", "81,88");
        constellationScoreMap.put("9-8", "48,77");
        constellationScoreMap.put("9-9", "90,90");
        constellationScoreMap.put("9-10", "73,71");
        constellationScoreMap.put("9-11", "86,80");
        constellationScoreMap.put("9-12", "51,47");
        //10天蝎座
        constellationScoreMap.put("10-1", "51,57");
        constellationScoreMap.put("10-2", "99,92");
        constellationScoreMap.put("10-3", "70,60");
        constellationScoreMap.put("10-4", "78,80");
        constellationScoreMap.put("10-5", "69,68");
        constellationScoreMap.put("10-6", "92,97");
        constellationScoreMap.put("10-7", "45,65");
        constellationScoreMap.put("10-8", "81,84");
        constellationScoreMap.put("10-9", "71,73");
        constellationScoreMap.put("10-10", "87,87");
        constellationScoreMap.put("10-11", "68,47");
        constellationScoreMap.put("10-12", "85,76");
        //11射手座
        constellationScoreMap.put("11-1", "82,78");
        constellationScoreMap.put("11-2", "54,44");
        constellationScoreMap.put("11-3", "99,92");
        constellationScoreMap.put("11-4", "61,70");
        constellationScoreMap.put("11-5", "86,81");
        constellationScoreMap.put("11-6", "70,65");
        constellationScoreMap.put("11-7", "92,98");
        constellationScoreMap.put("11-8", "72,58");
        constellationScoreMap.put("11-9", "80,86");
        constellationScoreMap.put("11-10", "47,68");
        constellationScoreMap.put("11-11", "89,89");
        constellationScoreMap.put("11-12", "64,75");
        //12摩羯座
        constellationScoreMap.put("12-1", "69,74");
        constellationScoreMap.put("12-2", "82,77");
        constellationScoreMap.put("12-3", "58,43");
        constellationScoreMap.put("12-4", "93,97");
        constellationScoreMap.put("12-5", "64,70");
        constellationScoreMap.put("12-6", "87,80");
        constellationScoreMap.put("12-7", "77,59");
        constellationScoreMap.put("12-8", "95,92");
        constellationScoreMap.put("12-9", "47,51");
        constellationScoreMap.put("12-10", "76,85");
        constellationScoreMap.put("12-11", "75,64");
        constellationScoreMap.put("12-12", "88,88");
    }

    public static List<User> matchUsers(User user, List<User> userList) {

        // 计算每个用户与目标用户的星座匹配度，并将结果保存在Map中
        Map<User, Double> userMap = new HashMap<>();
        for (User u : userList) {
            if (!u.getId().equals(user.getId())) { // 排除自己
                double matchScore = calculateMatchScore(user, u);

                userMap.put(u, matchScore);
            }
        }

        // 按照星座匹配度从高到低排序，并选出两个最合适的用户
        List<User> sortedList = userMap.entrySet().stream()
                .sorted(Map.Entry.<User, Double>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return sortedList.subList(0, Math.min(sortedList.size(), 2));
    }


    // 计算两个用户的星座匹配度
    private static double calculateMatchScore(User u1, User u2) {
        String star1 = GetConstellation.getConstellation(u1.getBirthday());
        String star2 = GetConstellation.getConstellation(u2.getBirthday());

        // 将星座转换成数字（0-11）
        int num1 = getStarNumber(star1);
        int num2 = getStarNumber(star2);

        String key = "" + (num1+1) + "-" + (num2+1);

        // 计算两个星座之间的差值
        int diff = Math.abs(num1 - num2);
        if (diff > 6) {
            diff = 12 - diff;
        }

        String s;
        if (u1.getSex().equals("男")){
             s = constellationScoreMap.get(key).split(",")[0];
        }else {
             s = constellationScoreMap.get(key).split(",")[1];
        }



        // 根据差值计算匹配度（100为最高分）
        return (int) (100 * (1 - diff / 6.0))*0.4 + Integer.parseInt(s)*0.6;
    }

    // 将星座转换成数字（0-11）
    @Contract(pure = true)
    private  static int getStarNumber(String star) {
        int num = -1;
        switch (star) {
            case "白羊座" -> num = 0;
            case "金牛座" -> num = 1;
            case "双子座" -> num = 2;
            case "巨蟹座" -> num = 3;
            case "狮子座" -> num = 4;
            case "处女座" -> num = 5;
            case "天秤座" -> num = 6;
            case "天蝎座" -> num = 7;
            case "射手座" -> num = 8;
            case "摩羯座" -> num = 9;
            case "水瓶座" -> num = 10;
            case "双鱼座" -> num = 11;
            default -> {
            }
        }
        return num;
    }

}





