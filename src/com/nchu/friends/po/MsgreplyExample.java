package com.nchu.friends.po;

import java.util.ArrayList;
import java.util.List;

public class MsgreplyExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	public MsgreplyExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
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

		public Criteria andReplyidIsNull() {
			addCriterion("replyId is null");
			return (Criteria) this;
		}

		public Criteria andReplyidIsNotNull() {
			addCriterion("replyId is not null");
			return (Criteria) this;
		}

		public Criteria andReplyidEqualTo(Integer value) {
			addCriterion("replyId =", value, "replyid");
			return (Criteria) this;
		}

		public Criteria andReplyidNotEqualTo(Integer value) {
			addCriterion("replyId <>", value, "replyid");
			return (Criteria) this;
		}

		public Criteria andReplyidGreaterThan(Integer value) {
			addCriterion("replyId >", value, "replyid");
			return (Criteria) this;
		}

		public Criteria andReplyidGreaterThanOrEqualTo(Integer value) {
			addCriterion("replyId >=", value, "replyid");
			return (Criteria) this;
		}

		public Criteria andReplyidLessThan(Integer value) {
			addCriterion("replyId <", value, "replyid");
			return (Criteria) this;
		}

		public Criteria andReplyidLessThanOrEqualTo(Integer value) {
			addCriterion("replyId <=", value, "replyid");
			return (Criteria) this;
		}

		public Criteria andReplyidIn(List<Integer> values) {
			addCriterion("replyId in", values, "replyid");
			return (Criteria) this;
		}

		public Criteria andReplyidNotIn(List<Integer> values) {
			addCriterion("replyId not in", values, "replyid");
			return (Criteria) this;
		}

		public Criteria andReplyidBetween(Integer value1, Integer value2) {
			addCriterion("replyId between", value1, value2, "replyid");
			return (Criteria) this;
		}

		public Criteria andReplyidNotBetween(Integer value1, Integer value2) {
			addCriterion("replyId not between", value1, value2, "replyid");
			return (Criteria) this;
		}

		public Criteria andMsgidIsNull() {
			addCriterion("msgId is null");
			return (Criteria) this;
		}

		public Criteria andMsgidIsNotNull() {
			addCriterion("msgId is not null");
			return (Criteria) this;
		}

		public Criteria andMsgidEqualTo(Integer value) {
			addCriterion("msgId =", value, "msgid");
			return (Criteria) this;
		}

		public Criteria andMsgidNotEqualTo(Integer value) {
			addCriterion("msgId <>", value, "msgid");
			return (Criteria) this;
		}

		public Criteria andMsgidGreaterThan(Integer value) {
			addCriterion("msgId >", value, "msgid");
			return (Criteria) this;
		}

		public Criteria andMsgidGreaterThanOrEqualTo(Integer value) {
			addCriterion("msgId >=", value, "msgid");
			return (Criteria) this;
		}

		public Criteria andMsgidLessThan(Integer value) {
			addCriterion("msgId <", value, "msgid");
			return (Criteria) this;
		}

		public Criteria andMsgidLessThanOrEqualTo(Integer value) {
			addCriterion("msgId <=", value, "msgid");
			return (Criteria) this;
		}

		public Criteria andMsgidIn(List<Integer> values) {
			addCriterion("msgId in", values, "msgid");
			return (Criteria) this;
		}

		public Criteria andMsgidNotIn(List<Integer> values) {
			addCriterion("msgId not in", values, "msgid");
			return (Criteria) this;
		}

		public Criteria andMsgidBetween(Integer value1, Integer value2) {
			addCriterion("msgId between", value1, value2, "msgid");
			return (Criteria) this;
		}

		public Criteria andMsgidNotBetween(Integer value1, Integer value2) {
			addCriterion("msgId not between", value1, value2, "msgid");
			return (Criteria) this;
		}

		public Criteria andUseridIsNull() {
			addCriterion("userId is null");
			return (Criteria) this;
		}

		public Criteria andUseridIsNotNull() {
			addCriterion("userId is not null");
			return (Criteria) this;
		}

		public Criteria andUseridEqualTo(Integer value) {
			addCriterion("userId =", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridNotEqualTo(Integer value) {
			addCriterion("userId <>", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridGreaterThan(Integer value) {
			addCriterion("userId >", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
			addCriterion("userId >=", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridLessThan(Integer value) {
			addCriterion("userId <", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridLessThanOrEqualTo(Integer value) {
			addCriterion("userId <=", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridIn(List<Integer> values) {
			addCriterion("userId in", values, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridNotIn(List<Integer> values) {
			addCriterion("userId not in", values, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridBetween(Integer value1, Integer value2) {
			addCriterion("userId between", value1, value2, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridNotBetween(Integer value1, Integer value2) {
			addCriterion("userId not between", value1, value2, "userid");
			return (Criteria) this;
		}

		public Criteria andIslikeIsNull() {
			addCriterion("isLike is null");
			return (Criteria) this;
		}

		public Criteria andIslikeIsNotNull() {
			addCriterion("isLike is not null");
			return (Criteria) this;
		}

		public Criteria andIslikeEqualTo(Boolean value) {
			addCriterion("isLike =", value, "islike");
			return (Criteria) this;
		}

		public Criteria andIslikeNotEqualTo(Boolean value) {
			addCriterion("isLike <>", value, "islike");
			return (Criteria) this;
		}

		public Criteria andIslikeGreaterThan(Boolean value) {
			addCriterion("isLike >", value, "islike");
			return (Criteria) this;
		}

		public Criteria andIslikeGreaterThanOrEqualTo(Boolean value) {
			addCriterion("isLike >=", value, "islike");
			return (Criteria) this;
		}

		public Criteria andIslikeLessThan(Boolean value) {
			addCriterion("isLike <", value, "islike");
			return (Criteria) this;
		}

		public Criteria andIslikeLessThanOrEqualTo(Boolean value) {
			addCriterion("isLike <=", value, "islike");
			return (Criteria) this;
		}

		public Criteria andIslikeIn(List<Boolean> values) {
			addCriterion("isLike in", values, "islike");
			return (Criteria) this;
		}

		public Criteria andIslikeNotIn(List<Boolean> values) {
			addCriterion("isLike not in", values, "islike");
			return (Criteria) this;
		}

		public Criteria andIslikeBetween(Boolean value1, Boolean value2) {
			addCriterion("isLike between", value1, value2, "islike");
			return (Criteria) this;
		}

		public Criteria andIslikeNotBetween(Boolean value1, Boolean value2) {
			addCriterion("isLike not between", value1, value2, "islike");
			return (Criteria) this;
		}

		public Criteria andIsdislikeIsNull() {
			addCriterion("isDislike is null");
			return (Criteria) this;
		}

		public Criteria andIsdislikeIsNotNull() {
			addCriterion("isDislike is not null");
			return (Criteria) this;
		}

		public Criteria andIsdislikeEqualTo(Boolean value) {
			addCriterion("isDislike =", value, "isdislike");
			return (Criteria) this;
		}

		public Criteria andIsdislikeNotEqualTo(Boolean value) {
			addCriterion("isDislike <>", value, "isdislike");
			return (Criteria) this;
		}

		public Criteria andIsdislikeGreaterThan(Boolean value) {
			addCriterion("isDislike >", value, "isdislike");
			return (Criteria) this;
		}

		public Criteria andIsdislikeGreaterThanOrEqualTo(Boolean value) {
			addCriterion("isDislike >=", value, "isdislike");
			return (Criteria) this;
		}

		public Criteria andIsdislikeLessThan(Boolean value) {
			addCriterion("isDislike <", value, "isdislike");
			return (Criteria) this;
		}

		public Criteria andIsdislikeLessThanOrEqualTo(Boolean value) {
			addCriterion("isDislike <=", value, "isdislike");
			return (Criteria) this;
		}

		public Criteria andIsdislikeIn(List<Boolean> values) {
			addCriterion("isDislike in", values, "isdislike");
			return (Criteria) this;
		}

		public Criteria andIsdislikeNotIn(List<Boolean> values) {
			addCriterion("isDislike not in", values, "isdislike");
			return (Criteria) this;
		}

		public Criteria andIsdislikeBetween(Boolean value1, Boolean value2) {
			addCriterion("isDislike between", value1, value2, "isdislike");
			return (Criteria) this;
		}

		public Criteria andIsdislikeNotBetween(Boolean value1, Boolean value2) {
			addCriterion("isDislike not between", value1, value2, "isdislike");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table msgreply
     *
     * @mbg.generated do_not_delete_during_merge Mon Apr 17 20:06:27 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}