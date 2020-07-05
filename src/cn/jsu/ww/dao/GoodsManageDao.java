package cn.jsu.ww.dao;

import java.sql.SQLException;
import java.util.Vector;

import cn.jsu.ww.vo.Goods;

/**
 * 物品管理接口
 * @author ww
 *
 */
public interface GoodsManageDao {
	/**
	 * 查询方法
	 * @param sql
	 * @return 返回物品集合
	 * @throws SQLException
	 */
	public Vector<Goods> Query(String sql) throws SQLException;
	/**
	 * 增加方法
	 * @param goods
	 * @param sql
	 * @return返回是否增加成功
	 * @throws SQLException
	 */
	public boolean Add(Goods goods,String sql)throws SQLException;
	/**
	 * 删除方法
	 * @param goods
	 * @param sql
	 * @return是否删除成功
	 * @throws SQLException
	 */
	public boolean Delete(Goods goods,String sql)throws SQLException;
	/**
	 * 修改方法
	 * @param goods
	 * @param sql
	 * @return是否修改成功
	 * @throws SQLException
	 */
	public boolean Update(Goods goods,String sql)throws SQLException;
}
