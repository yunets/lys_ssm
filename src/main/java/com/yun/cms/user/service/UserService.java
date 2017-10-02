/**
 *Project Name: lys_ssm
 *File Name:    UserService.java
 *Package Name: com.yun.cms.user.service
 *Date:         2017年9月30日 上午9:39:29
 *Copyright (c) 2017,578888218@qq.com All Rights Reserved.
*/

package com.yun.cms.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yun.cms.user.dao.UserDao;
import com.yun.cms.user.dao.entity.User;
import com.yun.cms.user.model.UserModel;
import com.yun.common.entity.DataGrid;

/**
 *Title:      UserService<br/>
 *Description:
 *@Company:   励图高科<br/>
 *@author:    刘云生
 *@version:   v1.0
 *@since:     JDK 1.8.0_40
 *@Date:      2017年9月30日 上午9:39:29 <br/>
*/
@Service("userService")
public class UserService {
	@Autowired
	UserDao userDao;
	public int insert(User user){
		return userDao.insert(user);
	}
	
	public DataGrid<User> selectUserNPBySearch(UserModel userModel){
		List<User> list=userDao.selectUserNPBySearch(userModel);		
		return DataGrid.combinTotalRecords(list);
	}
	
	
}

