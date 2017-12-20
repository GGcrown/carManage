/**
 * @Title InsuranceService.java
 * @Package cn.boom.service
 * @Description TODO
 * @author crown
 * @date Oct 23, 2017 4:21:51 PM
 */
package cn.boom.service;

import cn.boom.pojo.Insurance;

import java.util.List;

/**
 * @author crown
 * @ClassName InsuranceService
 * @Description 保险服务层
 * @email 1084961504@qq.com
 * @date Oct 23, 2017 4:21:51 PM
 */
public interface InsuranceService {

    /**
     * 分页查询保险
     *
     * @param page 页数
     * @return
     */
    List<Insurance> findInsuranceList(Integer page);

    /**
     * 通过id查找保险
     *
     * @param insuranceId 保险id
     * @return
     */
    Insurance findByInsuranceId(Integer insuranceId);

    /**
     * 计数页数
     *
     * @return
     */
    int countInsurance();

    /**
     * 通过id更新保险
     *
     * @param insurance 保险
     * @return
     */
    int updateInsurance(Insurance insurance);

    /**
     * 添加保险
     *
     * @param insurance 保险
     * @return
     */
    int addInsurance(Insurance insurance);

    /**
     * 通过id删除保险
     *
     * @param insureId 保险id
     * @return
     */
    int deleteInsurance(int insureId);

}
