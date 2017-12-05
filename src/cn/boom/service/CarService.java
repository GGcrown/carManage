/**
 * @Title CarService.java
 * @Package cn.boom.service
 * @Description TODO
 * @author crown
 * @date Oct 24, 2017 9:32:18 AM
 */
package cn.boom.service;

import cn.boom.pojo.Car;

import java.util.List;

/**
 * @author crown
 * @ClassName CarService
 * @Description TODO
 * @email 1084961504@qq.com
 * @date Oct 24, 2017 9:32:18 AM
 */
public interface CarService {

    /**
     * @param page
     * @Description findCarList
     * @author crown
     * @date Oct 24, 2017
     */
    List<Car> findCarList(int page);

    /**
     * @Description TODO
     * @author crown
     * @date Oct 31, 2017
     */
    int findCountCar();

    /**
     * @param carId
     * @return
     * @Description TODO
     * @author crown
     * @date Nov 1, 2017
     */
    Car findCarById(int carId);

    /**
     * @param car
     * @Description update car
     * @author crown
     * @date Nov 3, 2017
     */
    int updateCar(Car car);

    /**
     * @return
     * @Description add car
     * @author crown
     * @date Nov 6, 2017
     */
    int addCar(Car car);

    /**
     * @param carId
     * @return
     * @Description TODO
     * @author crown
     * @date Nov 6, 2017
     */
    int deleteCar(int carId);

    /**
     * 查找车牌号
     */
    List<Car> listCar();
}
