package cn.jsu.ww.dao;

import java.sql.SQLException;

import cn.jsu.ww.vo.User;

/**
 * �û���¼�ӿ�
 * 
 * @author ww
 *
 */
public interface UseDao {
	/**
	 * �û���ѯ
	 * @param user
	 * @param sql
	 * @return���ز�ѯ���ı��
	 * @throws SQLException
	 */
	public int Query(User user, String sql) throws SQLException;
	/**
	 * �û���ѯ
	 * @param user
	 * @param sql
	 * @return���ز�ѯ���˻�
	 * @throws SQLException
	 */
	public User Query1(User user, String sql) throws SQLException;
	/**
	 * �����û�
	 * @param user
	 * @param sql
	 * @return�Ƿ����ӳɹ�
	 * @throws SQLException
	 */
	public boolean Add(User user, String sql) throws SQLException;
	/**
	 * ɾ���û�
	 * @param user
	 * @param sql
	 * @return�Ƿ�ɾ���ɹ�
	 * @throws SQLException
	 */
	public boolean Delete(User user, String sql) throws SQLException;
	/**
	 * �޸��û�
	 * @param user
	 * @param sql
	 * @return�Ƿ��޸ĳɹ�
	 * @throws SQLException
	 */
	public boolean Update(User user, String sql) throws SQLException;
}
