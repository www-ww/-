package cn.jsu.ww.service.impl;

import cn.jsu.ww.factory.DAOFactory;
import cn.jsu.ww.service.ManagerService;

public class ManagerServiceImpl implements ManagerService{
	/**
	 * ʵ�ֹ���Ա�˺�����Ĳ�ѯ����,���õ���ManagerDao.Add����
	 * @param s
	 * @param filepath
	 * @return
	 * @throws Exception
	 */
	public boolean Query(String s,String filepath) throws Exception
	{
		return DAOFactory.getManagerInstance().Query(s, filepath);
	}
	/**
	 * ʵ�ֹ���Ա�����Ӳ���,���õ���ManagerDao.Add����
	 * @param s
	 * @param filepath
	 * @return
	 * @throws Exception
	 */
	public boolean Add(String s,String filepath)throws Exception
	{
		return DAOFactory.getManagerInstance().Add(s, filepath);
	}
	/**
	 * ʵ�ֹ���Ա��ɾ������,���õ���ManagerDao.Delete����
	 * @param s
	 * @param filepath
	 * @return
	 * @throws Exception
	 */
	public boolean Delete(String s,String filepath)throws Exception
	{
		return DAOFactory.getManagerInstance().Delete(s, filepath);

	}
	/**
	 * ʵ�ֹ���Ա���޸Ĳ���,���õ���ManagerDao.Update����
	 * @param old
	 * @param news
	 * @param filepath
	 * @return
	 * @throws Exception
	 */
	public boolean Update(String s, String filepath)throws Exception
	{
		return DAOFactory.getManagerInstance().Update(s,filepath);

	}
}
