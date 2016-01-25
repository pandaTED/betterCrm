/**
 * 新增客户页面jquery-validate表单验证js
 */
    $().ready(function() {
		$("#saveCustomerForm").validate({
			rules : {
				name: {
					required : true,
					minlength : 2
				},
				status: {
					required : true,
					minlength : 2
				},
				cellphone: {
					required : true,
					minlength : 11
				}	
			}
		});
	});