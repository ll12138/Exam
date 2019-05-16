package com.oxy.model;

import java.util.ArrayList;
import java.util.List;

public class SingleselectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SingleselectExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andQuestionidIsNull() {
            addCriterion("QuestionID is null");
            return (Criteria) this;
        }

        public Criteria andQuestionidIsNotNull() {
            addCriterion("QuestionID is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionidEqualTo(Integer value) {
            addCriterion("QuestionID =", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidNotEqualTo(Integer value) {
            addCriterion("QuestionID <>", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidGreaterThan(Integer value) {
            addCriterion("QuestionID >", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("QuestionID >=", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidLessThan(Integer value) {
            addCriterion("QuestionID <", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidLessThanOrEqualTo(Integer value) {
            addCriterion("QuestionID <=", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidIn(List<Integer> values) {
            addCriterion("QuestionID in", values, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidNotIn(List<Integer> values) {
            addCriterion("QuestionID not in", values, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidBetween(Integer value1, Integer value2) {
            addCriterion("QuestionID between", value1, value2, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidNotBetween(Integer value1, Integer value2) {
            addCriterion("QuestionID not between", value1, value2, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionIsNull() {
            addCriterion("Question is null");
            return (Criteria) this;
        }

        public Criteria andQuestionIsNotNull() {
            addCriterion("Question is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionEqualTo(String value) {
            addCriterion("Question =", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotEqualTo(String value) {
            addCriterion("Question <>", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionGreaterThan(String value) {
            addCriterion("Question >", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionGreaterThanOrEqualTo(String value) {
            addCriterion("Question >=", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLessThan(String value) {
            addCriterion("Question <", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLessThanOrEqualTo(String value) {
            addCriterion("Question <=", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLike(String value) {
            addCriterion("Question like", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotLike(String value) {
            addCriterion("Question not like", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionIn(List<String> values) {
            addCriterion("Question in", values, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotIn(List<String> values) {
            addCriterion("Question not in", values, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionBetween(String value1, String value2) {
            addCriterion("Question between", value1, value2, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotBetween(String value1, String value2) {
            addCriterion("Question not between", value1, value2, "question");
            return (Criteria) this;
        }

        public Criteria andChoiceoneIsNull() {
            addCriterion("ChoiceOne is null");
            return (Criteria) this;
        }

        public Criteria andChoiceoneIsNotNull() {
            addCriterion("ChoiceOne is not null");
            return (Criteria) this;
        }

        public Criteria andChoiceoneEqualTo(String value) {
            addCriterion("ChoiceOne =", value, "choiceone");
            return (Criteria) this;
        }

        public Criteria andChoiceoneNotEqualTo(String value) {
            addCriterion("ChoiceOne <>", value, "choiceone");
            return (Criteria) this;
        }

        public Criteria andChoiceoneGreaterThan(String value) {
            addCriterion("ChoiceOne >", value, "choiceone");
            return (Criteria) this;
        }

        public Criteria andChoiceoneGreaterThanOrEqualTo(String value) {
            addCriterion("ChoiceOne >=", value, "choiceone");
            return (Criteria) this;
        }

        public Criteria andChoiceoneLessThan(String value) {
            addCriterion("ChoiceOne <", value, "choiceone");
            return (Criteria) this;
        }

        public Criteria andChoiceoneLessThanOrEqualTo(String value) {
            addCriterion("ChoiceOne <=", value, "choiceone");
            return (Criteria) this;
        }

        public Criteria andChoiceoneLike(String value) {
            addCriterion("ChoiceOne like", value, "choiceone");
            return (Criteria) this;
        }

        public Criteria andChoiceoneNotLike(String value) {
            addCriterion("ChoiceOne not like", value, "choiceone");
            return (Criteria) this;
        }

        public Criteria andChoiceoneIn(List<String> values) {
            addCriterion("ChoiceOne in", values, "choiceone");
            return (Criteria) this;
        }

        public Criteria andChoiceoneNotIn(List<String> values) {
            addCriterion("ChoiceOne not in", values, "choiceone");
            return (Criteria) this;
        }

        public Criteria andChoiceoneBetween(String value1, String value2) {
            addCriterion("ChoiceOne between", value1, value2, "choiceone");
            return (Criteria) this;
        }

        public Criteria andChoiceoneNotBetween(String value1, String value2) {
            addCriterion("ChoiceOne not between", value1, value2, "choiceone");
            return (Criteria) this;
        }

        public Criteria andChoicetwoIsNull() {
            addCriterion("ChoiceTwo is null");
            return (Criteria) this;
        }

        public Criteria andChoicetwoIsNotNull() {
            addCriterion("ChoiceTwo is not null");
            return (Criteria) this;
        }

        public Criteria andChoicetwoEqualTo(String value) {
            addCriterion("ChoiceTwo =", value, "choicetwo");
            return (Criteria) this;
        }

        public Criteria andChoicetwoNotEqualTo(String value) {
            addCriterion("ChoiceTwo <>", value, "choicetwo");
            return (Criteria) this;
        }

        public Criteria andChoicetwoGreaterThan(String value) {
            addCriterion("ChoiceTwo >", value, "choicetwo");
            return (Criteria) this;
        }

        public Criteria andChoicetwoGreaterThanOrEqualTo(String value) {
            addCriterion("ChoiceTwo >=", value, "choicetwo");
            return (Criteria) this;
        }

        public Criteria andChoicetwoLessThan(String value) {
            addCriterion("ChoiceTwo <", value, "choicetwo");
            return (Criteria) this;
        }

        public Criteria andChoicetwoLessThanOrEqualTo(String value) {
            addCriterion("ChoiceTwo <=", value, "choicetwo");
            return (Criteria) this;
        }

        public Criteria andChoicetwoLike(String value) {
            addCriterion("ChoiceTwo like", value, "choicetwo");
            return (Criteria) this;
        }

        public Criteria andChoicetwoNotLike(String value) {
            addCriterion("ChoiceTwo not like", value, "choicetwo");
            return (Criteria) this;
        }

        public Criteria andChoicetwoIn(List<String> values) {
            addCriterion("ChoiceTwo in", values, "choicetwo");
            return (Criteria) this;
        }

        public Criteria andChoicetwoNotIn(List<String> values) {
            addCriterion("ChoiceTwo not in", values, "choicetwo");
            return (Criteria) this;
        }

        public Criteria andChoicetwoBetween(String value1, String value2) {
            addCriterion("ChoiceTwo between", value1, value2, "choicetwo");
            return (Criteria) this;
        }

        public Criteria andChoicetwoNotBetween(String value1, String value2) {
            addCriterion("ChoiceTwo not between", value1, value2, "choicetwo");
            return (Criteria) this;
        }

        public Criteria andChoicethreeIsNull() {
            addCriterion("ChoiceThree is null");
            return (Criteria) this;
        }

        public Criteria andChoicethreeIsNotNull() {
            addCriterion("ChoiceThree is not null");
            return (Criteria) this;
        }

        public Criteria andChoicethreeEqualTo(String value) {
            addCriterion("ChoiceThree =", value, "choicethree");
            return (Criteria) this;
        }

        public Criteria andChoicethreeNotEqualTo(String value) {
            addCriterion("ChoiceThree <>", value, "choicethree");
            return (Criteria) this;
        }

        public Criteria andChoicethreeGreaterThan(String value) {
            addCriterion("ChoiceThree >", value, "choicethree");
            return (Criteria) this;
        }

        public Criteria andChoicethreeGreaterThanOrEqualTo(String value) {
            addCriterion("ChoiceThree >=", value, "choicethree");
            return (Criteria) this;
        }

        public Criteria andChoicethreeLessThan(String value) {
            addCriterion("ChoiceThree <", value, "choicethree");
            return (Criteria) this;
        }

        public Criteria andChoicethreeLessThanOrEqualTo(String value) {
            addCriterion("ChoiceThree <=", value, "choicethree");
            return (Criteria) this;
        }

        public Criteria andChoicethreeLike(String value) {
            addCriterion("ChoiceThree like", value, "choicethree");
            return (Criteria) this;
        }

        public Criteria andChoicethreeNotLike(String value) {
            addCriterion("ChoiceThree not like", value, "choicethree");
            return (Criteria) this;
        }

        public Criteria andChoicethreeIn(List<String> values) {
            addCriterion("ChoiceThree in", values, "choicethree");
            return (Criteria) this;
        }

        public Criteria andChoicethreeNotIn(List<String> values) {
            addCriterion("ChoiceThree not in", values, "choicethree");
            return (Criteria) this;
        }

        public Criteria andChoicethreeBetween(String value1, String value2) {
            addCriterion("ChoiceThree between", value1, value2, "choicethree");
            return (Criteria) this;
        }

        public Criteria andChoicethreeNotBetween(String value1, String value2) {
            addCriterion("ChoiceThree not between", value1, value2, "choicethree");
            return (Criteria) this;
        }

        public Criteria andChoicefourIsNull() {
            addCriterion("ChoiceFour is null");
            return (Criteria) this;
        }

        public Criteria andChoicefourIsNotNull() {
            addCriterion("ChoiceFour is not null");
            return (Criteria) this;
        }

        public Criteria andChoicefourEqualTo(String value) {
            addCriterion("ChoiceFour =", value, "choicefour");
            return (Criteria) this;
        }

        public Criteria andChoicefourNotEqualTo(String value) {
            addCriterion("ChoiceFour <>", value, "choicefour");
            return (Criteria) this;
        }

        public Criteria andChoicefourGreaterThan(String value) {
            addCriterion("ChoiceFour >", value, "choicefour");
            return (Criteria) this;
        }

        public Criteria andChoicefourGreaterThanOrEqualTo(String value) {
            addCriterion("ChoiceFour >=", value, "choicefour");
            return (Criteria) this;
        }

        public Criteria andChoicefourLessThan(String value) {
            addCriterion("ChoiceFour <", value, "choicefour");
            return (Criteria) this;
        }

        public Criteria andChoicefourLessThanOrEqualTo(String value) {
            addCriterion("ChoiceFour <=", value, "choicefour");
            return (Criteria) this;
        }

        public Criteria andChoicefourLike(String value) {
            addCriterion("ChoiceFour like", value, "choicefour");
            return (Criteria) this;
        }

        public Criteria andChoicefourNotLike(String value) {
            addCriterion("ChoiceFour not like", value, "choicefour");
            return (Criteria) this;
        }

        public Criteria andChoicefourIn(List<String> values) {
            addCriterion("ChoiceFour in", values, "choicefour");
            return (Criteria) this;
        }

        public Criteria andChoicefourNotIn(List<String> values) {
            addCriterion("ChoiceFour not in", values, "choicefour");
            return (Criteria) this;
        }

        public Criteria andChoicefourBetween(String value1, String value2) {
            addCriterion("ChoiceFour between", value1, value2, "choicefour");
            return (Criteria) this;
        }

        public Criteria andChoicefourNotBetween(String value1, String value2) {
            addCriterion("ChoiceFour not between", value1, value2, "choicefour");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNull() {
            addCriterion("Answer is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNotNull() {
            addCriterion("Answer is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerEqualTo(String value) {
            addCriterion("Answer =", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotEqualTo(String value) {
            addCriterion("Answer <>", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThan(String value) {
            addCriterion("Answer >", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("Answer >=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThan(String value) {
            addCriterion("Answer <", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThanOrEqualTo(String value) {
            addCriterion("Answer <=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLike(String value) {
            addCriterion("Answer like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotLike(String value) {
            addCriterion("Answer not like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerIn(List<String> values) {
            addCriterion("Answer in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotIn(List<String> values) {
            addCriterion("Answer not in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerBetween(String value1, String value2) {
            addCriterion("Answer between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotBetween(String value1, String value2) {
            addCriterion("Answer not between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("Subject is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("Subject is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("Subject =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("Subject <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("Subject >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("Subject >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("Subject <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("Subject <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("Subject like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("Subject not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("Subject in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("Subject not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("Subject between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("Subject not between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andChapterIsNull() {
            addCriterion("Chapter is null");
            return (Criteria) this;
        }

        public Criteria andChapterIsNotNull() {
            addCriterion("Chapter is not null");
            return (Criteria) this;
        }

        public Criteria andChapterEqualTo(String value) {
            addCriterion("Chapter =", value, "chapter");
            return (Criteria) this;
        }

        public Criteria andChapterNotEqualTo(String value) {
            addCriterion("Chapter <>", value, "chapter");
            return (Criteria) this;
        }

        public Criteria andChapterGreaterThan(String value) {
            addCriterion("Chapter >", value, "chapter");
            return (Criteria) this;
        }

        public Criteria andChapterGreaterThanOrEqualTo(String value) {
            addCriterion("Chapter >=", value, "chapter");
            return (Criteria) this;
        }

        public Criteria andChapterLessThan(String value) {
            addCriterion("Chapter <", value, "chapter");
            return (Criteria) this;
        }

        public Criteria andChapterLessThanOrEqualTo(String value) {
            addCriterion("Chapter <=", value, "chapter");
            return (Criteria) this;
        }

        public Criteria andChapterLike(String value) {
            addCriterion("Chapter like", value, "chapter");
            return (Criteria) this;
        }

        public Criteria andChapterNotLike(String value) {
            addCriterion("Chapter not like", value, "chapter");
            return (Criteria) this;
        }

        public Criteria andChapterIn(List<String> values) {
            addCriterion("Chapter in", values, "chapter");
            return (Criteria) this;
        }

        public Criteria andChapterNotIn(List<String> values) {
            addCriterion("Chapter not in", values, "chapter");
            return (Criteria) this;
        }

        public Criteria andChapterBetween(String value1, String value2) {
            addCriterion("Chapter between", value1, value2, "chapter");
            return (Criteria) this;
        }

        public Criteria andChapterNotBetween(String value1, String value2) {
            addCriterion("Chapter not between", value1, value2, "chapter");
            return (Criteria) this;
        }

        public Criteria andDifficultyIsNull() {
            addCriterion("Difficulty is null");
            return (Criteria) this;
        }

        public Criteria andDifficultyIsNotNull() {
            addCriterion("Difficulty is not null");
            return (Criteria) this;
        }

        public Criteria andDifficultyEqualTo(Integer value) {
            addCriterion("Difficulty =", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyNotEqualTo(Integer value) {
            addCriterion("Difficulty <>", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyGreaterThan(Integer value) {
            addCriterion("Difficulty >", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyGreaterThanOrEqualTo(Integer value) {
            addCriterion("Difficulty >=", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyLessThan(Integer value) {
            addCriterion("Difficulty <", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyLessThanOrEqualTo(Integer value) {
            addCriterion("Difficulty <=", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyIn(List<Integer> values) {
            addCriterion("Difficulty in", values, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyNotIn(List<Integer> values) {
            addCriterion("Difficulty not in", values, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyBetween(Integer value1, Integer value2) {
            addCriterion("Difficulty between", value1, value2, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyNotBetween(Integer value1, Integer value2) {
            addCriterion("Difficulty not between", value1, value2, "difficulty");
            return (Criteria) this;
        }

        public Criteria andCreateuserIsNull() {
            addCriterion("CreateUser is null");
            return (Criteria) this;
        }

        public Criteria andCreateuserIsNotNull() {
            addCriterion("CreateUser is not null");
            return (Criteria) this;
        }

        public Criteria andCreateuserEqualTo(String value) {
            addCriterion("CreateUser =", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotEqualTo(String value) {
            addCriterion("CreateUser <>", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThan(String value) {
            addCriterion("CreateUser >", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("CreateUser >=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThan(String value) {
            addCriterion("CreateUser <", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThanOrEqualTo(String value) {
            addCriterion("CreateUser <=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLike(String value) {
            addCriterion("CreateUser like", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotLike(String value) {
            addCriterion("CreateUser not like", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserIn(List<String> values) {
            addCriterion("CreateUser in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotIn(List<String> values) {
            addCriterion("CreateUser not in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserBetween(String value1, String value2) {
            addCriterion("CreateUser between", value1, value2, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotBetween(String value1, String value2) {
            addCriterion("CreateUser not between", value1, value2, "createuser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}