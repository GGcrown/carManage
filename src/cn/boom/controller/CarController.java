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
import cn.boom.util.BaseLog;
import cn.boom.util.FileUtil;
import cn.boom.vo.CarVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author crown
 * @ClassName CarController
 * @Description 汽车控制层
 * @email 1084961504@qq.com
 * @date Oct 24, 2017 9:29:23 AM
 */
@RequestMapping("/car")
@Controller
public class CarController {

    // 自动注入车辆服务层
    @Autowired
    private CarService carService;

    //日志
    private Logger log = BaseLog.getLogger(AnnualcheckController.class);

    // @RequestMapping("/findCarListFirst")
    // public String findCarListFirst(RedirectAttributes attr) {
    //     attr.addAttribute("page", 0);
    //     return "redirect:findCarList.action";
    // }

    // @RequestMapping("/findCarList")
    // public String findCarList(int page, Model model) {
    //     List<Car> cars = carService.findCarList(page);
    //     model.addAttribute("cars", cars);
    //     return "content0";
    // }
    //
    // @RequestMapping("/findCarById")
    // public String findCarById(int carId, Model model) {
    //     Car car = carService.findCarById(carId);
    //     model.addAttribute("car", car);
    //
    //     return null;
    // }

    /**
     * 列表查询ajax
     *
     * @param page 页数
     * @return
     */
    @RequestMapping("/findCarListAjax")
    @ResponseBody
    public CarVo findCarListAjax(int page) {
        // paging query car
        List<Car> cars = carService.findCarList(page);
        CarVo carVo = new CarVo();
        carVo.setCars(cars);
        return carVo;
    }

    /**
     * ajax统计汽车页数
     *
     * @return
     */
    @RequestMapping("/countCarAjax")
    @ResponseBody
    public CarVo countCarAjax() {
        CarVo carVo = new CarVo();
        // query count car
        int carPage = carService.findCountCar();
        carVo.setPageSum(carPage);
        return carVo;
    }


    /**
     * 通过id查找汽车ajax
     *
     * @param carId 汽车id
     * @return
     */
    @RequestMapping("/findCarByIdAjax")
    @ResponseBody
    public CarVo findCarByIdAjax(int carId) {
        Car car = carService.findCarById(carId);
        CarVo carVo = new CarVo();
        carVo.setCar(car);
        return carVo;
    }


    /**
     * 通过汽车id更新汽车信息ajax
     *
     * @param car 汽车
     * @return
     */
    @RequestMapping("/updateCarAjax")
    @ResponseBody
    public int updateCarAjax(@RequestBody Car car) {
        System.out.println(car);
        return carService.updateCar(car);
    }

    /**
     * 添加汽车
     *
     * @param car 汽车
     * @return
     */
    @RequestMapping("/addCarAjax")
    @ResponseBody
    public int addCarAjax(@RequestBody Car car) {
        // 暂时还没有session
        // TODO
        // 创建日期文件夹
        String dirPath = FileUtil.mkCalendarDir();
        // 移动文件到日期到日期文件夹
        FileUtil.moveFile(car.getCarPhoto(), dirPath);
        // 完整的路径
        String fullPath = dirPath + car.getCarPhoto();
        // 把完整路径存储到数据库
        fullPath = fullPath.substring(fullPath.lastIndexOf("car_photo") + 10);
        car.setCarPhoto(fullPath);
        car.setCarUserid(1);
        return carService.addCar(car);
    }

    /**
     * 删除汽车
     *
     * @param carId
     * @return
     */
    @RequestMapping("/ss")
    @ResponseBody
    public int ss(int carId) {
        return carService.deleteCar(carId);
    }

    /**
     * 查找所有汽车车牌号ajax
     *
     * @return
     */
    @RequestMapping("/findAllCarPlateAjax")
    @ResponseBody
    public List<Car> findAllCarPlateAjax() {
        return carService.listCar();
    }

    /**
     * 上传汽车图片
     *
     * @param multipartFile
     * @return
     */
    @RequestMapping("/uplodingFile")
    public String uplodingFile(MultipartFile multipartFile) {
        if (multipartFile != null) {
            // 原始名称
            String originalFileName = multipartFile.getOriginalFilename();
            // 存储图片的物理位置
            String pic_path = "H:\\car_photo\\";
            // 新图片的名称
            String newFileName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
            // 新图片
            File newFile = new File(pic_path + newFileName);
            // 将内存中的图片写到磁盘上
            try {
                multipartFile.transferTo(newFile);
            } catch (IOException e) {
                log.error("---->uploadingFileException" + e.getMessage());
            }
        }
        return "/content8.html";
    }

    /**
     * 上传汽车图片ajax
     *
     * @param multipartFile 文件
     * @return
     */
    @RequestMapping("/uplodingFileAjax")
    @ResponseBody
    public CarVo uplodingFileAjax(MultipartFile multipartFile) {
        CarVo carVo = new CarVo();
        if (multipartFile != null) {
            // 原始名称
            String originalFileName = multipartFile.getOriginalFilename();
            // 存储图片的物理位置    临时存储文件夹
            String pic_path = "H:\\car_photo\\temp\\";
            // 新图片的名称
            String newFileName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
            // 新图片
            File newFile = new File(pic_path + newFileName);
            // 将内存中的图片写到磁盘上
            try {
                multipartFile.transferTo(newFile);
            } catch (IOException e) {
                log.error("---->uploadingFileException" + e.getMessage());
            }
            carVo.setMessage("提交成功");
            Car car = new Car();
            car.setCarPhoto(newFileName);
            carVo.setCar(car);
        } else {
            carVo.setMessage("提交失败");
            return carVo;
        }
        return carVo;
    }

}
