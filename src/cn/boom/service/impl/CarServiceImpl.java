/**
 * @Title CarServiceImpl.java
 * @Package cn.boom.service.impl
 * @Description TODO
 * @author crown
 * @date Oct 24, 2017 9:32:46 AM
 */
package cn.boom.service.impl;

import cn.boom.dao.CarMapper;
import cn.boom.pojo.Car;
import cn.boom.pojo.CarExample;
import cn.boom.service.CarService;
import cn.boom.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CarServiceImpl
 * @Description TODO
 * @author crown
 * @email 1084961504@qq.com
 * @date Oct 24, 2017 9:32:46 AM
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public List<Car> findCarList(int page) {
        List<Car> cars = carMapper.selectByPage(page * Page.CARPAGE);
        return cars;
    }

    /**
     * @Description TODO
     * @return
     */
    @Override
    public int findCountCar() {
        CarExample example = new CarExample();
        // example
        int countCar = carMapper.countByExample(example);
        int page = countCar % Page.CARPAGE == 0 ? countCar / Page.CARPAGE : countCar / Page.CARPAGE + 1;
        return page;
    }

    /**
     * @Description view car detail
     * @param carId
     * @return
     */
	@Override
	public Car findCarById(int carId) {
		return carMapper.selectByPrimaryKey(carId);
	}

    /**
     * @Description TODO
     * @param car
     * @return
     */
    @Override
    public int updateCar(Car car) {
        // return carMapper.updateByPrimaryKey(car);
        return carMapper.updateByPrimaryKeySelective(car);

    }

    /**
     * @Description TODO
     * @return
     */
    @Override
    public int addCar(Car car) {
        return carMapper.insertSelective(car);
    }

    /**
     * @Description TODO
     * @param carId
     * @return
     */
    @Override
    public int deleteCar(int carId) {
        return carMapper.deleteByPrimaryKey(carId);
    }

    @Override
    public List<Car> listCar() {
        CarExample carExample=new CarExample();
        return carMapper.selectByExample(carExample);
    }

}
