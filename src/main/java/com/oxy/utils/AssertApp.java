package com.oxy.utils;

import java.util.List;

/**
 * @author lil1
 * @date 2019年4月12日 下午2:39:39
 * @Description 
 */
public class AssertApp {
	 public static void notNull(Object object, String message) {
	        if(object == null)
	            throw new ServiceOperationException(-2,message);
	    }
	    
	    public static void isNull(Object object, String message) {
	        if(object != null)
	            throw new ServiceOperationException(-2,message);
	    }
	    public static void notEmptyString(String str, String message) {
	        if(isEmpty(str))
	            throw new ServiceOperationException(-2,message);
	    }
	    
	    public static void isEmptyString(String str, String message) {
	        if(!isEmpty(str))
	            throw new ServiceOperationException(-2,message);
	    }

	    public static void notEmptyList(List<?> list, String message) {
	        if(list == null || list.isEmpty())
	            throw new ServiceOperationException(-2,message);
	    }
	    
	    public static void emptyList(List<?> list, String message) {
	        if(list != null && !list.isEmpty())
	            throw new ServiceOperationException(-2,message);
	    }
	    
	    public static boolean  isEmptyList(List<?> list) {
	        if(list != null && !list.isEmpty()){
	        	return false;
	        }
	        return true;   
	    }
	    
	    
	    public static boolean isEmpty(String str) {
	        if (str == null || str.trim().isEmpty() || "null".equals(str))
	            return true;
	        else
	            return false;
	    }

}
