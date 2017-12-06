package cn.boom.controller;

import cn.boom.pojo.Annualcheck;
import cn.boom.service.AnnualcheckService;
import cn.boom.vo.AnnualcheckVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Crown
 * @ClassName AnnualcheckController
 * @Description TODO
 * @email 1084961504@qq.com
 * @date 2017/12/5
 */
@RequestMapping("/annualcheck")
@Controller
public class AnnualcheckController {

    @Autowired
    private AnnualcheckService annualcheckService;


    @RequestMapping("/addAnnualcheckAjax")
    @ResponseBody
    public int addAnnualcheckAjax(Annualcheck annualcheck) {
        return annualcheckService.addAnnualcheck(annualcheck);
    }

    @RequestMapping("/deleteAnnualcheckAjax")
    @ResponseBody
    public int deleteAnnualcheckAjax(int annualcheckId) {
        //todo
        return 0;
    }

    @RequestMapping("/updateAnnualcheckAjax")
    @ResponseBody
    public int updateAnnualcheckAjax(Annualcheck annualcheck) {
        return annualcheckService.updateByAnnualcheckId(annualcheck);
    }

    @RequestMapping("/listAnnualcheckByPageAjax")
    @ResponseBody
    public AnnualcheckVo listAnnualcheckByPageAjax(int page) {
        List<Annualcheck> annualchecks = annualcheckService.listAnnualcheckByPage(page);
        AnnualcheckVo annualcheckVo = new AnnualcheckVo();
        annualcheckVo.setAnnualcheckList(annualchecks);
        return annualcheckVo;
    }

    @RequestMapping("/findAnnualcheckById")
    @ResponseBody
    public AnnualcheckVo findAnnualcheckById(int annualcheckId) {
        Annualcheck annualcheck = annualcheckService.findAnnualcheckById(annualcheckId);
        AnnualcheckVo annualcheckVo = new AnnualcheckVo();
        annualcheckVo.setAnnualcheck(annualcheck);
        return annualcheckVo;
    }


    /**
     * 获取页数量
     *
     * @return
     */
    @RequestMapping("/countAnnualcheckAjax")
    @ResponseBody
    public int countAnnualcheckAjax() {
        return annualcheckService.countAnnualcheck();
    }

}
