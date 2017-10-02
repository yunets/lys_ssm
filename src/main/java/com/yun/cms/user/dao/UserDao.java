/**
 *Project Name: lys_ssm
 *File Name:    UserDao.java
 *Package Name: com.yun.cms.user.dao
 *Date:         2017年9月30日 上午9:39:00
 *Copyright (c) 2017,578888218@qq.com All Rights Reserved.
*/

package com.yun.cms.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yun.cms.user.dao.entity.User;
import com.yun.cms.user.model.UserModel;
import com.yun.dao.base.SimpleDao;

/**
 *Title:      UserDao<br/>
 *Description:
 *@Company:   励图高科<br/>
 *@author:    刘云生
 *@version:   v1.0
 *@since:     JDK 1.8.0_40
 *@Date:      2017年9月30日 上午9:39:00 <br/>
*/
@Repository
public class UserDao extends SimpleDao<User>{
	public List<User> selectUserNPBySearch(UserModel userModel){
		List<User> list=null;
		list=(List<User>) this.selectForPageListNP("selectUserNPBySearch", userModel);
		return list;
	}
}

