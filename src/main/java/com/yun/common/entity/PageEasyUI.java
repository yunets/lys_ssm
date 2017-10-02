/**
 *Project Name: price
 *File Name:    PageEasyUI.java
 *Package Name: com.yun.common.entity
 *Date:         2016年7月30日 下午3:16:43
 *Copyright (c) 2016,578888218@qq.com All Rights Reserved.
*/

package com.yun.common.entity;

import java.io.Serializable;

/**
 *Title:      PageEasyUI<br/>
 *Description:分页专用类
 *@Company:   青岛励图高科<br/>
 *@author:    刘云生
 *@version:   v1.0
 *@since:     JDK 1.7.0_80
 *@Date:      2016年7月30日 下午3:16:43 <br/>
*/
public class PageEasyUI implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 973910636031323411L;
	private int page;
	private int rows;
	private String sort;
	protected String UserId;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	
}

