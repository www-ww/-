package cn.jsu.ww.service;

import java.sql.SQLException;
import java.util.Vector;

import cn.jsu.ww.vo.Goods;

public interface GoodsService {
	/**
	 * 实现物品的查询操作,调用的是GoodsManageDao.Query方法
	 * @param sql
	 * @throws SQLException
	 */
	public Vector<Goods> Query(String sql) throws SQLException;
	/**
	 * 实现物品的增加操作,调用的是GoodsManageDao.Add方法
	 * @param goods
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public boolean Add(Goods goods,String sql)throws SQLException;
	/**
	 * 实现物品的删除操作,调用的是GoodsManageDao.Delete方法
	 * @param goods
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public boolean Delete(Goods goods,String sql)throws SQLException;
	/**
	 * 实现物品的修改操作,调用的是GoodsManageDao.Query方法
	 * @param goods
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public boolean Update(Goods goods,String sql)throws SQLException;
	

}
