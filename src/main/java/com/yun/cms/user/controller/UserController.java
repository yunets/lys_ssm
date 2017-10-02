/**
 *Project Name: lys_ssm
 *File Name:    UserController.java
 *Package Name: com.yun.cms.user.controller
 *Date:         2017年9月30日 上午9:39:46
 *Copyright (c) 2017,578888218@qq.com All Rights Reserved.
*/

package com.yun.cms.user.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yun.cms.user.dao.entity.User;
import com.yun.cms.user.model.UserModel;
import com.yun.cms.user.service.UserService;
import com.yun.common.entity.DataGrid;
import com.yun.common.utils.UUIDUtils;

/**
 *Title:      UserController<br/>
 *Description:
 *@Company:   励图高科<br/>
 *@author:    刘云生
 *@version:   v1.0
 *@since:     JDK 1.8.0_40
 *@Date:      2017年9月30日 上午9:39:46 <br/>
*/
@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "user_insert", method ={RequestMethod.POST,RequestMethod.GET}, produces = "application/json; charset=utf-8")
	@ResponseBody
	public int insert(User user){
		//User user=new User();
		user.setUserId(UUIDUtils.create());
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		return userService.insert(user);
	}
	
	@RequestMapping(value = "user_selectUserNPBySearch", method ={RequestMethod.POST,RequestMethod.GET}, produces = "application/json; charset=utf-8")
	@ResponseBody
	public DataGrid<User> selectUserNPBySearch(UserModel userModel){
		//CmsSysUserModel cmsSysUserModel=new CmsSysUserModel();
		//cmsSysUserModel.setPage(0);
		//cmsSysUserModel.setRows(10);
		return userService.selectUserNPBySearch(userModel);
	}
}

