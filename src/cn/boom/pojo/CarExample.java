package cn.boom.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CarExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andCarIdIsNull() {
            addCriterion("car_id is null");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNotNull() {
            addCriterion("car_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarIdEqualTo(Integer value) {
            addCriterion("car_id =", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotEqualTo(Integer value) {
            addCriterion("car_id <>", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThan(Integer value) {
            addCriterion("car_id >", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_id >=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThan(Integer value) {
            addCriterion("car_id <", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThanOrEqualTo(Integer value) {
            addCriterion("car_id <=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdIn(List<Integer> values) {
            addCriterion("car_id in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotIn(List<Integer> values) {
            addCriterion("car_id not in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdBetween(Integer value1, Integer value2) {
            addCriterion("car_id between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotBetween(Integer value1, Integer value2) {
            addCriterion("car_id not between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarPlateIsNull() {
            addCriterion("car_plate is null");
            return (Criteria) this;
        }

        public Criteria andCarPlateIsNotNull() {
            addCriterion("car_plate is not null");
            return (Criteria) this;
        }

        public Criteria andCarPlateEqualTo(String value) {
            addCriterion("car_plate =", value, "carPlate");
            return (Criteria) this;
        }

        public Criteria andCarPlateNotEqualTo(String value) {
            addCriterion("car_plate <>", value, "carPlate");
            return (Criteria) this;
        }

        public Criteria andCarPlateGreaterThan(String value) {
            addCriterion("car_plate >", value, "carPlate");
            return (Criteria) this;
        }

        public Criteria andCarPlateGreaterThanOrEqualTo(String value) {
            addCriterion("car_plate >=", value, "carPlate");
            return (Criteria) this;
        }

        public Criteria andCarPlateLessThan(String value) {
            addCriterion("car_plate <", value, "carPlate");
            return (Criteria) this;
        }

        public Criteria andCarPlateLessThanOrEqualTo(String value) {
            addCriterion("car_plate <=", value, "carPlate");
            return (Criteria) this;
        }

        public Criteria andCarPlateLike(String value) {
            addCriterion("car_plate like", value, "carPlate");
            return (Criteria) this;
        }

        public Criteria andCarPlateNotLike(String value) {
            addCriterion("car_plate not like", value, "carPlate");
            return (Criteria) this;
        }

        public Criteria andCarPlateIn(List<String> values) {
            addCriterion("car_plate in", values, "carPlate");
            return (Criteria) this;
        }

        public Criteria andCarPlateNotIn(List<String> values) {
            addCriterion("car_plate not in", values, "carPlate");
            return (Criteria) this;
        }

        public Criteria andCarPlateBetween(String value1, String value2) {
            addCriterion("car_plate between", value1, value2, "carPlate");
            return (Criteria) this;
        }

        public Criteria andCarPlateNotBetween(String value1, String value2) {
            addCriterion("car_plate not between", value1, value2, "carPlate");
            return (Criteria) this;
        }

        public Criteria andCarMarkIsNull() {
            addCriterion("car_mark is null");
            return (Criteria) this;
        }

        public Criteria andCarMarkIsNotNull() {
            addCriterion("car_mark is not null");
            return (Criteria) this;
        }

        public Criteria andCarMarkEqualTo(String value) {
            addCriterion("car_mark =", value, "carMark");
            return (Criteria) this;
        }

        public Criteria andCarMarkNotEqualTo(String value) {
            addCriterion("car_mark <>", value, "carMark");
            return (Criteria) this;
        }

        public Criteria andCarMarkGreaterThan(String value) {
            addCriterion("car_mark >", value, "carMark");
            return (Criteria) this;
        }

        public Criteria andCarMarkGreaterThanOrEqualTo(String value) {
            addCriterion("car_mark >=", value, "carMark");
            return (Criteria) this;
        }

        public Criteria andCarMarkLessThan(String value) {
            addCriterion("car_mark <", value, "carMark");
            return (Criteria) this;
        }

        public Criteria andCarMarkLessThanOrEqualTo(String value) {
            addCriterion("car_mark <=", value, "carMark");
            return (Criteria) this;
        }

        public Criteria andCarMarkLike(String value) {
            addCriterion("car_mark like", value, "carMark");
            return (Criteria) this;
        }

        public Criteria andCarMarkNotLike(String value) {
            addCriterion("car_mark not like", value, "carMark");
            return (Criteria) this;
        }

        public Criteria andCarMarkIn(List<String> values) {
            addCriterion("car_mark in", values, "carMark");
            return (Criteria) this;
        }

        public Criteria andCarMarkNotIn(List<String> values) {
            addCriterion("car_mark not in", values, "carMark");
            return (Criteria) this;
        }

        public Criteria andCarMarkBetween(String value1, String value2) {
            addCriterion("car_mark between", value1, value2, "carMark");
            return (Criteria) this;
        }

        public Criteria andCarMarkNotBetween(String value1, String value2) {
            addCriterion("car_mark not between", value1, value2, "carMark");
            return (Criteria) this;
        }

        public Criteria andCarColorIsNull() {
            addCriterion("car_color is null");
            return (Criteria) this;
        }

        public Criteria andCarColorIsNotNull() {
            addCriterion("car_color is not null");
            return (Criteria) this;
        }

        public Criteria andCarColorEqualTo(String value) {
            addCriterion("car_color =", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorNotEqualTo(String value) {
            addCriterion("car_color <>", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorGreaterThan(String value) {
            addCriterion("car_color >", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorGreaterThanOrEqualTo(String value) {
            addCriterion("car_color >=", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorLessThan(String value) {
            addCriterion("car_color <", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorLessThanOrEqualTo(String value) {
            addCriterion("car_color <=", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorLike(String value) {
            addCriterion("car_color like", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorNotLike(String value) {
            addCriterion("car_color not like", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorIn(List<String> values) {
            addCriterion("car_color in", values, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorNotIn(List<String> values) {
            addCriterion("car_color not in", values, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorBetween(String value1, String value2) {
            addCriterion("car_color between", value1, value2, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorNotBetween(String value1, String value2) {
            addCriterion("car_color not between", value1, value2, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarMileageIsNull() {
            addCriterion("car_mileage is null");
            return (Criteria) this;
        }

        public Criteria andCarMileageIsNotNull() {
            addCriterion("car_mileage is not null");
            return (Criteria) this;
        }

        public Criteria andCarMileageEqualTo(Integer value) {
            addCriterion("car_mileage =", value, "carMileage");
            return (Criteria) this;
        }

        public Criteria andCarMileageNotEqualTo(Integer value) {
            addCriterion("car_mileage <>", value, "carMileage");
            return (Criteria) this;
        }

        public Criteria andCarMileageGreaterThan(Integer value) {
            addCriterion("car_mileage >", value, "carMileage");
            return (Criteria) this;
        }

        public Criteria andCarMileageGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_mileage >=", value, "carMileage");
            return (Criteria) this;
        }

        public Criteria andCarMileageLessThan(Integer value) {
            addCriterion("car_mileage <", value, "carMileage");
            return (Criteria) this;
        }

        public Criteria andCarMileageLessThanOrEqualTo(Integer value) {
            addCriterion("car_mileage <=", value, "carMileage");
            return (Criteria) this;
        }

        public Criteria andCarMileageIn(List<Integer> values) {
            addCriterion("car_mileage in", values, "carMileage");
            return (Criteria) this;
        }

        public Criteria andCarMileageNotIn(List<Integer> values) {
            addCriterion("car_mileage not in", values, "carMileage");
            return (Criteria) this;
        }

        public Criteria andCarMileageBetween(Integer value1, Integer value2) {
            addCriterion("car_mileage between", value1, value2, "carMileage");
            return (Criteria) this;
        }

        public Criteria andCarMileageNotBetween(Integer value1, Integer value2) {
            addCriterion("car_mileage not between", value1, value2, "carMileage");
            return (Criteria) this;
        }

        public Criteria andCarLimitIsNull() {
            addCriterion("car_limit is null");
            return (Criteria) this;
        }

        public Criteria andCarLimitIsNotNull() {
            addCriterion("car_limit is not null");
            return (Criteria) this;
        }

        public Criteria andCarLimitEqualTo(Integer value) {
            addCriterion("car_limit =", value, "carLimit");
            return (Criteria) this;
        }

        public Criteria andCarLimitNotEqualTo(Integer value) {
            addCriterion("car_limit <>", value, "carLimit");
            return (Criteria) this;
        }

        public Criteria andCarLimitGreaterThan(Integer value) {
            addCriterion("car_limit >", value, "carLimit");
            return (Criteria) this;
        }

        public Criteria andCarLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_limit >=", value, "carLimit");
            return (Criteria) this;
        }

        public Criteria andCarLimitLessThan(Integer value) {
            addCriterion("car_limit <", value, "carLimit");
            return (Criteria) this;
        }

        public Criteria andCarLimitLessThanOrEqualTo(Integer value) {
            addCriterion("car_limit <=", value, "carLimit");
            return (Criteria) this;
        }

        public Criteria andCarLimitIn(List<Integer> values) {
            addCriterion("car_limit in", values, "carLimit");
            return (Criteria) this;
        }

        public Criteria andCarLimitNotIn(List<Integer> values) {
            addCriterion("car_limit not in", values, "carLimit");
            return (Criteria) this;
        }

        public Criteria andCarLimitBetween(Integer value1, Integer value2) {
            addCriterion("car_limit between", value1, value2, "carLimit");
            return (Criteria) this;
        }

        public Criteria andCarLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("car_limit not between", value1, value2, "carLimit");
            return (Criteria) this;
        }

        public Criteria andCarAgeIsNull() {
            addCriterion("car_age is null");
            return (Criteria) this;
        }

        public Criteria andCarAgeIsNotNull() {
            addCriterion("car_age is not null");
            return (Criteria) this;
        }

        public Criteria andCarAgeEqualTo(Date value) {
            addCriterionForJDBCDate("car_age =", value, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeNotEqualTo(Date value) {
            addCriterionForJDBCDate("car_age <>", value, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeGreaterThan(Date value) {
            addCriterionForJDBCDate("car_age >", value, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("car_age >=", value, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeLessThan(Date value) {
            addCriterionForJDBCDate("car_age <", value, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("car_age <=", value, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeIn(List<Date> values) {
            addCriterionForJDBCDate("car_age in", values, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeNotIn(List<Date> values) {
            addCriterionForJDBCDate("car_age not in", values, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("car_age between", value1, value2, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("car_age not between", value1, value2, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarPhotoIsNull() {
            addCriterion("car_photo is null");
            return (Criteria) this;
        }

        public Criteria andCarPhotoIsNotNull() {
            addCriterion("car_photo is not null");
            return (Criteria) this;
        }

        public Criteria andCarPhotoEqualTo(String value) {
            addCriterion("car_photo =", value, "carPhoto");
            return (Criteria) this;
        }

        public Criteria andCarPhotoNotEqualTo(String value) {
            addCriterion("car_photo <>", value, "carPhoto");
            return (Criteria) this;
        }

        public Criteria andCarPhotoGreaterThan(String value) {
            addCriterion("car_photo >", value, "carPhoto");
            return (Criteria) this;
        }

        public Criteria andCarPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("car_photo >=", value, "carPhoto");
            return (Criteria) this;
        }

        public Criteria andCarPhotoLessThan(String value) {
            addCriterion("car_photo <", value, "carPhoto");
            return (Criteria) this;
        }

        public Criteria andCarPhotoLessThanOrEqualTo(String value) {
            addCriterion("car_photo <=", value, "carPhoto");
            return (Criteria) this;
        }

        public Criteria andCarPhotoLike(String value) {
            addCriterion("car_photo like", value, "carPhoto");
            return (Criteria) this;
        }

        public Criteria andCarPhotoNotLike(String value) {
            addCriterion("car_photo not like", value, "carPhoto");
            return (Criteria) this;
        }

        public Criteria andCarPhotoIn(List<String> values) {
            addCriterion("car_photo in", values, "carPhoto");
            return (Criteria) this;
        }

        public Criteria andCarPhotoNotIn(List<String> values) {
            addCriterion("car_photo not in", values, "carPhoto");
            return (Criteria) this;
        }

        public Criteria andCarPhotoBetween(String value1, String value2) {
            addCriterion("car_photo between", value1, value2, "carPhoto");
            return (Criteria) this;
        }

        public Criteria andCarPhotoNotBetween(String value1, String value2) {
            addCriterion("car_photo not between", value1, value2, "carPhoto");
            return (Criteria) this;
        }

        public Criteria andCarUseridIsNull() {
            addCriterion("car_userid is null");
            return (Criteria) this;
        }

        public Criteria andCarUseridIsNotNull() {
            addCriterion("car_userid is not null");
            return (Criteria) this;
        }

        public Criteria andCarUseridEqualTo(Integer value) {
            addCriterion("car_userid =", value, "carUserid");
            return (Criteria) this;
        }

        public Criteria andCarUseridNotEqualTo(Integer value) {
            addCriterion("car_userid <>", value, "carUserid");
            return (Criteria) this;
        }

        public Criteria andCarUseridGreaterThan(Integer value) {
            addCriterion("car_userid >", value, "carUserid");
            return (Criteria) this;
        }

        public Criteria andCarUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_userid >=", value, "carUserid");
            return (Criteria) this;
        }

        public Criteria andCarUseridLessThan(Integer value) {
            addCriterion("car_userid <", value, "carUserid");
            return (Criteria) this;
        }

        public Criteria andCarUseridLessThanOrEqualTo(Integer value) {
            addCriterion("car_userid <=", value, "carUserid");
            return (Criteria) this;
        }

        public Criteria andCarUseridIn(List<Integer> values) {
            addCriterion("car_userid in", values, "carUserid");
            return (Criteria) this;
        }

        public Criteria andCarUseridNotIn(List<Integer> values) {
            addCriterion("car_userid not in", values, "carUserid");
            return (Criteria) this;
        }

        public Criteria andCarUseridBetween(Integer value1, Integer value2) {
            addCriterion("car_userid between", value1, value2, "carUserid");
            return (Criteria) this;
        }

        public Criteria andCarUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("car_userid not between", value1, value2, "carUserid");
            return (Criteria) this;
        }

        public Criteria andReserve1IsNull() {
            addCriterion("reserve1 is null");
            return (Criteria) this;
        }

        public Criteria andReserve1IsNotNull() {
            addCriterion("reserve1 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve1EqualTo(String value) {
            addCriterion("reserve1 =", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotEqualTo(String value) {
            addCriterion("reserve1 <>", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1GreaterThan(String value) {
            addCriterion("reserve1 >", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1GreaterThanOrEqualTo(String value) {
            addCriterion("reserve1 >=", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1LessThan(String value) {
            addCriterion("reserve1 <", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1LessThanOrEqualTo(String value) {
            addCriterion("reserve1 <=", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1Like(String value) {
            addCriterion("reserve1 like", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotLike(String value) {
            addCriterion("reserve1 not like", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1In(List<String> values) {
            addCriterion("reserve1 in", values, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotIn(List<String> values) {
            addCriterion("reserve1 not in", values, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1Between(String value1, String value2) {
            addCriterion("reserve1 between", value1, value2, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotBetween(String value1, String value2) {
            addCriterion("reserve1 not between", value1, value2, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve2IsNull() {
            addCriterion("reserve2 is null");
            return (Criteria) this;
        }

        public Criteria andReserve2IsNotNull() {
            addCriterion("reserve2 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve2EqualTo(String value) {
            addCriterion("reserve2 =", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotEqualTo(String value) {
            addCriterion("reserve2 <>", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2GreaterThan(String value) {
            addCriterion("reserve2 >", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2GreaterThanOrEqualTo(String value) {
            addCriterion("reserve2 >=", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2LessThan(String value) {
            addCriterion("reserve2 <", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2LessThanOrEqualTo(String value) {
            addCriterion("reserve2 <=", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2Like(String value) {
            addCriterion("reserve2 like", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotLike(String value) {
            addCriterion("reserve2 not like", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2In(List<String> values) {
            addCriterion("reserve2 in", values, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotIn(List<String> values) {
            addCriterion("reserve2 not in", values, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2Between(String value1, String value2) {
            addCriterion("reserve2 between", value1, value2, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotBetween(String value1, String value2) {
            addCriterion("reserve2 not between", value1, value2, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve3IsNull() {
            addCriterion("reserve3 is null");
            return (Criteria) this;
        }

        public Criteria andReserve3IsNotNull() {
            addCriterion("reserve3 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve3EqualTo(String value) {
            addCriterion("reserve3 =", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotEqualTo(String value) {
            addCriterion("reserve3 <>", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3GreaterThan(String value) {
            addCriterion("reserve3 >", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3GreaterThanOrEqualTo(String value) {
            addCriterion("reserve3 >=", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3LessThan(String value) {
            addCriterion("reserve3 <", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3LessThanOrEqualTo(String value) {
            addCriterion("reserve3 <=", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3Like(String value) {
            addCriterion("reserve3 like", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotLike(String value) {
            addCriterion("reserve3 not like", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3In(List<String> values) {
            addCriterion("reserve3 in", values, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotIn(List<String> values) {
            addCriterion("reserve3 not in", values, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3Between(String value1, String value2) {
            addCriterion("reserve3 between", value1, value2, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotBetween(String value1, String value2) {
            addCriterion("reserve3 not between", value1, value2, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve4IsNull() {
            addCriterion("reserve4 is null");
            return (Criteria) this;
        }

        public Criteria andReserve4IsNotNull() {
            addCriterion("reserve4 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve4EqualTo(String value) {
            addCriterion("reserve4 =", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4NotEqualTo(String value) {
            addCriterion("reserve4 <>", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4GreaterThan(String value) {
            addCriterion("reserve4 >", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4GreaterThanOrEqualTo(String value) {
            addCriterion("reserve4 >=", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4LessThan(String value) {
            addCriterion("reserve4 <", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4LessThanOrEqualTo(String value) {
            addCriterion("reserve4 <=", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4Like(String value) {
            addCriterion("reserve4 like", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4NotLike(String value) {
            addCriterion("reserve4 not like", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4In(List<String> values) {
            addCriterion("reserve4 in", values, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4NotIn(List<String> values) {
            addCriterion("reserve4 not in", values, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4Between(String value1, String value2) {
            addCriterion("reserve4 between", value1, value2, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4NotBetween(String value1, String value2) {
            addCriterion("reserve4 not between", value1, value2, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve5IsNull() {
            addCriterion("reserve5 is null");
            return (Criteria) this;
        }

        public Criteria andReserve5IsNotNull() {
            addCriterion("reserve5 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve5EqualTo(String value) {
            addCriterion("reserve5 =", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5NotEqualTo(String value) {
            addCriterion("reserve5 <>", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5GreaterThan(String value) {
            addCriterion("reserve5 >", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5GreaterThanOrEqualTo(String value) {
            addCriterion("reserve5 >=", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5LessThan(String value) {
            addCriterion("reserve5 <", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5LessThanOrEqualTo(String value) {
            addCriterion("reserve5 <=", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5Like(String value) {
            addCriterion("reserve5 like", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5NotLike(String value) {
            addCriterion("reserve5 not like", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5In(List<String> values) {
            addCriterion("reserve5 in", values, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5NotIn(List<String> values) {
            addCriterion("reserve5 not in", values, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5Between(String value1, String value2) {
            addCriterion("reserve5 between", value1, value2, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5NotBetween(String value1, String value2) {
            addCriterion("reserve5 not between", value1, value2, "reserve5");
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