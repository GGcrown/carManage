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
 * @author crown
 * @ClassName CarServiceImpl
 * @Description TODO
 * @email 1084961504@qq.com
 * @date Oct 24, 2017 9:32:46 AM
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public List<Car> findCarList(int page) {
        List<Car> cars = carMapper.selectByPage(page * Page.CAR_PAGE);
        return cars;
    }

    /**
     * @return
     * @Description TODO
     */
    @Override
    public int findCountCar() {
        CarExample example = new CarExample();
        example.createCriteria().andCarTypeNotEqualTo(3);
        int countCar = carMapper.countByExample(example);
        int page = countCar % Page.CAR_PAGE == 0 ? countCar / Page.CAR_PAGE : countCar / Page.CAR_PAGE + 1;
        return page;
    }

    /**
     * @param carId
     * @return
     * @Description view car detail
     */
    @Override
    public Car findCarById(int carId) {
        return carMapper.selectByPrimaryKey(carId);
    }

    /**
     * @param car
     * @return
     * @Description TODO
     */
    @Override
    public int updateCar(Car car) {
        // return carMapper.updateByPrimaryKey(car);
        return carMapper.updateByPrimaryKeySelective(car);

    }

    /**
     * @return
     * @Description TODO
     */
    @Override
    public int addCar(Car car) {
        return carMapper.insertSelective(car);
    }

    /**
     * @param carId
     * @return
     * @Description TODO
     */
    @Override
    public int deleteCar(int carId) {
        Car car = new Car();
        car.setCarId(carId);
        car.setCarType(3);
        return carMapper.updateByPrimaryKeySelective(car);
        // return carMapper.deleteByPrimaryKey(carId);
    }

    @Override
    public List<Car> listCar() {
        CarExample carExample = new CarExample();
        carExample.createCriteria().andCarTypeNotEqualTo(3);
        return carMapper.selectByExample(carExample);
    }

}
