/**  
 * @Title InsuranceServiceImpl.java
 * @Package cn.boom.service
 * @Description TODO
 * @author crown
 * @date Oct 23, 2017 4:22:13 PM
 */
package cn.boom.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.boom.dao.InsuranceMapper;
import cn.boom.pojo.Insurance;
import cn.boom.pojo.InsuranceExample;
import cn.boom.service.InsuranceService;
import cn.boom.util.Page;
import cn.boom.vo.InsuranceVo;

/**
 * @ClassName InsuranceServiceImpl
 * @Description insurance service impl class
 * @author crown
 * @email 1084961504@qq.com
 * @date Oct 23, 2017 4:22:13 PM
 */
@Service
public class InsuranceServiceImpl implements InsuranceService {

	@Autowired
	private InsuranceMapper insuranceMapper;

	/**
	 * @Description
	 * @param page 页数
	 * @return
	 */
	@Override
	public List<Insurance> findInsuranceList(Integer page) {
		return insuranceMapper.selectCarByPage(page * Page.INSURANCEPAGE);
	}

	@Override
	public Insurance findByInsuranceId(Integer insuranceId) {
		return insuranceMapper.selectByPrimaryKey(insuranceId);
	}

	@Override
	public int countInsurance() {
		InsuranceExample example = new InsuranceExample();
		int insuranceSum = insuranceMapper.countByExample(example);
		int insurancePage = insuranceSum % Page.INSURANCEPAGE == 0 ? insuranceSum / Page.INSURANCEPAGE
				: insuranceSum / Page.INSURANCEPAGE + 1;
		return insurancePage;
	}

	/**
	 * @Description TODO
	 * @param insurance
	 * @return
	 */
	@Override
	public int updateInsurance(Insurance insurance) {
		return insuranceMapper.updateByPrimaryKeySelective(insurance);
	}

	/**
	 * @Description TODO
	 * @param insurance
	 * @return
	 */
	@Override
	public int addInsurance(Insurance insurance) {
		return insuranceMapper.insert(insurance);
	}

	/**
	 * @Description TODO
	 * @param insureId
	 * @return
	 */
	@Override
	public int deleteInsurance(int insureId) {
		return insuranceMapper.deleteByPrimaryKey(insureId);
	}

}
