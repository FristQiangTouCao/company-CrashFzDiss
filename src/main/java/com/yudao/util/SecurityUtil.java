package com.yudao.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class SecurityUtil {

	public static final String TOKEN = "token";

//	private final Map<String, Map<String, String>> userCacheMap = new HashMap<>(); // 用户信息 token=userMap
	
	//测试用
	private final Map<String, Map<String, String>> userCacheMap = new HashMap<>(); //token=userMap
	{
		Map<String, String> mm = new HashMap<>();
		mm.put("role", "guest");  //商户
		mm.put("userId", "12");
		mm.put("paraId", "gamec");
		mm.put("username", "gamec");
		mm.put("lilv", "0.025");
		mm.put("md5Key", "82454544-04f6-401a-7894-021457855451");
		userCacheMap.put("123456", mm);
	}
	
	public String getToken(HttpServletRequest request) {
		return request.getHeader(TOKEN);
	}

	public void cacheUser(String key, Map<String, String> val) {
		userCacheMap.put(key, val);
	}

	public Map<String, String> getCacheUser(String key) {
		return userCacheMap.get(key);
	}
	
	public String getCacheUserProperty(HttpServletRequest request, String key) {
		Map<String, String> user = userCacheMap.get(getToken(request));
		return user == null ? null : user.get(key);
	}

	public int getCacheUserId(HttpServletRequest request) {
		Map<String, String> user = userCacheMap.get(getToken(request));
		if (user == null) {
			throw new RuntimeException("get userId error[token is null or invalid]");
		}
		return Integer.parseInt(user.get("userId"));
	}

	public String getCacheUserParaId(HttpServletRequest request) {
		Map<String, String> user = userCacheMap.get(getToken(request));
		if (user == null) {
			throw new RuntimeException("get userId error[token is null or invalid]");
		}
		return user.get("paraId");
	}

	public void removeCacheUser(String key) {
		userCacheMap.remove(key);
	}

	public void removeCacheUser(HttpServletRequest request) {
		userCacheMap.remove(getToken(request));
	}
	
	public Map<String, Map<String, String>> getUserCacheMap() {
		return userCacheMap;
	}
	
	public static void main(String[] args) {

	}

}
