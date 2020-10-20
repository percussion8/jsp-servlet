package green.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class CharacterEncodingFilter
 */
//@WebFilter("/*")
//@WebFilter ( 필터를 xml 파일에 넣지 않는 경우 
//		{
//			urlPaterns ="/*",
//			initParams = {
//			@WebInitParm(name="encodig", value="utf-8");
//			}
//			
//		}
//		
//		
//		)


public class CharacterEncodingFilter implements Filter {
	FilterConfig config; //멤버변수 
 
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(config.getInitParameter("encoding")); //web.xml에서 가져옴 
		chain.doFilter(request, response);
	}


	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;
	}

}
