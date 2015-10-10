package com.dbdou.app.wechat.util;

import net.sf.json.JSONObject;

/**
 * 获取全局唯一票据，失效时间为2小时
 * 
 * @author 0000
 *
 */
public class AccessTokenUtil {

	public static String getAccessToken() {

		String requestUrl = ConstantUtil.GET_TOKEN_URL.replace("APPID",
				ConstantUtil.APPID).replace("APPSECRET", ConstantUtil.SECRET);
		JSONObject jsonObject = HttpsAndHttpUtil.httpsRequest(requestUrl,
				"GET", null);
		// TODO exception + cache token
		if (null != jsonObject) {

			return jsonObject.getString("access_token");
		}
		return null;

	}

}
