package cn.boom.dao;

import cn.boom.pojo.Insurance;
import cn.boom.pojo.InsuranceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InsuranceMapper {
	int countByExample(InsuranceExample example);

	int deleteByExample(InsuranceExample example);

	int deleteByPrimaryKey(Integer insureId);

	int insert(Insurance record);

	int insertSelective(Insurance record);

	List<Insurance> selectByExample(InsuranceExample example);

	Insurance selectByPrimaryKey(Integer insureId);

	int updateByExampleSelective(@Param("record") Insurance record, @Param("example") InsuranceExample example);

	int updateByExample(@Param("record") Insurance record, @Param("example") InsuranceExample example);

	int updateByPrimaryKeySelective(Insurance record);

	int updateByPrimaryKey(Insurance record);

	List<Insurance> selectCarByPage(int page);
}