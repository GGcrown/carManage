package cn.boom.dao;

import cn.boom.pojo.Car;
import cn.boom.pojo.CarExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 汽车dao接口
 */
public interface CarMapper {
    int countByExample(CarExample example);

    int deleteByExample(CarExample example);

    int deleteByPrimaryKey(Integer carId);

    int insert(Car record);

    int insertSelective(Car record);

    List<Car> selectByExample(CarExample example);

    Car selectByPrimaryKey(Integer carId);

    int updateByExampleSelective(@Param("record") Car record, @Param("example") CarExample example);

    int updateByExample(@Param("record") Car record, @Param("example") CarExample example);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);
    
    //oneself write interface
    List<Car> selectByPage(int page);
}