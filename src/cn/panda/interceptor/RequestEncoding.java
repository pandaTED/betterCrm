package cn.panda.interceptor;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class RequestEncoding extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		System.out.println(Messages.getString("RequestEncoding.0")); //$NON-NLS-1$
		ActionContext ac = ai.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) ac.get(StrutsStatics.HTTP_REQUEST);
		if (request.getMethod().compareToIgnoreCase(Messages.getString("RequestEncoding.1")) >= 0) { //$NON-NLS-1$
			try {
				request.setCharacterEncoding(Messages.getString("RequestEncoding.2")); // 将post提交的数据编码设为utf-8 //$NON-NLS-1$
			} catch (Exception e) {
				throw new RuntimeException(Messages.getString("RequestEncoding.3")); //$NON-NLS-1$
			}
		} else {
			Iterator it = request.getParameterMap().values().iterator();
			while (it.hasNext()) {
				String[] parames = (String[]) it.next();
				for (int i = 0; i < parames.length; i++) {
					try {
						parames[i] = new String(parames[i].getBytes(Messages.getString("RequestEncoding.4")), Messages.getString("RequestEncoding.5")); // 将request里iso8859-1编码的值改为utf-8编码 //$NON-NLS-1$ //$NON-NLS-2$
					} catch (Exception e) {
						throw new RuntimeException(Messages.getString("RequestEncoding.6")); //$NON-NLS-1$
					}
				}
			}
		}
		return ai.invoke();
	}

}
