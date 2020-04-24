<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="front.jsp"%>

<div style="width:95%;margin:20px;">

    <c:if test="${permission.orders==1 || permission.orders==2}">
    <div class="layui-col-sm6 layui-col-md2">
        <div class="layui-card">
            <div class="layui-card-header">
                订单量
                <span class="layui-badge layui-bg-blue layuiadmin-badge" style="float:right;margin-top:10px;">月</span>
            </div>
            <div class="layui-card-body layuiadmin-card-list">
                <p class="layuiadmin-big-font" style="font-size: 36px;color: #666;line-height: 36px;padding: 5px 0 10px;overflow: hidden;text-overflow: ellipsis;word-break: break-all;white-space: nowrap;">${monthNum}</p>
                <p>
                    总计订单量
                    <span class="layuiadmin-span-color" style="color: #666;float:right;">
							${totalOrder}
							<i class="layui-inline layui-icon layui-icon-flag" style="margin-left:10px;"></i>
						</span>
                </p>
            </div>
        </div>
    </div>
    </c:if>
    <c:if test="${permission.warehouse==1 || permission.warehouse==2}">
    <div class="layui-col-sm6 layui-col-md2" style="margin-left:20px;">
        <div class="layui-card">
            <div class="layui-card-header">
                仓储体积
                <span class="layui-badge layui-bg-blue layuiadmin-badge" style="float:right;margin-top:10px;">方</span>
            </div>
            <div class="layui-card-body layuiadmin-card-list">
                <p class="layuiadmin-big-font" style="font-size: 36px;color: #666;line-height: 36px;padding: 5px 0 10px;overflow: hidden;text-overflow: ellipsis;word-break: break-all;white-space: nowrap;">${capacity}</p>
                <p>
                    已用仓储体积
                    <span class="layuiadmin-span-color" style="color: #666;float:right;">
							${capacity - size}
							<i class="layui-inline layui-icon layui-icon-component" style="margin-left:10px;"></i>
						</span>
                </p>
            </div>
        </div>
    </div>
    </c:if>
    <c:if test="${permission.plan==1 || permission.plan==2}">
    <div class="layui-col-sm6 layui-col-md2" style="margin-left:20px;">
        <div class="layui-card">
            <div class="layui-card-header">
                车辆总数
                <span class="layui-badge layui-bg-blue layuiadmin-badge" style="float:right;margin-top:10px;">辆</span>
            </div>
            <div class="layui-card-body layuiadmin-card-list">
                <p class="layuiadmin-big-font" style="font-size: 36px;color: #666;line-height: 36px;padding: 5px 0 10px;overflow: hidden;text-overflow: ellipsis;word-break: break-all;white-space: nowrap;">${carNum}</p>
                <p>
                    在途车辆数目
                    <span class="layuiadmin-span-color" style="color: #666;float:right;">
							${carNumInRoad}
							<i class="layui-inline layui-icon layui-icon-location" style="margin-left:10px;"></i>
						</span>
                </p>
            </div>
        </div>
    </div>
    </c:if>
    <c:if test="${permission.affairs==1 || permission.affairs==2}">
    <div class="layui-col-sm6 layui-col-md2" style="margin-left:20px;">
        <div class="layui-card">
            <div class="layui-card-header">
                收款
                <span class="layui-badge layui-bg-blue layuiadmin-badge" style="float:right;margin-top:10px;">月</span>
            </div>
            <div class="layui-card-body layuiadmin-card-list">
                <p class="layuiadmin-big-font" style="font-size: 36px;color: #666;line-height: 36px;padding: 5px 0 10px;overflow: hidden;text-overflow: ellipsis;word-break: break-all;white-space: nowrap;">${moneyMonth}</p>
                <p>
                    总计收款
                    <span class="layuiadmin-span-color" style="color: #666;float:right;">
							${money}
							<i class="layui-inline layui-icon layui-icon-rmb" style="margin-left:10px;"></i>
						</span>
                </p>
            </div>
        </div>
    </div>
    </c:if>
    <c:if test="${permission.orders==1 || permission.orders==2}">
    <div class="layui-col-sm6 layui-col-md2" style="margin-left:20px;">
        <div class="layui-card">
            <div class="layui-card-header">
                货源公司
                <span class="layui-badge layui-bg-blue layuiadmin-badge" style="float:right;margin-top:10px;">家</span>
            </div>
            <div class="layui-card-body layuiadmin-card-list">
                <p class="layuiadmin-big-font" style="font-size: 36px;color: #666;line-height: 36px;padding: 5px 0 10px;overflow: hidden;text-overflow: ellipsis;word-break: break-all;white-space: nowrap;">${companies}</p>
                <p>
                    总计货源公司
                    <span class="layuiadmin-span-color" style="color: #666;float:right;">
							${companies}
							<i class="layui-inline layui-icon layui-icon-note" style="margin-left:10px;"></i>
						</span>
                </p>
            </div>
        </div>
    </div>
    </c:if>
    <c:if test="${permission.orders==1 || permission.orders==2}">
    <div class="layui-col-sm6 layui-col-md11" style="margin-top:20px;">
        <div class="layui-card">
            <div class="layui-card-header">
                订单详情
            </div>
            <div class="layui-card-body layuiadmin-card-list" style="height:400px">
                <div id="main" style="width: 700px;height:400px;float:left"></div>
                <div id="company" style="width: 400px;height:400px;float:left"></div>
            </div>
        </div>
    </div>
    </c:if>
    <c:if test="${permission.affairs==1 || permission.affairs==2}">
    <div class="layui-col-sm6 layui-col-md11" style="margin-top:20px;">
        <div class="layui-card">
            <div class="layui-card-header">
                收款详情
            </div>
            <div class="layui-card-body layuiadmin-card-list" style="height:400px">
                <div id="moneynum" style="width: 700px;height:400px;float:left"></div>
                <div id="moneycount" style="width: 400px;height:400px;float:left"></div>
            </div>
        </div>
    </div>
    </c:if>


    <div class="layui-card layui-col-sm6 layui-col-md6" style="margin-top:20px;">
        <div class="layui-card-header">待办列表</div>
        <div class="layui-card-body">
            <dl class="layuiadmin-card-status">
                <c:forEach var="item" items="${todolist}" varStatus="status">
                <dd style="border-bottom: 1px solid rgb(238, 238, 238);margin-bottom:10px;">
                    <div style="width: 32px;height: 32px;margin-right: 15px;border-radius: 50%;float:left;">
                        <i class="layui-inline layui-icon layui-icon-username" style="margin-left:10px;font-size:20px;"></i>
                    </div>
                    <div >
                        <p style="font-size:15px;">${item.content}</p>
                        <span style="font-size:15px;">截止日期： ${item.time}</span>
                    </div>
                </dd>
                </c:forEach>
            </dl>
        </div>
    </div>

    <div class="layui-card layui-col-sm6 layui-col-md5" style="margin-top:20px;margin-left:20px;">
        <div class="layui-card-header">通知</div>
        <div class="layui-card-body">

            <c:forEach var="item" items="${notices}" varStatus="status">
            <ul class="layuiadmin-card-status layuiadmin-home2-usernote">
                <li style="border-bottom: 1px solid rgb(238, 238, 238);margin-bottom:10px;">
                    <h3 style="padding-bottom: 5px;font-weight: 700;-webkit-tap-highlight-color: rgba(0, 0, 0, 0);margin: 0px;padding: 0px;display: block;font-size: 1.17em;margin-block-start: 1em;margin-block-end: 1em;margin-inline-start: 0px;margin-inline-end: 0px;font-weight: bold;">
                        来自 ${item.departmentName} 的由 ${item.fromuser} 发布的通知
                    </h3>
                    <p>${item.content}</p>
                    <span>${item.time}</span>
                </li>
            </ul>
            </c:forEach>
            <c:forEach var="item" items="${messages}" varStatus="status">
            <ul class="layuiadmin-card-status layuiadmin-home2-usernote">
                <li style="border-bottom: 1px solid rgb(238, 238, 238);margin-bottom:10px;">
                    <h3 style="padding-bottom: 5px;font-weight: 700;-webkit-tap-highlight-color: rgba(0, 0, 0, 0);margin: 0px;padding: 0px;display: block;font-size: 1.17em;margin-block-start: 1em;margin-block-end: 1em;margin-inline-start: 0px;margin-inline-end: 0px;font-weight: bold;">
                        来自 ${item.fromuser} 的用户信息
                    </h3>
                    <p>${item.message}</p>
                    <span>信息ID：${item.id}</span>
                </li>

            </ul>
            </c:forEach>
        </div>



    </div>

