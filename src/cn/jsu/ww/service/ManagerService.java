package cn.jsu.ww.service;

public interface ManagerService {
	/**
	 * ʵ�ֹ���Ա�˺�����Ĳ�ѯ����,���õ���ManagerDao.Add����
	 * @param s
	 * @param filepath
	 * @return
	 * @throws Exception
	 */
	public boolean Query(String s,String filepath) throws Exception;
	/**
	 * ʵ�ֹ���Ա�����Ӳ���,���õ���ManagerDao.Add����
	 * @param s
	 * @param filepath
	 * @return
	 * @throws Exception
	 */
	public boolean Add(String s,String filepath)throws Exception;
	/**
	 * ʵ�ֹ���Ա��ɾ������,���õ���ManagerDao.Delete����
	 * @param s
	 * @param filepath
	 * @return
	 * @throws Exception
	 */
	public boolean Delete(String s,String filepath)throws Exception;
	/**
	 * ʵ�ֹ���Ա���޸Ĳ���,���õ���ManagerDao.Update����
	 * @param old
	 * @param news
	 * @param filepath
	 * @return
	 * @throws Exception
	 */
	public boolean Update(String s, String filepath)throws Exception;
}
