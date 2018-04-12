<!DOCTYPE html>
<html>
  <head>
    <title></title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
	  <style type="text/css">
		.middle-layout {
			width: 1500px;
			height: 900px; 
			top: 50%;
			left: 50%;
			margin: 0 auto;
			border: 0px solid;
			background-color: #FCFCFC;
		}
		
		.datalist {
			border: 1px solid #0058a3; /* 表格边框 */
			font-family: Arial;
			border-collapse: collapse; /* 边框重叠 */
			background-color: #FCFCFC; /* 表格背景色 */
			font-size: 14px;
		}
		
		.datalist caption {
			padding-bottom: 5px;
			font: bold 1.4em;
			text-align: left;
		}
		
		.datalist th {
			border: 1px solid #0058a3; /* 行名称边框 */
			background-color: #4bacff; /* 行名称背景色 */
			color: #FFFFFF; /* 行名称颜色 */
			font-weight: bold;
			padding-top: 4px;
			padding-bottom: 4px;
			padding-left: 12px;
			padding-right: 12px;
			text-align: center;
		}
		
		.datalist td {
			border: 1px solid #0058a3; /* 单元格边框 */
			text-align: center;
			padding-top: 4px;
			padding-bottom: 4px;
			padding-left: 10px;
			padding-right: 10px;
		}
		
		.datalist tr.altrow {
			background-color: #c7e5ff; /* 隔行变色 */
		}
	
		.idCls
		{
			width: 20px;
		}		
		
		.username {
			width: 100px;
		}
		
		.password {
			width: 50px;
			color:#FCFCFC;
			background-color: #FCFCFC;
		}
		
		.status {
			width: 20px;
		}
		
		.level {
			width: 20px;
		}
		
		.type {
			width: 50px;
		}
		
		.source {
			width: 100px;
		}
		
		.expireDt {
			width: 50px;
		}
		
		.createDt {
			width: 100px;
		}
		
		.updateDt {
			width: 100px;
		}
		
		.remark {
			width: 100px;
		}
		
		.summary
		{
			float: right;
			margin: 10px;
		}
		
		/* 超链接样式 */
		a
		{
		 	text-decoration: none;
		}
		a:link 
		{
			color: #0000;
		} 
		a:visited 
		{
			color: #0000;
		} 
		a:hover 
		{
			color: #0000;
		} 
		a:active 
		{
			color: #0000;
		}
	</style>
	<script type="text/javascript">
		
		/* 函数 */
		function rowMouseOver(target)
		{
			target.style.backgroundColor = "#c7e5ff";
		}
		
		/* 函数 */
		function rowMouseOut(target)
		{
			target.style.backgroundColor = "#FCFCFC";
		}		
		/*
		  备注限制10个字符，加一个title悬浮提示
		*/
	</script>
  </head>
  
  <body>
    <div style="padding:5px 0;" class="middle-layout">
		<table id="dataGrid" class="datalist" style="width: 1500px;">
			<tr>
				<td>ID</td>			
				<td class="source">来源</td>
				<td class="username">用户名</td>
				<td>密码</td>
				<td class="status">状态</td>
				<td class="level">级别</td>
				<td class="type">类型</td>
				<td class="expireDt">有效期至</td>
				<td class="createDt">创建时间</td>
				<td class="updateDt">更新时间</td>
				<td class="remark">备注</td>												
			</tr>
			<!-- 遍历 -->
			<#list data.records as record>
				<tr onmouseover="rowMouseOver(this);" onmouseout="rowMouseOut(this);">
					<td class="idCls">${record.id}</td>
					<td class="source">
						<#if record.loginLink ?exists>
							<a href="${record.loginLink}" target="_blank">${record.source}</a>
							<#else>${record.source}
						</#if>
					</td>
					<td class="username">${record.username}</td>
					<td class="password">${record.showPassword}</td>
					<td class="status">${record.statusName}</td>
					<td class="level">${record.levelName}</td>
					<td class="type">${record.typeName}</td>
					<td class="expireDt">					
						<#if record.expireDate ?exists>
							${record.expireDate?string("yyyy.MM.dd")}
							<#else>无限
						</#if>
					</td>
					<td class="createDt">${record.createDateTime}</td>
					<td class="updateDt">${record.updateDateTime}</td>				
					<td class="remark" title="${record.remark}">${record.shortRemark}</td>
				</tr>
			</#list>								
		</table>
		<div class="summary">总共 ${data.totalRecord} 条记录，更新日期: ${(data.updateDt?string("yyyy.MM.dd"))}</div>
    </div>
  </body>
  
</html>
