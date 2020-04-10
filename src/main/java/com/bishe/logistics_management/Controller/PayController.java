package com.bishe.logistics_management.Controller;


import com.bishe.logistics_management.Utils.CookieUtil;
import com.bishe.logistics_management.database.dataObject.CompanyObject;
import com.bishe.logistics_management.database.dataObject.OrderObject;
import com.bishe.logistics_management.database.dataObject.PayMethodObject;
import com.bishe.logistics_management.database.dataObject.Payment;
import com.bishe.logistics_management.database.service.CompanyService;
import com.bishe.logistics_management.database.service.OrderService;
import com.bishe.logistics_management.database.service.PayMethodService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 支付方式的控制器
 * @author 黄伟
 */
@Controller
public class PayController {

    /**
     * 增加支付方式的页面
     * @param request 请求类
     * @return 返回MV
     */
    @RequestMapping("addpaymethod")
    public ModelAndView addPayMethod(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("addpaymethod");
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

    /**
     * 审核新增支付方式并且插入数据表
     * @param request 请求类
     * @param address 地址
     * @param account 帐号
     * @param bank 开户行
     * @param method 支付方法名
     * @param balance 初始余额
     * @return 返回MV
     */
    @RequestMapping("addpaymethodcheck")
    public ModelAndView addPayMethodChecker(HttpServletRequest request,
                                            @RequestParam("address") String address,
                                            @RequestParam("account") String account,
                                            @RequestParam("bank") String bank,
                                            @RequestParam("method") String method,
                                            @RequestParam("balance") int balance){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("redirect:/addpaymethod");
            PayMethodObject payMethodObject = new PayMethodObject();
            payMethodObject.setAccount(account);
            payMethodObject.setAddress(address);
            payMethodObject.setBalance(balance);
            payMethodObject.setBank(bank);
            payMethodObject.setMethod(method);
            PayMethodService.insertPayMethod(payMethodObject);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

    /**
     * 显示需要支付的订单的页面
     * @param request 请求类
     * @return 返回MV
     */
    @RequestMapping("waitforpay")
    public ModelAndView waitForPay(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("waitforpay");
            ArrayList<OrderObject> needPay = OrderService.getNeedPay();
            mv.addObject("pays",needPay);
            ArrayList<PayMethodObject> payMethods = PayMethodService.getAllPay();
            mv.addObject("methods",payMethods);
            ArrayList<CompanyObject> tempCompany = CompanyService.getAllCompany();
            HashMap<String,CompanyObject> companies = new HashMap<>();
            for(CompanyObject c : tempCompany){
                companies.put(c.getName(),c);
            }
            mv.addObject("companies",companies);
            for(OrderObject o : needPay){
                if(o.getMethod()==1)o.setPrice(o.getPrice() * o.getVolume());
                else o.setPrice(o.getPrice() * o.getWeight());
            }
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

    /**
     * 审核提交订单入账
     * @param request 请求类
     * @param id 订单ID
     * @param method 付款方式ID
     * @param total 付款总价
     * @return 发挥重定向
     */
    @RequestMapping("payordercheck/{id}")
    public ModelAndView payOrderCheck(HttpServletRequest request,
                                      @PathVariable("id") int id,
                                      @RequestParam("methodId") int method,
                                      @RequestParam("total") float total){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("redirect:/waitforpay");
            OrderService.payOrder(id);
            Payment payment = new Payment();
            payment.setId(method);
            payment.setNum(total);
            PayMethodService.payOrder(payment);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }
}
