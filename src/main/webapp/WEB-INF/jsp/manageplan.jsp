<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="front.jsp"%>

<div style="margin:auto;width:80%;">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>订单详情</legend>
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
                    <input type="text" name="tags" lay-verify="required" autocomplete="off" class="layui-input" style="width:800px;height:200px" value="${order.tags}" readonly>
                </div>
            </div>
        </div>

    </form>

</div>

<div style="margin:auto;width:80%;">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>运力安排</legend>
    </fieldset>

    <table class="layui-table" lay-even="" lay-skin="row" >
        <colgroup>
            <col width="150">
            <col width="150">
            <col width="150">
            <col width="150">
            <col width="200">
            <col>
        </colgroup>
        <thead>
        <tr>
            <th style="text-align:center;margin:auto">车辆编号</th>
            <th style="text-align:center;margin:auto">车辆牌照</th>
            <th style="text-align:center;margin:auto">司机</th>
            <th style="text-align:center;margin:auto">联系电话</th>
            <th style="text-align:center;margin:auto">详细</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${carList}" varStatus="status">
            <tr>
                <td>${item.id}</td>
                <td>${item.number}</td>
                <td>${item.driver}</td>
                <td>${item.phone}</td>
                <td><button type="button" class="layui-btn" onclick="window.location.href = '/cardetail/${item.id}'"><i class="layui-icon">查看详情</i></button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<script src="../layui/layui.all.js" charset="utf-8"></script>
<%@include file="rear.jsp"%>