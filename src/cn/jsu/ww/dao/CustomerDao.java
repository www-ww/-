package cn.jsu.ww.dao;

import java.sql.SQLException;

import cn.jsu.ww.vo.Client;

/**
 * 客户管理接口
 * @author ww
 *
 */
public interface CustomerDao {
	/**
	 * 增加客户
	 * @param cli
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public boolean Add(Client cli,String sql)throws SQLException;

}
