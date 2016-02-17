package com.song.bll;

import com.song.dao.MasterDAO;
import com.song.entity.Master;

public class MasterBLL {
	private MasterDAO masterDAO;

	/**
	 * ���췽��
	 */
	public MasterBLL()
	{
		masterDAO = new MasterDAO();
	}
	
	/**
	 * ע���û�
	 * @param user ע���û�����ʵ��
	 * @return trueע��ɹ���falseע��ʧ��
	 */
	public boolean Register(Master user)
	{
		return masterDAO.AddMaster(user);		
	}
	
	/**
	 * �û���¼
	 * @param user ��װ�ĵ�¼�û���Ϣ
	 * @return true��֤ͨ�����Ե�¼��false��֤ʧ�ܲ��ܵ�¼
	 */
	public Master Login(Master user)
	{
		return masterDAO.GetMaster(user);
	}
	
	/**
	 * ��������ID��ȡ������Ϣ
	 * @param masterId
	 * @return
	 */
	public Master GetMasterInfo(int masterId){
		return masterDAO.getMaster(masterId);
	}
}