</div>




<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    <c:if test="${permission.orders==1 || permission.orders==2}">
    var myChart = echarts.init(document.getElementById('main'));
    var company = echarts.init(document.getElementById('company'));
    </c:if>
    <c:if test="${permission.affairs==1 || permission.affairs==2}">
    var moneynum = echarts.init(document.getElementById('moneynum'));
    var moneycount = echarts.init(document.getElementById('moneycount'));
    </c:if>
    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '最近7天订单数'
        },
        xAxis: {
            type: 'category',
            data: ['${sevenDay.get(6)}', '${sevenDay.get(5)}', '${sevenDay.get(4)}',
                '${sevenDay.get(3)}', '${sevenDay.get(2)}', '${sevenDay.get(1)}', '${sevenDay.get(0)}']
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [${sevenDayOrderNum.get(6)}, ${sevenDayOrderNum.get(5)}, ${sevenDayOrderNum.get(4)},
                ${sevenDayOrderNum.get(3)}, ${sevenDayOrderNum.get(2)}, ${sevenDayOrderNum.get(1)},
                ${sevenDayOrderNum.get(0)}],
            type: 'line'
        }]
    };
    var companies = {
        title: {
            text: '订单来源'
        },
        series : [
            {
                name: '访问来源',
                type: 'pie',
                radius: '55%',
                data:[
                    ${pieData}
                ]
            }
        ]
    };
    var optionMoneyNum = {
        title: {
            text: '近7日收款'
        },
        xAxis: {
            type: 'category',
            data: ['${sevenDay.get(6)}', '${sevenDay.get(5)}', '${sevenDay.get(4)}',
                '${sevenDay.get(3)}', '${sevenDay.get(2)}', '${sevenDay.get(1)}', '${sevenDay.get(0)}']
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [${sevenDayPayNum.get(6)}, ${sevenDayPayNum.get(5)}, ${sevenDayPayNum.get(4)},
                ${sevenDayPayNum.get(3)}, ${sevenDayPayNum.get(2)}, ${sevenDayPayNum.get(1)},
                ${sevenDayPayNum.get(0)}],
            type: 'line'
        }]

    };
    var optionMoneyCount = {
        title: {
            text: '近7天收款数量'
        },
        xAxis: {
            type: 'category',
            data: ['${sevenDay.get(6)}', '${sevenDay.get(5)}', '${sevenDay.get(4)}',
                '${sevenDay.get(3)}', '${sevenDay.get(2)}', '${sevenDay.get(1)}', '${sevenDay.get(0)}']
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [${sevenDayBillNum.get(6)}, ${sevenDayBillNum.get(5)}, ${sevenDayBillNum.get(4)},
                ${sevenDayBillNum.get(3)}, ${sevenDayBillNum.get(2)}, ${sevenDayBillNum.get(1)},
                ${sevenDayBillNum.get(0)}],
            type: 'bar',
            showBackground: true,
            backgroundStyle: {
                color: 'rgba(220, 220, 220, 0.8)'
            }
        }]
    };
    // 使用刚指定的配置项和数据显示图表。
    <c:if test="${permission.orders==1 || permission.orders==2}">
    myChart.setOption(option);
    company.setOption(companies);
    </c:if>
    <c:if test="${permission.affairs==1 || permission.affairs==2}">
    moneycount.setOption(optionMoneyCount);
    moneynum.setOption(optionMoneyNum);
    </c:if>
</script>






<script src="./layui/layui.all.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script src="./layui/jquery.js" charset="utf-8"></script>
<script>
    layui.config({
        base: '../layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use('index');
</script>


<div class="layui-footer">
    <!-- 底部固定区域 -->
    鸣谢：LayUI
</div>
</div>

</body>
</html>
