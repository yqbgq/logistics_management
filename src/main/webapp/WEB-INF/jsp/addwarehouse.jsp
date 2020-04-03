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


<div style="margin:auto;width:80%;">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>新增仓库</legend>
    </fieldset>

    <form class="layui-form" action="/addwarehousecheck" method="post">

        <div class="layui-form-item">
            <div class="layui-inline" >
                <label class="layui-form-label">仓库名</label>
                <div class="layui-input-inline">
                    <input type="text" name="name" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline" >
                <label class="layui-form-label">仓库地址</label>
                <div class="layui-input-inline">
                    <input type="text" name="pos" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>

    </form>

</div>
<script src="./layui/layui.all.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;
        //日期
    });
</script>

<div class="layui-footer">
    <!-- 底部固定区域 -->
    鸣谢：LayUI
</div>
</div>

</body>
</html>
