<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="front.jsp"%>

<div class="layui-row">
    <div class="layui-col-xs3" style="margin:20px;">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>个人信息</legend>
        </fieldset>
        <div style="padding: 20px; background-color: #F2F2F2;">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md6">
                    <div class="layui-card">
                        <div class="layui-card-header">个人资料</div>
                        <div class="layui-card-body">
                            用户名：${user.getName()}<br><br>
                            ${user.getDepartment()} - ${user.getJob()}
                        </div>
                    </div>
                </div>
                <div class="layui-col-md6">
                    <div class="layui-card">
                        <div class="layui-card-header">联系方式</div>
                        <div class="layui-card-body">
                            ${user.getPhone()}<br><br>
                            ${user.getEmail()}
                        </div>
                    </div>
                </div>
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">上次登录时间</div>
                        <div class="layui-card-body">
                            ${lastTime}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="layui-col-xs6" style="margin:20px;">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>修改信息</legend>
        </fieldset>

        <form class="layui-form" action="/resubmit">

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">员工姓名</label>
                    <div class="layui-input-inline">
                        <input type="text" name="name" lay-verify="required" autocomplete="off" class="layui-input" value=${user.getName()}>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">联系电话</label>
                    <div class="layui-input-inline">
                        <input type="text" name="phone" lay-verify="required" autocomplete="off" class="layui-input" value=${user.getPhone()}>
                    </div>
                </div>
            </div>


            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">邮箱</label>
                    <div class="layui-input-inline">
                        <input type="text" name="email" lay-verify="required" autocomplete="off" class="layui-input" value=${user.getEmail()}>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">隶属部门</label>
                    <div class="layui-input-inline">
                        <input type="text" name="department" lay-verify="required" autocomplete="off" class="layui-input" value=${user.getDepartment()} readonly>
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">岗位</label>
                    <div class="layui-input-inline">
                        <input type="text" name="job" lay-verify="required" autocomplete="off" class="layui-input" value=${user.getJob()} readonly>
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">用户密码</label>
                    <div class="layui-input-inline">
                        <input type="password" name="pw1" lay-verify="required" autocomplete="off" class="layui-input"value=${user.getPassword()}>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">确认密码</label>
                    <div class="layui-input-inline">
                        <input type="password" name="pw2" lay-verify="required" autocomplete="off" class="layui-input" value=${user.getPassword()}>
                    </div>
                </div>
            </div>

            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">附加文本</label>
                <div class="layui-input-block">
                    <textarea placeholder="请输入内容" class="layui-textarea" name = "addition" value=${user.getAddition()}></textarea>
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


</div>


<script src="./layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;
    });
</script>

<%@include file="rear.jsp"%>