<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/10
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>

<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="front.jsp"%>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>用户管理-用户审核</legend>
</fieldset>

<fieldset class="layui-elem-field">
    <legend>用户信息</legend>
    <div class="layui-field-box">

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">员工姓名</label>
                <label class="layui-form-label">${user.name}</label>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">联系电话</label>
                <label class="layui-form-label">${user.phone}</label>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">联系邮箱</label>
                <label class="layui-form-label">${user.email}</label>
            </div>
        </div>


        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">所属部门</label>
                <label class="layui-form-label">${user.department}</label>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">岗位</label>
                <label class="layui-form-label">${user.job}</label>
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">附加文本</label>
            <div class="layui-input-block">
                <textarea class="layui-textarea" name = "addition" readonly>${user.addition}</textarea>
            </div>
        </div>

    </div>
</fieldset>

<fieldset class="layui-elem-field">
    <legend>用户审批</legend>

    <form class="layui-form" action="/approveuser" method="POST">

        <div class="layui-form-item">
            <label class="layui-form-label" style="margin-left:40px;">开关-默认开</label>
            <div class="layui-input-block">
                <input type="checkbox" checked="" name="approve" lay-skin="switch" lay-filter="switchTest" lay-text="ON|OFF">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label" style="margin-left:40px;">员工ID</label>
                <div class="layui-inline">
                    <div class="layui-input-inline">
                        <input type="text" value="${user.id}" name="id"  autocomplete="off" class="layui-input" readonly>
                    </div>
                </div>
            </div>
        </div>



        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label" style="margin-left:40px;">人事管理</label>
                <div class="layui-input-inline">
                    <select name="users" lay-verify="required" lay-search="">
                        <option value="0" selected>无权限</option>
                        <option value="1">主管权限</option>
                        <option value="2">员工权限</option>
                    </select>
                </div>
            </div>
        </div>


        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label" style="margin-left:40px;">订单管理</label>
                <div class="layui-input-inline">
                    <select name="orders" lay-verify="required" lay-search="">
                        <option value="0" selected>无权限</option>
                        <option value="1">主管权限</option>
                        <option value="2">员工权限</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label" style="margin-left:40px;">仓库管理</label>
                <div class="layui-input-inline">
                    <select name="warehouse" lay-verify="required" lay-search="">
                        <option value="0" selected>无权限</option>
                        <option value="1">主管权限</option>
                        <option value="2">员工权限</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label" style="margin-left:40px;">运力管理</label>
                <div class="layui-input-inline">
                    <select name="plan" lay-verify="required" lay-search="">
                        <option value="0" selected>无权限</option>
                        <option value="1">主管权限</option>
                        <option value="2">员工权限</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label" style="margin-left:40px;">财务管理</label>
                <div class="layui-input-inline">
                    <select name="affairs" lay-verify="required" lay-search="">
                        <option value="0" selected>无权限</option>
                        <option value="1">主管权限</option>
                        <option value="2">员工权限</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">提交</button>
            </div>
        </div>

    </form>

</fieldset>



<script src="./layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['element', 'layer'], function(){
        var element = layui.element;
        var layer = layui.layer;

        //监听折叠
        element.on('collapse(test)', function(data){
            layer.msg('展开状态：'+ data.show);
        });
    });
</script>
<%@include file="rear.jsp"%>