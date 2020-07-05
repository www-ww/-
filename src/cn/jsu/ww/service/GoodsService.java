package cn.jsu.ww.service;

import java.sql.SQLException;
import java.util.Vector;

import cn.jsu.ww.vo.Goods;

public interface GoodsService {
	/**
	 * ʵ����Ʒ�Ĳ�ѯ����,���õ���GoodsManageDao.Query����
	 * @param sql
	 * @throws SQLException
	 */
	public Vector<Goods> Query(String sql) throws SQLException;
	/**
	 * ʵ����Ʒ�����Ӳ���,���õ���GoodsManageDao.Add����
	 * @param goods
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public boolean Add(Goods goods,String sql)throws SQLException;
	/**
	 * ʵ����Ʒ��ɾ������,���õ���GoodsManageDao.Delete����
	 * @param goods
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public boolean Delete(Goods goods,String sql)throws SQLException;
	/**
	 * ʵ����Ʒ���޸Ĳ���,���õ���GoodsManageDao.Query����
	 * @param goods
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public boolean Update(Goods goods,String sql)throws SQLException;
	

}
