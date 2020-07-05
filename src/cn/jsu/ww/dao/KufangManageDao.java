package cn.jsu.ww.dao;

import java.sql.SQLException;
import java.util.Vector;

import cn.jsu.ww.vo.Room;
/**
 * �ⷿ����
 * @author ww
 *
 */
public interface KufangManageDao {
	/**
	 * �ⷿ��ѯ
	 * @param sql
	 * @return���ؿⷿ����
	 * @throws SQLException
	 */
	public Vector<Room> Query(String sql) throws SQLException;
	/**
	 * �ⷿ����
	 * @param room
	 * @param sql
	 * @return�Ƿ����ӳɹ�
	 * @throws SQLException
	 */
	public boolean Add(Room room,String sql)throws SQLException;
	/**
	 * �ⷿɾ��
	 * @param room
	 * @param sql
	 * @return�Ƿ�ɾ���ɹ�
	 * @throws SQLException
	 */
	public boolean Delete(Room room,String sql)throws SQLException;
	/**
	 * �ⷿ�޸�
	 * @param room
	 * @param sql
	 * @return�Ƿ��޸ĳɹ�
	 * @throws SQLException
	 */
	public boolean Update(Room room,String sql)throws SQLException;
	/**
	 * ���ҿⷿ���
	 * @param sql
	 * @return���ؿⷿ������id
	 * @throws SQLException
	 */
	public Vector Query1(String sql)throws SQLException;
}
