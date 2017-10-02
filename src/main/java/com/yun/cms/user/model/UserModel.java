/**
 *Project Name: lys_ssm
 *File Name:    UserModel.java
 *Package Name: com.yun.cms.user.model
 *Date:         2017年10月1日 下午4:13:16
 *Copyright (c) 2017,578888218@qq.com All Rights Reserved.
*/

package com.yun.cms.user.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yun.common.entity.PageEasyUI;

/**
 *Title:      UserModel<br/>
 *Description:
 *@Company:   励图高科<br/>
 *@author:    刘云生
 *@version:   v1.0
 *@since:     JDK 1.8.0_40
 *@Date:      2017年10月1日 下午4:13:16 <br/>
*/
public class UserModel extends PageEasyUI{
	private String userId;

    private String loginName;

    private String loginPwd;

    private String userName;

    private String userSex;

    private String userTelNo;

    private String userEmail;

    private Date createTime;

    private String createName;

    private Date updateTime;

    private String updateName;
    
    
    private String startTime;
    private String endTime;
    
	@Override
	public String getUserId() {
		return userId;
	}

	@Override
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserTelNo() {
		return userTelNo;
	}

	public void setUserTelNo(String userTelNo) {
		this.userTelNo = userTelNo;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
    
}

