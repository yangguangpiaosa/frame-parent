package com.ibm.dst.frame.ssm.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.dst.frame.ssm.common.constants.Constants;

public class RequestFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
	    FilterChain chain) throws IOException, ServletException {
    	
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		//HttpSession session = req.getSession(false);
		
		String ip = req.getHeader("x-forwarded-for");
		if(null == ip || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		    ip = req.getHeader("Proxy-Client-IP");
		}
		if(null == ip || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		    ip = req.getHeader("WL-Proxy-Client-IP");
		}
		if(null == ip || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		    ip = req.getRemoteAddr();
		}
		
		//强制浏览器不缓存页面
		res.setContentType("text/html;charset=utf-8");
	    res.setCharacterEncoding("utf-8");
	    res.setDateHeader("Expires",0);
		res.setHeader("Cache-Control","no-cache");
		res.setHeader("Cache-Control","no-store");
		res.setHeader("Pragma","no-cache");
		res.setDateHeader ("Expires", -1);
		
		System.out.println("Hello,filter is coming...");
		System.out.println("You can deal with invalid url, character seeting, invalid characters, or user log in...");
		
		if(Constants.DEFAULT_CONTEXT_PATH.equals(uri)
			||(Constants.DEFAULT_CONTEXT_PATH+"/").equals(uri)
			||(uri.startsWith("/page/common") && uri.endsWith(".jsp"))
			||(uri.startsWith("/page/common") && uri.endsWith(".html"))
			||uri.endsWith(".js")
			||uri.endsWith(".css")
			||uri.endsWith(".gif")
			||uri.endsWith(".jpg")) {
		    chain.doFilter(req, res);
		    //return;
		}
		//验证登录
		/*if(session != null) {
		    if(session.getAttribute(Constants.SESSION_USER_ID) != null) {
				String regex = ".+((\\%3[cC])|<).+((\\%3[eE])|>).*"; //拦截非法URL请求 
				if( Pattern.matches(regex, uri)){
					Constants.LOGGER.info("非法请求IP："+ip);
					Constants.LOGGER.info("非法请求路径："+uri);
				    res.sendRedirect(Constants.DEFAULT_CONTEXT_PATH);
				    return;
				} else {
				    //if(new AccessDB().isUriExists(uri)) {
					chain.doFilter(request, response);
					return;
				    //} else {
					//Constants.SLF_INFO_LOGGER.info("非法请求IP："+ip);
					//Constants.SLF_INFO_LOGGER.info("非法请求路径："+uri);
					//session.invalidate();
					//res.sendRedirect("/parsexml");
					//req.setAttribute("message", "非法路径，请确定地址无误！");
					//return;
				    //}
				}
		    } else {
		    	Constants.LOGGER.info("非法请求IP："+ip);
		    	Constants.LOGGER.info("非法请求路径："+uri);
		    	Constants.LOGGER.info("未登录");
				session.invalidate();
				res.sendRedirect(Constants.DEFAULT_CONTEXT_PATH);
				return;
		    }
		} else {
			Constants.LOGGER.info("非法请求IP："+ip);
			Constants.LOGGER.info("非法请求路径："+uri);
			Constants.LOGGER.info("未登录");
		    res.sendRedirect(Constants.DEFAULT_CONTEXT_PATH);
		    return;
		}*/
		chain.doFilter(req, res);
    }

    public void init(FilterConfig arg0) throws ServletException {
    }

}
