package com.oxy.model;

import java.util.ArrayList;
import java.util.List;

public class ExaminationPaperExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExaminationPaperExample() {
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

        public Criteria andPaperidIsNull() {
            addCriterion("PaperID is null");
            return (Criteria) this;
        }

        public Criteria andPaperidIsNotNull() {
            addCriterion("PaperID is not null");
            return (Criteria) this;
        }

        public Criteria andPaperidEqualTo(Integer value) {
            addCriterion("PaperID =", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidNotEqualTo(Integer value) {
            addCriterion("PaperID <>", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidGreaterThan(Integer value) {
            addCriterion("PaperID >", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidGreaterThanOrEqualTo(Integer value) {
            addCriterion("PaperID >=", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidLessThan(Integer value) {
            addCriterion("PaperID <", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidLessThanOrEqualTo(Integer value) {
            addCriterion("PaperID <=", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidIn(List<Integer> values) {
            addCriterion("PaperID in", values, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidNotIn(List<Integer> values) {
            addCriterion("PaperID not in", values, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidBetween(Integer value1, Integer value2) {
            addCriterion("PaperID between", value1, value2, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidNotBetween(Integer value1, Integer value2) {
            addCriterion("PaperID not between", value1, value2, "paperid");
            return (Criteria) this;
        }

        public Criteria andQuestionidsIsNull() {
            addCriterion("QuestionIds is null");
            return (Criteria) this;
        }

        public Criteria andQuestionidsIsNotNull() {
            addCriterion("QuestionIds is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionidsEqualTo(String value) {
            addCriterion("QuestionIds =", value, "questionids");
            return (Criteria) this;
        }

        public Criteria andQuestionidsNotEqualTo(String value) {
            addCriterion("QuestionIds <>", value, "questionids");
            return (Criteria) this;
        }

        public Criteria andQuestionidsGreaterThan(String value) {
            addCriterion("QuestionIds >", value, "questionids");
            return (Criteria) this;
        }

        public Criteria andQuestionidsGreaterThanOrEqualTo(String value) {
            addCriterion("QuestionIds >=", value, "questionids");
            return (Criteria) this;
        }

        public Criteria andQuestionidsLessThan(String value) {
            addCriterion("QuestionIds <", value, "questionids");
            return (Criteria) this;
        }

        public Criteria andQuestionidsLessThanOrEqualTo(String value) {
            addCriterion("QuestionIds <=", value, "questionids");
            return (Criteria) this;
        }

        public Criteria andQuestionidsLike(String value) {
            addCriterion("QuestionIds like", value, "questionids");
            return (Criteria) this;
        }

        public Criteria andQuestionidsNotLike(String value) {
            addCriterion("QuestionIds not like", value, "questionids");
            return (Criteria) this;
        }

        public Criteria andQuestionidsIn(List<String> values) {
            addCriterion("QuestionIds in", values, "questionids");
            return (Criteria) this;
        }

        public Criteria andQuestionidsNotIn(List<String> values) {
            addCriterion("QuestionIds not in", values, "questionids");
            return (Criteria) this;
        }

        public Criteria andQuestionidsBetween(String value1, String value2) {
            addCriterion("QuestionIds between", value1, value2, "questionids");
            return (Criteria) this;
        }

        public Criteria andQuestionidsNotBetween(String value1, String value2) {
            addCriterion("QuestionIds not between", value1, value2, "questionids");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("Name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("Name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("Name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("Name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("Name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("Name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("Name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("Name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("Name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("Name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("Name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("Name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("Name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("Name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSaqidsIsNull() {
            addCriterion("SAQIds is null");
            return (Criteria) this;
        }

        public Criteria andSaqidsIsNotNull() {
            addCriterion("SAQIds is not null");
            return (Criteria) this;
        }

        public Criteria andSaqidsEqualTo(String value) {
            addCriterion("SAQIds =", value, "saqids");
            return (Criteria) this;
        }

        public Criteria andSaqidsNotEqualTo(String value) {
            addCriterion("SAQIds <>", value, "saqids");
            return (Criteria) this;
        }

        public Criteria andSaqidsGreaterThan(String value) {
            addCriterion("SAQIds >", value, "saqids");
            return (Criteria) this;
        }

        public Criteria andSaqidsGreaterThanOrEqualTo(String value) {
            addCriterion("SAQIds >=", value, "saqids");
            return (Criteria) this;
        }

        public Criteria andSaqidsLessThan(String value) {
            addCriterion("SAQIds <", value, "saqids");
            return (Criteria) this;
        }

        public Criteria andSaqidsLessThanOrEqualTo(String value) {
            addCriterion("SAQIds <=", value, "saqids");
            return (Criteria) this;
        }

        public Criteria andSaqidsLike(String value) {
            addCriterion("SAQIds like", value, "saqids");
            return (Criteria) this;
        }

        public Criteria andSaqidsNotLike(String value) {
            addCriterion("SAQIds not like", value, "saqids");
            return (Criteria) this;
        }

        public Criteria andSaqidsIn(List<String> values) {
            addCriterion("SAQIds in", values, "saqids");
            return (Criteria) this;
        }

        public Criteria andSaqidsNotIn(List<String> values) {
            addCriterion("SAQIds not in", values, "saqids");
            return (Criteria) this;
        }

        public Criteria andSaqidsBetween(String value1, String value2) {
            addCriterion("SAQIds between", value1, value2, "saqids");
            return (Criteria) this;
        }

        public Criteria andSaqidsNotBetween(String value1, String value2) {
            addCriterion("SAQIds not between", value1, value2, "saqids");
            return (Criteria) this;
        }

        public Criteria andSelectnumIsNull() {
            addCriterion("SelectNum is null");
            return (Criteria) this;
        }

        public Criteria andSelectnumIsNotNull() {
            addCriterion("SelectNum is not null");
            return (Criteria) this;
        }

        public Criteria andSelectnumEqualTo(Integer value) {
            addCriterion("SelectNum =", value, "selectnum");
            return (Criteria) this;
        }

        public Criteria andSelectnumNotEqualTo(Integer value) {
            addCriterion("SelectNum <>", value, "selectnum");
            return (Criteria) this;
        }

        public Criteria andSelectnumGreaterThan(Integer value) {
            addCriterion("SelectNum >", value, "selectnum");
            return (Criteria) this;
        }

        public Criteria andSelectnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("SelectNum >=", value, "selectnum");
            return (Criteria) this;
        }

        public Criteria andSelectnumLessThan(Integer value) {
            addCriterion("SelectNum <", value, "selectnum");
            return (Criteria) this;
        }

        public Criteria andSelectnumLessThanOrEqualTo(Integer value) {
            addCriterion("SelectNum <=", value, "selectnum");
            return (Criteria) this;
        }

        public Criteria andSelectnumIn(List<Integer> values) {
            addCriterion("SelectNum in", values, "selectnum");
            return (Criteria) this;
        }

        public Criteria andSelectnumNotIn(List<Integer> values) {
            addCriterion("SelectNum not in", values, "selectnum");
            return (Criteria) this;
        }

        public Criteria andSelectnumBetween(Integer value1, Integer value2) {
            addCriterion("SelectNum between", value1, value2, "selectnum");
            return (Criteria) this;
        }

        public Criteria andSelectnumNotBetween(Integer value1, Integer value2) {
            addCriterion("SelectNum not between", value1, value2, "selectnum");
            return (Criteria) this;
        }

        public Criteria andSaqnumIsNull() {
            addCriterion("SAQNum is null");
            return (Criteria) this;
        }

        public Criteria andSaqnumIsNotNull() {
            addCriterion("SAQNum is not null");
            return (Criteria) this;
        }

        public Criteria andSaqnumEqualTo(Integer value) {
            addCriterion("SAQNum =", value, "saqnum");
            return (Criteria) this;
        }

        public Criteria andSaqnumNotEqualTo(Integer value) {
            addCriterion("SAQNum <>", value, "saqnum");
            return (Criteria) this;
        }

        public Criteria andSaqnumGreaterThan(Integer value) {
            addCriterion("SAQNum >", value, "saqnum");
            return (Criteria) this;
        }

        public Criteria andSaqnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("SAQNum >=", value, "saqnum");
            return (Criteria) this;
        }

        public Criteria andSaqnumLessThan(Integer value) {
            addCriterion("SAQNum <", value, "saqnum");
            return (Criteria) this;
        }

        public Criteria andSaqnumLessThanOrEqualTo(Integer value) {
            addCriterion("SAQNum <=", value, "saqnum");
            return (Criteria) this;
        }

        public Criteria andSaqnumIn(List<Integer> values) {
            addCriterion("SAQNum in", values, "saqnum");
            return (Criteria) this;
        }

        public Criteria andSaqnumNotIn(List<Integer> values) {
            addCriterion("SAQNum not in", values, "saqnum");
            return (Criteria) this;
        }

        public Criteria andSaqnumBetween(Integer value1, Integer value2) {
            addCriterion("SAQNum between", value1, value2, "saqnum");
            return (Criteria) this;
        }

        public Criteria andSaqnumNotBetween(Integer value1, Integer value2) {
            addCriterion("SAQNum not between", value1, value2, "saqnum");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("Score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("Score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("Score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("Score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("Score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("Score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("Score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("Score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("Score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("Score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("Score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("Score not between", value1, value2, "score");
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

        public Criteria andTotalselectIsNull() {
            addCriterion("TotalSelect is null");
            return (Criteria) this;
        }

        public Criteria andTotalselectIsNotNull() {
            addCriterion("TotalSelect is not null");
            return (Criteria) this;
        }

        public Criteria andTotalselectEqualTo(Integer value) {
            addCriterion("TotalSelect =", value, "totalselect");
            return (Criteria) this;
        }

        public Criteria andTotalselectNotEqualTo(Integer value) {
            addCriterion("TotalSelect <>", value, "totalselect");
            return (Criteria) this;
        }

        public Criteria andTotalselectGreaterThan(Integer value) {
            addCriterion("TotalSelect >", value, "totalselect");
            return (Criteria) this;
        }

        public Criteria andTotalselectGreaterThanOrEqualTo(Integer value) {
            addCriterion("TotalSelect >=", value, "totalselect");
            return (Criteria) this;
        }

        public Criteria andTotalselectLessThan(Integer value) {
            addCriterion("TotalSelect <", value, "totalselect");
            return (Criteria) this;
        }

        public Criteria andTotalselectLessThanOrEqualTo(Integer value) {
            addCriterion("TotalSelect <=", value, "totalselect");
            return (Criteria) this;
        }

        public Criteria andTotalselectIn(List<Integer> values) {
            addCriterion("TotalSelect in", values, "totalselect");
            return (Criteria) this;
        }

        public Criteria andTotalselectNotIn(List<Integer> values) {
            addCriterion("TotalSelect not in", values, "totalselect");
            return (Criteria) this;
        }

        public Criteria andTotalselectBetween(Integer value1, Integer value2) {
            addCriterion("TotalSelect between", value1, value2, "totalselect");
            return (Criteria) this;
        }

        public Criteria andTotalselectNotBetween(Integer value1, Integer value2) {
            addCriterion("TotalSelect not between", value1, value2, "totalselect");
            return (Criteria) this;
        }

        public Criteria andTotalsaqIsNull() {
            addCriterion("TotalSAQ is null");
            return (Criteria) this;
        }

        public Criteria andTotalsaqIsNotNull() {
            addCriterion("TotalSAQ is not null");
            return (Criteria) this;
        }

        public Criteria andTotalsaqEqualTo(Integer value) {
            addCriterion("TotalSAQ =", value, "totalsaq");
            return (Criteria) this;
        }

        public Criteria andTotalsaqNotEqualTo(Integer value) {
            addCriterion("TotalSAQ <>", value, "totalsaq");
            return (Criteria) this;
        }

        public Criteria andTotalsaqGreaterThan(Integer value) {
            addCriterion("TotalSAQ >", value, "totalsaq");
            return (Criteria) this;
        }

        public Criteria andTotalsaqGreaterThanOrEqualTo(Integer value) {
            addCriterion("TotalSAQ >=", value, "totalsaq");
            return (Criteria) this;
        }

        public Criteria andTotalsaqLessThan(Integer value) {
            addCriterion("TotalSAQ <", value, "totalsaq");
            return (Criteria) this;
        }

        public Criteria andTotalsaqLessThanOrEqualTo(Integer value) {
            addCriterion("TotalSAQ <=", value, "totalsaq");
            return (Criteria) this;
        }

        public Criteria andTotalsaqIn(List<Integer> values) {
            addCriterion("TotalSAQ in", values, "totalsaq");
            return (Criteria) this;
        }

        public Criteria andTotalsaqNotIn(List<Integer> values) {
            addCriterion("TotalSAQ not in", values, "totalsaq");
            return (Criteria) this;
        }

        public Criteria andTotalsaqBetween(Integer value1, Integer value2) {
            addCriterion("TotalSAQ between", value1, value2, "totalsaq");
            return (Criteria) this;
        }

        public Criteria andTotalsaqNotBetween(Integer value1, Integer value2) {
            addCriterion("TotalSAQ not between", value1, value2, "totalsaq");
            return (Criteria) this;
        }

        public Criteria andSelectscoreIsNull() {
            addCriterion("SelectScore is null");
            return (Criteria) this;
        }

        public Criteria andSelectscoreIsNotNull() {
            addCriterion("SelectScore is not null");
            return (Criteria) this;
        }

        public Criteria andSelectscoreEqualTo(Integer value) {
            addCriterion("SelectScore =", value, "selectscore");
            return (Criteria) this;
        }

        public Criteria andSelectscoreNotEqualTo(Integer value) {
            addCriterion("SelectScore <>", value, "selectscore");
            return (Criteria) this;
        }

        public Criteria andSelectscoreGreaterThan(Integer value) {
            addCriterion("SelectScore >", value, "selectscore");
            return (Criteria) this;
        }

        public Criteria andSelectscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("SelectScore >=", value, "selectscore");
            return (Criteria) this;
        }

        public Criteria andSelectscoreLessThan(Integer value) {
            addCriterion("SelectScore <", value, "selectscore");
            return (Criteria) this;
        }

        public Criteria andSelectscoreLessThanOrEqualTo(Integer value) {
            addCriterion("SelectScore <=", value, "selectscore");
            return (Criteria) this;
        }

        public Criteria andSelectscoreIn(List<Integer> values) {
            addCriterion("SelectScore in", values, "selectscore");
            return (Criteria) this;
        }

        public Criteria andSelectscoreNotIn(List<Integer> values) {
            addCriterion("SelectScore not in", values, "selectscore");
            return (Criteria) this;
        }

        public Criteria andSelectscoreBetween(Integer value1, Integer value2) {
            addCriterion("SelectScore between", value1, value2, "selectscore");
            return (Criteria) this;
        }

        public Criteria andSelectscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("SelectScore not between", value1, value2, "selectscore");
            return (Criteria) this;
        }

        public Criteria andSaqscoreIsNull() {
            addCriterion("SAQScore is null");
            return (Criteria) this;
        }

        public Criteria andSaqscoreIsNotNull() {
            addCriterion("SAQScore is not null");
            return (Criteria) this;
        }

        public Criteria andSaqscoreEqualTo(Integer value) {
            addCriterion("SAQScore =", value, "saqscore");
            return (Criteria) this;
        }

        public Criteria andSaqscoreNotEqualTo(Integer value) {
            addCriterion("SAQScore <>", value, "saqscore");
            return (Criteria) this;
        }

        public Criteria andSaqscoreGreaterThan(Integer value) {
            addCriterion("SAQScore >", value, "saqscore");
            return (Criteria) this;
        }

        public Criteria andSaqscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("SAQScore >=", value, "saqscore");
            return (Criteria) this;
        }

        public Criteria andSaqscoreLessThan(Integer value) {
            addCriterion("SAQScore <", value, "saqscore");
            return (Criteria) this;
        }

        public Criteria andSaqscoreLessThanOrEqualTo(Integer value) {
            addCriterion("SAQScore <=", value, "saqscore");
            return (Criteria) this;
        }

        public Criteria andSaqscoreIn(List<Integer> values) {
            addCriterion("SAQScore in", values, "saqscore");
            return (Criteria) this;
        }

        public Criteria andSaqscoreNotIn(List<Integer> values) {
            addCriterion("SAQScore not in", values, "saqscore");
            return (Criteria) this;
        }

        public Criteria andSaqscoreBetween(Integer value1, Integer value2) {
            addCriterion("SAQScore between", value1, value2, "saqscore");
            return (Criteria) this;
        }

        public Criteria andSaqscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("SAQScore not between", value1, value2, "saqscore");
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