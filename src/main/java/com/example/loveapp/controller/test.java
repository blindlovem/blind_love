package com.example.loveapp.controller;

import com.example.loveapp.entity.Feedback;
import com.example.loveapp.entity.Romantic;
import com.example.loveapp.entity.Sendword;
import com.example.loveapp.mapper.RomanticMapper;

import com.example.loveapp.mapper.SendwordMapper;
import com.example.loveapp.mapper.feedbackMapper;
import com.example.loveapp.service.impl.RomanticServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
@RequestMapping("/test")
public class test {


    @Autowired
    private RomanticMapper romanticMapper;

    @Autowired
    private SendwordMapper sendwordMapper;

    @Autowired
    feedbackMapper feedbackMapper;
    @Autowired
    private RomanticServiceImpl romanticService;



    // 查询情话标签
    public List<Romantic> findRomanticByTag(String tag) {
        return romanticMapper.findRomanticByTag(tag);
    }


    @GetMapping("/{id}")
    // 分析用户偏好并推荐情话
    public List<Romantic> recommendRomanticByUser(@PathVariable String id) {

        List<Feedback> feedbacks = feedbackMapper.selectAllById(id);

        // 获取用户选择记录
        List<Sendword> userSelections = sendwordMapper.selectBySendId(id);


        // 检查用户选择记录是否为空
        if (userSelections.isEmpty()) {

            List<Romantic> res = new ArrayList<>();
            List<String> tags = romanticMapper.selectTag();
            for (String t : tags){
                List<Romantic> romanticByTag = romanticMapper.findRomanticByTag(t);
                if (!romanticByTag.isEmpty()){
                    res.add(romanticByTag.get(0));
                }
            }


            //return romanticService.getThrWords();
            return res;
        }

        // 统计标签偏好程度
        Map<String, Integer> tagPreferences = new HashMap<>();
        for (Sendword selection : userSelections
        ) {

            Romantic romantic = romanticMapper.selectById(selection.getWordId());
            String[] tags = romantic.getTag().split(",");

            for (String tag : tags) {
                for (Feedback f: feedbacks){
                    if (findRomanticByTag(tag).contains(romanticMapper.selectById(f.getWordId())) && f.getIslike() >= 1){
                        tagPreferences.put(tag, tagPreferences.getOrDefault(tag, 0) - f.getIslike());
                    }
                }
                tagPreferences.put(tag, tagPreferences.getOrDefault(tag, 0) + 1);
            }
        }

        // 根据标签偏好程度排序
        List<Map.Entry<String, Integer>> sortedPreferences = new ArrayList<>(tagPreferences.entrySet());
        sortedPreferences.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // 获取排名靠前的标签
        List<String> topTags = sortedPreferences.stream()
                .limit(3) // 假设只考虑前三个标签
                .map(Map.Entry::getKey).toList();

        // 根据标签推荐情话
        List<Romantic> recommendedRomantic = new ArrayList<>();
        for (String tag : topTags) {
            List<Romantic> romantics = findRomanticByTag(tag);
            //recommendedRomantic.addAll(romantics);
            Random r = new Random();
            int t = r.nextInt(4);
            int a = r.nextInt(4);
            recommendedRomantic.add(romantics.get(t));
            while (true){
                if (a != t){
                    break;
                }
                a = r.nextInt(4);
            }
            recommendedRomantic.add(romantics.get(a));
        }
        List<Romantic> res = new ArrayList<>(recommendedRomantic);

        if (recommendedRomantic.size() < 6){
            List<String> tags = romanticMapper.selectTag();
            tags.removeAll(topTags);

            for (String t : tags){
                List<Romantic> romanticByTag = romanticMapper.findRomanticByTag(t);
                if (!romanticByTag.isEmpty()){
                    recommendedRomantic.add(romanticByTag.get(0));
                    //res.add(romanticByTag.get(0));
                }
            }
        }

        //if ()

       // List<Romantic> res = new ArrayList<>();

        //return recommendedRomantic;
        return recommendedRomantic;
    }
}

/*我们首先获取用户的选择记录，并统计每个标签的偏好程度。然后，我们根据标签偏好程度排序，并选取排名靠前的标签作为用户的偏好。最后，根据用户偏好的标签推荐情话。*/


