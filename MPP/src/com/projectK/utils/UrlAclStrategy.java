package com.projectK.utils;
//package com.aliyun.mpp.utils;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.regex.Pattern;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import com.aliyun.mpp.common.AccessPrimitive;
//
//public class UrlAclStrategy {
//	public static void initACL(List<UrlDescriptor> acl)
//	{
//		acl.add(new UrlDescriptor(".*deleteCasesAction.*",
//				AccessPrimitive.DELETE_CASE.toString()));
//		acl.add(new UrlDescriptor(".*addCaseAction.*",
//				AccessPrimitive.EDIT_CASE.toString()));
//		acl.add(new UrlDescriptor(".*deleteCaseGroupsAction.*",
//				AccessPrimitive.DELETE_CASE.toString()));
//		acl.add(new UrlDescriptor(".*renameCaseGroup.*",
//				AccessPrimitive.EDIT_CASE.toString()));
//		acl.add(new UrlDescriptor(".*addCaseGroupAction.*",
//				AccessPrimitive.EDIT_CASE.toString()));
//		acl.add(new UrlDescriptor(".*importCase.*",
//				AccessPrimitive.EDIT_CASE.toString()));
//		acl.add(new UrlDescriptor(".*modUser.*",
//				AccessPrimitive.MODIFY_USER.toString()));
//		acl.add(new UrlDescriptor(".*modPwd.*",
//				AccessPrimitive.MODIFY_USER.toString()));
//		acl.add(new UrlDescriptor(".*userBrowseAction.*",
//				AccessPrimitive.MODIFY_USER.toString()));
//		acl.add(new UrlDescriptor(".*addNewModule.*",
//				AccessPrimitive.EDIT_MODULE.toString()));
//		acl.add(new UrlDescriptor(".*editSelectModule.*",
//				AccessPrimitive.EDIT_MODULE.toString()));
//		acl.add(new UrlDescriptor(".*deleteModule.*",
//				AccessPrimitive.DELETE_MODULE.toString()));
//		acl.add(new UrlDescriptor(".*deleteProject.*",
//				AccessPrimitive.DELETE_PROJECT.toString()));
//		acl.add(new UrlDescriptor(".*editProject.*",
//				AccessPrimitive.EDIT_PROJECT.toString()));
//		acl.add(new UrlDescriptor(".*editHisProject.*",
//				AccessPrimitive.MODIFY_RUN_REC_DATA.toString()));
//		acl.add(new UrlDescriptor(".*edit-project-action.*",
//				AccessPrimitive.EDIT_PROJECT.toString()));
//		acl.add(new UrlDescriptor(".*updateIndexFieldData.*",
//				AccessPrimitive.MODIFY_RUN_REC_DATA.toString()));
//		acl.add(new UrlDescriptor(".*updateResMetaVisibility.*",
//				AccessPrimitive.MODIFY_RUN_REC_DATA.toString()));
//		acl.add(new UrlDescriptor(".*addNewModuleIndex.*",
//				AccessPrimitive.EDIT_MODULE.toString()));
//		acl.add(new UrlDescriptor(".*addIndexField.*",
//				AccessPrimitive.EDIT_MODULE.toString()));
//		acl.add(new UrlDescriptor(".*deleteModuleIndex.*",
//				AccessPrimitive.EDIT_MODULE.toString()));
//		acl.add(new UrlDescriptor(".*editSelectModuleIndex.*",
//				AccessPrimitive.EDIT_MODULE.toString()));
//		acl.add(new UrlDescriptor(".*addNewModulePlot.*",
//				AccessPrimitive.EDIT_MODULE.toString()));
//		acl.add(new UrlDescriptor(".*deleteModulePlot.*",
//				AccessPrimitive.EDIT_MODULE.toString()));
//		acl.add(new UrlDescriptor(".*editSelectModulePlot.*",
//				AccessPrimitive.EDIT_MODULE.toString()));
//		acl.add(new UrlDescriptor(".*runCase.*",
//				AccessPrimitive.RUN_CASE.toString()));
//		acl.add(new UrlDescriptor(".*addNewHisModulePlot.*",
//				AccessPrimitive.MODIFY_RUN_REC_DATA.toString()));
//		acl.add(new UrlDescriptor(".*editSelectHisModulePlot.*",
//				AccessPrimitive.MODIFY_RUN_REC_DATA.toString()));
//		acl.add(new UrlDescriptor(".*deleteHisModulePlot.*",
//				AccessPrimitive.MODIFY_RUN_REC_DATA.toString()));
//		acl.add(new UrlDescriptor(".*edit-oper-case-action.*",
//				AccessPrimitive.EDIT_CASE.toString()));
//		acl.add(new UrlDescriptor(".*fEditIndexFieldAction.*",
//				AccessPrimitive.EDIT_MODULE.toString()));
//		acl.add(new UrlDescriptor(".*querySVNCredentialAction.*",
//				AccessPrimitive.CHANGE_HUDSON_CONFIG.toString()));
//		acl.add(new UrlDescriptor(".*updateSVNCredentialAction.*",
//				AccessPrimitive.CHANGE_HUDSON_CONFIG.toString()));
//	}
//	
//	@SuppressWarnings("unchecked")
//	public static boolean checkUrlPrivilege(HttpServletRequest request, List<UrlDescriptor> acl)
//	{
//		String url = request.getRequestURL().toString();
//		
//		for(UrlDescriptor descriptor : acl)
//		{
//			String pattern = descriptor.getUrlPattern();
//			boolean b = Pattern.matches(pattern, url);
//			if(b)
//			{
//				HttpSession session = request.getSession();
//				HashMap<String, String> accessMap = (HashMap<String, String>) session.getAttribute("AccessMap");
//				for(String privilege : descriptor.getAccessPrimitive())
//				{
//					if(accessMap.get(privilege).equals("false"))
//						return false;
//				}
//				
//				return true;
//			}
//		}
//		
//		return true;
//	}
//}
