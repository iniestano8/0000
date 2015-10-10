package com.dbdou.app.wechat.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

/**
 * 请求工具类
 * @ClassName: HttpsUtil  
 * @exception
 * @since 1.0
 */
public class HttpsAndHttpUtil {
	
	/**
	 * https请求方法
	 * <p>Title: httpsRequest</p>
	 * <p>Description: 发送https请求</p>
	 * @param requestUrl请求地址
	 * @param requestMethod请求方式（GET、POST）
	 * @param outputStr提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
		
		JSONObject jsonObject = null;
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(ssf);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			conn.setRequestMethod(requestMethod);
			// 当outputStr不为null时向输出流写数据
			if (null != outputStr) {
				OutputStream outputStream = conn.getOutputStream();
				// 注意编码格式
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}
			// 从输入流读取返回内容
			InputStream inputStream = conn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			// 释放资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			conn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			// TODO write error log
			// ("连接超时：{" + ce + "}");
		} catch (Exception e) {
			// TODO write error log
			// ("https请求异常：{" + e + "}");
		}
		return jsonObject;
	}
	
	/**
	 * post请求
	 * @Title: httpPostRequest 
	 * @exception
	 * @since 1.0
	 */
	public static Map<String, Object> httpPostRequest(String url, Map<String, Object> params) {
		
		HttpClient httpClient = new HttpClient();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			PostMethod method = new PostMethod(url);
			method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
			method.addRequestHeader("Content-Type", "text/html;charset=utf-8");
			method.setRequestHeader("Content-Type", "text/html;charset=utf-8");
			if (null != params && params.size() >0) {
				for (Map.Entry<String, Object> entry : params.entrySet()) {
					method.setParameter(entry.getKey(), (String) entry.getValue());
				}
			}
			int resultCode = httpClient.executeMethod(method);
			if (200 == resultCode) {
				resultMap.put("status", "success");
				resultMap.put("result", method);
			}else{
				resultMap.put("status", "fail");
			}
		} catch (ConnectException ce) {
			// TODO write error log
			// ("连接超时：{" + ce + "}");
		} catch (Exception e) {
			// TODO write error log
			// ("httpPostRequest请求异常：{" + e + "}");
		}
		return resultMap;
	}
	
	/**
	 * get请求
	 * @Title: httpGetRequest 
	 * @exception
	 * @since 1.0
	 */
	public static Map<String, Object> httpGetRequest(String url, Map<String, Object> params) {
		
		HttpClient httpClient = new HttpClient();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			if (url.indexOf("?")<0) {
				url = url + "?";
			}
			if (null != params && params.size() >0) {
				for (Map.Entry<String, Object> entry : params.entrySet()) {
					url = url + "&" + entry.getKey() + "=" + entry.getValue(); 
				}
			}
			GetMethod method = new GetMethod(url);
			method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
			method.addRequestHeader("Content-Type", "text/html;charset=utf-8");
			method.setRequestHeader("Content-Type", "text/html;charset=utf-8");
			int resultCode = httpClient.executeMethod(method);
			if (200 == resultCode) {
				resultMap.put("status", "success");
				resultMap.put("result", method);
			}else{
				resultMap.put("status", "fail");
			}
		} catch (ConnectException ce) {
			// TODO write error log
			// ("连接超时：{" + ce + "}");
		} catch (Exception e) {
			// TODO write error log
			// ("httpGetRequest请求异常：{" + e + "}");
		}
		return resultMap;
	}
	public static void main(String[] args) {
		
		String url = "http://gaozhili.net/checkWX";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("", "");
		System.out.println(httpPostRequest(url, params));
		
	}
}