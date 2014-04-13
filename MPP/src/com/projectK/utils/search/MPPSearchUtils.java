package com.projectK.utils.search;
//package com.aliyun.mpp.utils.search;
//
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//
//import com.aliyun.mpp.bean.Criterion;
//import com.aliyun.mpp.bean.Criterion.CompareType;
//import com.aliyun.mpp.utils.MPPObjWrapper;
//import com.aliyun.mpp.utils.ReflectUtils;
//
//public class MPPSearchUtils {
//	
//	private static String getIDFromBeanObj(Object elem)
//	{
//		Method getID = ReflectUtils.getMethodByName(elem.getClass(), "getId");
//		String ID = "";
//		try {
//			ID = getID.invoke(elem) + "";
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return ID;
//	}
//	
//	private static <T> List<T> mergeAnd(List<T> lst1, List<T> lst2)
//	{
//		List<T> ret = new ArrayList<T>();
//		HashSet<String> existence = new HashSet<String>();
//		for(T elem : lst1)
//		{
//			String ID = getIDFromBeanObj(elem);
//			existence.add(ID);
//		}
//		
//		for(T elem : lst2)
//		{
//			String ID = getIDFromBeanObj(elem);
//			if(existence.contains(ID))
//				ret.add(elem);
//		}
//		return ret;
//	}
//	
//	private static <T> List<T> mergeOr(List<T> lst1, List<T> lst2)
//	{
//		List<T> ret = new ArrayList<T>();
//		HashSet<String> existence = new HashSet<String>();
//		for(T elem : lst1)
//		{
//			String ID = getIDFromBeanObj(elem);
//			existence.add(ID);
//			ret.add(elem);
//		}
//		
//		for(T elem : lst2)
//		{
//			String ID = getIDFromBeanObj(elem);
//			if(!existence.contains(ID))
//				ret.add(elem);
//		}
//		return ret;
//	}
//	
//	public static <T> List<T> merge(List<T> lst1, List<T> lst2, String oper)
//	{
//		List<T> ret = null;
//		
//		if(oper.toLowerCase().equals("and"))
//		{
//			ret = mergeAnd(lst1, lst2);
//		}
//		else if(oper.toLowerCase().equals("any"))
//		{
//			ret = mergeOr(lst1, lst2);
//		}
//		else
//		{
//			//never comes here! something terrible happened!
//		}
//		
//		return ret;
//	}
//	
//	
//	
//	public static <T> List<T> filter(List<T> lst, MPPPredicate predicate)
//	{
//		List<T> ret = new ArrayList<T>();
//		
//		for(T elem : lst)
//		{
//			if(predicate.check(elem))
//				ret.add(elem);
//		}
//		
//		return ret;
//	}
//	
//	//多条件查询 ：将filters参数解析为Criterion列表
//	public static List<Criterion> generateSearchCriteriaFromFilters(String filters, String tableName, MPPObjWrapper groupOpWrapper) {  
//	    List<Criterion> criteria = new ArrayList<Criterion>();  
//	      
//	    JSONObject jsonObject = JSONObject.fromObject(filters);
//	    String groupOp = jsonObject.getString("groupOp");
//	    groupOpWrapper.obj = groupOp;
//	    
//	    JSONArray rules = jsonObject.getJSONArray("rules");  
//	      
//	    for(Object obj : rules) {  
//	        JSONObject rule = (JSONObject) obj;  
//	          
//	        String field = rule.getString("field");  
//	        String op = rule.getString("op");  
//	        String data = rule.getString("data");  
//	          
//	        Criterion criterion = MPPSearchUtils.generateSearchCriterion(field, data, op, tableName);  
//	          
//	        if(criterion != null) {  
//	            criteria.add(criterion);  
//	        }  
//	    }
//	    return criteria;  
//	} 
//	
//	
//	 //(单条件查询)通过searchField、searchString、searchOper三个参数生成Criterion的方法  
//    public static Criterion generateSearchCriterion(String searchField,  
//            String searchString, String searchOper, String tableName) {  
//        Criterion criterion = null;  
//          
//        //如果searchField、searchString、searchOper均不为null，且searchString不为空字符串时，则创建Criterion  
//        if (searchField != null && searchString != null  
//                & searchString.length() > 0 && searchOper != null) {  
//            if ("eq".equals(searchOper)) {  
//                criterion = Criterion.getEqualCriterion(searchField,  
//                        searchString, tableName);  
//            } else if ("ne".equals(searchOper)) {  
//                criterion = Criterion.getCompareCriterion(CompareType.NE,  
//                        searchField, searchString, tableName);  
//            } else if ("lt".equals(searchOper)) {  
//                criterion = Criterion.getCompareCriterion(CompareType.LT,  
//                        searchField, searchString, tableName);  
//            } else if ("le".equals(searchOper)) {  
//                criterion = Criterion.getCompareCriterion(CompareType.LTE,  
//                        searchField, searchString, tableName);  
//            } else if ("gt".equals(searchOper)) {  
//                criterion = Criterion.getCompareCriterion(CompareType.GT,  
//                        searchField, searchString, tableName);  
//            } else if ("ge".equals(searchOper)) {  
//                criterion = Criterion.getCompareCriterion(CompareType.GTE,  
//                        searchField, searchString, tableName);  
//            } else if ("bw".equals(searchOper)) {  
//                criterion = Criterion.getLikeCriterion(searchField,  
//                        searchString + "%", tableName);  
//            } else if ("bn".equals(searchOper)) {  
//                criterion = Criterion.getNotLikeCriterion(searchField,  
//                        searchString + "%", tableName);  
//            } else if ("ew".equals(searchOper)) {  
//                criterion = Criterion.getLikeCriterion(searchField, "%"  
//                        + searchString, tableName);  
//            } else if ("en".equals(searchOper)) {  
//                criterion = Criterion.getNotLikeCriterion(searchField, "%"  
//                        + searchString, tableName);  
//            } else if ("cn".equals(searchOper)) {  
//                criterion = Criterion.getLikeCriterion(searchField, "%"  
//                        + searchString + "%", tableName);  
//            } else if ("nc".equals(searchOper)) {  
//                criterion = Criterion.getNotLikeCriterion(searchField, "%"  
//                        + searchString + "%", tableName);  
//            } else if ("in".equals(searchOper)) {  
//                criterion = Criterion.getLikeCriterion(searchField, "%"  
//                        + searchString + "%", tableName);  
//            } else if ("ni".equals(searchOper)) {  
//                criterion = Criterion.getNotLikeCriterion(searchField, "%"  
//                        + searchString + "%", tableName);  
//            } 
//        }  
//        return criterion;  
//    }  
//}
