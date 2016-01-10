/**
 * 倒计时
 */
    var start = 5;  
    var step = -1;  
    function count() {  
        document.getElementById("countdown").innerHTML = "页面将在" + start+ "秒后返回";  
        start += step;  
        if (start <= 0) {  
            start = 5;  
            //alert(start);  
            window.location = "customerAction_listCustomer.do";//重定位  
        }  
        setTimeout("count()", 1000);  
    }  
    window.onload = count;  
