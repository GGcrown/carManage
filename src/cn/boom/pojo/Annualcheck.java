package cn.boom.pojo;

import java.util.Date;

public class Annualcheck {
    private Integer annualcheckId;

    private Date lastannualcheckdate;

    private Date nextannualcheckdate;

    private String path;

    private String deptname;

    private Integer userId;

    private Integer carId;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    private String reserve4;

    private String reserve5;

    private String reserve6;

    public Integer getAnnualcheckId() {
        return annualcheckId;
    }

    public void setAnnualcheckId(Integer annualcheckId) {
        this.annualcheckId = annualcheckId;
    }

    public Date getLastannualcheckdate() {
        return lastannualcheckdate;
    }

    public void setLastannualcheckdate(Date lastannualcheckdate) {
        this.lastannualcheckdate = lastannualcheckdate;
    }

    public Date getNextannualcheckdate() {
        return nextannualcheckdate;
    }

    public void setNextannualcheckdate(Date nextannualcheckdate) {
        this.nextannualcheckdate = nextannualcheckdate;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
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

    public String getReserve6() {
        return reserve6;
    }

    public void setReserve6(String reserve6) {
        this.reserve6 = reserve6 == null ? null : reserve6.trim();
    }
}