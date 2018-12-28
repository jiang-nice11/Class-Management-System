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
			//��request��response���б���ת��
			request.setCharacterEncoding(encodingName);
			response.setCharacterEncoding(encodingName);
		}
		chain.doFilter(request, response);
		
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//��ȡ�����ļ�����
		this.fc=filterConfig;
		//��ȡ�����ļ��еĲ���ֵ
		encodingName = fc.getInitParameter("encoding");
		enable = Boolean.valueOf(fc.getInitParameter("enable"));	
	}

}
