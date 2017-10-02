/**
 *Project Name: price
 *File Name:    DataGrid.java
 *Package Name: com.yun.common.entity
 *Date:         2016年7月30日 下午3:44:25
 *Copyright (c) 2016,578888218@qq.com All Rights Reserved.
*/

package com.yun.common.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 *Title:      DataGrid<br/>
 *Description: 分页专用类
 *@Company:   青岛励图高科<br/>
 *@author:    刘云生
 *@version:   v1.0
 *@since:     JDK 1.7.0_80
 *@Date:      2016年7月30日 下午3:44:25 <br/>
*/
public class DataGrid<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 544917865935003248L;
	private int pageNo = 1;//页码，默认是第一页  
    private int pageSize = 10;//每页显示的记录数，默认是15  
    private int total;//总记录数  Record
    private int totalPage;//总页数  
    private List<T> rows;//对应的当前页记录  results
    private Map<String, Object> params = new HashMap<String, Object>();//其他的参数我们把它分装成一个Map对象  
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public Map<String, Object> getParams() {
		return params;
	}
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	/**
	 * 
	 * @Title:       combinTotalRecords  
	 * @Description: TODO  拼装数据条数
	 * @param:       @param tList
	 * @param:       @return
	 * @return:      DataGrid<T>
	 * @author:      刘云生
	 * @Date:        2016年7月30日 下午3:53:44   
	 * @throws
	 */
	 public static <T> DataGrid<T> combinTotalRecords(List<T> tList) {
	    	DataGrid<T> dg = new DataGrid<T>();
			PageList<T> pageList = (PageList<T>) tList;
			int totalCount = (int) pageList.getPaginator().getTotalCount();
			dg.setTotal(totalCount);
			dg.setRows(tList);
			return dg;
		}

}

