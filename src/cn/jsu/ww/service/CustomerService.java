package cn.jsu.ww.service;

import java.sql.SQLException;

import cn.jsu.ww.vo.Client;

public interface CustomerService {
	/**
	 * ʵ�ֿͻ������Ӳ���,���õ���CustomerManageDao.Add����
	 * @param cli
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public boolean Add(Client cli,String sql)throws SQLException;
}
