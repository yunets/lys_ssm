/**
 *Project Name: price
 *File Name:    TestQUST.java
 *Package Name: com.yun.common.utils
 *Date:         2016年7月17日 上午9:35:30
 *Copyright (c) 2016,578888218@qq.com All Rights Reserved.
*/

package com.yun.common.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpException;

/**
 *Title:      TestQUST<br/>
 *Description:
 *@Company:   青岛励图高科<br/>
 *@author:    刘云生
 *@version:   v1.0
 *@since:     JDK 1.7.0_80
 *@Date:      2016年7月17日 上午9:35:30 <br/>
*/
public class TestQUST {

	public static void main(String[] args) throws HttpException {
		// TODO Auto-generated method stub
    String url="";
    HashMap<String, Object> params=new HashMap<String, Object>();
    params.put("id", 2000);
    params.put("strAccount", "t02594");
    params.put("strPassword", 2000);
    params.put("0MKKey", "");
    
    String response=HttpConnectUtil.postHttp(url, params);
	}

}

