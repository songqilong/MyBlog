package com.song.common;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertiesUtils {


	private String getPath(){
		return this.getClass().getResource("/config.properties").getPath();
	}
	/**
	 * 加载properties文件
	 * @param file 文件路径
	 * @return
	 */
	public static Properties LoadProperties(){
		PropertiesUtils utils = new PropertiesUtils();
		Properties pro = null;
		FileInputStream in = null;
		try{
			// 获取文件输入流
			in = new FileInputStream(utils.getPath());
			pro = new Properties();
			// 加载文件
			pro.load(in);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(in != null){
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pro;
	}
	
	/**
	 * 读取属性文件的属性值
	 * @param key
	 * @return
	 */
	public static String ReadProperties(String key){
		String value = "";
		if(key==null||"".equals(key)){
			return value;
		}
		PropertiesUtils urils = new PropertiesUtils();
		Properties pro = null;
		FileInputStream in = null;
		try{
			in = new FileInputStream(urils.getPath());
			pro = new Properties();
			pro.load(in);
			value = pro.getProperty(key).toString();
		}catch(Exception e){
			e.printStackTrace();
		}
		if(in != null){
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return value;
	}
	
	/**
	 * 增加属性
	 * @param key 
	 * @param value
	 */
	public static void SavePoperties(String key,String value){
		PropertiesUtils utils = new PropertiesUtils();
		// 获取配置文件对象
		Properties pro = LoadProperties();
		FileOutputStream fos =  null;
		try{
			// 文件中添加属性
			pro.put(key, value);
			// 创建输出流
			fos = new FileOutputStream(utils.getPath(), true);
			// 存储属性
			pro.store(fos, "add properties");
		}catch(Exception e){
			e.printStackTrace();
		}
		if(fos != null){
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 更新属性
	 * @param key
	 * @param value
	 */
	public static void UpdateProperties(String key,String value){
		if(key == null||"".equals(key)){
			return;
		}
		SavePoperties(key,value);
	}
}
