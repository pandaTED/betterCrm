package cn.panda.bettercrm.interceptor;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class RequestEncoding extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		System.out.println("RequestEncoding执行");
		ActionContext ac = ai.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) ac.get(StrutsStatics.HTTP_REQUEST);
		if(request.getMethod().compareToIgnoreCase("post")>=0){
			try{
				request.setCharacterEncoding("utf-8");	//将post提交的数据编码设为utf-8
			}catch(Exception e){
				throw new RuntimeException("不支持的编码类型");
			}
		}else{
			Iterator it = request.getParameterMap().values().iterator();	
			while(it.hasNext()){
				String [] parames = (String[])it.next();
				for(int i=0;i<parames.length;i++){
					try{
						parames[i] = new String(parames[i].getBytes("iso8859-1"),"utf-8");	//将request里iso8859-1编码的值改为utf-8编码
					}catch(Exception e){
						throw new RuntimeException("不支持的编码类型");
					}
				}	
			}	
		}
		return ai.invoke();
	}
	
}
