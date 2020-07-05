package cn.jsu.ww.service;

import java.sql.SQLException;
import java.util.Vector;

import cn.jsu.ww.vo.Room;

public interface KufangService {
	/**
	 * ʵ�ֿⷿ�Ĳ�ѯ����,���õ���KufangManageDaoImpl.Query����
	 * @param sql
	 * @throws SQLException
	 */
	public Vector<Room> Query(String sql) throws SQLException;
	/**
	 * ��ѯ���еĿⷿ���,���õ���KufangManageDaoImpl.Query1����
	 * @param sql
	 * @throws SQLException
	 */
	public Vector Query1(String sql) throws SQLException;
	/**
	 * ʵ�ֿⷿ�����Ӳ���,���õ���KufangManageDaoImpl.Add����
	 * @param room
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public boolean Add(Room room,String sql)throws SQLException;
	/**
	 * ʵ�ֿⷿ��ɾ������,���õ���KufangManageDaoImpl.Delete����
	 * @param room
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public boolean Delete(Room room,String sql)throws SQLException;
	/**
	 * ʵ�ֿⷿ���޸Ĳ���,���õ���KufangManageDaoImpl.Update����
	 * @param room
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public boolean Update(Room room,String sql)throws SQLException;

}
