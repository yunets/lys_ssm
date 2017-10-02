/**
 *Project Name: price
 *File Name:    BaseController.java
 *Package Name: com.yun.common.controller
 *Date:         2016年6月23日 上午11:05:38
 *Copyright (c) 2016,578888218@qq.com All Rights Reserved.
*/

package com.yun.common.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *Title:      BaseController<br/>
 *Description:
 *@Company:   青岛励图高科<br/>
 *@author:    刘云生
 *@version:   v1.0
 *@since:     JDK 1.7.0_80
 *@Date:      2016年6月23日 上午11:05:38 <br/>
*/
@Controller
public class BaseController {
	protected Logger logger = Logger.getLogger(this.getClass());

	private static final long serialVersionUID = 6357869213649815390L;
	
	
	@RequestMapping(value = "jspView")
	@ResponseBody
	public ModelAndView jspView(String jsp) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(jsp);
		return modelAndView;
	}
	
	
	
}

