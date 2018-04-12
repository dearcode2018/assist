/* JavaScript Language */
/*
@filename account-list.js
@version 1.0
@description 帐户列表
@author qianye.zheng
*/



/*  */

/*  */
// 页面加载
$(document).ready(function() {
	// 加载页面
	readyIndex();
});

// 页面加载调用
function readyIndex() {
	
	
  $("#expireDateBegin").datebox({   
	  required: false,
	  currentText: "今天",
	  closeText: "关闭",
	  okText: "确定",
	  disabled: false,
/*			  formatter: function(date)
		  {
			  var month =date.getMonth() + 1;
			  var day = date.getDate();
			  var result = date.getFullYear() + "-" + (month < 10 ? ("0" + month) : month) + "-" + (day < 10 ? ("0" + day) : day) ;
			  
			  return result;
		  },*/
	  onSelect: function(date)
	  {
		  var month =date.getMonth() + 1;
		  var day = date.getDate();
		  var result = date.getFullYear() + "-" + (month < 10 ? ("0" + month) : month) + "-" + (day < 10 ? ("0" + day) : day) ;
		  
		  return result;
	  },
	  }); 	
  
  $("#expireDateEnd").datebox({   
	  required: false,
	  currentText: "今天",
	  closeText: "关闭",
	  okText: "确定",
	  disabled: false,
/*			  formatter: function(date)
		  {
			  var month =date.getMonth() + 1;
			  var day = date.getDate();
			  var result = date.getFullYear() + "-" + (month < 10 ? ("0" + month) : month) + "-" + (day < 10 ? ("0" + day) : day) ;
			  
			  return result;
		  },*/
	  onSelect: function(date)
	  {
		  var month =date.getMonth() + 1;
		  var day = date.getDate();
		  var result = date.getFullYear() + "-" + (month < 10 ? ("0" + month) : month) + "-" + (day < 10 ? ("0" + day) : day) ;
		  
		  return result;
	  },
	  }); 	
  
  $("#createDateTimeBegin").datebox({   
	  required: false,
	  currentText: "今天",
	  closeText: "关闭",
	  okText: "确定",
	  disabled: false,
/*			  formatter: function(date)
	  {
		  var month =date.getMonth() + 1;
		  var day = date.getDate();
		  var result = date.getFullYear() + "-" + (month < 10 ? ("0" + month) : month) + "-" + (day < 10 ? ("0" + day) : day) ;
		  
		  return result;
	  },*/
	  onSelect: function(date)
	  {
		  var month =date.getMonth() + 1;
		  var day = date.getDate();
		  var result = date.getFullYear() + "-" + (month < 10 ? ("0" + month) : month) + "-" + (day < 10 ? ("0" + day) : day) ;
		  
		  return result;
	  },
	  }); 	
  
  $("#createDateTimeEnd").datebox({   
	  required: false,
	  currentText: "今天",
	  closeText: "关闭",
	  okText: "确定",
	  disabled: false,
/*			  formatter: function(date)
	  {
		  var month =date.getMonth() + 1;
		  var day = date.getDate();
		  var result = date.getFullYear() + "-" + (month < 10 ? ("0" + month) : month) + "-" + (day < 10 ? ("0" + day) : day) ;
		  
		  return result;
	  },*/
	  onSelect: function(date)
	  {
		  var month =date.getMonth() + 1;
		  var day = date.getDate();
		  var result = date.getFullYear() + "-" + (month < 10 ? ("0" + month) : month) + "-" + (day < 10 ? ("0" + day) : day) ;
		  
		  return result;
	  },
	  });
  
  $("#updateDateTimeBegin").datebox({   
	  required: false,
	  currentText: "今天",
	  closeText: "关闭",
	  okText: "确定",
	  disabled: false,
/*			  formatter: function(date)
	  {
		  var month =date.getMonth() + 1;
		  var day = date.getDate();
		  var result = date.getFullYear() + "-" + (month < 10 ? ("0" + month) : month) + "-" + (day < 10 ? ("0" + day) : day) ;
		  
		  return result;
	  },*/
	  onSelect: function(date)
	  {
		  var month =date.getMonth() + 1;
		  var day = date.getDate();
		  var result = date.getFullYear() + "-" + (month < 10 ? ("0" + month) : month) + "-" + (day < 10 ? ("0" + day) : day) ;
		  
		  return result;
	  },
	  }); 	
  
  $("#updateDateTimeEnd").datebox({   
	  required: false,
	  currentText: "今天",
	  closeText: "关闭",
	  okText: "确定",
	  disabled: false,
/*			  formatter: function(date)
	  {
		  var month =date.getMonth() + 1;
		  var day = date.getDate();
		  var result = date.getFullYear() + "-" + (month < 10 ? ("0" + month) : month) + "-" + (day < 10 ? ("0" + day) : day) ;
		  
		  return result;
	  },*/
	  onSelect: function(date)
	  {
		  var month =date.getMonth() + 1;
		  var day = date.getDate();
		  var result = date.getFullYear() + "-" + (month < 10 ? ("0" + month) : month) + "-" + (day < 10 ? ("0" + day) : day) ;
		  
		  return result;
	  },
	  });  
	
	var url = APP_ROOT + "/api/search";
	// 一般列表查询，请求参数据量都比较小，使用get方式
	// get 方式让后台可以通过getParameter方式获取参数
	var method = "GET";
	$("#dataGrid").datagrid({
		url: url,
		method: method,
		loadMsg: "加载中...",
		columns: [[
		           {field: "username", title: "用 户 名", width: 200, align: "center", resizable: false},
		           {field: "password", title: "状 态", width: 50, align: "center", resizable: false},
		           {field: "level", title: "级 别", width: 50, align: "center", resizable: false},
		           {field: "type", title: "类 型", width: 50, align: "center", resizable: false},
		           {field: "source", title: "来 源", width: 100, align: "center", resizable: false},
		           {field: "expireDate", title: "有效期至", width: 100, align: "center", resizable: false},
		           {field: "createDateTime", title: "创建时间", width: 130, align: "center", resizable: false},
		           {field: "updateDateTime", title: "更新时间", width: 130, align: "center", resizable: false}
		           ]],
		// 是否显示分页栏
		pagination: true,
		// 是否单选
		singleSelect: true,
		// 额外请求参数
		queryParams: {},
		// 定义可排序的列
		sortName: null,
		sortOrder: "asc",
		// 是否显示一行页脚
		//showFooter: true,
		// 初始化页面尺寸的选择列表
		pageList: [10,15,20,25,30],
		pageSize: 10,
		// 初始页码
		pageNumber: 1,
	// 自适应列宽，关闭掉自适应宽度，页面展示的宽度不会变化，不管有没有数据
	fitColumns: false,
	displayMsg: "显示第 <b>{from}</b> 条到 <b>{to}</b> 条 总共 <b>{total}</b> 条记录",
	styler: function()
	{
		//return "font-size:250;";
	}
	});
	
	// 获取数据表格的分页对象
	var pager = $("#dataGrid").datagrid("getPager");
	// 分页配置构造
	pager.pagination({
		// 总记录数
		//total: 2450,
		// 页大小
		pageSize: 10,
		// 总页数
		
		// 当前页
		
		// 自定义按钮 - 多个,每个对象 有 iconCls 和 handler 2个属性
		//buttons: [{iconCls: "icon-reload", handler: function() {$.messager.alert("title", "自定义按钮");}}],
		// 创建pagination时显示的页码
		pageNumber: 1,
		// 用户能改变页面尺寸
		pageList: [10,15,20,25,30],
		// 是否数据正在加载
		loading: true,
		// 是否显示刷新按钮
		showRefresh: true,
		// input组件之前显示的文本
		beforePageText: "第",
		// input组件之后显示的文本
		afterPageText: "页 共 {pages} 页",
		// 是否显示页面的列表
		showPageList: true,
		
		// 显示页面信息 (Displaying {from} to {to} of {total} items)
		displayMsg: "显示第 <b>{from}</b> 条到 <b>{to}</b> 条 总共 <b>{total}</b> 条记录"
		});
}

/*  */

/*  */

/*  */




