package com.oxy.model;

public class Singleselect {
    private Integer questionid;

    private String question;

    private String choiceone;

    private String choicetwo;

    private String choicethree;

    private String choicefour;

    private String answer;

    private String subject;

    private String chapter;

    private Integer difficulty;

    private String createuser;

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getChoiceone() {
        return choiceone;
    }

    public void setChoiceone(String choiceone) {
        this.choiceone = choiceone == null ? null : choiceone.trim();
    }

    public String getChoicetwo() {
        return choicetwo;
    }

    public void setChoicetwo(String choicetwo) {
        this.choicetwo = choicetwo == null ? null : choicetwo.trim();
    }

    public String getChoicethree() {
        return choicethree;
    }

    public void setChoicethree(String choicethree) {
        this.choicethree = choicethree == null ? null : choicethree.trim();
    }

    public String getChoicefour() {
        return choicefour;
    }

    public void setChoicefour(String choicefour) {
        this.choicefour = choicefour == null ? null : choicefour.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter == null ? null : chapter.trim();
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }
}