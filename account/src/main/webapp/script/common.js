/* JavaScript Language */
/*
@filename common.js
@version 1.0
@description 公共部分
@author qianye.zheng
*/

/* 公共变量 */
// 应用程序 上下文名称
var APP_CONTEXT = "account";
var APP_ROOT = "http://127.0.0.1:8080/" + APP_CONTEXT;


/*  */

$(document).ready(
	function()
	{
		  $("#expireDate").datebox({   
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
	}
);

/* 方法 : 补0 */
function addZero(value) {
	if (value < 10) {
		value = "0" + value;
	}
	
	return value;
}


/*  */

/*  */





