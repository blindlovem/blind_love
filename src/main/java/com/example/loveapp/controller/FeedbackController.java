package com.example.loveapp.controller;

import com.example.loveapp.entity.Feedback;
import com.example.loveapp.mapper.feedbackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class FeedbackController {


    @Autowired
    feedbackMapper feedbackMapper;


    @PostMapping("/feedback")
    @Transactional
    public boolean handleFeedback(@RequestBody Feedback feedback) {
        System.out.println(feedback.getWordId());
        Integer integer = feedbackMapper.selectRById(feedback.getWordId());
        System.out.println(integer);
        if (integer == null){
            return feedbackMapper.insert(feedback) > 0;
        }

        feedback.setIslike(feedback.getIslike()+1);
        feedback.setId(integer);

        return feedbackMapper.updateById(feedback) > 0;
    }

}
