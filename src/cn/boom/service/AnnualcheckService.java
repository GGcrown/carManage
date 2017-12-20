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

    /**
     * 添加年检
     *
     * @param annualcheck 年检
     * @return
     */
    int addAnnualcheck(Annualcheck annualcheck);

    /**
     * 通过id通过id删除年检
     *
     * @param annualcheckId 年检id
     * @return
     */
    int deleteByAnnualcheckId(int annualcheckId);

    /**
     * 更新年检
     *
     * @param annualcheck
     * @return
     */
    int updateByAnnualcheckId(Annualcheck annualcheck);

    /**
     * 通过id查找年检
     *
     * @param annualcheckId 年检id
     * @return
     */
    Annualcheck findAnnualcheckById(int annualcheckId);

    /**
     * 分页查询页面
     *
     * @param page 页数
     * @return
     */
    List<Annualcheck> listAnnualcheckByPage(int page);

    /**
     * 分页计数
     *
     * @return
     */
    int countAnnualcheck();
}
