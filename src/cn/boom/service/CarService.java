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
 * 汽车服务层
 */
public interface CarService {

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
