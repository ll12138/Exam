package com.oxy.model;

public class UserAnswer extends UserAnswerKey {
    private String useranswer;

    private String answer;

    private Boolean iscorrrent;

    public String getUseranswer() {
        return useranswer;
    }

    public void setUseranswer(String useranswer) {
        this.useranswer = useranswer == null ? null : useranswer.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Boolean getIscorrrent() {
        return iscorrrent;
    }

    public void setIscorrrent(Boolean iscorrrent) {
        this.iscorrrent = iscorrrent;
    }
}