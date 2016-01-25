/**
 * 客户详情页面jquery-validate表单验证js
 */
    $().ready(function() {
		$("#addTrackingForm").validate({
			rules : {
				text : {
					required : true,
					minlength : 10,
					maxlength : 255
				}
			}
		});
	});