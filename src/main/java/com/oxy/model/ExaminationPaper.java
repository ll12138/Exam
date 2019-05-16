package com.oxy.model;

public class ExaminationPaper {
    private Integer paperid;

    private String questionids;

    private String name;

    private String saqids;

    private Integer selectnum;

    private Integer saqnum;

    private Integer score;

    private String subject;

    private String createuser;

    private Integer totalselect;

    private Integer totalsaq;

    private Integer selectscore;

    private Integer saqscore;

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    public String getQuestionids() {
        return questionids;
    }

    public void setQuestionids(String questionids) {
        this.questionids = questionids == null ? null : questionids.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSaqids() {
        return saqids;
    }

    public void setSaqids(String saqids) {
        this.saqids = saqids == null ? null : saqids.trim();
    }

    public Integer getSelectnum() {
        return selectnum;
    }

    public void setSelectnum(Integer selectnum) {
        this.selectnum = selectnum;
    }

    public Integer getSaqnum() {
        return saqnum;
    }

    public void setSaqnum(Integer saqnum) {
        this.saqnum = saqnum;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    public Integer getTotalselect() {
        return totalselect;
    }

    public void setTotalselect(Integer totalselect) {
        this.totalselect = totalselect;
    }

    public Integer getTotalsaq() {
        return totalsaq;
    }

    public void setTotalsaq(Integer totalsaq) {
        this.totalsaq = totalsaq;
    }

    public Integer getSelectscore() {
        return selectscore;
    }

    public void setSelectscore(Integer selectscore) {
        this.selectscore = selectscore;
    }

    public Integer getSaqscore() {
        return saqscore;
    }

    public void setSaqscore(Integer saqscore) {
        this.saqscore = saqscore;
    }
}