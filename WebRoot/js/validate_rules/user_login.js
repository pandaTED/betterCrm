/**
 * 登录页面jquery-validate表单验证js
 */
  $().ready(function() {
		$("#loginForm").validate({
			rules : {
				loginName : {
					required : true,
					minlength : 4
				},
				password : {
					required : true,
					minlength : 6
				}
			}
		});
	});