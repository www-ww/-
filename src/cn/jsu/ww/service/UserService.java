package cn.jsu.ww.service;

import java.sql.SQLException;

import cn.jsu.ww.vo.User;

public interface UserService {
	/**
	 * 实现用户的查询操作来判断用户信息和密码是否正确,调用的是UseDao.Query方法
	 * @param user
	 * @param sql
	 * @return 查询到返回true，没有查询到返回false
	 * @throws SQLException
	 */
	public int Query(User user, String sql) throws SQLException;
	/**
	 * 返回所查询的用户信息,调用的是UseDao.Query1方法
	 * @param user
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public User Query1(User user, String sql) throws SQLException;

	/**
	 * 实现用户的增加操作,调用的是LoginUseDao.Add方法
	 * @param user
	 * @param sql
	 * @return 
	 * @throws SQLException
	 */
	public boolean Add(User user, String sql) throws SQLException;
	/**
	 * 实现用户的删除操作，在本操作中执行如下调用:<br>
	 * <li>需要判断要删除的数据传入的内容是否为空（判断null）<li>
	 * <li>如果确定有删除的数据，调用LoginUseDao.Delete方法<li>
	 * @param user
	 * @param sql
	 * @return 
	 * @throws SQLException
	 */
	public boolean Delete(User user, String sql) throws SQLException;
	/**
	 * 实现用户的修改操作，在本操作中执行如下调用:<br>
	 * <li>需要判断要修改的数据传入的内容是否为空（判断null）<li>
	 * <li>如果确定有要修改的数据，调用LoginUseDao.Update方法<li>
	 * @param user
	 * @param sql
	 * @return 
	 * @throws SQLException
	 */
	public boolean Update(User user, String sql) throws SQLException;

}
