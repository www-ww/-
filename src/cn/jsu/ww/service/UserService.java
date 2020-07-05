package cn.jsu.ww.service;

import java.sql.SQLException;

import cn.jsu.ww.vo.User;

public interface UserService {
	/**
	 * ʵ���û��Ĳ�ѯ�������ж��û���Ϣ�������Ƿ���ȷ,���õ���UseDao.Query����
	 * @param user
	 * @param sql
	 * @return ��ѯ������true��û�в�ѯ������false
	 * @throws SQLException
	 */
	public int Query(User user, String sql) throws SQLException;
	/**
	 * ��������ѯ���û���Ϣ,���õ���UseDao.Query1����
	 * @param user
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public User Query1(User user, String sql) throws SQLException;

	/**
	 * ʵ���û������Ӳ���,���õ���LoginUseDao.Add����
	 * @param user
	 * @param sql
	 * @return 
	 * @throws SQLException
	 */
	public boolean Add(User user, String sql) throws SQLException;
	/**
	 * ʵ���û���ɾ���������ڱ�������ִ�����µ���:<br>
	 * <li>��Ҫ�ж�Ҫɾ�������ݴ���������Ƿ�Ϊ�գ��ж�null��<li>
	 * <li>���ȷ����ɾ�������ݣ�����LoginUseDao.Delete����<li>
	 * @param user
	 * @param sql
	 * @return 
	 * @throws SQLException
	 */
	public boolean Delete(User user, String sql) throws SQLException;
	/**
	 * ʵ���û����޸Ĳ������ڱ�������ִ�����µ���:<br>
	 * <li>��Ҫ�ж�Ҫ�޸ĵ����ݴ���������Ƿ�Ϊ�գ��ж�null��<li>
	 * <li>���ȷ����Ҫ�޸ĵ����ݣ�����LoginUseDao.Update����<li>
	 * @param user
	 * @param sql
	 * @return 
	 * @throws SQLException
	 */
	public boolean Update(User user, String sql) throws SQLException;

}
