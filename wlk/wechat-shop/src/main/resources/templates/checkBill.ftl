<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    
    <title>账单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <style>
table{background:#000000;width:100%;height:100%;text-align:center;}
table td{background:#FFF;width:120px;} 
#iptable{width:800px;height:500px;}
.bgcolor{background-color:#c5d79b;}
    </style>
</head>
	<body>
		<div id="iptable" style="margin:0 auto">
		<br/>
		<span style="font-weight:bold;">亲爱的${userName!''}客户你好:</span>
		<div style="text-align:center;font-weight:bold;height:30px;line-height:30px;">商户对帐单</div>
			<table  border="0" cellspacing="1" cellpadding="0">
				<tr><td class="bgcolor">商户名称</td><td colspan="6" class="bgcolor">&nbsp;${userName!''}</td></tr>
				<tr><td class="bgcolor">对账信息</td><td class="bgcolor">对账月份</td><td colspan="2" class="bgcolor">${month!''}</td><td colspan="1" class="bgcolor">单位</td><td colspan="2" class="bgcolor">（元）</td></tr>
				<tr><td class="bgcolor">账目信息</td><td class="bgcolor">本月消费金额</td><td class="bgcolor">&nbsp;${consumptionAmount!''}</td><td class="bgcolor">本月充值金额</td><td class="bgcolor">&nbsp;${rechargeAmount!''}</td><td class="bgcolor">账户余额</td><td class="bgcolor">${balance!''}</td></tr>
				<tr><td rowspan="6">对账汇总信息</td><td>主题</td><td>产品名称</td><td>计费数（笔）</td><td>单价</td><td>计费金额</td><td>备注</td></tr>
				<tr><td rowspan="5">企业征信产品</td><td>海豚信用</td><td>${count!''}</td><td>${price!''}</td><td>${consumptionAmount!''}</td><td>&nbsp;</td></tr>
				<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
				<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
				<tr><td>小计</td><td colspan="5" align="right">${consumptionAmount!''}&nbsp;&nbsp;</td></tr>
				<tr><td class="bgcolor">总计</td><td colspan="5" class="bgcolor" align="right">${consumptionAmount!''}&nbsp;&nbsp;</td></tr>
			</table>
		</div>
	</body>
</html>
