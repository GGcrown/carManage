package cn.boom.controller;

import cn.boom.pojo.Insurance;
import cn.boom.service.InsuranceService;
import cn.boom.vo.InsuranceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author crown
 * @ClassName InsuranceController
 * @Description 保险控制层
 * @email 1084961504@qq.com
 * @date Oct 23, 2017 4:24:54 PM
 */
@RequestMapping("/insurance")
@Controller
public class InsuranceController {

    // 保险服务层
    @Autowired
    private InsuranceService insuranceService;

    /**
     * 分页查询保险ajax
     *
     * @param page 页数
     * @return
     */
    @RequestMapping("/findInsuranceListAjax")
    @ResponseBody
    public InsuranceVo findInsuranceListAjax(int page) {
        InsuranceVo insuranceVo = new InsuranceVo();
        List<Insurance> insurances = insuranceService.findInsuranceList(page);
        insuranceVo.setInsurances(insurances);
        return insuranceVo;
    }

    /**
     * 通过id查找保险ajax
     *
     * @param insuranceId 保险id
     * @return
     */
    @RequestMapping("/findByInsureIdAjax")
    @ResponseBody
    public InsuranceVo findByInsureIdAjax(int insuranceId) {
        InsuranceVo insuranceVo = new InsuranceVo();
        Insurance insurance = insuranceService.findByInsuranceId(insuranceId);
        insuranceVo.setInsurance(insurance);
        return insuranceVo;
    }

    /**
     * 查找保险页数ajax
     *
     * @return
     */
    @RequestMapping("/countInsuranceAjax")
    @ResponseBody
    public InsuranceVo countInsuranceAjax() {
        InsuranceVo insuranceVo = new InsuranceVo();
        int insurancePage = insuranceService.countInsurance();
        insuranceVo.setPageSum(insurancePage);
        return insuranceVo;
    }

    /**
     * 通过保险id删除保险ajax
     *
     * @param insureId 保险id
     * @return
     */
    @RequestMapping("/deleteInsuranceAjax")
    @ResponseBody
    public int deleteInsuranceAjax(int insureId) {
        return insuranceService.deleteInsurance(insureId);
    }

    /**
     * 通过保险id更新保险
     *
     * @param insurance 保险
     * @return
     */
    @RequestMapping("/updateInsuranceAjax")
    @ResponseBody
    public int updateInsuranceAjax(@RequestBody Insurance insurance) {
        return insuranceService.updateInsurance(insurance);
    }


    /**
     * 添加保险ajax
     *
     * @param insurance 保险
     * @return
     */
    @RequestMapping("/addInsuranceAjax")
    @ResponseBody
    public int addInsuranceAjax(@RequestBody Insurance insurance) {
        insurance.setUserid(1);
        insurance.setCarid(4);
        return insuranceService.addInsurance(insurance);
    }

}
