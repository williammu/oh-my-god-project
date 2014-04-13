package com.projectK.utils;
//package com.aliyun.mpp.utils;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.regex.Pattern;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.BeanUtils;
//import org.springframework.web.context.support.WebApplicationContextUtils;
//
//import com.aliyun.mpp.bean.UserBean;
//import com.aliyun.mpp.common.AccessPrimitive;
//import com.aliyun.mpp.entity.UserEntity;
//import com.aliyun.mpp.service.UserAuthService;
//
//public class MPPAuthenticationFilter implements Filter {
//	private static Log log = LogFactory.getLog(MPPAuthenticationFilter.class); 
//	private static List<UrlDescriptor> urlACL;
//	private String excludePatterns;
//	
//	static
//	{
//		urlACL = new ArrayList<UrlDescriptor>();
//
//		UrlAclStrategy.initACL(urlACL);
//	}
//
//	@Override
//	public void destroy() {
//		// TODO Auto-generated method stub
//		System.out.print("destory");
//	}
//	
//	 private Object getBean(HttpServletRequest request,String name) {           
//         return WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext()).getBean(name);  
//     } 
//	 
//	 private Object getBean(HttpSession session, String name)
//	 {
//		 return WebApplicationContextUtils.getWebApplicationContext(session.getServletContext()).getBean(name);
//	 }
//	
//	private void fillAccessMap(HttpSession session)
//	{
//		Map<String, String> accessMap = new HashMap<String, String>();
//		UserAuthService userAuthService = (UserAuthService) getBean(session, "userAuthService");
//		
//		UserBean userBean = (UserBean)session.getAttribute("user");
//		
//		boolean b = false;
//		
//		b = userAuthService.grantAccessPrimitive(AccessPrimitive.DELETE_CASE, userBean);
//		accessMap.put(AccessPrimitive.DELETE_CASE.toString(), b ? "true" : "false");
//		
//		b = userAuthService.grantAccessPrimitive(AccessPrimitive.DELETE_MODULE, userBean);
//		accessMap.put(AccessPrimitive.DELETE_MODULE.toString(), b ? "true" : "false");
//		
//		b = userAuthService.grantAccessPrimitive(AccessPrimitive.DELETE_PROJECT, userBean);
//		accessMap.put(AccessPrimitive.DELETE_PROJECT.toString(), b ? "true" : "false");
//		
//		b = userAuthService.grantAccessPrimitive(AccessPrimitive.DELETE_RUN_REC, userBean);
//		accessMap.put(AccessPrimitive.DELETE_RUN_REC.toString(), b ? "true" : "false");
//		
//		b = userAuthService.grantAccessPrimitive(AccessPrimitive.EDIT_CASE, userBean);
//		accessMap.put(AccessPrimitive.EDIT_CASE.toString(), b ? "true" : "false");
//		
//		b = userAuthService.grantAccessPrimitive(AccessPrimitive.EDIT_MODULE, userBean);
//		accessMap.put(AccessPrimitive.EDIT_MODULE.toString(), b ? "true" : "false");
//		
//		b = userAuthService.grantAccessPrimitive(AccessPrimitive.EDIT_PROJECT, userBean);
//		accessMap.put(AccessPrimitive.EDIT_PROJECT.toString(), b ? "true" : "false");
//		
//		b = userAuthService.grantAccessPrimitive(AccessPrimitive.MODIFY_RUN_REC_DATA, userBean);
//		accessMap.put(AccessPrimitive.MODIFY_RUN_REC_DATA.toString(), b ? "true" : "false");
//		
//		b = userAuthService.grantAccessPrimitive(AccessPrimitive.MODIFY_USER, userBean);
//		accessMap.put(AccessPrimitive.MODIFY_USER.toString(), b ? "true" : "false");
//		
//		b = userAuthService.grantAccessPrimitive(AccessPrimitive.RUN_CASE, userBean);
//		accessMap.put(AccessPrimitive.RUN_CASE.toString(), b ? "true" : "false");
//		
//		b = userAuthService.grantAccessPrimitive(AccessPrimitive.ASSIGN_TASK, userBean);
//		accessMap.put(AccessPrimitive.ASSIGN_TASK.toString(), b ? "true" : "false");
//		
//		b = userAuthService.grantAccessPrimitive(AccessPrimitive.CHECK_ASSIGNED_TASK, userBean);
//		accessMap.put(AccessPrimitive.CHECK_ASSIGNED_TASK.toString(), b ? "true" : "false");
//		
//		b = userAuthService.grantAccessPrimitive(AccessPrimitive.EDIT_RUN_REC_META, userBean);
//		accessMap.put(AccessPrimitive.EDIT_RUN_REC_META.toString(), b ? "true" : "false");
//		
//		b = userAuthService.grantAccessPrimitive(AccessPrimitive.CHANGE_HUDSON_CONFIG, userBean);
//		accessMap.put(AccessPrimitive.CHANGE_HUDSON_CONFIG.toString(), b ? "true" : "false");
//		
//		session.setAttribute("AccessMap", accessMap);
//	}
//	
//	private boolean isUserLoggedIn(HttpSession session)
//	{
//		UserBean user = (UserBean) session.getAttribute("user");
//		
//		return user != null;
//	}
//	
//	private boolean canAuthByCookie(HttpServletRequest request)
//	{
//		Cookie[] cookies = request.getCookies();
//		if(cookies == null || cookies.length == 0)
//			return false;
//		
//		String token = CookieUtils.getKeyFromCookies(cookies, "token");
//		if(token == null)
//			return false;
//		
//		UserAuthService userAuthService = (UserAuthService) getBean(request, "userAuthService");
//		UserEntity user = userAuthService.getValidUserByToken(token);
//		if(user == null)
//			return false;
//		
//		return true;
//	}
//	
//	private void autoLoginUser(HttpServletRequest request)
//	{
//		UserAuthService userAuthService = (UserAuthService) getBean(request, "userAuthService");
//		Cookie[] cookies = request.getCookies();
//		String token = CookieUtils.getKeyFromCookies(cookies, "token");
//		UserEntity user = userAuthService.getValidUserByToken(token);
//		UserBean userBean = new UserBean();
//		BeanUtils.copyProperties(user, userBean);
//		LoginUtils.setLoginState(request.getSession(), userBean);
//	}
//	
//	@SuppressWarnings("unchecked")
//	private void initAccessMap(HttpSession session)
//	{
//		Map<String, String> accessMap = (Map<String, String>) session.getAttribute("AccessMap");
//		if(accessMap == null)
//			fillAccessMap(session);
//	}
//
//	
//	private void loginAsGuestUser(HttpSession session)
//	{
//		UserAuthService userAuthService = (UserAuthService) getBean(session, "userAuthService");
//		UserEntity guest = null;
//		try
//		{
//			guest = userAuthService.initGuestUser();
//		}
//		catch(Exception ex)
//		{
//			ex.printStackTrace();
//		}
//		
//		UserBean guestBean = new UserBean();
//		BeanUtils.copyProperties(guest, guestBean);
//		
//		LoginUtils.setLoginState(session, guestBean);
//	}
//	
//	private boolean isCookieConsist(HttpServletRequest httpReq)
//	{
//		Cookie[] cookies = httpReq.getCookies();
//		if(cookies == null || cookies.length == 0)
//			return false;
//		
//		String token = CookieUtils.getKeyFromCookies(cookies, "token");
//		if(token == null)
//			return false;
//		
//		UserBean user = (UserBean) httpReq.getSession().getAttribute("user");
//		if(user.getToken().equals(token))
//			return true;
//		
//		return false;
//	}
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response,
//			FilterChain chain) throws IOException, ServletException {
//
//		HttpServletRequest httpReq = (HttpServletRequest) request;
//		HttpServletResponse httpRes = (HttpServletResponse) response;
//		HttpSession session = httpReq.getSession();
//		
//		
//		if(Pattern.matches(excludePatterns, httpReq.getRequestURL().toString()))
//		{
//			chain.doFilter(request, response);
//			return;
//		}
//		
//		
//		if(!isUserLoggedIn(httpReq.getSession()))
//		{
//			if(canAuthByCookie(httpReq))
//			{
//				autoLoginUser(httpReq);
//				initAccessMap(httpReq.getSession());
//				if(!UrlAclStrategy.checkUrlPrivilege(httpReq, urlACL))
//				{
//					httpRes.setStatus(403);
//					return;
//				}
//				chain.doFilter(request, response);
//				return;
//			}
//			
//			loginAsGuestUser(httpReq.getSession());
//			initAccessMap(httpReq.getSession());
//			if(!UrlAclStrategy.checkUrlPrivilege(httpReq, urlACL))
//			{
//				httpRes.setStatus(403);
//				return;
//			}
//			chain.doFilter(request, response);
//			return;
//		}
//		else
//		{
//			//user login successfully, but cookie is not sent yet, send it now
//			if(!isCookieConsist(httpReq))
//			{
//				UserBean user = (UserBean) httpReq.getSession().getAttribute("user");
//				String token = user.getToken();
//				Date tokenExpireDate = user.getTokenExpireDate();
//				long diffInMillSec = tokenExpireDate.getTime() - new Date().getTime();
//				
//				Cookie tokenCookie = new Cookie("token", token);
//				tokenCookie.setMaxAge((int) (diffInMillSec / 1000));
//				httpRes.addCookie(tokenCookie);
//				initAccessMap(httpReq.getSession());
//			}
//		}
//		
//		
//		if(!UrlAclStrategy.checkUrlPrivilege(httpReq, urlACL))
//		{
//			log.warn("http req:" + httpReq.getRequestURL().toString() + " is REJECTED due to security reasons!");
//			httpRes.setStatus(403);
//			return;
//		}
//		
//		String url = httpReq.getRequestURL().toString();
//		String queryString = httpReq.getQueryString();
//		
//		System.out.println("url:" + url);
//		System.out.println("queryStr:" + queryString);
//
//		chain.doFilter(request, response);
//	}
//
//	@Override
//	public void init(FilterConfig cfg) throws ServletException {
//		// TODO Auto-generated method stub
//
//		this.excludePatterns = cfg.getInitParameter("excludePatterns");
//
//	}
//
//}
