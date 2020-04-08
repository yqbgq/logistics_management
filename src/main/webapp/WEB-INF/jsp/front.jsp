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
</head>
<body class="layui-layout-body" style="background-color:#F5F5F5;">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">物流管理系统</div>
        <!-- 头部区域导航 视情况而定开放权限管理-->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="/index">控制台</a></li>
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
                        <a class="" href="javascript:;">用户管理</a>
                        <dl class="layui-nav-child">
                            <dd><a href="/person">个人信息</a></dd>
                            <dd><a href="/send">内部交流</a></dd>
                            <dd><a href="/todolist">待办事项</a></dd>
                            <c:if test="${permission.users==1 || permission.orders==1 || permission.plan==1 || permission.warehouse==1||permission.affairs==1}"><dd><a href="/announce">发布通知</a></dd></c:if>
                            <c:if test="${permission.users==2}"><dd><a href="https://www.baidu.com">员工操作</a></dd></c:if>
                            <c:if test="${permission.users==1}"><dd><a href="/approvelist">用户审核</a></dd></c:if>
                        </dl>
                    </li>


                <c:if test="${permission.orders != 0}" >
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">营销管理</a>
                    <dl class="layui-nav-child">
                        <c:if test="${permission.orders==2}"><dd><a href="https://www.baidu.com">员工操作</a></dd></c:if>
                        <c:if test="${permission.orders==1}"><dd><a href="https://www.baidu.com">主管操作</a></dd></c:if>
                        <dd><a href="/addcompany">增加货源</a></dd>
                        <dd><a href="/addorder">新增订单</a></dd>
                        <dd><a href="/orderlist">订单列表</a></dd>
                        <dd><a href="/onroad">在途订单</a></dd>
                    </dl>
                </li>
                </c:if>
                <c:if test="${permission.plan != 0}" >
                <li class="layui-nav-item">
                    <a href="javascript:;">运力管理</a>
                    <dl class="layui-nav-child">
                        <c:if test="${permission.plan == 2}" ><dd><a href="https://www.baidu.com">员工操作</a></dd></c:if>
                        <c:if test="${permission.plan==1}" ><dd><a href="javascript:;">主管操作</a></dd></c:if>
                        <dd><a href="/addcar">增加运力</a></dd>
                        <dd><a href="/replacecar">修改运力</a></dd>
                        <dd><a href="/carlist">运力列表</a></dd>
                        <dd><a href="/managelist">运力安排</a></dd>
                    </dl>
                </li>
                </c:if>
                <c:if test="${permission.warehouse != 0}" >
                    <li class="layui-nav-item">
                        <a href="javascript:;">仓库管理</a>
                        <dl class="layui-nav-child">
                            <c:if test="${permission.warehouse == 2}" ><dd><a href="https://www.baidu.com">员工操作</a></dd></c:if>
                            <c:if test="${permission.warehouse==1}" ><dd><a href="javascript:;">主管操作</a></dd></c:if>
                            <dd><a href="/addwarehouse">增加仓库</a></dd>
                            <dd><a href="/addwarehouseunit">增加库位</a></dd>
                            <dd><a href="/warehouselist">仓库列表</a></dd>
                        </dl>
                    </li>
                </c:if>
                <c:if test="${permission.affairs != 0}" >
				<li class="layui-nav-item">
                    <a href="javascript:;">财务管理</a>
                    <dl class="layui-nav-child">
                        <c:if test="${permission.affairs == 2}" ><dd><a href="https://www.baidu.com">员工操作</a></dd></c:if>
                        <c:if test="${permission.affairs==1}" ><dd><a href="javascript:;">主管操作</a></dd></c:if>
                    </dl>
                </li>
                </c:if>
            </ul>
        </div>
    </div>
    <div class="layui-body">