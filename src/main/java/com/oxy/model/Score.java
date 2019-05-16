package com.oxy.model;

public class Score extends ScoreKey {
    private String score;

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }
}