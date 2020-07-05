package cn.jsu.ww.service;

import java.sql.SQLException;
import java.util.Vector;

import cn.jsu.ww.vo.Room;

public interface KufangService {
	/**
	 * 实现库房的查询操作,调用的是KufangManageDaoImpl.Query方法
	 * @param sql
	 * @throws SQLException
	 */
	public Vector<Room> Query(String sql) throws SQLException;
	/**
	 * 查询所有的库房编号,调用的是KufangManageDaoImpl.Query1方法
	 * @param sql
	 * @throws SQLException
	 */
	public Vector Query1(String sql) throws SQLException;
	/**
	 * 实现库房的增加操作,调用的是KufangManageDaoImpl.Add方法
	 * @param room
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public boolean Add(Room room,String sql)throws SQLException;
	/**
	 * 实现库房的删除操作,调用的是KufangManageDaoImpl.Delete方法
	 * @param room
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public boolean Delete(Room room,String sql)throws SQLException;
	/**
	 * 实现库房的修改操作,调用的是KufangManageDaoImpl.Update方法
	 * @param room
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public boolean Update(Room room,String sql)throws SQLException;

}
