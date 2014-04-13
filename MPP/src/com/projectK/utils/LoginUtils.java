package com.projectK.utils;
//package com.aliyun.mpp.utils;
//
//import java.util.Map;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.BeanUtils;
//
//import com.aliyun.mpp.bean.UserBean;
//import com.aliyun.mpp.entity.UserEntity;
//
//public class LoginUtils {
//	public static void setLoginState(HttpSession session, UserBean userBean)
//	{
//		session.removeAttribute("user");
//		
//		session.setAttribute("user", userBean);
//	}
//	
//	@SuppressWarnings("unchecked")
//	public static void setLoginState(Map session, UserBean user)
//	{
//		session.remove("user");
//		
//		UserBean bean = new UserBean();
//		BeanUtils.copyProperties(user, bean);
//		
//		session.put("user", bean);
//	}
//	
//	public static void resetLoginState(Map session)
//	{
//		session.remove("user");
//		session.remove("AccessMap");
//		session.remove("LastAccessedUrl");
//	}
//}
