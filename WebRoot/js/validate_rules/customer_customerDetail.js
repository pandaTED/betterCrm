/**
 * 客户详情页面jquery-validate表单验证js
 */
    $().ready(function() {
		$("#addTrackingForm").validate({
			rules : {
				text : {
					required : true,
					minlength : 5,
					maxlength : 255
				}
			}
		});
	});