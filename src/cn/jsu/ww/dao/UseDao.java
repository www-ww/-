package cn.jsu.ww.dao;

import java.sql.SQLException;

import cn.jsu.ww.vo.User;

/**
 * 用户登录接口
 * 
 * @author ww
 *
 */
public interface UseDao {
	/**
	 * 用户查询
	 * @param user
	 * @param sql
	 * @return返回查询到的编号
	 * @throws SQLException
	 */
	public int Query(User user, String sql) throws SQLException;
	/**
	 * 用户查询
	 * @param user
	 * @param sql
	 * @return返回查询的账户
	 * @throws SQLException
	 */
	public User Query1(User user, String sql) throws SQLException;
	/**
	 * 增加用户
	 * @param user
	 * @param sql
	 * @return是否增加成功
	 * @throws SQLException
	 */
	public boolean Add(User user, String sql) throws SQLException;
	/**
	 * 删除用户
	 * @param user
	 * @param sql
	 * @return是否删除成功
	 * @throws SQLException
	 */
	public boolean Delete(User user, String sql) throws SQLException;
	/**
	 * 修改用户
	 * @param user
	 * @param sql
	 * @return是否修改成功
	 * @throws SQLException
	 */
	public boolean Update(User user, String sql) throws SQLException;
}
