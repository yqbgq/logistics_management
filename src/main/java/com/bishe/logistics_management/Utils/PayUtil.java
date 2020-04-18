package com.bishe.logistics_management.Utils;

import com.bishe.logistics_management.database.service.PayRecordService;
import org.springframework.web.servlet.ModelAndView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * 支付工具类
 * @author 黄伟
 */
public class PayUtil {

    /**
     * 在首页添加订单支付信息
     * @param mv MV
     */
    public static void indexAddPayInformation(ModelAndView mv){
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        String tempTime = "";
        tempTime += year + "-0" + month + "%";
        int moneyMonth = PayRecordService.countMoneyMonth(tempTime);
        int money = PayRecordService.countMoney();
        mv.addObject("money",money);
        mv.addObject("moneyMonth",moneyMonth);
    }

    /**
     * 在首页添加近7日支付款总数
     * @param mv
     */
    public static void indexAddPaySevenDayNum(ModelAndView mv){
        Calendar calendar = Calendar.getInstance();
        ArrayList<Integer> sevenDayPayNum = new ArrayList<>();
        for(int i=1;i<=7;i++){
            calendar.add(Calendar.DATE, -1); //得到前一天
            Date date = calendar.getTime();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            sevenDayPayNum.add(PayRecordService.getPayNumCertainDay(df.format(date)));
        }
        mv.addObject("sevenDayPayNum",sevenDayPayNum);
    }

    /**
     * 在首页添加最近7天支付的次数
     * @param mv MV
     */
    public static void indexAddPaySevenDayBillNum(ModelAndView mv){
        Calendar calendar = Calendar.getInstance();
        ArrayList<Integer> sevenDayBillNum = new ArrayList<>();
        for(int i=1;i<=7;i++){
            calendar.add(Calendar.DATE, -1); //得到前一天
            Date date = calendar.getTime();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            sevenDayBillNum.add(PayRecordService.getPayBillNumCertainDay(df.format(date)));
        }
        mv.addObject("sevenDayBillNum",sevenDayBillNum);
    }
}
