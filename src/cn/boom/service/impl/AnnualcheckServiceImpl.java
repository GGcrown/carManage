package cn.boom.service.impl;

import cn.boom.dao.AnnualcheckMapper;
import cn.boom.pojo.Annualcheck;
import cn.boom.pojo.AnnualcheckExample;
import cn.boom.service.AnnualcheckService;
import cn.boom.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Crown
 * @ClassName AnnualcheckServiceImpl
 * @Description 年检服务层实现
 * @email 1084961504@qq.com
 * @date 2017/12/5
 */
@Service
public class AnnualcheckServiceImpl implements AnnualcheckService {

    @Autowired
    private AnnualcheckMapper annualcheckMapper;

    @Override
    public int addAnnualcheck(Annualcheck annualcheck) {
        return annualcheckMapper.insertSelective(annualcheck);
    }

    @Override
    public int deleteByAnnualcheckId(int annualcheckId) {
        Annualcheck annualcheck = new Annualcheck();
        annualcheck.setAnnualcheckId(annualcheckId);
        annualcheck.setAnnualcheckType(3);
        return annualcheckMapper.updateByPrimaryKeySelective(annualcheck);
    }

    @Override
    public int updateByAnnualcheckId(Annualcheck annualcheck) {
        return annualcheckMapper.updateByPrimaryKeySelective(annualcheck);
    }

    @Override
    public Annualcheck findAnnualcheckById(int annualcheckId) {
        return annualcheckMapper.selectByPrimaryKey(annualcheckId);
    }

    @Override
    public List<Annualcheck> listAnnualcheckByPage(int page) {
        return annualcheckMapper.selectByPage(page * Page.ANNUALCHECK_PAGE);
    }

    @Override
    public int countAnnualcheck() {
        AnnualcheckExample annualcheckExample = new AnnualcheckExample();
        //默认3为被删除
        annualcheckExample.createCriteria().andAnnualcheckTypeNotEqualTo(3);
        int count = annualcheckMapper.countByExample(annualcheckExample);
        //三目运算符
        return count % Page.ANNUALCHECK_PAGE == 0 ? count / Page.ANNUALCHECK_PAGE : count / Page.ANNUALCHECK_PAGE + 1;
    }
}