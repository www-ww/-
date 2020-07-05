package cn.jsu.ww.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import cn.jsu.ww.dao.GoodsManageDao;
import cn.jsu.ww.util.DB;
import cn.jsu.ww.vo.Goods;

/**
 * 物品管理实现类
 * 
 * @author hp
 *
 */
public class GoodsManageDaoImpl implements GoodsManageDao {
	Connection conn;
	public GoodsManageDaoImpl() {

	}
	@Override
	/**
	 * 查询物品
	 */
	public Vector<Goods> Query(String sql) throws SQLException {
		// TODO Auto-generated method stub
	     	try {
				conn=DB.getCon();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     	Vector vec=new Vector();
			PreparedStatement pra = conn.prepareStatement(sql);
			ResultSet rs = pra.executeQuery();
			vec.removeAllElements();
			while(rs.next()){
			Vector v = new Vector();
			v.add(rs.getInt("id"));
			v.add(rs.getInt("ghs_id"));
			v.add(rs.getInt("number"));
			v.add(rs.getDate("in_date"));
			v.add(rs.getString("type"));
			v.add(rs.getString("name"));
			v.add(rs.getInt("kf_id"));
			vec.add(v);
			}
			return vec;
	}
	/**
	 * 增加物品
	 */
	@Override
	public boolean Add(Goods goods, String sql) throws SQLException {
		// TODO Auto-generated method stub
		try {
			conn=DB.getCon();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement pra = conn.prepareStatement(sql);
		pra.setInt(1, goods.getId());
		pra.setInt(2, goods.getGhs_id());
		pra.setInt(3, goods.getNumber());
		pra.setDate(4, (Date) goods.getIn_date());
		pra.setString(5, goods.getType());
		pra.setString(6, goods.getName());
		pra.setInt(7, goods.getKf_id());
		pra.executeUpdate();
		pra.close();
		return true;
	}
	/**
	 * 删除物品
	 */
	@Override
	public boolean Delete(Goods goods,String sql) throws SQLException {
		// TODO Auto-generated method stub
		try {
			conn = DB.getCon();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement pra = conn.prepareStatement(sql);
		pra.executeUpdate();
		pra.close();
		return true;
	}
	/**
	 * 修改物品信息
	 */
	@Override
	public boolean Update(Goods goods, String sql) throws SQLException {
		// TODO Auto-generated method stub
		try {
			conn = DB.getCon();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement pra = conn.prepareStatement(sql);
		pra.setInt(1, goods.getGhs_id());
		pra.setInt(2, goods.getNumber());
		pra.setDate(3, (Date) goods.getIn_date());
		pra.setString(4, goods.getType());
		pra.setString(5, goods.getName());
		pra.setInt(6, goods.getKf_id());
		pra.executeUpdate();
		pra.close();
		return true;
	}	
//	public static void main(String[] args) throws SQLException
//	{
//		GoodsManageDaoImpl a=new GoodsManageDaoImpl();
//		a.Query("select * from 物品  where id=? and ghs_id=? and number=? and in_date=? and type=? and name=? and kf_id=?");
//	}
	

}
