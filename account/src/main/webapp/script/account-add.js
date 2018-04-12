/* JavaScript Language */
/*
@filename account-add.js
@version 1.0
@description 新增帐户
@author qianye.zheng
*/


/*  */

/*  */
$(document).ready(
	function()
	{
		 clear();
	}
);

/*  */
function clear()
{
	$("#password").val("");
}

/* 新增帐户 */
function add()
{
	// 提交表单
	document.getElementById("form").submit();
	/*
	 * 若处理成功，服务端设置重定向到列表
	 * 处理失败，服务端返回能否提示给客户端 ?
	 */
}

/* 数据校验 */
function check()
{
	return true;
}



