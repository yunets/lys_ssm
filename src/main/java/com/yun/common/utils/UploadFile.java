package com.yun.common.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.util.FileUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class UploadFile {
	public boolean Upload(File file,String fileName,String path){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
		String dir = request.getRealPath(File.separator + "resources" + File.separator + "upload"+ File.separator + path);
		
		//String dir = ServletActionContext.getRequest().getRealPath(File.separator + "resources" + File.separator + "upload"+ File.separator + path);// 取得要上传后文件要存放的路径
		try{
			//InputStream in=new FileInputStream(file);
			File fileLocation= new File(dir);
			if(!fileLocation.exists()){
				fileLocation.mkdir();
				System.out.println("创建上传目录");
			}
			//重命名文件名
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
			String time=df.format(new Date());
			fileName=time+fileName;
			
			File fileUpload=new File(dir, fileName);
			try {
				FileUtil.copyFile(file, fileUpload);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return false;
		
	}

}
