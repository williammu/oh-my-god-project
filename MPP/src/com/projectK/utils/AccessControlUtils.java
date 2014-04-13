package com.projectK.utils;
//package com.aliyun.mpp.utils;
//
//import java.util.HashSet;
//
//import com.aliyun.mpp.common.AccessPrimitive;
//import com.aliyun.mpp.common.UserIdentityEnum;
//
//public class AccessControlUtils {
//	public static HashSet<String> getIdentityAccessPrimitives(int userIdentity)
//	{
//		HashSet<String> ret = new HashSet<String>();
//		
//		if(userIdentity == UserIdentityEnum.IDENTITY_VIEWER)
//		{
//			
//		}
//		else if(userIdentity == UserIdentityEnum.IDENTITY_OPERATOR)
//		{
//			ret.add(AccessPrimitive.RUN_CASE.toString());
//			ret.add(AccessPrimitive.MODIFY_RUN_REC_DATA.toString());
//			ret.add(AccessPrimitive.CHECK_ASSIGNED_TASK.toString());
//		}
//		else if(userIdentity == UserIdentityEnum.IDENTITY_DICTATOR)
//		{
//			ret.add(AccessPrimitive.EDIT_CASE.toString());
//			ret.add(AccessPrimitive.DELETE_CASE.toString());
//			ret.add(AccessPrimitive.RUN_CASE.toString());
//			ret.add(AccessPrimitive.EDIT_PROJECT.toString());
//			ret.add(AccessPrimitive.DELETE_PROJECT.toString());
//			ret.add(AccessPrimitive.DELETE_RUN_REC.toString());
//			ret.add(AccessPrimitive.MODIFY_RUN_REC_DATA.toString());
//			ret.add(AccessPrimitive.EDIT_MODULE.toString());
//			ret.add(AccessPrimitive.DELETE_MODULE.toString());
//			ret.add(AccessPrimitive.ASSIGN_TASK.toString());
//			ret.add(AccessPrimitive.CHECK_ASSIGNED_TASK.toString());
//			ret.add(AccessPrimitive.EDIT_RUN_REC_META.toString());
//			ret.add(AccessPrimitive.CHANGE_HUDSON_CONFIG.toString());
//		}
//		else if(userIdentity == UserIdentityEnum.IDENTITY_SUPERADMIN)
//		{
//			ret.add(AccessPrimitive.MODIFY_USER.toString());
//		}
//		else
//		{
//			//for unknown identity, there is of course no access privilege
//		}
//		
//		return ret;
//	}
//}
