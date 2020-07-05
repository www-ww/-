package cn.jsu.ww.dao;

import java.sql.SQLException;
import java.util.Vector;

import cn.jsu.ww.vo.Room;
/**
 * 库房管理
 * @author ww
 *
 */
public interface KufangManageDao {
	/**
	 * 库房查询
	 * @param sql
	 * @return返回库房集合
	 * @throws SQLException
	 */
	public Vector<Room> Query(String sql) throws SQLException;
	/**
	 * 库房增加
	 * @param room
	 * @param sql
	 * @return是否增加成功
	 * @throws SQLException
	 */
	public boolean Add(Room room,String sql)throws SQLException;
	/**
	 * 库房删除
	 * @param room
	 * @param sql
	 * @return是否删除成功
	 * @throws SQLException
	 */
	public boolean Delete(Room room,String sql)throws SQLException;
	/**
	 * 库房修改
	 * @param room
	 * @param sql
	 * @return是否修改成功
	 * @throws SQLException
	 */
	public boolean Update(Room room,String sql)throws SQLException;
	/**
	 * 查找库房编号
	 * @param sql
	 * @return返回库房的所有id
	 * @throws SQLException
	 */
	public Vector Query1(String sql)throws SQLException;
}
