package cn.jsu.ww.dao;

import java.sql.SQLException;

import cn.jsu.ww.vo.Client;

/**
 * �ͻ�����ӿ�
 * @author ww
 *
 */
public interface CustomerDao {
	/**
	 * ���ӿͻ�
	 * @param cli
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public boolean Add(Client cli,String sql)throws SQLException;

}
