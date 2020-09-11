package com.sz.paper.model;

import java.util.ArrayList;
import java.util.List;

public class ItemsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ItemsExample() {
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

        public Criteria andEnameIsNull() {
            addCriterion("eName is null");
            return (Criteria) this;
        }

        public Criteria andEnameIsNotNull() {
            addCriterion("eName is not null");
            return (Criteria) this;
        }

        public Criteria andEnameEqualTo(String value) {
            addCriterion("eName =", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotEqualTo(String value) {
            addCriterion("eName <>", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameGreaterThan(String value) {
            addCriterion("eName >", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameGreaterThanOrEqualTo(String value) {
            addCriterion("eName >=", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLessThan(String value) {
            addCriterion("eName <", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLessThanOrEqualTo(String value) {
            addCriterion("eName <=", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLike(String value) {
            addCriterion("eName like", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotLike(String value) {
            addCriterion("eName not like", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameIn(List<String> values) {
            addCriterion("eName in", values, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotIn(List<String> values) {
            addCriterion("eName not in", values, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameBetween(String value1, String value2) {
            addCriterion("eName between", value1, value2, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotBetween(String value1, String value2) {
            addCriterion("eName not between", value1, value2, "ename");
            return (Criteria) this;
        }

        public Criteria andEpaperidIsNull() {
            addCriterion("ePaperId is null");
            return (Criteria) this;
        }

        public Criteria andEpaperidIsNotNull() {
            addCriterion("ePaperId is not null");
            return (Criteria) this;
        }

        public Criteria andEpaperidEqualTo(Integer value) {
            addCriterion("ePaperId =", value, "epaperid");
            return (Criteria) this;
        }

        public Criteria andEpaperidNotEqualTo(Integer value) {
            addCriterion("ePaperId <>", value, "epaperid");
            return (Criteria) this;
        }

        public Criteria andEpaperidGreaterThan(Integer value) {
            addCriterion("ePaperId >", value, "epaperid");
            return (Criteria) this;
        }

        public Criteria andEpaperidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ePaperId >=", value, "epaperid");
            return (Criteria) this;
        }

        public Criteria andEpaperidLessThan(Integer value) {
            addCriterion("ePaperId <", value, "epaperid");
            return (Criteria) this;
        }

        public Criteria andEpaperidLessThanOrEqualTo(Integer value) {
            addCriterion("ePaperId <=", value, "epaperid");
            return (Criteria) this;
        }

        public Criteria andEpaperidIn(List<Integer> values) {
            addCriterion("ePaperId in", values, "epaperid");
            return (Criteria) this;
        }

        public Criteria andEpaperidNotIn(List<Integer> values) {
            addCriterion("ePaperId not in", values, "epaperid");
            return (Criteria) this;
        }

        public Criteria andEpaperidBetween(Integer value1, Integer value2) {
            addCriterion("ePaperId between", value1, value2, "epaperid");
            return (Criteria) this;
        }

        public Criteria andEpaperidNotBetween(Integer value1, Integer value2) {
            addCriterion("ePaperId not between", value1, value2, "epaperid");
            return (Criteria) this;
        }

        public Criteria andEscoreIsNull() {
            addCriterion("eScore is null");
            return (Criteria) this;
        }

        public Criteria andEscoreIsNotNull() {
            addCriterion("eScore is not null");
            return (Criteria) this;
        }

        public Criteria andEscoreEqualTo(String value) {
            addCriterion("eScore =", value, "escore");
            return (Criteria) this;
        }

        public Criteria andEscoreNotEqualTo(String value) {
            addCriterion("eScore <>", value, "escore");
            return (Criteria) this;
        }

        public Criteria andEscoreGreaterThan(String value) {
            addCriterion("eScore >", value, "escore");
            return (Criteria) this;
        }

        public Criteria andEscoreGreaterThanOrEqualTo(String value) {
            addCriterion("eScore >=", value, "escore");
            return (Criteria) this;
        }

        public Criteria andEscoreLessThan(String value) {
            addCriterion("eScore <", value, "escore");
            return (Criteria) this;
        }

        public Criteria andEscoreLessThanOrEqualTo(String value) {
            addCriterion("eScore <=", value, "escore");
            return (Criteria) this;
        }

        public Criteria andEscoreLike(String value) {
            addCriterion("eScore like", value, "escore");
            return (Criteria) this;
        }

        public Criteria andEscoreNotLike(String value) {
            addCriterion("eScore not like", value, "escore");
            return (Criteria) this;
        }

        public Criteria andEscoreIn(List<String> values) {
            addCriterion("eScore in", values, "escore");
            return (Criteria) this;
        }

        public Criteria andEscoreNotIn(List<String> values) {
            addCriterion("eScore not in", values, "escore");
            return (Criteria) this;
        }

        public Criteria andEscoreBetween(String value1, String value2) {
            addCriterion("eScore between", value1, value2, "escore");
            return (Criteria) this;
        }

        public Criteria andEscoreNotBetween(String value1, String value2) {
            addCriterion("eScore not between", value1, value2, "escore");
            return (Criteria) this;
        }

        public Criteria andEtypeIsNull() {
            addCriterion("eType is null");
            return (Criteria) this;
        }

        public Criteria andEtypeIsNotNull() {
            addCriterion("eType is not null");
            return (Criteria) this;
        }

        public Criteria andEtypeEqualTo(Integer value) {
            addCriterion("eType =", value, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeNotEqualTo(Integer value) {
            addCriterion("eType <>", value, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeGreaterThan(Integer value) {
            addCriterion("eType >", value, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("eType >=", value, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeLessThan(Integer value) {
            addCriterion("eType <", value, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeLessThanOrEqualTo(Integer value) {
            addCriterion("eType <=", value, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeIn(List<Integer> values) {
            addCriterion("eType in", values, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeNotIn(List<Integer> values) {
            addCriterion("eType not in", values, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeBetween(Integer value1, Integer value2) {
            addCriterion("eType between", value1, value2, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("eType not between", value1, value2, "etype");
            return (Criteria) this;
        }

        public Criteria andEdegreeIsNull() {
            addCriterion("eDegree is null");
            return (Criteria) this;
        }

        public Criteria andEdegreeIsNotNull() {
            addCriterion("eDegree is not null");
            return (Criteria) this;
        }

        public Criteria andEdegreeEqualTo(Integer value) {
            addCriterion("eDegree =", value, "edegree");
            return (Criteria) this;
        }

        public Criteria andEdegreeNotEqualTo(Integer value) {
            addCriterion("eDegree <>", value, "edegree");
            return (Criteria) this;
        }

        public Criteria andEdegreeGreaterThan(Integer value) {
            addCriterion("eDegree >", value, "edegree");
            return (Criteria) this;
        }

        public Criteria andEdegreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("eDegree >=", value, "edegree");
            return (Criteria) this;
        }

        public Criteria andEdegreeLessThan(Integer value) {
            addCriterion("eDegree <", value, "edegree");
            return (Criteria) this;
        }

        public Criteria andEdegreeLessThanOrEqualTo(Integer value) {
            addCriterion("eDegree <=", value, "edegree");
            return (Criteria) this;
        }

        public Criteria andEdegreeIn(List<Integer> values) {
            addCriterion("eDegree in", values, "edegree");
            return (Criteria) this;
        }

        public Criteria andEdegreeNotIn(List<Integer> values) {
            addCriterion("eDegree not in", values, "edegree");
            return (Criteria) this;
        }

        public Criteria andEdegreeBetween(Integer value1, Integer value2) {
            addCriterion("eDegree between", value1, value2, "edegree");
            return (Criteria) this;
        }

        public Criteria andEdegreeNotBetween(Integer value1, Integer value2) {
            addCriterion("eDegree not between", value1, value2, "edegree");
            return (Criteria) this;
        }

        public Criteria andEaIsNull() {
            addCriterion("ea is null");
            return (Criteria) this;
        }

        public Criteria andEaIsNotNull() {
            addCriterion("ea is not null");
            return (Criteria) this;
        }

        public Criteria andEaEqualTo(String value) {
            addCriterion("ea =", value, "ea");
            return (Criteria) this;
        }

        public Criteria andEaNotEqualTo(String value) {
            addCriterion("ea <>", value, "ea");
            return (Criteria) this;
        }

        public Criteria andEaGreaterThan(String value) {
            addCriterion("ea >", value, "ea");
            return (Criteria) this;
        }

        public Criteria andEaGreaterThanOrEqualTo(String value) {
            addCriterion("ea >=", value, "ea");
            return (Criteria) this;
        }

        public Criteria andEaLessThan(String value) {
            addCriterion("ea <", value, "ea");
            return (Criteria) this;
        }

        public Criteria andEaLessThanOrEqualTo(String value) {
            addCriterion("ea <=", value, "ea");
            return (Criteria) this;
        }

        public Criteria andEaLike(String value) {
            addCriterion("ea like", value, "ea");
            return (Criteria) this;
        }

        public Criteria andEaNotLike(String value) {
            addCriterion("ea not like", value, "ea");
            return (Criteria) this;
        }

        public Criteria andEaIn(List<String> values) {
            addCriterion("ea in", values, "ea");
            return (Criteria) this;
        }

        public Criteria andEaNotIn(List<String> values) {
            addCriterion("ea not in", values, "ea");
            return (Criteria) this;
        }

        public Criteria andEaBetween(String value1, String value2) {
            addCriterion("ea between", value1, value2, "ea");
            return (Criteria) this;
        }

        public Criteria andEaNotBetween(String value1, String value2) {
            addCriterion("ea not between", value1, value2, "ea");
            return (Criteria) this;
        }

        public Criteria andEbIsNull() {
            addCriterion("eb is null");
            return (Criteria) this;
        }

        public Criteria andEbIsNotNull() {
            addCriterion("eb is not null");
            return (Criteria) this;
        }

        public Criteria andEbEqualTo(String value) {
            addCriterion("eb =", value, "eb");
            return (Criteria) this;
        }

        public Criteria andEbNotEqualTo(String value) {
            addCriterion("eb <>", value, "eb");
            return (Criteria) this;
        }

        public Criteria andEbGreaterThan(String value) {
            addCriterion("eb >", value, "eb");
            return (Criteria) this;
        }

        public Criteria andEbGreaterThanOrEqualTo(String value) {
            addCriterion("eb >=", value, "eb");
            return (Criteria) this;
        }

        public Criteria andEbLessThan(String value) {
            addCriterion("eb <", value, "eb");
            return (Criteria) this;
        }

        public Criteria andEbLessThanOrEqualTo(String value) {
            addCriterion("eb <=", value, "eb");
            return (Criteria) this;
        }

        public Criteria andEbLike(String value) {
            addCriterion("eb like", value, "eb");
            return (Criteria) this;
        }

        public Criteria andEbNotLike(String value) {
            addCriterion("eb not like", value, "eb");
            return (Criteria) this;
        }

        public Criteria andEbIn(List<String> values) {
            addCriterion("eb in", values, "eb");
            return (Criteria) this;
        }

        public Criteria andEbNotIn(List<String> values) {
            addCriterion("eb not in", values, "eb");
            return (Criteria) this;
        }

        public Criteria andEbBetween(String value1, String value2) {
            addCriterion("eb between", value1, value2, "eb");
            return (Criteria) this;
        }

        public Criteria andEbNotBetween(String value1, String value2) {
            addCriterion("eb not between", value1, value2, "eb");
            return (Criteria) this;
        }

        public Criteria andEcIsNull() {
            addCriterion("ec is null");
            return (Criteria) this;
        }

        public Criteria andEcIsNotNull() {
            addCriterion("ec is not null");
            return (Criteria) this;
        }

        public Criteria andEcEqualTo(String value) {
            addCriterion("ec =", value, "ec");
            return (Criteria) this;
        }

        public Criteria andEcNotEqualTo(String value) {
            addCriterion("ec <>", value, "ec");
            return (Criteria) this;
        }

        public Criteria andEcGreaterThan(String value) {
            addCriterion("ec >", value, "ec");
            return (Criteria) this;
        }

        public Criteria andEcGreaterThanOrEqualTo(String value) {
            addCriterion("ec >=", value, "ec");
            return (Criteria) this;
        }

        public Criteria andEcLessThan(String value) {
            addCriterion("ec <", value, "ec");
            return (Criteria) this;
        }

        public Criteria andEcLessThanOrEqualTo(String value) {
            addCriterion("ec <=", value, "ec");
            return (Criteria) this;
        }

        public Criteria andEcLike(String value) {
            addCriterion("ec like", value, "ec");
            return (Criteria) this;
        }

        public Criteria andEcNotLike(String value) {
            addCriterion("ec not like", value, "ec");
            return (Criteria) this;
        }

        public Criteria andEcIn(List<String> values) {
            addCriterion("ec in", values, "ec");
            return (Criteria) this;
        }

        public Criteria andEcNotIn(List<String> values) {
            addCriterion("ec not in", values, "ec");
            return (Criteria) this;
        }

        public Criteria andEcBetween(String value1, String value2) {
            addCriterion("ec between", value1, value2, "ec");
            return (Criteria) this;
        }

        public Criteria andEcNotBetween(String value1, String value2) {
            addCriterion("ec not between", value1, value2, "ec");
            return (Criteria) this;
        }

        public Criteria andEdIsNull() {
            addCriterion("ed is null");
            return (Criteria) this;
        }

        public Criteria andEdIsNotNull() {
            addCriterion("ed is not null");
            return (Criteria) this;
        }

        public Criteria andEdEqualTo(String value) {
            addCriterion("ed =", value, "ed");
            return (Criteria) this;
        }

        public Criteria andEdNotEqualTo(String value) {
            addCriterion("ed <>", value, "ed");
            return (Criteria) this;
        }

        public Criteria andEdGreaterThan(String value) {
            addCriterion("ed >", value, "ed");
            return (Criteria) this;
        }

        public Criteria andEdGreaterThanOrEqualTo(String value) {
            addCriterion("ed >=", value, "ed");
            return (Criteria) this;
        }

        public Criteria andEdLessThan(String value) {
            addCriterion("ed <", value, "ed");
            return (Criteria) this;
        }

        public Criteria andEdLessThanOrEqualTo(String value) {
            addCriterion("ed <=", value, "ed");
            return (Criteria) this;
        }

        public Criteria andEdLike(String value) {
            addCriterion("ed like", value, "ed");
            return (Criteria) this;
        }

        public Criteria andEdNotLike(String value) {
            addCriterion("ed not like", value, "ed");
            return (Criteria) this;
        }

        public Criteria andEdIn(List<String> values) {
            addCriterion("ed in", values, "ed");
            return (Criteria) this;
        }

        public Criteria andEdNotIn(List<String> values) {
            addCriterion("ed not in", values, "ed");
            return (Criteria) this;
        }

        public Criteria andEdBetween(String value1, String value2) {
            addCriterion("ed between", value1, value2, "ed");
            return (Criteria) this;
        }

        public Criteria andEdNotBetween(String value1, String value2) {
            addCriterion("ed not between", value1, value2, "ed");
            return (Criteria) this;
        }

        public Criteria andEeIsNull() {
            addCriterion("ee is null");
            return (Criteria) this;
        }

        public Criteria andEeIsNotNull() {
            addCriterion("ee is not null");
            return (Criteria) this;
        }

        public Criteria andEeEqualTo(String value) {
            addCriterion("ee =", value, "ee");
            return (Criteria) this;
        }

        public Criteria andEeNotEqualTo(String value) {
            addCriterion("ee <>", value, "ee");
            return (Criteria) this;
        }

        public Criteria andEeGreaterThan(String value) {
            addCriterion("ee >", value, "ee");
            return (Criteria) this;
        }

        public Criteria andEeGreaterThanOrEqualTo(String value) {
            addCriterion("ee >=", value, "ee");
            return (Criteria) this;
        }

        public Criteria andEeLessThan(String value) {
            addCriterion("ee <", value, "ee");
            return (Criteria) this;
        }

        public Criteria andEeLessThanOrEqualTo(String value) {
            addCriterion("ee <=", value, "ee");
            return (Criteria) this;
        }

        public Criteria andEeLike(String value) {
            addCriterion("ee like", value, "ee");
            return (Criteria) this;
        }

        public Criteria andEeNotLike(String value) {
            addCriterion("ee not like", value, "ee");
            return (Criteria) this;
        }

        public Criteria andEeIn(List<String> values) {
            addCriterion("ee in", values, "ee");
            return (Criteria) this;
        }

        public Criteria andEeNotIn(List<String> values) {
            addCriterion("ee not in", values, "ee");
            return (Criteria) this;
        }

        public Criteria andEeBetween(String value1, String value2) {
            addCriterion("ee between", value1, value2, "ee");
            return (Criteria) this;
        }

        public Criteria andEeNotBetween(String value1, String value2) {
            addCriterion("ee not between", value1, value2, "ee");
            return (Criteria) this;
        }

        public Criteria andEfIsNull() {
            addCriterion("ef is null");
            return (Criteria) this;
        }

        public Criteria andEfIsNotNull() {
            addCriterion("ef is not null");
            return (Criteria) this;
        }

        public Criteria andEfEqualTo(String value) {
            addCriterion("ef =", value, "ef");
            return (Criteria) this;
        }

        public Criteria andEfNotEqualTo(String value) {
            addCriterion("ef <>", value, "ef");
            return (Criteria) this;
        }

        public Criteria andEfGreaterThan(String value) {
            addCriterion("ef >", value, "ef");
            return (Criteria) this;
        }

        public Criteria andEfGreaterThanOrEqualTo(String value) {
            addCriterion("ef >=", value, "ef");
            return (Criteria) this;
        }

        public Criteria andEfLessThan(String value) {
            addCriterion("ef <", value, "ef");
            return (Criteria) this;
        }

        public Criteria andEfLessThanOrEqualTo(String value) {
            addCriterion("ef <=", value, "ef");
            return (Criteria) this;
        }

        public Criteria andEfLike(String value) {
            addCriterion("ef like", value, "ef");
            return (Criteria) this;
        }

        public Criteria andEfNotLike(String value) {
            addCriterion("ef not like", value, "ef");
            return (Criteria) this;
        }

        public Criteria andEfIn(List<String> values) {
            addCriterion("ef in", values, "ef");
            return (Criteria) this;
        }

        public Criteria andEfNotIn(List<String> values) {
            addCriterion("ef not in", values, "ef");
            return (Criteria) this;
        }

        public Criteria andEfBetween(String value1, String value2) {
            addCriterion("ef between", value1, value2, "ef");
            return (Criteria) this;
        }

        public Criteria andEfNotBetween(String value1, String value2) {
            addCriterion("ef not between", value1, value2, "ef");
            return (Criteria) this;
        }

        public Criteria andEkeyIsNull() {
            addCriterion("eKey is null");
            return (Criteria) this;
        }

        public Criteria andEkeyIsNotNull() {
            addCriterion("eKey is not null");
            return (Criteria) this;
        }

        public Criteria andEkeyEqualTo(String value) {
            addCriterion("eKey =", value, "ekey");
            return (Criteria) this;
        }

        public Criteria andEkeyNotEqualTo(String value) {
            addCriterion("eKey <>", value, "ekey");
            return (Criteria) this;
        }

        public Criteria andEkeyGreaterThan(String value) {
            addCriterion("eKey >", value, "ekey");
            return (Criteria) this;
        }

        public Criteria andEkeyGreaterThanOrEqualTo(String value) {
            addCriterion("eKey >=", value, "ekey");
            return (Criteria) this;
        }

        public Criteria andEkeyLessThan(String value) {
            addCriterion("eKey <", value, "ekey");
            return (Criteria) this;
        }

        public Criteria andEkeyLessThanOrEqualTo(String value) {
            addCriterion("eKey <=", value, "ekey");
            return (Criteria) this;
        }

        public Criteria andEkeyLike(String value) {
            addCriterion("eKey like", value, "ekey");
            return (Criteria) this;
        }

        public Criteria andEkeyNotLike(String value) {
            addCriterion("eKey not like", value, "ekey");
            return (Criteria) this;
        }

        public Criteria andEkeyIn(List<String> values) {
            addCriterion("eKey in", values, "ekey");
            return (Criteria) this;
        }

        public Criteria andEkeyNotIn(List<String> values) {
            addCriterion("eKey not in", values, "ekey");
            return (Criteria) this;
        }

        public Criteria andEkeyBetween(String value1, String value2) {
            addCriterion("eKey between", value1, value2, "ekey");
            return (Criteria) this;
        }

        public Criteria andEkeyNotBetween(String value1, String value2) {
            addCriterion("eKey not between", value1, value2, "ekey");
            return (Criteria) this;
        }

        public Criteria andEhintsIsNull() {
            addCriterion("eHints is null");
            return (Criteria) this;
        }

        public Criteria andEhintsIsNotNull() {
            addCriterion("eHints is not null");
            return (Criteria) this;
        }

        public Criteria andEhintsEqualTo(String value) {
            addCriterion("eHints =", value, "ehints");
            return (Criteria) this;
        }

        public Criteria andEhintsNotEqualTo(String value) {
            addCriterion("eHints <>", value, "ehints");
            return (Criteria) this;
        }

        public Criteria andEhintsGreaterThan(String value) {
            addCriterion("eHints >", value, "ehints");
            return (Criteria) this;
        }

        public Criteria andEhintsGreaterThanOrEqualTo(String value) {
            addCriterion("eHints >=", value, "ehints");
            return (Criteria) this;
        }

        public Criteria andEhintsLessThan(String value) {
            addCriterion("eHints <", value, "ehints");
            return (Criteria) this;
        }

        public Criteria andEhintsLessThanOrEqualTo(String value) {
            addCriterion("eHints <=", value, "ehints");
            return (Criteria) this;
        }

        public Criteria andEhintsLike(String value) {
            addCriterion("eHints like", value, "ehints");
            return (Criteria) this;
        }

        public Criteria andEhintsNotLike(String value) {
            addCriterion("eHints not like", value, "ehints");
            return (Criteria) this;
        }

        public Criteria andEhintsIn(List<String> values) {
            addCriterion("eHints in", values, "ehints");
            return (Criteria) this;
        }

        public Criteria andEhintsNotIn(List<String> values) {
            addCriterion("eHints not in", values, "ehints");
            return (Criteria) this;
        }

        public Criteria andEhintsBetween(String value1, String value2) {
            addCriterion("eHints between", value1, value2, "ehints");
            return (Criteria) this;
        }

        public Criteria andEhintsNotBetween(String value1, String value2) {
            addCriterion("eHints not between", value1, value2, "ehints");
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