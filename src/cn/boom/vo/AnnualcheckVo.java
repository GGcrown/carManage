package cn.boom.vo;

import cn.boom.pojo.Annualcheck;

import java.util.List;

/**
 * @author Crown
 * @ClassName AnnualcheckVo
 * @Description TODO
 * @email 1084961504@qq.com
 * @date 2017/12/5
 */
public class AnnualcheckVo {
    // 年检信息
    private Annualcheck annualcheck;
    // 列表显示
    private List<Annualcheck> annualcheckList;
    // 分页数量
    private int pageSum;

    public Annualcheck getAnnualcheck() {
        return annualcheck;
    }

    public void setAnnualcheck(Annualcheck annualcheck) {
        this.annualcheck = annualcheck;
    }

    public List<Annualcheck> getAnnualcheckList() {
        return annualcheckList;
    }

    public void setAnnualcheckList(List<Annualcheck> annualcheckList) {
        this.annualcheckList = annualcheckList;
    }

    public int getPageSum() {
        return pageSum;
    }

    public void setPageSum(int pageSum) {
        this.pageSum = pageSum;
    }
}
