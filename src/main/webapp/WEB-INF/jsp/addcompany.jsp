<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/10
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>

<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="front.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fieldset style="width:80%;margin-left:10%;margin-top:5%">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>录入货主公司</legend>
    </fieldset>

<form class="layui-form" action="/addcompanycheck" method="post">

    <div class="layui-form-item">
        <label class="layui-form-label">公司名称</label>
        <div class="layui-input-block" style="width:50%">
            <input type="text" name="name"  autocomplete="off" placeholder="请输入标题" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">联系人</label>
        <div class="layui-input-block" style="width:50%">
            <input type="text" name="person"  autocomplete="off" placeholder="请输入标题" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">验证手机</label>
            <div class="layui-input-inline">
                <input type="tel" name="phone"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">验证邮箱</label>
            <div class="layui-input-inline">
                <input type="text" name="email"  autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">联系地址</label>
        <div class="layui-input-block" style="width:50%">
            <input type="text" name="address"  autocomplete="off" placeholder="请输入标题" class="layui-input">
        </div>
    </div>


    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">描述信息</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入内容，最大长度为300字" class="layui-textarea" name = "description"></textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>


</fieldset>
<script src="./layui/layui.all.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;
    });
</script>
<div class="layui-footer">
    <!-- 底部固定区域 -->
    鸣谢：LayUI
</div>
</body>
</html>