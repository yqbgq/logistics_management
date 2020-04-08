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
        <legend>车辆登录</legend>
    </fieldset>

    <form class="layui-form" action="/addcarcheck" method="post">

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">车辆牌照</label>
                <div class="layui-input-inline">
                    <input type="text" name="number" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">司机名称</label>
                <div class="layui-input-inline">
                    <input type="text" name="driver" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">联系电话</label>
                <div class="layui-input-inline">
                    <input type="text" name="phone" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">车辆品牌</label>
                <div class="layui-input-inline">
                    <input type="text" name="brand" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">车辆类型</label>
                <div class="layui-input-inline">
                    <input type="text" name="type" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">车辆长度(米)</label>
                <div class="layui-input-inline">
                    <input type="text" name="length" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">容量(立方)</label>
                <div class="layui-input-inline">
                    <input type="text" name="size" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">出厂日期</label>
                <div class="layui-input-inline">
                    <input type="text" name="times" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">当前位置</label>
                <div class="layui-input-inline">
                    <input type="text" name="current" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">车辆标签</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入内容，最大长度为300字" class="layui-textarea" name = "tags"></textarea>
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
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#date1'
        });

    });
</script>

</body>
</html>