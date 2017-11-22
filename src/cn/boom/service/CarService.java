/**  
 * @Title CarService.java
 * @Package cn.boom.service
 * @Description TODO
 * @author crown
 * @date Oct 24, 2017 9:32:18 AM
 */
package cn.boom.service;

import java.util.List;

import cn.boom.pojo.Car;

/**
 * @ClassName CarService
 * @Description TODO
 * @author crown
 * @email 1084961504@qq.com
 * @date Oct 24, 2017 9:32:18 AM
 */
public interface CarService {

	/**
	 * @Description findCarList
	 * @param page
	 * @author crown
	 * @date Oct 24, 2017
	 */
	public List<Car> findCarList(int page);

	/**
	 * @Description TODO
	 * @author crown
	 * @date Oct 31, 2017
	 */
	public int findCountCar();

	/**
	 * @Description TODO
	 * @param carId
	 * @return
	 * @author crown
	 * @date Nov 1, 2017
	 */
	public Car findCarById(int carId);

	/**
	 * @Description update car
	 * @param car
	 * @author crown
	 * @date Nov 3, 2017
	 */
	public int updateCar(Car car);

	/**
	 * @Description add car
	 * @return
	 * @author crown
	 * @date Nov 6, 2017
	 */
	public int addCar(Car car);

	/**
	 * @Description TODO
	 * @param carId
	 * @return
	 * @author crown
	 * @date Nov 6, 2017
	 */
	public int deleteCar(int carId);

}
