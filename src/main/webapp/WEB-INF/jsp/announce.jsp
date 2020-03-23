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
        <legend>发布通知</legend>
    </fieldset>

    <form class="layui-form" action="/submitannounce">


        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">所属部门</label>
                <div class="layui-input-inline">
                    <select name="department" lay-verify="required" lay-search="">
                        <option value="0"> </option>
                        <c:if test="${permission.getUsers()==1}" ><option value="1">人事部</option></c:if>
                        <c:if test="${permission.getOrders()==1}" ><option value="2">营销部</option></c:if>
                        <c:if test="${permission.getPlan()==1}" ><option value="3">计划部</option></c:if>
                        <c:if test="${permission.getAffairs()==1}" ><option value="4">财务部</option></c:if>
                        <c:if test="${permission.getWarehouse()==1}" ><option value="5">仓管部</option></c:if>
                    </select>
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">截止日期</label>
                <div class="layui-input-inline">
                    <input type="text" name="date" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>


        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">附加文本</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入内容，最大长度为300字" class="layui-textarea" name = "addition"></textarea>
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
</div>
<script src="./layui/layui.js" charset="utf-8"></script>
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