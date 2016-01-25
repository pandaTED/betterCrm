/**
 * 登录名查重
 */

var xmlhttp;
        function hadLoginName(loginName){
        	//1.创建XMLHttpRequest对象
            xmlhttp = new XMLHttpRequest();
            //2.XMLHttpRequest打开连接
          	xmlhttp.open("GET","userAction_register_loginNameCheck.do?Lname="+loginName,true);
          	//3.设置回调函数
          	xmlhttp.onreadystatechange = callback;
          	//4.send
          	xmlhttp.send(null);
        }
	//5.写callback函数
	function callback(){
		//6.状态改变时
		if(xmlhttp.readyState == 4){
		//7.状态码为200时
			if(xmlhttp.status == 200){
			//8.获取responseText
				var message = xmlhttp.responseText;
				//9.获取要覆盖的元素
            	var span = document.getElementById("loginNameExist");
            	//10.修改元素的输出
            	span.innerHTML = message;
			}
		}
	}