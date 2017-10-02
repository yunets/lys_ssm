package com.yun.dao.base;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * @ClassName: Generator<br>
 * @Description: Mybatis按照xml配置自动生成工具<br>
 * @Copyright tianren Copyright (c) 2015<br>
 * @Company 天人环境<br>
 * 
 * @author Wangxu<br>
 * @version V1.0<br>
 * @date 2015年5月1日 下午6:33:44<br>
 */
public class Generator {

	public static final String CONFIG_STRING = "D:/workspace-sts-3.7.3.RELEASE/lys_ssm/src/main/resources/log4j.properties";
	public static final String CONTEXT_STRING = "D:/workspace-sts-3.7.3.RELEASE/lys_ssm/src/main/resources/db/generatorConfig.xml";


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PropertyConfigurator.configure(CONFIG_STRING);
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;

		// 获取配置文件generatorConfig
		File configFile = new File(CONTEXT_STRING);
		ConfigurationParser cp = new ConfigurationParser(warnings);
		try {
			Configuration config = cp.parseConfiguration(configFile);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
