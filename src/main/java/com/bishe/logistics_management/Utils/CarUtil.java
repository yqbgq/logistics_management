package com.bishe.logistics_management.Utils;

import com.bishe.logistics_management.database.service.CarService;
import org.springframework.web.servlet.ModelAndView;

/**
 * 车辆类的工具类
 * @author 黄伟
 */
public class CarUtil {

    /**
     * 在首页中添加车辆信息
     * @param mv MV
     */
    public static void indexAddCarInformation(ModelAndView mv){
        mv.addObject("carNum", CarService.getCarNum());
        mv.addObject("carNumInRoad",CarService.getCarNumInRoad());
    }
}
