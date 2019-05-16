package com.oxy.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 2019年4月12日 下午2:32:30
 * @Description 
 */
public class MapUtils {

	  private static Map<Object, Object> map;
	  private static MapUtils mapUtils;

	  public static MapUtils build() {
	    return build(16);
	  }

	  public static MapUtils build(int size) {
	    return new MapUtils(size);
	  }

	  public MapUtils put(Object key, Object value) {
	    map.put(key,value);
	    return this;
	  }

	 public MapUtils putAll(Map<Object,Object> map) {
	    map.putAll(map);
	    return this;
	  }

	  public Map<Object,Object> map() {
	    return map;
	  }
	  private MapUtils(int size) {
	    map = new HashMap<>(size);
	  }
	}
