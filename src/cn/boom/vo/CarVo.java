/**
 * @Title CarVo.java
 * @Package cn.boom.vo
 * @Description TODO
 * @author crown
 * @date Oct 31, 2017 10:50:48 AM
 */
package cn.boom.vo;

import cn.boom.pojo.Car;

import java.util.List;

/**
 * @author crown
 * @ClassName CarVo
 * @Description TODO
 * @email 1084961504@qq.com
 * @date Oct 31, 2017 10:50:48 AM
 */
public class CarVo {
    // 列表显示
    private List<Car> cars;
    // 分页数量
    private int pageSum;
    // 车辆信息
    private Car car;
    // 查询信息
    private String message;


    public int getPageSum() {
        return pageSum;
    }

    public void setPageSum(int pageSum) {
        this.pageSum = pageSum;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
