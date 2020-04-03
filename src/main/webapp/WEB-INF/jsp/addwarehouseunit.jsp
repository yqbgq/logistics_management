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
        <legend>新增库位</legend>
    </fieldset>

    <form class="layui-form" action="/addwarehouseunitcheck" method="post">

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">仓库列表</label>
                <div class="layui-input-inline">
                    <select name="warehouse" lay-verify="required" lay-search="">
                        <option value="0"> </option>
                        <c:forEach var="item" items="${warehouses}" varStatus="status">
                        <option value="${item.id}">${item.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">库位名</label>
            <div class="layui-input-block" style="width:50%">
                <input type="text" name="name" placeholder="请输入库位名" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">总容量(方)</label>
            <div class="layui-input-block" style="width:50%">
                <input type="text" name="size" placeholder="请输入库位容量" class="layui-input">
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
