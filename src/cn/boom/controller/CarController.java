/**
 * @Title CarController.java
 * @Package cn.boom.controller
 * @Description TODO
 * @author crown
 * @date Oct 24, 2017 9:29:23 AM
 */
package cn.boom.controller;

import cn.boom.pojo.Car;
import cn.boom.service.CarService;
import cn.boom.vo.CarVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @ClassName CarController
 * @Description TODO
 * @author crown
 * @email 1084961504@qq.com
 * @date Oct 24, 2017 9:29:23 AM
 */

@RequestMapping("/car")
@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping("/findCarListFirst")
    public String findCarListFirst(RedirectAttributes attr) {
        attr.addAttribute("page", 0);
        return "redirect:findCarList.action";
    }

    @RequestMapping("/findCarList")
    public String findCarList(int page, Model model) {
        List<Car> cars = carService.findCarList(page);
        model.addAttribute("cars", cars);
        return "content0";
    }

    @RequestMapping("/findCarListAjax")
    @ResponseBody
    public CarVo findCarListAjax(int page) {
        // paging query car
        List<Car> cars = carService.findCarList(page);
        CarVo carVo = new CarVo();
        carVo.setCars(cars);
        return carVo;
    }

    @RequestMapping("/countCarAjax")
    @ResponseBody
    public CarVo countCarAjax() {
        CarVo carVo = new CarVo();
        // query count car
        int carPage = carService.findCountCar();
        carVo.setPageSum(carPage);
        return carVo;
    }

    /*
     * view car detail
     */
    @RequestMapping("/findCarById")
    public String findCarById(int carId, Model model) {
        Car car = carService.findCarById(carId);
        model.addAttribute("car", car);
        return "content_car_detail";
    }

    /*
     * view car detail ajax
     */
    @RequestMapping("/findCarByIdAjax")
    @ResponseBody
    public Car findCarByIdAjax(int carId) {
        Car car = carService.findCarById(carId);
        // System.out.println(car);
        return car;
    }

    @RequestMapping("/updateCarAjax")
    @ResponseBody
    public int updateCarAjax(@RequestBody Car car) {
        System.out.println(car);
        return carService.updateCar(car);
    }

    @RequestMapping("/addCarAjax")
    @ResponseBody
    public int addCarAjax(@RequestBody Car car) {
        // 暂时还没有session
        // TODO
        car.setCarUserid(1);
        return carService.addCar(car);
    }

    @RequestMapping("/ss")
    @ResponseBody
    public int ss(int carId) {


        System.out.println(carId);
        return carService.deleteCar(carId);
    }

}
