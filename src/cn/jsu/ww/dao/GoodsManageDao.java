package cn.jsu.ww.dao;

import java.sql.SQLException;
import java.util.Vector;

import cn.jsu.ww.vo.Goods;

/**
 * ��Ʒ����ӿ�
 * @author ww
 *
 */
public interface GoodsManageDao {
	/**
	 * ��ѯ����
	 * @param sql
	 * @return ������Ʒ����
	 * @throws SQLException
	 */
	public Vector<Goods> Query(String sql) throws SQLException;
	/**
	 * ���ӷ���
	 * @param goods
	 * @param sql
	 * @return�����Ƿ����ӳɹ�
	 * @throws SQLException
	 */
	public boolean Add(Goods goods,String sql)throws SQLException;
	/**
	 * ɾ������
	 * @param goods
	 * @param sql
	 * @return�Ƿ�ɾ���ɹ�
	 * @throws SQLException
	 */
	public boolean Delete(Goods goods,String sql)throws SQLException;
	/**
	 * �޸ķ���
	 * @param goods
	 * @param sql
	 * @return�Ƿ��޸ĳɹ�
	 * @throws SQLException
	 */
	public boolean Update(Goods goods,String sql)throws SQLException;
}
