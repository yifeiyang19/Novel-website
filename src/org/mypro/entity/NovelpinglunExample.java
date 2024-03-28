package org.mypro.entity;

import java.util.ArrayList;
import java.util.List;

public class NovelpinglunExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NovelpinglunExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNovelIsNull() {
            addCriterion("novel is null");
            return (Criteria) this;
        }

        public Criteria andNovelIsNotNull() {
            addCriterion("novel is not null");
            return (Criteria) this;
        }

        public Criteria andNovelEqualTo(String value) {
            addCriterion("novel =", value, "novel");
            return (Criteria) this;
        }

        public Criteria andNovelNotEqualTo(String value) {
            addCriterion("novel <>", value, "novel");
            return (Criteria) this;
        }

        public Criteria andNovelGreaterThan(String value) {
            addCriterion("novel >", value, "novel");
            return (Criteria) this;
        }

        public Criteria andNovelGreaterThanOrEqualTo(String value) {
            addCriterion("novel >=", value, "novel");
            return (Criteria) this;
        }

        public Criteria andNovelLessThan(String value) {
            addCriterion("novel <", value, "novel");
            return (Criteria) this;
        }

        public Criteria andNovelLessThanOrEqualTo(String value) {
            addCriterion("novel <=", value, "novel");
            return (Criteria) this;
        }

        public Criteria andNovelLike(String value) {
            addCriterion("novel like", value, "novel");
            return (Criteria) this;
        }

        public Criteria andNovelNotLike(String value) {
            addCriterion("novel not like", value, "novel");
            return (Criteria) this;
        }

        public Criteria andNovelIn(List<String> values) {
            addCriterion("novel in", values, "novel");
            return (Criteria) this;
        }

        public Criteria andNovelNotIn(List<String> values) {
            addCriterion("novel not in", values, "novel");
            return (Criteria) this;
        }

        public Criteria andNovelBetween(String value1, String value2) {
            addCriterion("novel between", value1, value2, "novel");
            return (Criteria) this;
        }

        public Criteria andNovelNotBetween(String value1, String value2) {
            addCriterion("novel not between", value1, value2, "novel");
            return (Criteria) this;
        }

        public Criteria andNovelidIsNull() {
            addCriterion("novelid is null");
            return (Criteria) this;
        }

        public Criteria andNovelidIsNotNull() {
            addCriterion("novelid is not null");
            return (Criteria) this;
        }

        public Criteria andNovelidEqualTo(Integer value) {
            addCriterion("novelid =", value, "novelid");
            return (Criteria) this;
        }

        public Criteria andNovelidNotEqualTo(Integer value) {
            addCriterion("novelid <>", value, "novelid");
            return (Criteria) this;
        }

        public Criteria andNovelidGreaterThan(Integer value) {
            addCriterion("novelid >", value, "novelid");
            return (Criteria) this;
        }

        public Criteria andNovelidGreaterThanOrEqualTo(Integer value) {
            addCriterion("novelid >=", value, "novelid");
            return (Criteria) this;
        }

        public Criteria andNovelidLessThan(Integer value) {
            addCriterion("novelid <", value, "novelid");
            return (Criteria) this;
        }

        public Criteria andNovelidLessThanOrEqualTo(Integer value) {
            addCriterion("novelid <=", value, "novelid");
            return (Criteria) this;
        }

        public Criteria andNovelidIn(List<Integer> values) {
            addCriterion("novelid in", values, "novelid");
            return (Criteria) this;
        }

        public Criteria andNovelidNotIn(List<Integer> values) {
            addCriterion("novelid not in", values, "novelid");
            return (Criteria) this;
        }

        public Criteria andNovelidBetween(Integer value1, Integer value2) {
            addCriterion("novelid between", value1, value2, "novelid");
            return (Criteria) this;
        }

        public Criteria andNovelidNotBetween(Integer value1, Integer value2) {
            addCriterion("novelid not between", value1, value2, "novelid");
            return (Criteria) this;
        }

        public Criteria andNeirongIsNull() {
            addCriterion("neirong is null");
            return (Criteria) this;
        }

        public Criteria andNeirongIsNotNull() {
            addCriterion("neirong is not null");
            return (Criteria) this;
        }

        public Criteria andNeirongEqualTo(String value) {
            addCriterion("neirong =", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongNotEqualTo(String value) {
            addCriterion("neirong <>", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongGreaterThan(String value) {
            addCriterion("neirong >", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongGreaterThanOrEqualTo(String value) {
            addCriterion("neirong >=", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongLessThan(String value) {
            addCriterion("neirong <", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongLessThanOrEqualTo(String value) {
            addCriterion("neirong <=", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongLike(String value) {
            addCriterion("neirong like", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongNotLike(String value) {
            addCriterion("neirong not like", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongIn(List<String> values) {
            addCriterion("neirong in", values, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongNotIn(List<String> values) {
            addCriterion("neirong not in", values, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongBetween(String value1, String value2) {
            addCriterion("neirong between", value1, value2, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongNotBetween(String value1, String value2) {
            addCriterion("neirong not between", value1, value2, "neirong");
            return (Criteria) this;
        }

        public Criteria andPinglunrenmingziIsNull() {
            addCriterion("pinglunrenmingzi is null");
            return (Criteria) this;
        }

        public Criteria andPinglunrenmingziIsNotNull() {
            addCriterion("pinglunrenmingzi is not null");
            return (Criteria) this;
        }

        public Criteria andPinglunrenmingziEqualTo(String value) {
            addCriterion("pinglunrenmingzi =", value, "pinglunrenmingzi");
            return (Criteria) this;
        }

        public Criteria andPinglunrenmingziNotEqualTo(String value) {
            addCriterion("pinglunrenmingzi <>", value, "pinglunrenmingzi");
            return (Criteria) this;
        }

        public Criteria andPinglunrenmingziGreaterThan(String value) {
            addCriterion("pinglunrenmingzi >", value, "pinglunrenmingzi");
            return (Criteria) this;
        }

        public Criteria andPinglunrenmingziGreaterThanOrEqualTo(String value) {
            addCriterion("pinglunrenmingzi >=", value, "pinglunrenmingzi");
            return (Criteria) this;
        }

        public Criteria andPinglunrenmingziLessThan(String value) {
            addCriterion("pinglunrenmingzi <", value, "pinglunrenmingzi");
            return (Criteria) this;
        }

        public Criteria andPinglunrenmingziLessThanOrEqualTo(String value) {
            addCriterion("pinglunrenmingzi <=", value, "pinglunrenmingzi");
            return (Criteria) this;
        }

        public Criteria andPinglunrenmingziLike(String value) {
            addCriterion("pinglunrenmingzi like", value, "pinglunrenmingzi");
            return (Criteria) this;
        }

        public Criteria andPinglunrenmingziNotLike(String value) {
            addCriterion("pinglunrenmingzi not like", value, "pinglunrenmingzi");
            return (Criteria) this;
        }

        public Criteria andPinglunrenmingziIn(List<String> values) {
            addCriterion("pinglunrenmingzi in", values, "pinglunrenmingzi");
            return (Criteria) this;
        }

        public Criteria andPinglunrenmingziNotIn(List<String> values) {
            addCriterion("pinglunrenmingzi not in", values, "pinglunrenmingzi");
            return (Criteria) this;
        }

        public Criteria andPinglunrenmingziBetween(String value1, String value2) {
            addCriterion("pinglunrenmingzi between", value1, value2, "pinglunrenmingzi");
            return (Criteria) this;
        }

        public Criteria andPinglunrenmingziNotBetween(String value1, String value2) {
            addCriterion("pinglunrenmingzi not between", value1, value2, "pinglunrenmingzi");
            return (Criteria) this;
        }

        public Criteria andPinglunrenidIsNull() {
            addCriterion("pinglunrenid is null");
            return (Criteria) this;
        }

        public Criteria andPinglunrenidIsNotNull() {
            addCriterion("pinglunrenid is not null");
            return (Criteria) this;
        }

        public Criteria andPinglunrenidEqualTo(Integer value) {
            addCriterion("pinglunrenid =", value, "pinglunrenid");
            return (Criteria) this;
        }

        public Criteria andPinglunrenidNotEqualTo(Integer value) {
            addCriterion("pinglunrenid <>", value, "pinglunrenid");
            return (Criteria) this;
        }

        public Criteria andPinglunrenidGreaterThan(Integer value) {
            addCriterion("pinglunrenid >", value, "pinglunrenid");
            return (Criteria) this;
        }

        public Criteria andPinglunrenidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pinglunrenid >=", value, "pinglunrenid");
            return (Criteria) this;
        }

        public Criteria andPinglunrenidLessThan(Integer value) {
            addCriterion("pinglunrenid <", value, "pinglunrenid");
            return (Criteria) this;
        }

        public Criteria andPinglunrenidLessThanOrEqualTo(Integer value) {
            addCriterion("pinglunrenid <=", value, "pinglunrenid");
            return (Criteria) this;
        }

        public Criteria andPinglunrenidIn(List<Integer> values) {
            addCriterion("pinglunrenid in", values, "pinglunrenid");
            return (Criteria) this;
        }

        public Criteria andPinglunrenidNotIn(List<Integer> values) {
            addCriterion("pinglunrenid not in", values, "pinglunrenid");
            return (Criteria) this;
        }

        public Criteria andPinglunrenidBetween(Integer value1, Integer value2) {
            addCriterion("pinglunrenid between", value1, value2, "pinglunrenid");
            return (Criteria) this;
        }

        public Criteria andPinglunrenidNotBetween(Integer value1, Integer value2) {
            addCriterion("pinglunrenid not between", value1, value2, "pinglunrenid");
            return (Criteria) this;
        }

        public Criteria andPinglunshijianIsNull() {
            addCriterion("pinglunshijian is null");
            return (Criteria) this;
        }

        public Criteria andPinglunshijianIsNotNull() {
            addCriterion("pinglunshijian is not null");
            return (Criteria) this;
        }

        public Criteria andPinglunshijianEqualTo(String value) {
            addCriterion("pinglunshijian =", value, "pinglunshijian");
            return (Criteria) this;
        }

        public Criteria andPinglunshijianNotEqualTo(String value) {
            addCriterion("pinglunshijian <>", value, "pinglunshijian");
            return (Criteria) this;
        }

        public Criteria andPinglunshijianGreaterThan(String value) {
            addCriterion("pinglunshijian >", value, "pinglunshijian");
            return (Criteria) this;
        }

        public Criteria andPinglunshijianGreaterThanOrEqualTo(String value) {
            addCriterion("pinglunshijian >=", value, "pinglunshijian");
            return (Criteria) this;
        }

        public Criteria andPinglunshijianLessThan(String value) {
            addCriterion("pinglunshijian <", value, "pinglunshijian");
            return (Criteria) this;
        }

        public Criteria andPinglunshijianLessThanOrEqualTo(String value) {
            addCriterion("pinglunshijian <=", value, "pinglunshijian");
            return (Criteria) this;
        }

        public Criteria andPinglunshijianLike(String value) {
            addCriterion("pinglunshijian like", value, "pinglunshijian");
            return (Criteria) this;
        }

        public Criteria andPinglunshijianNotLike(String value) {
            addCriterion("pinglunshijian not like", value, "pinglunshijian");
            return (Criteria) this;
        }

        public Criteria andPinglunshijianIn(List<String> values) {
            addCriterion("pinglunshijian in", values, "pinglunshijian");
            return (Criteria) this;
        }

        public Criteria andPinglunshijianNotIn(List<String> values) {
            addCriterion("pinglunshijian not in", values, "pinglunshijian");
            return (Criteria) this;
        }

        public Criteria andPinglunshijianBetween(String value1, String value2) {
            addCriterion("pinglunshijian between", value1, value2, "pinglunshijian");
            return (Criteria) this;
        }

        public Criteria andPinglunshijianNotBetween(String value1, String value2) {
            addCriterion("pinglunshijian not between", value1, value2, "pinglunshijian");
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