package cn.boom.pojo;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import cn.boom.util.JsonDateSerializer;

public class Insurance {
	private Integer insureId;

	private Date insureTime;

	private String insureTypeofinsurance;

	private String insureCompany;

	private Date insuranceStarttime;

	private Date insuranceEndtime;

	private String deptname;

	private String filepath;

	private Integer insureType;

	private Integer carid;

	private Integer userid;

	private String reserve1;

	private String reserve2;

	private String reserve3;

	private String reserve4;

	private String reserve5;

	public Integer getInsureId() {
		return insureId;
	}

	public void setInsureId(Integer insureId) {
		this.insureId = insureId;
	}

	public Date getInsureTime() {
		return insureTime;
	}

	public void setInsureTime(Date insureTime) {
		this.insureTime = insureTime;
	}

	public String getInsureTypeofinsurance() {
		return insureTypeofinsurance;
	}

	public void setInsureTypeofinsurance(String insureTypeofinsurance) {
		this.insureTypeofinsurance = insureTypeofinsurance == null ? null : insureTypeofinsurance.trim();
	}

	public String getInsureCompany() {
		return insureCompany;
	}

	public void setInsureCompany(String insureCompany) {
		this.insureCompany = insureCompany == null ? null : insureCompany.trim();
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getInsuranceStarttime() {
		return insuranceStarttime;
	}

	public void setInsuranceStarttime(Date insuranceStarttime) {
		this.insuranceStarttime = insuranceStarttime;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getInsuranceEndtime() {
		return insuranceEndtime;
	}

	public void setInsuranceEndtime(Date insuranceEndtime) {
		this.insuranceEndtime = insuranceEndtime;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname == null ? null : deptname.trim();
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath == null ? null : filepath.trim();
	}

	public Integer getInsureType() {
		return insureType;
	}

	public void setInsureType(Integer insureType) {
		this.insureType = insureType;
	}

	public Integer getCarid() {
		return carid;
	}

	public void setCarid(Integer carid) {
		this.carid = carid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getReserve1() {
		return reserve1;
	}

	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1 == null ? null : reserve1.trim();
	}

	public String getReserve2() {
		return reserve2;
	}

	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2 == null ? null : reserve2.trim();
	}

	public String getReserve3() {
		return reserve3;
	}

	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3 == null ? null : reserve3.trim();
	}

	public String getReserve4() {
		return reserve4;
	}

	public void setReserve4(String reserve4) {
		this.reserve4 = reserve4 == null ? null : reserve4.trim();
	}

	public String getReserve5() {
		return reserve5;
	}

	public void setReserve5(String reserve5) {
		this.reserve5 = reserve5 == null ? null : reserve5.trim();
	}

	@Override
	public String toString() {
		return "Insurance [insureId=" + insureId + ", insureTime=" + insureTime + ", insureTypeofinsurance="
				+ insureTypeofinsurance + ", insureCompany=" + insureCompany + ", insuranceStarttime="
				+ insuranceStarttime + ", insuranceEndtime=" + insuranceEndtime + ", deptname=" + deptname
				+ ", filepath=" + filepath + ", insureType=" + insureType + ", carid=" + carid + ", userid=" + userid
				+ "]";
	}

}