<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="front.jsp"%>

<div style="margin:auto;width:80%;">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>审核订单</legend>
    </fieldset>

    <form class="layui-form" action="/orderchecks" method="post">

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">订单编号</label>
                <div class="layui-input-inline">
                    <input type="text" name="id" lay-verify="required" autocomplete="off" class="layui-input"  value="${order.id}"  readonly>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">委托单位</label>
                <div class="layui-input-inline">
                    <input type="text" name="company" lay-verify="required" autocomplete="off" class="layui-input"  value="${order.company}"  readonly>
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">起始站点</label>
                <div class="layui-input-inline">
                    <input type="text" name="start" lay-verify="required" autocomplete="off" class="layui-input" value="${order.startPos}" readonly>
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">目的站点</label>
                <div class="layui-input-inline">
                    <input type="text" name="end" lay-verify="required" autocomplete="off" class="layui-input" value="${order.endPos}" readonly>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">货物类型</label>
                <div class="layui-input-inline">
                    <input type="text" name="type" lay-verify="required" autocomplete="off" class="layui-input" value="${order.type}" readonly>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">总立方</label>
                <div class="layui-input-inline">
                    <input type="text" name="volume" lay-verify="required" autocomplete="off" class="layui-input" value="${order.volume}" readonly>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">重量（吨）</label>
                <div class="layui-input-inline">
                    <input type="text" name="weight" lay-verify="required" autocomplete="off" class="layui-input" value="${order.weight}" readonly>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">下单日期</label>
                <div class="layui-input-inline">
                    <input type="text" name="opendate"  lay-verify="date"  autocomplete="off" class="layui-input" value="${order.openDate}" readonly>
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">截止日期</label>
                <div class="layui-input-inline">
                    <input type="text" name="endtime" lay-verify="date" autocomplete="off" class="layui-input" value="${order.endDate}" readonly>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">计重方式</label>
                <div class="layui-input-inline">
                    <input type="text" name="method" lay-verify="required" autocomplete="off" class="layui-input" value="${method}" readonly>
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">单价</label>
                <div class="layui-input-inline">
                    <input type="text" name="price" lay-verify="required" autocomplete="off" class="layui-input" value="${order.price}" readonly>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">额外描述</label>
                <div class="layui-input-inline">
                    <input type="text" name="tags"  autocomplete="off" class="layui-input" style="width:800px;height:200px" value="${order.tags}" readonly>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label" style="margin-left:40px;">审核通过</label>
            <div class="layui-input-block">
                <input type="checkbox" checked="" name="approve" lay-skin="switch" lay-filter="switchTest" lay-text="是|否">
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

<script src="../layui/layui.all.js" charset="utf-8"></script>
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
