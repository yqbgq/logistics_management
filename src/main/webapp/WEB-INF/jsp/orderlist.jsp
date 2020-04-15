<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="front.jsp"%>


<fieldset class="layui-elem-field layui-field-title" style="margin:40px;width:90%">
    <legend>订单列表</legend>
</fieldset>

<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief" style="margin:40px;width:90%">
    <ul class="layui-tab-title">
        <li class="layui-this">等待审核</li>
        <li>未安排运力</li>
        <li>在途订单</li>
        <li>已到达</li>
        <li>已收款</li>
    </ul>
    <div class="layui-tab-content" style="height: 100px;">
        <div class="layui-tab-item layui-show">
            <table class="layui-table" lay-even="" lay-skin="row" style="margin:40px;width:90%">
                <thead>
                <tr>
                    <th style="text-align:center;margin:auto">订单ID</th>
                    <th style="text-align:center;margin:auto">委托方</th>
                    <th style="text-align:center;margin:auto">起始地点</th>
                    <th style="text-align:center;margin:auto">目的地点</th>
                    <th style="text-align:center;margin:auto">货物类型</th>
                    <th style="text-align:center;margin:auto">截止日期</th>
                    <th style="text-align:center;margin:auto">审核订单</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${unpermissioned}" varStatus="status">
                    <tr>
                        <td style="text-align:center;margin:auto">${item.id}</td>
                        <td style="text-align:center;margin:auto">${item.company}</td>
                        <td style="text-align:center;margin:auto">${item.startPos}</td>
                        <td style="text-align:center;margin:auto">${item.endPos}</td>
                        <td style="text-align:center;margin:auto">${item.type}</td>
                        <td style="text-align:center;margin:auto">${item.endDate}</td>
                        <td style="text-align:center;margin:auto">
                            <button type="button" class="layui-btn" onclick="window.location.href = '/ordercheck/${item.id}'">
                                <i class="layui-icon"></i>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="layui-tab-item">
            <table class="layui-table" lay-even="" lay-skin="row" style="margin:40px;width:90%">
                <thead>
                <tr>
                    <th style="text-align:center;margin:auto">订单ID</th>
                    <th style="text-align:center;margin:auto">委托方</th>
                    <th style="text-align:center;margin:auto">起始地点</th>
                    <th style="text-align:center;margin:auto">目的地点</th>
                    <th style="text-align:center;margin:auto">货物类型</th>
                    <th style="text-align:center;margin:auto">截止日期</th>
                    <th style="text-align:center;margin:auto">详细信息</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${unmanaged}" varStatus="status">
                    <tr>
                        <td style="text-align:center;margin:auto">${item.id}</td>
                        <td style="text-align:center;margin:auto">${item.company}</td>
                        <td style="text-align:center;margin:auto">${item.startPos}</td>
                        <td style="text-align:center;margin:auto">${item.endPos}</td>
                        <td style="text-align:center;margin:auto">${item.type}</td>
                        <td style="text-align:center;margin:auto">${item.endDate}</td>
                        <td style="text-align:center;margin:auto">
                            <button type="button" class="layui-btn" onclick="window.location.href = '/orderdetail/${item.id}'">
                                <i class="layui-icon"></i>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="layui-tab-item">
            <table class="layui-table" lay-even="" lay-skin="row" style="margin:40px;width:90%">
                <thead>
                <tr>
                    <th style="text-align:center;margin:auto">订单ID</th>
                    <th style="text-align:center;margin:auto">委托方</th>
                    <th style="text-align:center;margin:auto">起始地点</th>
                    <th style="text-align:center;margin:auto">目的地点</th>
                    <th style="text-align:center;margin:auto">货物类型</th>
                    <th style="text-align:center;margin:auto">截止日期</th>
                    <th style="text-align:center;margin:auto">详细信息</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${managed}" varStatus="status">
                    <tr>
                        <td style="text-align:center;margin:auto">${item.id}</td>
                        <td style="text-align:center;margin:auto">${item.company}</td>
                        <td style="text-align:center;margin:auto">${item.startPos}</td>
                        <td style="text-align:center;margin:auto">${item.endPos}</td>
                        <td style="text-align:center;margin:auto">${item.type}</td>
                        <td style="text-align:center;margin:auto">${item.endDate}</td>
                        <td style="text-align:center;margin:auto">
                            <button type="button" class="layui-btn" onclick="window.location.href = '/orderdetail/${item.id}'">
                                <i class="layui-icon"></i>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="layui-tab-item">
            <table class="layui-table" lay-even="" lay-skin="row" style="margin:40px;width:90%">
                <thead>
                <tr>
                    <th style="text-align:center;margin:auto">订单ID</th>
                    <th style="text-align:center;margin:auto">委托方</th>
                    <th style="text-align:center;margin:auto">起始地点</th>
                    <th style="text-align:center;margin:auto">目的地点</th>
                    <th style="text-align:center;margin:auto">货物类型</th>
                    <th style="text-align:center;margin:auto">截止日期</th>
                    <th style="text-align:center;margin:auto">详细信息</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${arrived}" varStatus="status">
                    <tr>
                        <td style="text-align:center;margin:auto">${item.id}</td>
                        <td style="text-align:center;margin:auto">${item.company}</td>
                        <td style="text-align:center;margin:auto">${item.startPos}</td>
                        <td style="text-align:center;margin:auto">${item.endPos}</td>
                        <td style="text-align:center;margin:auto">${item.type}</td>
                        <td style="text-align:center;margin:auto">${item.endDate}</td>
                        <td style="text-align:center;margin:auto">
                            <button type="button" class="layui-btn" onclick="window.location.href = '/orderdetail/${item.id}'">
                                <i class="layui-icon"></i>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="layui-tab-item">
            <table class="layui-table" lay-even="" lay-skin="row" style="margin:40px;width:90%">
                <thead>
                <tr>
                    <th style="text-align:center;margin:auto">订单ID</th>
                    <th style="text-align:center;margin:auto">委托方</th>
                    <th style="text-align:center;margin:auto">起始地点</th>
                    <th style="text-align:center;margin:auto">目的地点</th>
                    <th style="text-align:center;margin:auto">货物类型</th>
                    <th style="text-align:center;margin:auto">截止日期</th>
                    <th style="text-align:center;margin:auto">详细信息</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${paid}" varStatus="status">
                    <tr>
                        <td style="text-align:center;margin:auto">${item.id}</td>
                        <td style="text-align:center;margin:auto">${item.company}</td>
                        <td style="text-align:center;margin:auto">${item.startPos}</td>
                        <td style="text-align:center;margin:auto">${item.endPos}</td>
                        <td style="text-align:center;margin:auto">${item.type}</td>
                        <td style="text-align:center;margin:auto">${item.endDate}</td>
                        <td style="text-align:center;margin:auto">
                            <button type="button" class="layui-btn" onclick="window.location.href = '/orderdetail/${item.id}'">
                                <i class="layui-icon"></i>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>




<script>
    layui.use('element', function(){
        var $ = layui.jquery
            ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
    });
</script>



<%@include file="rear.jsp"%>