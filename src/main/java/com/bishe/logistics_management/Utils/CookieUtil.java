package com.bishe.logistics_management.Utils;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * 有关Cookie的工具类用于存储、读取、删除以及销毁
 * 还存在一些有关于Cookie的方法，如：确认是否登录
 * @author 黄伟
 */
public class CookieUtil {

    /**
     * 存储Cookie的所有名字
     */
    private static ArrayList<String> stack = new ArrayList<>();

    /**
     * 检验当前是否已经登录
     * @param request 请求变量
     * @return 返回布尔值判断是否已经登录
     */
    public static boolean checkLogIn(ModelAndView mv,HttpServletRequest request){
        if(CookieUtil.getValue(request,"username")!=null && CookieUtil.getValue(request,"password")!=null){
            UserUtil.addUser(mv,request);//为MV添加用户
            PermissionUtil.setPermission(mv,request);//为MV添加权限
            return true;
        }
        return false;
    }

    /**
    工具类用以设置cookie
    @param response 响应变量
     @param key cookie中的键
     @param value cookie中键对应的值
     */
    public static void set(HttpServletResponse response, String key, String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setPath("/");
        cookie.setMaxAge(3600);
        stack.add(key);
        response.addCookie(cookie);
    }

    /**
     *按照键获取Cookie的值
     * @param request 请求变量
     * @param key 想要访问的cookie中的键值
     * @return 返回查询的值
     */
    public static String getValue(HttpServletRequest request, String key) {
        Cookie cookie = get(request, key);
        if (cookie != null) {
            return cookie.getValue();
        }
        return null;
    }

    /**
     * 按照键删除cookie
     * @param request 请求变量
     * @param response 响应变量
     * @param key 要求删除的cookie的键
     */
    public static void remove(HttpServletRequest request, HttpServletResponse response, String key) {
        Cookie cookie = get(request, key);
        stack.remove(key);
        if (cookie != null) {
            set(response, key, null);
        }
    }

    /**
     * 用户登出之后，销毁所有的cookie
     * @param request 请求变量
     * @param response 返回变量
     */
    public static void destroy(HttpServletRequest request, HttpServletResponse response){
        for(String e : stack){
            Cookie cookie = get(request, e);
            stack.remove(e);
            if (cookie != null) {
                set(response, e, null);
            }
        }
    }

    /**
     * 查询Cookie
     * @param request 请求变量
     * @param key 键变量
     */
    private static Cookie get(HttpServletRequest request, String key) {
        Cookie[] arr_cookie = request.getCookies();
        if (arr_cookie != null && arr_cookie.length > 0) {
            for (Cookie cookie : arr_cookie) {
                if (cookie.getName().equals(key)) {
                    return cookie;
                }
            }
        }
        return null;
    }
}
