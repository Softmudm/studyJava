package com.sz.wx.model;

import java.util.ArrayList;
import java.util.List;

public class ScoreDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScoreDetailExample() {
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

        public Criteria andDetailidIsNull() {
            addCriterion("detailId is null");
            return (Criteria) this;
        }

        public Criteria andDetailidIsNotNull() {
            addCriterion("detailId is not null");
            return (Criteria) this;
        }

        public Criteria andDetailidEqualTo(Integer value) {
            addCriterion("detailId =", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidNotEqualTo(Integer value) {
            addCriterion("detailId <>", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidGreaterThan(Integer value) {
            addCriterion("detailId >", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidGreaterThanOrEqualTo(Integer value) {
            addCriterion("detailId >=", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidLessThan(Integer value) {
            addCriterion("detailId <", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidLessThanOrEqualTo(Integer value) {
            addCriterion("detailId <=", value, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidIn(List<Integer> values) {
            addCriterion("detailId in", values, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidNotIn(List<Integer> values) {
            addCriterion("detailId not in", values, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidBetween(Integer value1, Integer value2) {
            addCriterion("detailId between", value1, value2, "detailid");
            return (Criteria) this;
        }

        public Criteria andDetailidNotBetween(Integer value1, Integer value2) {
            addCriterion("detailId not between", value1, value2, "detailid");
            return (Criteria) this;
        }

        public Criteria andScoreidIsNull() {
            addCriterion("scoreId is null");
            return (Criteria) this;
        }

        public Criteria andScoreidIsNotNull() {
            addCriterion("scoreId is not null");
            return (Criteria) this;
        }

        public Criteria andScoreidEqualTo(Integer value) {
            addCriterion("scoreId =", value, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidNotEqualTo(Integer value) {
            addCriterion("scoreId <>", value, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidGreaterThan(Integer value) {
            addCriterion("scoreId >", value, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidGreaterThanOrEqualTo(Integer value) {
            addCriterion("scoreId >=", value, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidLessThan(Integer value) {
            addCriterion("scoreId <", value, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidLessThanOrEqualTo(Integer value) {
            addCriterion("scoreId <=", value, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidIn(List<Integer> values) {
            addCriterion("scoreId in", values, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidNotIn(List<Integer> values) {
            addCriterion("scoreId not in", values, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidBetween(Integer value1, Integer value2) {
            addCriterion("scoreId between", value1, value2, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidNotBetween(Integer value1, Integer value2) {
            addCriterion("scoreId not between", value1, value2, "scoreid");
            return (Criteria) this;
        }

        public Criteria andEidIsNull() {
            addCriterion("eId is null");
            return (Criteria) this;
        }

        public Criteria andEidIsNotNull() {
            addCriterion("eId is not null");
            return (Criteria) this;
        }

        public Criteria andEidEqualTo(Integer value) {
            addCriterion("eId =", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotEqualTo(Integer value) {
            addCriterion("eId <>", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThan(Integer value) {
            addCriterion("eId >", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThanOrEqualTo(Integer value) {
            addCriterion("eId >=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThan(Integer value) {
            addCriterion("eId <", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThanOrEqualTo(Integer value) {
            addCriterion("eId <=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidIn(List<Integer> values) {
            addCriterion("eId in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotIn(List<Integer> values) {
            addCriterion("eId not in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidBetween(Integer value1, Integer value2) {
            addCriterion("eId between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotBetween(Integer value1, Integer value2) {
            addCriterion("eId not between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andUanswerIsNull() {
            addCriterion("uAnswer is null");
            return (Criteria) this;
        }

        public Criteria andUanswerIsNotNull() {
            addCriterion("uAnswer is not null");
            return (Criteria) this;
        }

        public Criteria andUanswerEqualTo(String value) {
            addCriterion("uAnswer =", value, "uanswer");
            return (Criteria) this;
        }

        public Criteria andUanswerNotEqualTo(String value) {
            addCriterion("uAnswer <>", value, "uanswer");
            return (Criteria) this;
        }

        public Criteria andUanswerGreaterThan(String value) {
            addCriterion("uAnswer >", value, "uanswer");
            return (Criteria) this;
        }

        public Criteria andUanswerGreaterThanOrEqualTo(String value) {
            addCriterion("uAnswer >=", value, "uanswer");
            return (Criteria) this;
        }

        public Criteria andUanswerLessThan(String value) {
            addCriterion("uAnswer <", value, "uanswer");
            return (Criteria) this;
        }

        public Criteria andUanswerLessThanOrEqualTo(String value) {
            addCriterion("uAnswer <=", value, "uanswer");
            return (Criteria) this;
        }

        public Criteria andUanswerLike(String value) {
            addCriterion("uAnswer like", value, "uanswer");
            return (Criteria) this;
        }

        public Criteria andUanswerNotLike(String value) {
            addCriterion("uAnswer not like", value, "uanswer");
            return (Criteria) this;
        }

        public Criteria andUanswerIn(List<String> values) {
            addCriterion("uAnswer in", values, "uanswer");
            return (Criteria) this;
        }

        public Criteria andUanswerNotIn(List<String> values) {
            addCriterion("uAnswer not in", values, "uanswer");
            return (Criteria) this;
        }

        public Criteria andUanswerBetween(String value1, String value2) {
            addCriterion("uAnswer between", value1, value2, "uanswer");
            return (Criteria) this;
        }

        public Criteria andUanswerNotBetween(String value1, String value2) {
            addCriterion("uAnswer not between", value1, value2, "uanswer");
            return (Criteria) this;
        }

        public Criteria andUpointIsNull() {
            addCriterion("upoint is null");
            return (Criteria) this;
        }

        public Criteria andUpointIsNotNull() {
            addCriterion("upoint is not null");
            return (Criteria) this;
        }

        public Criteria andUpointEqualTo(Integer value) {
            addCriterion("upoint =", value, "upoint");
            return (Criteria) this;
        }

        public Criteria andUpointNotEqualTo(Integer value) {
            addCriterion("upoint <>", value, "upoint");
            return (Criteria) this;
        }

        public Criteria andUpointGreaterThan(Integer value) {
            addCriterion("upoint >", value, "upoint");
            return (Criteria) this;
        }

        public Criteria andUpointGreaterThanOrEqualTo(Integer value) {
            addCriterion("upoint >=", value, "upoint");
            return (Criteria) this;
        }

        public Criteria andUpointLessThan(Integer value) {
            addCriterion("upoint <", value, "upoint");
            return (Criteria) this;
        }

        public Criteria andUpointLessThanOrEqualTo(Integer value) {
            addCriterion("upoint <=", value, "upoint");
            return (Criteria) this;
        }

        public Criteria andUpointIn(List<Integer> values) {
            addCriterion("upoint in", values, "upoint");
            return (Criteria) this;
        }

        public Criteria andUpointNotIn(List<Integer> values) {
            addCriterion("upoint not in", values, "upoint");
            return (Criteria) this;
        }

        public Criteria andUpointBetween(Integer value1, Integer value2) {
            addCriterion("upoint between", value1, value2, "upoint");
            return (Criteria) this;
        }

        public Criteria andUpointNotBetween(Integer value1, Integer value2) {
            addCriterion("upoint not between", value1, value2, "upoint");
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