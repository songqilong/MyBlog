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
	 * ����properties�ļ�
	 * @param file �ļ�·��
	 * @return
	 */
	public static Properties LoadProperties(){
		PropertiesUtils utils = new PropertiesUtils();
		Properties pro = null;
		FileInputStream in = null;
		try{
			// ��ȡ�ļ�������
			in = new FileInputStream(utils.getPath());
			pro = new Properties();
			// �����ļ�
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
	 * ��ȡ�����ļ�������ֵ
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
	 * ��������
	 * @param key 
	 * @param value
	 */
	public static void SavePoperties(String key,String value){
		PropertiesUtils utils = new PropertiesUtils();
		// ��ȡ�����ļ�����
		Properties pro = LoadProperties();
		FileOutputStream fos =  null;
		try{
			// �ļ����������
			pro.put(key, value);
			// ���������
			fos = new FileOutputStream(utils.getPath(), true);
			// �洢����
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
	 * ��������
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
