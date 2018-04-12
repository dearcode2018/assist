/* JavaScript Language */
/*
@filename account-view.js
@version 1.0
@description 查看帐户
@author qianye.zheng
*/



/*  */

/*  */


/*  */

/*  */

/*  */
// JavaScript Document
$(document).ready(function(e) {
	//$("#slider").powerSlider({handle:"left"});
	/** 构造页面 */
	// 数据字典 url
	var dictUrl = null;
	// 级别 下拉选项
	$.ajax({
		url: dictUrl,
		type: "GET",
		data:{"code":"level"},
		dataType: "json",
		success: function(data, textStatus, jqXHR)
		{
			var beanList = data;
			var select = document.getElementsByName("level")[0];
			var option = null;
			for (i = 0; i < beanList.length; i++)
			{
				option = select.createElement("option");
				option.value = beanList[0].value;
				option.innerHTML = beanList[0].text;
				select.appendChild(option);
			}
		}
	});
	// 类型 下拉选项
	$.ajax({
		url: dictUrl,
		type: "GET",
		data:{"code":"type"},
		dataType: "json",
		success: function(data, textStatus, jqXHR)
		{
			var beanList = data;
			var select = document.getElementsByName("type")[0];
			var option = null;
			for (i = 0; i < beanList.length; i++)
			{
				option = select.createElement("option");
				option.value = beanList[0].value;
				option.innerHTML = beanList[0].text;
				select.appendChild(option);
			}
		}
	});
	/** 加载页面数据 */
	var url = null;
	// 从url中获取参数只
	var id = null;
	$.ajax({
		url: url,
		type: "GET",
		data:{"id":id},
		dataType: "json",
		success: function(data, textStatus, jqXHR)
		{
			var resultBean = data;
			$("input[name='username']").val(resultBean.username);
			// 状态
			if (1 == resultBean.status)
			{
				$("input[name=status''][value='1']").attr("checked", true);
			} else
			{
				$("input[name=status''][value='0']").attr("checked", true);
			}
			$("input[name='password']").val(resultBean.password);
			// 级别
			$("input[name=level''][value='" + resultBean.level + "']").attr("selected", true);
			// 类型
			$("input[name=type''][value='" + resultBean.type + "']").attr("selected", true);
			
			$("input[name='source']").val(resultBean.source);
			$("input[name='usage']").val(resultBean.usage);
			$("input[name='expireDate']").val(resultBean.expireDate);
			$("input[name='relationalAccounts']").val(resultBean.relationalAccounts);
			$("input[name='mobilePhone']").val(resultBean.mobilePhone);
			$("input[name='email']").val(resultBean.email);
			$("input[name='officialLink']").val(resultBean.officialLink);
			$("input[name='loginLink']").val(resultBean.loginLink);
			$("input[name='location']").val(resultBean.location);
			$("input[name='remark']").val(resultBean.remark);
		},
		error: function () {},
	});
	
});




