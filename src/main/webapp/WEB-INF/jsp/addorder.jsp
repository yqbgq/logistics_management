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
        <legend>新建订单</legend>
    </fieldset>

    <form class="layui-form" action="/addcarcheck" method="post">

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">委托单位</label>
                <div class="layui-input-inline">
                    <select name="company" lay-verify="required" lay-search="">
                        <option value="0"> </option>
                        <option value="1">甲</option>
                        <option value="2">乙</option>
                        <option value="3">丙</option>
                        <option value="4">丁</option>
                    </select>
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">起始站点</label>
                <div class="layui-input-inline">
                    <input type="text" name="start" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">目的站点</label>
                <div class="layui-input-inline">
                    <input type="text" name="end" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>

        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">货物类型</label>
                <div class="layui-input-inline">
                    <input type="text" name="type" lay-verify="required" autocomplete="off" class="layui-input" readonly>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">货物体积</label>
                <div class="layui-input-inline">
                    <input type="text" name="volume" lay-verify="required" autocomplete="off" class="layui-input" readonly>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">货物重量</label>
                <div class="layui-input-inline">
                    <input type="text" name="weight" lay-verify="required" autocomplete="off" class="layui-input" readonly>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">截止日期</label>
                <div class="layui-input-inline">
                    <input type="text" name="endtime" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input" readonly>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">计重方式</label>
                <div class="layui-input-inline">
                    <select name="method" lay-verify="required" lay-search="">
                        <option value="0"> </option>
                        <option value="1">甲</option>
                        <option value="2">乙</option>
                        <option value="3">丙</option>
                        <option value="4">丁</option>
                    </select>
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">单价</label>
                <div class="layui-input-inline">
                    <input type="text" name="price" lay-verify="required" autocomplete="off" class="layui-input" readonly>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">额外描述</label>
                <div class="layui-input-inline">
                    <input type="text" name="tags" lay-verify="required" autocomplete="off" class="layui-input" readonly>
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


<script src="./layui/layui.js" charset="utf-8"></script>
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

<%@include file="rear.jsp"%>