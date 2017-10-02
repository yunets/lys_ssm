package com.yun.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpException;

import net.sf.json.JSONObject;

public class HttpConnectUtil {
	private static String MDMIP = "119.167.153.8:8089/gsp-manager";// 多说短域名
																	// ****.yoodb.****
	private static String MESIP = "xxxxxxxxxxxxxxxxx";// 多说秘钥

	/**
	 * get方法获取http请求
	 * @Title:       getHttp  
	 * @Description: TODO  
	 * @param:       @param url
	 * @param:       @return
	 * @param:       @throws HttpException
	 * @return:      String
	 * @author:      刘云生
	 * @Date:        2016年6月16日 下午9:02:59   
	 * @throws
	 */
	public static String getHttp(String url) throws HttpException {
		String responseMsg = "";
		HttpClient httpClient = new HttpClient();
		GetMethod getMethod = new GetMethod(url);
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
		try {
			httpClient.executeMethod(getMethod);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			InputStream in = getMethod.getResponseBodyAsStream();
			int len = 0;
			byte[] buf = new byte[1024];
			while ((len = in.read(buf)) != -1) {
				out.write(buf, 0, len);
			}
			responseMsg = out.toString("UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 释放连接
			getMethod.releaseConnection();
		}
		return responseMsg;
	}


	/**
	 * post提交方式
	 * @Title:       postHttp  
	 * @Description: TODO  
	 * @param:       @param url
	 * @param:       @param params
	 * @param:       @return
	 * @param:       @throws HttpException
	 * @return:      String
	 * @author:      刘云生
	 * @Date:        2016年6月16日 下午9:04:36   
	 * @throws
	 */
	public static String postHttp(String url, Map<String, Object> params) throws HttpException {
		String responseMsg = "";
		HttpClient httpClient = new HttpClient();
		httpClient.getParams().setContentCharset("UTF-8");
		PostMethod postMethod = new PostMethod(url);
		Iterator<Map.Entry<String, Object>> itRequest = params.entrySet().iterator();
		while (itRequest.hasNext()) {
			Map.Entry<String, Object> entry = itRequest.next();
			// System.out.println(entry.getKey()+"----"+entry.getValue());
			postMethod.addParameter(entry.getKey().toString(), entry.getValue().toString());
		}
		try {
			httpClient.executeMethod(postMethod);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			InputStream in = postMethod.getResponseBodyAsStream();
			int len = 0;
			byte[] buf = new byte[1024];
			while ((len = in.read(buf)) != -1) {
				out.write(buf, 0, len);
			}
			responseMsg = out.toString("UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			postMethod.releaseConnection();
		}
		return responseMsg;
	}
/**
 * 测试函数
 * @param args
 */
	public static void main(String[] args) {
		String result = "";
		Map<String, Object> params = new HashMap<String, Object>();
		//params.put("checkCode", "AAAAAAAAAA");
		try {
			result = postHttp("http://115.28.189.111/sendServer/sectionDictionary", params);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("连接失败" + e.getMessage());
		}
		System.out.println(result);
		JSONObject jsonObject = JSONObject.fromObject(result);
		System.out.println("resultFlag:"+jsonObject.get("errorCode"));
		
	}
}
