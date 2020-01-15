package com.yudao.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

public class ResponseUtil {

	private static int SUCCESS = 0;
	private static int FAIL = 1;

	public static void write(HttpServletResponse response, Object o) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(o.toString());
		out.flush();
		out.close();
	}

	public static JSONObject success() {
		JSONObject json = new JSONObject();
		json.put("code", SUCCESS);
		json.put("msg", "成功");
		return json;
	}
	public static JSONObject success(Object object) {
		JSONObject json = new JSONObject();
		json.put("code", SUCCESS);
		json.put("msg", "成功");
		json.put("data", object);
		return json;
	}

	public static JSONObject fail(String msg) {
		JSONObject json = new JSONObject();
		json.put("code", FAIL);
		json.put("msg", msg);
		return json;
	}

	public static JSONObject fail(int errorCode, String msg) {
		JSONObject json = new JSONObject();
		json.put("code", errorCode);
		json.put("msg", msg);
		return json;
	}

}
