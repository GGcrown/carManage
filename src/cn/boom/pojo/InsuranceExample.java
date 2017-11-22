package cn.boom.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class InsuranceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InsuranceExample() {
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

        public Criteria andInsureIdIsNull() {
            addCriterion("insure_id is null");
            return (Criteria) this;
        }

        public Criteria andInsureIdIsNotNull() {
            addCriterion("insure_id is not null");
            return (Criteria) this;
        }

        public Criteria andInsureIdEqualTo(Integer value) {
            addCriterion("insure_id =", value, "insureId");
            return (Criteria) this;
        }

        public Criteria andInsureIdNotEqualTo(Integer value) {
            addCriterion("insure_id <>", value, "insureId");
            return (Criteria) this;
        }

        public Criteria andInsureIdGreaterThan(Integer value) {
            addCriterion("insure_id >", value, "insureId");
            return (Criteria) this;
        }

        public Criteria andInsureIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("insure_id >=", value, "insureId");
            return (Criteria) this;
        }

        public Criteria andInsureIdLessThan(Integer value) {
            addCriterion("insure_id <", value, "insureId");
            return (Criteria) this;
        }

        public Criteria andInsureIdLessThanOrEqualTo(Integer value) {
            addCriterion("insure_id <=", value, "insureId");
            return (Criteria) this;
        }

        public Criteria andInsureIdIn(List<Integer> values) {
            addCriterion("insure_id in", values, "insureId");
            return (Criteria) this;
        }

        public Criteria andInsureIdNotIn(List<Integer> values) {
            addCriterion("insure_id not in", values, "insureId");
            return (Criteria) this;
        }

        public Criteria andInsureIdBetween(Integer value1, Integer value2) {
            addCriterion("insure_id between", value1, value2, "insureId");
            return (Criteria) this;
        }

        public Criteria andInsureIdNotBetween(Integer value1, Integer value2) {
            addCriterion("insure_id not between", value1, value2, "insureId");
            return (Criteria) this;
        }

        public Criteria andInsureTimeIsNull() {
            addCriterion("insure_time is null");
            return (Criteria) this;
        }

        public Criteria andInsureTimeIsNotNull() {
            addCriterion("insure_time is not null");
            return (Criteria) this;
        }

        public Criteria andInsureTimeEqualTo(Date value) {
            addCriterionForJDBCDate("insure_time =", value, "insureTime");
            return (Criteria) this;
        }

        public Criteria andInsureTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("insure_time <>", value, "insureTime");
            return (Criteria) this;
        }

        public Criteria andInsureTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("insure_time >", value, "insureTime");
            return (Criteria) this;
        }

        public Criteria andInsureTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("insure_time >=", value, "insureTime");
            return (Criteria) this;
        }

        public Criteria andInsureTimeLessThan(Date value) {
            addCriterionForJDBCDate("insure_time <", value, "insureTime");
            return (Criteria) this;
        }

        public Criteria andInsureTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("insure_time <=", value, "insureTime");
            return (Criteria) this;
        }

        public Criteria andInsureTimeIn(List<Date> values) {
            addCriterionForJDBCDate("insure_time in", values, "insureTime");
            return (Criteria) this;
        }

        public Criteria andInsureTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("insure_time not in", values, "insureTime");
            return (Criteria) this;
        }

        public Criteria andInsureTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("insure_time between", value1, value2, "insureTime");
            return (Criteria) this;
        }

        public Criteria andInsureTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("insure_time not between", value1, value2, "insureTime");
            return (Criteria) this;
        }

        public Criteria andInsureTypeofinsuranceIsNull() {
            addCriterion("insure_typeofinsurance is null");
            return (Criteria) this;
        }

        public Criteria andInsureTypeofinsuranceIsNotNull() {
            addCriterion("insure_typeofinsurance is not null");
            return (Criteria) this;
        }

        public Criteria andInsureTypeofinsuranceEqualTo(String value) {
            addCriterion("insure_typeofinsurance =", value, "insureTypeofinsurance");
            return (Criteria) this;
        }

        public Criteria andInsureTypeofinsuranceNotEqualTo(String value) {
            addCriterion("insure_typeofinsurance <>", value, "insureTypeofinsurance");
            return (Criteria) this;
        }

        public Criteria andInsureTypeofinsuranceGreaterThan(String value) {
            addCriterion("insure_typeofinsurance >", value, "insureTypeofinsurance");
            return (Criteria) this;
        }

        public Criteria andInsureTypeofinsuranceGreaterThanOrEqualTo(String value) {
            addCriterion("insure_typeofinsurance >=", value, "insureTypeofinsurance");
            return (Criteria) this;
        }

        public Criteria andInsureTypeofinsuranceLessThan(String value) {
            addCriterion("insure_typeofinsurance <", value, "insureTypeofinsurance");
            return (Criteria) this;
        }

        public Criteria andInsureTypeofinsuranceLessThanOrEqualTo(String value) {
            addCriterion("insure_typeofinsurance <=", value, "insureTypeofinsurance");
            return (Criteria) this;
        }

        public Criteria andInsureTypeofinsuranceLike(String value) {
            addCriterion("insure_typeofinsurance like", value, "insureTypeofinsurance");
            return (Criteria) this;
        }

        public Criteria andInsureTypeofinsuranceNotLike(String value) {
            addCriterion("insure_typeofinsurance not like", value, "insureTypeofinsurance");
            return (Criteria) this;
        }

        public Criteria andInsureTypeofinsuranceIn(List<String> values) {
            addCriterion("insure_typeofinsurance in", values, "insureTypeofinsurance");
            return (Criteria) this;
        }

        public Criteria andInsureTypeofinsuranceNotIn(List<String> values) {
            addCriterion("insure_typeofinsurance not in", values, "insureTypeofinsurance");
            return (Criteria) this;
        }

        public Criteria andInsureTypeofinsuranceBetween(String value1, String value2) {
            addCriterion("insure_typeofinsurance between", value1, value2, "insureTypeofinsurance");
            return (Criteria) this;
        }

        public Criteria andInsureTypeofinsuranceNotBetween(String value1, String value2) {
            addCriterion("insure_typeofinsurance not between", value1, value2, "insureTypeofinsurance");
            return (Criteria) this;
        }

        public Criteria andInsureCompanyIsNull() {
            addCriterion("insure_company is null");
            return (Criteria) this;
        }

        public Criteria andInsureCompanyIsNotNull() {
            addCriterion("insure_company is not null");
            return (Criteria) this;
        }

        public Criteria andInsureCompanyEqualTo(String value) {
            addCriterion("insure_company =", value, "insureCompany");
            return (Criteria) this;
        }

        public Criteria andInsureCompanyNotEqualTo(String value) {
            addCriterion("insure_company <>", value, "insureCompany");
            return (Criteria) this;
        }

        public Criteria andInsureCompanyGreaterThan(String value) {
            addCriterion("insure_company >", value, "insureCompany");
            return (Criteria) this;
        }

        public Criteria andInsureCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("insure_company >=", value, "insureCompany");
            return (Criteria) this;
        }

        public Criteria andInsureCompanyLessThan(String value) {
            addCriterion("insure_company <", value, "insureCompany");
            return (Criteria) this;
        }

        public Criteria andInsureCompanyLessThanOrEqualTo(String value) {
            addCriterion("insure_company <=", value, "insureCompany");
            return (Criteria) this;
        }

        public Criteria andInsureCompanyLike(String value) {
            addCriterion("insure_company like", value, "insureCompany");
            return (Criteria) this;
        }

        public Criteria andInsureCompanyNotLike(String value) {
            addCriterion("insure_company not like", value, "insureCompany");
            return (Criteria) this;
        }

        public Criteria andInsureCompanyIn(List<String> values) {
            addCriterion("insure_company in", values, "insureCompany");
            return (Criteria) this;
        }

        public Criteria andInsureCompanyNotIn(List<String> values) {
            addCriterion("insure_company not in", values, "insureCompany");
            return (Criteria) this;
        }

        public Criteria andInsureCompanyBetween(String value1, String value2) {
            addCriterion("insure_company between", value1, value2, "insureCompany");
            return (Criteria) this;
        }

        public Criteria andInsureCompanyNotBetween(String value1, String value2) {
            addCriterion("insure_company not between", value1, value2, "insureCompany");
            return (Criteria) this;
        }

        public Criteria andInsuranceStarttimeIsNull() {
            addCriterion("insurance_startTime is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceStarttimeIsNotNull() {
            addCriterion("insurance_startTime is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceStarttimeEqualTo(Date value) {
            addCriterionForJDBCDate("insurance_startTime =", value, "insuranceStarttime");
            return (Criteria) this;
        }

        public Criteria andInsuranceStarttimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("insurance_startTime <>", value, "insuranceStarttime");
            return (Criteria) this;
        }

        public Criteria andInsuranceStarttimeGreaterThan(Date value) {
            addCriterionForJDBCDate("insurance_startTime >", value, "insuranceStarttime");
            return (Criteria) this;
        }

        public Criteria andInsuranceStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("insurance_startTime >=", value, "insuranceStarttime");
            return (Criteria) this;
        }

        public Criteria andInsuranceStarttimeLessThan(Date value) {
            addCriterionForJDBCDate("insurance_startTime <", value, "insuranceStarttime");
            return (Criteria) this;
        }

        public Criteria andInsuranceStarttimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("insurance_startTime <=", value, "insuranceStarttime");
            return (Criteria) this;
        }

        public Criteria andInsuranceStarttimeIn(List<Date> values) {
            addCriterionForJDBCDate("insurance_startTime in", values, "insuranceStarttime");
            return (Criteria) this;
        }

        public Criteria andInsuranceStarttimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("insurance_startTime not in", values, "insuranceStarttime");
            return (Criteria) this;
        }

        public Criteria andInsuranceStarttimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("insurance_startTime between", value1, value2, "insuranceStarttime");
            return (Criteria) this;
        }

        public Criteria andInsuranceStarttimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("insurance_startTime not between", value1, value2, "insuranceStarttime");
            return (Criteria) this;
        }

        public Criteria andInsuranceEndtimeIsNull() {
            addCriterion("insurance_endTime is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceEndtimeIsNotNull() {
            addCriterion("insurance_endTime is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceEndtimeEqualTo(Date value) {
            addCriterionForJDBCDate("insurance_endTime =", value, "insuranceEndtime");
            return (Criteria) this;
        }

        public Criteria andInsuranceEndtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("insurance_endTime <>", value, "insuranceEndtime");
            return (Criteria) this;
        }

        public Criteria andInsuranceEndtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("insurance_endTime >", value, "insuranceEndtime");
            return (Criteria) this;
        }

        public Criteria andInsuranceEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("insurance_endTime >=", value, "insuranceEndtime");
            return (Criteria) this;
        }

        public Criteria andInsuranceEndtimeLessThan(Date value) {
            addCriterionForJDBCDate("insurance_endTime <", value, "insuranceEndtime");
            return (Criteria) this;
        }

        public Criteria andInsuranceEndtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("insurance_endTime <=", value, "insuranceEndtime");
            return (Criteria) this;
        }

        public Criteria andInsuranceEndtimeIn(List<Date> values) {
            addCriterionForJDBCDate("insurance_endTime in", values, "insuranceEndtime");
            return (Criteria) this;
        }

        public Criteria andInsuranceEndtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("insurance_endTime not in", values, "insuranceEndtime");
            return (Criteria) this;
        }

        public Criteria andInsuranceEndtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("insurance_endTime between", value1, value2, "insuranceEndtime");
            return (Criteria) this;
        }

        public Criteria andInsuranceEndtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("insurance_endTime not between", value1, value2, "insuranceEndtime");
            return (Criteria) this;
        }

        public Criteria andDeptnameIsNull() {
            addCriterion("deptname is null");
            return (Criteria) this;
        }

        public Criteria andDeptnameIsNotNull() {
            addCriterion("deptname is not null");
            return (Criteria) this;
        }

        public Criteria andDeptnameEqualTo(String value) {
            addCriterion("deptname =", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotEqualTo(String value) {
            addCriterion("deptname <>", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameGreaterThan(String value) {
            addCriterion("deptname >", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameGreaterThanOrEqualTo(String value) {
            addCriterion("deptname >=", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameLessThan(String value) {
            addCriterion("deptname <", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameLessThanOrEqualTo(String value) {
            addCriterion("deptname <=", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameLike(String value) {
            addCriterion("deptname like", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotLike(String value) {
            addCriterion("deptname not like", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameIn(List<String> values) {
            addCriterion("deptname in", values, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotIn(List<String> values) {
            addCriterion("deptname not in", values, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameBetween(String value1, String value2) {
            addCriterion("deptname between", value1, value2, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotBetween(String value1, String value2) {
            addCriterion("deptname not between", value1, value2, "deptname");
            return (Criteria) this;
        }

        public Criteria andFilepathIsNull() {
            addCriterion("filePath is null");
            return (Criteria) this;
        }

        public Criteria andFilepathIsNotNull() {
            addCriterion("filePath is not null");
            return (Criteria) this;
        }

        public Criteria andFilepathEqualTo(String value) {
            addCriterion("filePath =", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotEqualTo(String value) {
            addCriterion("filePath <>", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathGreaterThan(String value) {
            addCriterion("filePath >", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathGreaterThanOrEqualTo(String value) {
            addCriterion("filePath >=", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLessThan(String value) {
            addCriterion("filePath <", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLessThanOrEqualTo(String value) {
            addCriterion("filePath <=", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLike(String value) {
            addCriterion("filePath like", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotLike(String value) {
            addCriterion("filePath not like", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathIn(List<String> values) {
            addCriterion("filePath in", values, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotIn(List<String> values) {
            addCriterion("filePath not in", values, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathBetween(String value1, String value2) {
            addCriterion("filePath between", value1, value2, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotBetween(String value1, String value2) {
            addCriterion("filePath not between", value1, value2, "filepath");
            return (Criteria) this;
        }

        public Criteria andInsureTypeIsNull() {
            addCriterion("insure_type is null");
            return (Criteria) this;
        }

        public Criteria andInsureTypeIsNotNull() {
            addCriterion("insure_type is not null");
            return (Criteria) this;
        }

        public Criteria andInsureTypeEqualTo(Integer value) {
            addCriterion("insure_type =", value, "insureType");
            return (Criteria) this;
        }

        public Criteria andInsureTypeNotEqualTo(Integer value) {
            addCriterion("insure_type <>", value, "insureType");
            return (Criteria) this;
        }

        public Criteria andInsureTypeGreaterThan(Integer value) {
            addCriterion("insure_type >", value, "insureType");
            return (Criteria) this;
        }

        public Criteria andInsureTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("insure_type >=", value, "insureType");
            return (Criteria) this;
        }

        public Criteria andInsureTypeLessThan(Integer value) {
            addCriterion("insure_type <", value, "insureType");
            return (Criteria) this;
        }

        public Criteria andInsureTypeLessThanOrEqualTo(Integer value) {
            addCriterion("insure_type <=", value, "insureType");
            return (Criteria) this;
        }

        public Criteria andInsureTypeIn(List<Integer> values) {
            addCriterion("insure_type in", values, "insureType");
            return (Criteria) this;
        }

        public Criteria andInsureTypeNotIn(List<Integer> values) {
            addCriterion("insure_type not in", values, "insureType");
            return (Criteria) this;
        }

        public Criteria andInsureTypeBetween(Integer value1, Integer value2) {
            addCriterion("insure_type between", value1, value2, "insureType");
            return (Criteria) this;
        }

        public Criteria andInsureTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("insure_type not between", value1, value2, "insureType");
            return (Criteria) this;
        }

        public Criteria andCaridIsNull() {
            addCriterion("carid is null");
            return (Criteria) this;
        }

        public Criteria andCaridIsNotNull() {
            addCriterion("carid is not null");
            return (Criteria) this;
        }

        public Criteria andCaridEqualTo(Integer value) {
            addCriterion("carid =", value, "carid");
            return (Criteria) this;
        }

        public Criteria andCaridNotEqualTo(Integer value) {
            addCriterion("carid <>", value, "carid");
            return (Criteria) this;
        }

        public Criteria andCaridGreaterThan(Integer value) {
            addCriterion("carid >", value, "carid");
            return (Criteria) this;
        }

        public Criteria andCaridGreaterThanOrEqualTo(Integer value) {
            addCriterion("carid >=", value, "carid");
            return (Criteria) this;
        }

        public Criteria andCaridLessThan(Integer value) {
            addCriterion("carid <", value, "carid");
            return (Criteria) this;
        }

        public Criteria andCaridLessThanOrEqualTo(Integer value) {
            addCriterion("carid <=", value, "carid");
            return (Criteria) this;
        }

        public Criteria andCaridIn(List<Integer> values) {
            addCriterion("carid in", values, "carid");
            return (Criteria) this;
        }

        public Criteria andCaridNotIn(List<Integer> values) {
            addCriterion("carid not in", values, "carid");
            return (Criteria) this;
        }

        public Criteria andCaridBetween(Integer value1, Integer value2) {
            addCriterion("carid between", value1, value2, "carid");
            return (Criteria) this;
        }

        public Criteria andCaridNotBetween(Integer value1, Integer value2) {
            addCriterion("carid not between", value1, value2, "carid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
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