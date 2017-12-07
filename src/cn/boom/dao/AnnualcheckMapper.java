package cn.boom.dao;

import cn.boom.pojo.Annualcheck;
import cn.boom.pojo.AnnualcheckExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnualcheckMapper {
    int countByExample(AnnualcheckExample example);

    int deleteByExample(AnnualcheckExample example);

    int deleteByPrimaryKey(Integer annualcheckId);

    int insert(Annualcheck record);

    int insertSelective(Annualcheck record);

    List<Annualcheck> selectByExample(AnnualcheckExample example);

    Annualcheck selectByPrimaryKey(Integer annualcheckId);

    int updateByExampleSelective(@Param("record") Annualcheck record, @Param("example") AnnualcheckExample example);

    int updateByExample(@Param("record") Annualcheck record, @Param("example") AnnualcheckExample example);

    int updateByPrimaryKeySelective(Annualcheck record);

    int updateByPrimaryKey(Annualcheck record);
    //-----------
    List<Annualcheck> selectByPage(int page);

}