package cn.jsu.ww.dao;

import java.sql.SQLException;

import cn.jsu.ww.vo.Room;
import cn.jsu.ww.vo.User;
/**
 * ����Ա�û�����IO
 * @author ww
 *
 */
public interface ManagerDao {
	/**
	 * �˻���ѯ
	 * @param s
	 * @param filepath
	 * @return�Ƿ��ѯ�ɹ�
	 * @throws Exception
	 */
	public boolean Query(String s,String filepath) throws Exception;
	/**
	 * �˻�����
	 * @param s
	 * @param filepath
	 * @return�Ƿ����ӳɹ�
	 * @throws Exception
	 */
	public boolean Add(String s,String filepath)throws Exception;
	/**
	 * �˻�ɾ��
	 * @param s
	 * @param filepath
	 * @return�Ƿ�ɾ���ɹ�
	 * @throws Exception
	 */
	public boolean Delete(String s,String filepath)throws Exception;
	public boolean Update(String s, String filepath)throws Exception;
}
