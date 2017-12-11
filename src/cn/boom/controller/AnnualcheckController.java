package cn.boom.controller;

import cn.boom.pojo.Annualcheck;
import cn.boom.service.AnnualcheckService;
import cn.boom.util.BaseLog;
import cn.boom.vo.AnnualcheckVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    // 自动注入年检接口
    @Autowired
    private AnnualcheckService annualcheckService;


    //日志
    private Logger log = BaseLog.getLogger(AnnualcheckController.class);

    /**
     * 添加年检
     *
     * @param annualcheck
     * @return
     */
    @RequestMapping("/addAnnualcheckAjax")
    @ResponseBody
    public int addAnnualcheckAjax(@RequestBody Annualcheck annualcheck) {
        log.error("addAnnualcheckAjax--"+annualcheck);
        annualcheck.setUserId(3);
        return annualcheckService.addAnnualcheck(annualcheck);
    }

    /**
     * 删除年检
     *
     * @param annualcheckId
     * @return
     */
    @RequestMapping("/deleteAnnualcheckAjax")
    @ResponseBody
    public int deleteAnnualcheckAjax(int annualcheckId) {

        return annualcheckService.deleteByAnnualcheckId(annualcheckId);
    }

    /**
     * 更新年检
     *
     * @param annualcheck
     * @return
     */
    @RequestMapping("/updateAnnualcheckAjax")
    @ResponseBody
    public int updateAnnualcheckAjax(Annualcheck annualcheck) {
        return annualcheckService.updateByAnnualcheckId(annualcheck);
    }

    /**
     * 分页查询年检
     *
     * @param page
     * @return
     */
    @RequestMapping("/listAnnualcheckByPageAjax")
    @ResponseBody
    public AnnualcheckVo listAnnualcheckByPageAjax(int page) {
        List<Annualcheck> annualchecks = annualcheckService.listAnnualcheckByPage(page);
        AnnualcheckVo annualcheckVo = new AnnualcheckVo();
        annualcheckVo.setAnnualcheckList(annualchecks);
        return annualcheckVo;
    }

    /**
     * 通过年检id查找年检信息
     *
     * @param annualcheckId
     * @return
     */
    @RequestMapping("/findAnnualcheckByIdAjax")
    @ResponseBody
    public AnnualcheckVo findAnnualcheckByIdAjax(int annualcheckId) {
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
    public AnnualcheckVo countAnnualcheckAjax() {
        AnnualcheckVo annualcheckVo = new AnnualcheckVo();
        annualcheckVo.setPageSum(annualcheckService.countAnnualcheck());
        return annualcheckVo;
    }

}
