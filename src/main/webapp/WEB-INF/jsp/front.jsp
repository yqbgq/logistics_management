<!--定义了后台界面中的上方导航栏以及左侧导航栏，用以在具体页面导入使用，无需重复 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>物流管理系统后台</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <script src="layui/echarts.all.js"></script>
</head>
<body class="layui-layout-body" style="background-color:#F5F5F5;">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">物流管理系统</div>
        <!-- 头部区域导航 视情况而定开放权限管理-->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item">
                <a href="/index">
                    <i class="layui-icon layui-icon-console" style="font-size: 18px; float:left;"></i>
                    &nbsp;&nbsp;&nbsp;&nbsp;控制台
                </a>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">登录记录</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">${user.getName()}</li>
            <li class="layui-nav-item"><a href="/logout">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域视情况而定开放权限 -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                    <li class="layui-nav-item">
                        <a class="" href="javascript:;">
                            <i class="layui-icon layui-icon-user" style="font-size: 18px; float:left;"></i>
                            &nbsp;&nbsp;&nbsp;&nbsp;用户管理
                        </a>
                        <dl class="layui-nav-child">
                            <dd><a href="/person">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;个人信息</a></dd>
                            <dd><a href="/send">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;内部交流</a></dd>
                            <dd><a href="/todolist">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;待办事项</a></dd>
                            <c:if test="${permission.users==1 || permission.orders==1 || permission.plan==1 || permission.warehouse==1||permission.affairs==1}"><dd><a href="/announce">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发布通知</a></dd></c:if>
                            <c:if test="${permission.users==1}"><dd><a href="/approvelist">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户审核</a></dd></c:if>
                        </dl>
                    </li>


                <c:if test="${permission.orders != 0}" >
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">
                        <i class="layui-icon layui-icon-chart-screen" style="font-size: 18px; float:left;"></i>
                        &nbsp;&nbsp;&nbsp;&nbsp;营销管理
                    </a>
                    <dl class="layui-nav-child">
                        <c:if test="${permission.orders==1 || permission.orders==2}">
                        <dd><a href="/addcompany">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;增加货源</a></dd>
                        </c:if>
                        <c:if test="${permission.orders==1 || permission.orders==2}">
                        <dd><a href="/companylist">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;货源列表</a></dd>
                        </c:if>
                        <c:if test="${permission.orders==1 || permission.orders==2}">
                        <dd><a href="/addorder">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;新增订单</a></dd>
                        </c:if>
                        <c:if test="${permission.orders==1}">
                        <dd><a href="/orderlist">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;订单列表</a></dd>
                        </c:if>
                        <c:if test="${permission.orders==1 }">
                        <dd><a href="/onroad">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在途管理</a></dd>
                        </c:if>
                    </dl>
                </li>
                </c:if>
                <c:if test="${permission.plan != 0}" >
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="layui-icon layui-icon-flag" style="font-size: 18px; float:left;"></i>
                        &nbsp;&nbsp;&nbsp;&nbsp;运力管理
                    </a>
                    <dl class="layui-nav-child">
                        <c:if test="${permission.plan==1 || permission.plan==2}">
                        <dd><a href="/addcar">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;增加运力</a></dd>
                        </c:if>
                        <c:if test="${permission.plan==1 || permission.plan==2}">
                        <dd><a href="/carlist">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;运力列表</a></dd>
                        <dd><a href="/managelist">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;运力安排</a></dd>
                        </c:if>
                        <c:if test="${permission.plan==1}">
                        <dd><a href="/onroadtoother">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在途管理</a></dd>
                        <dd><a href="/startcar">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;运力发出</a></dd>
                        </c:if>
                    </dl>
                </li>
                </c:if>
                <c:if test="${permission.warehouse != 0}" >
                    <li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon layui-icon-component" style="font-size: 18px; float:left;"></i>
                            &nbsp;&nbsp;&nbsp;&nbsp;仓库管理
                        </a>
                        <dl class="layui-nav-child">
                            <dd><a href="/addwarehouse">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;增加仓库</a></dd>
                            <dd><a href="/addwarehouseunit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;增加库位</a></dd>
                            <dd><a href="/warehouselist">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;仓库列表</a></dd>
                        </dl>
                    </li>
                </c:if>
                <c:if test="${permission.affairs != 0}" >
				<li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="layui-icon layui-icon-rmb" style="font-size: 18px; float:left;"></i>
                        &nbsp;&nbsp;&nbsp;&nbsp;财务管理
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="/addpaymethod">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;新增账户</a></dd>
                        <dd><a href="/waitforpay">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;订单收款</a></dd>
                    </dl>
                </li>
                </c:if>
            </ul>
        </div>
    </div>
    <div class="layui-body">