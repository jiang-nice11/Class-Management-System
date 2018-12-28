package cnFilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ChineseFilter implements Filter{
	private FilterConfig fc;
	private String encodingName;
	private boolean enable;

	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if(enable==true){
			//对request和response进行编码转换
			request.setCharacterEncoding(encodingName);
			response.setCharacterEncoding(encodingName);
		}
		chain.doFilter(request, response);
		
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//获取配置文件对象
		this.fc=filterConfig;
		//获取配置文件中的参数值
		encodingName = fc.getInitParameter("encoding");
		enable = Boolean.valueOf(fc.getInitParameter("enable"));	
	}

}
