package com.example.loveapp.util.nature;

import com.example.loveapp.entity.User;

public class UserScore {
    private User user;
    private double score;

    public UserScore(User user, double score) {
        this.user = user;
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
