package com.bishe.logistics_management.Controller;


import com.bishe.logistics_management.Utils.CookieUtil;
import com.bishe.logistics_management.database.dataObject.PayMethodObject;
import com.bishe.logistics_management.database.service.PayMethodService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

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
}
