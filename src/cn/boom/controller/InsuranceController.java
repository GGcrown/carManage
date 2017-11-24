package cn.boom.controller;

import cn.boom.pojo.Insurance;
import cn.boom.service.InsuranceService;
import cn.boom.vo.InsuranceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author crown
 * @ClassName InsuranceController
 * @Description insurance controller class
 * @email 1084961504@qq.com
 * @date Oct 23, 2017 4:24:54 PM
 */
@RequestMapping("/insurance")
@Controller
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    /* 查找第一页 */
    @RequestMapping("/findInsuranceListFirst")
    public String findInsuranceListFirst(Model model) {
        List<Insurance> list = insuranceService.findInsuranceList(0);
        System.out.println("content--0");
        return "/content0";// 引发css和script路径问题
        // return "redirect:/jsp/content0.jsp";
    }

    /* 通过页数查找保险 */
    @RequestMapping("/findInsuranceList")
    public String findInsuranceList(int page, Model model) {
        System.out.println("page----------" + page);
        page = page != 0 ? 0 : page;
        List<Insurance> list = insuranceService.findInsuranceList(page);
        return "redirect:/jsp/content0.jsp";
    }

    @RequestMapping("/findInsuranceListAjax")
    @ResponseBody
    public InsuranceVo findInsuranceListAjax(int page) {
        InsuranceVo insuranceVo = new InsuranceVo();
        List<Insurance> insurances = insuranceService.findInsuranceList(page);
        insuranceVo.setInsurances(insurances);
        return insuranceVo;
    }

    @RequestMapping("/findByInsureIdAjax")
    @ResponseBody
    public InsuranceVo findByInsureIdAjax(int insuranceId) {
        InsuranceVo insuranceVo = new InsuranceVo();
        Insurance insurance = insuranceService.findByInsuranceId(insuranceId);
        insuranceVo.setInsurance(insurance);
        return insuranceVo;
    }

    @RequestMapping("/countInsuranceAjax")
    @ResponseBody
    public InsuranceVo countInsuranceAjax() {
        InsuranceVo insuranceVo = new InsuranceVo();
        int insurancePage = insuranceService.countInsurance();
        insuranceVo.setPageSum(insurancePage);
        return insuranceVo;
    }

    @RequestMapping("/deleteInsuranceAjax")
    @ResponseBody
    public int deleteInsuranceAjax(int insureId) {
        return insuranceService.deleteInsurance(insureId);
    }

    @RequestMapping("/addInsuranceAjax")
    @ResponseBody
    public int addInsuranceAjax(@RequestBody Insurance insurance) {
        insurance.setUserid(1);
        insurance.setCarid(4);
        return insuranceService.addInsurance(insurance);
    }

}
