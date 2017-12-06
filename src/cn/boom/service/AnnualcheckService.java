package cn.boom.service;

import cn.boom.pojo.Annualcheck;

import java.util.List;

/**
 * @author Crown
 * @ClassName Annualcheck
 * @Description 年检服务层
 * @email 1084961504@qq.com
 * @date 2017/12/5
 */
public interface AnnualcheckService {

    int addAnnualcheck(Annualcheck annualcheck);

    int deleteByAnnualcheckId(int annualcheckId);

    int updateByAnnualcheckId(Annualcheck annualcheck);

    Annualcheck findAnnualcheckById(int annualcheckId);

    List<Annualcheck> listAnnualcheckByPage(int page);

    int countAnnualcheck();
}
