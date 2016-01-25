/**
 * 注册页面jquery-validate表单验证js
 */
   	$().ready(function() {
		$("#registerForm").validate({
			rules : {
				loginName : {
					required : true,
					minlength : 4
				},
				password : {
					required : true,
					minlength : 6
				},
				name : {
					required : true,
					minlength : 2
				},
				email : {
					required : true,
					email : true
				},
			}
		});
	});