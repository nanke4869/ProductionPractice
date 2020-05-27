<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>能耗智能监测管理系统</title>
    <link rel="shortcut icon" href="favicon.ico"/>
	<link rel="bookmark" href="favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="easyui/css/default.css" />
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src='easyui/js/outlook2.js'> </script>
    <script type="text/javascript">
	 var _menus = {"menus":[
						{"menuid":"1","icon":"","menuname":"设备管理",
							"menus":[
									{"menuid":"11","menuname":"设备选择","icon":"icon-user-teacher","url":"DeviceServlet?method=toDeviceListView"}
								]
						},
						{"menuid":"2","icon":"","menuname":"能耗监测1",
							"menus":[
									{"menuid":"21","menuname":"实时数据","icon":"icon-exam","url":"RealTimeServlet?method=toRealTimeListView"},
									{"menuid":"22","menuname":"噪声检测","icon":"icon-exam","url":"NoiseServlet?method=toNoiseListView"},
									{"menuid":"23","menuname":"温度监测","icon":"icon-exam","url":"TemperatureServlet?method=toTemperatureListView"},
									{"menuid":"24","menuname":"电压监测","icon":"icon-exam","url":"VoltageServlet?method=toVoltageListView"},
									{"menuid":"25","menuname":"线电压监测","icon":"icon-exam","url":"LineVoltageServlet?method=toLineVoltageListView"},
									{"menuid":"26","menuname":"电流监测","icon":"icon-exam","url":"CurrentServlet?method=toCurrentListView"}
								]
						},
						{"menuid":"3","icon":"","menuname":"能耗监测2",
							"menus":[
									{"menuid":"31","menuname":"有功功率监测","icon":"icon-exam","url":"ActivePowerServlet?method=toActivePowerListView"},
									{"menuid":"32","menuname":"无功功率监测","icon":"icon-exam","url":"ReactivePowerServlet?method=toReactivePowerListView"},
									{"menuid":"33","menuname":"功率因素","icon":"icon-exam","url":"PowerFactorServlet?method=toPowerFactorListView"},
									{"menuid":"34","menuname":"总用电量","icon":"icon-exam","url":"TotalElectConsumpServlet?method=toTotalElectConsumpListView"}
								]
						},
						{"menuid":"4","icon":"","menuname":"定位管理",
							"menus":[
							        {"menuid":"41","menuname":"定位管理","icon":"icon-house","url":"LocationServlet?method=toLocationView"},
								]
						}
				]};


    </script>

</head>
<body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
	<noscript>
		<div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
		    <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
		</div>
	</noscript>
    <div region="north" split="true" border="false" style="overflow: hidden; height: 30px;
        background: url(images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
        <span style="float:right; padding-right:20px;" class="head"><span style="color:red; font-weight:bold;">${user.name}&nbsp;</span>您好&nbsp;&nbsp;&nbsp;<a href="LoginServlet?method=Logout" id="loginOut">安全退出</a></span>
        <span style="padding-left:10px; font-size: 16px; ">能耗智能监测管理系统 </span>
    </div>
    <div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
        <div class="footer">Copyright &nbsp; B16112112 @ 孟影</div>
    </div>
    <div region="west" hide="true" split="true" title="导航菜单" style="width:180px;" id="west">
	<div id="nav" class="easyui-accordion" fit="true" border="false">
		<!--  导航内容 -->
	</div>
	
    </div>
    <div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
        <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
			<jsp:include page="welcome.jsp" />
		</div>
    </div>
	
	<iframe width=0 height=0 src="refresh.jsp"></iframe>
	
</body>
</html>