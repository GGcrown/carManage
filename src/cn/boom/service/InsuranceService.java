/**  
 * @Title InsuranceService.java
 * @Package cn.boom.service
 * @Description TODO
 * @author crown
 * @date Oct 23, 2017 4:21:51 PM
 */
package cn.boom.service;

import java.util.List;

import cn.boom.pojo.Insurance;
import cn.boom.vo.InsuranceVo;

/**
 * @ClassName InsuranceService
 * @Description insurance interface
 * @author crown
 * @email 1084961504@qq.com
 * @date Oct 23, 2017 4:21:51 PM
 */
public interface InsuranceService {

	/**
	 * @Description select insurance list
	 * @param page
	 * @return
	 * @author crown
	 * @date Oct 23, 2017
	 */
	public List<Insurance> findInsuranceList(Integer page);

	/**
	 * @Description TODO
	 * @param insuranceId
	 * @return
	 * @author crown
	 * @date Nov 6, 2017
	 */
	public Insurance findByInsuranceId(Integer insuranceId);

	/**
	 * @Description TODO
	 * @return
	 * @author crown
	 * @date Nov 7, 2017
	 */
	public int countInsurance();

	public int updateInsurance(Insurance insurance);

	public int addInsurance(Insurance insurance);

	public int deleteInsurance(int insureId);

}
