package cn.jsu.ww.service;

import java.sql.SQLException;

import cn.jsu.ww.vo.Client;

public interface CustomerService {
	/**
	 * 实现客户的增加操作,调用的是CustomerManageDao.Add方法
	 * @param cli
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public boolean Add(Client cli,String sql)throws SQLException;
}
