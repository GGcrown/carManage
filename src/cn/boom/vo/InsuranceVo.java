/**  
 * @Title InsuranceVo.java
 * @Package cn.boom.vo
 * @Description TODO
 * @author crown
 * @date Nov 6, 2017 1:59:18 PM
 */
package cn.boom.vo;

import java.util.List;

import cn.boom.pojo.Insurance;

/**
 * @ClassName InsuranceVo
 * @Description TODO
 * @author crown
 * @email 1084961504@qq.com
 * @date Nov 6, 2017 1:59:18 PM
 */
public class InsuranceVo {

	// 列表显示
	List<Insurance> insurances;
	// 分页数量
	private int pageSum;
	// 单个insurance
	private Insurance insurance;
	public List<Insurance> getInsurances() {
		return insurances;
	}

	public void setInsurances(List<Insurance> insurances) {
		this.insurances = insurances;
	}

	public int getPageSum() {
		return pageSum;
	}

	public void setPageSum(int pageSum) {
		this.pageSum = pageSum;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

}
