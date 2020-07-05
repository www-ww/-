package cn.jsu.ww.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import cn.jsu.ww.dao.KufangManageDao;
import cn.jsu.ww.util.DB;
import cn.jsu.ww.vo.Goods;
import cn.jsu.ww.vo.Room;
/**
 * 库房管理
 * @author ww
 *
 */
public class KufangManageDaoImpl implements KufangManageDao {
	Connection conn;
	public KufangManageDaoImpl()
	{
		
	}
	/**
	 * 返回所有库房信息
	 */
	public Vector<Room> Query(String sql) throws SQLException {
		// TODO Auto-generated method stub
		try {
			conn=DB.getCon();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Vector vec = new Vector();
		PreparedStatement pra = conn.prepareStatement(sql);
		ResultSet rs = pra.executeQuery();
		vec.removeAllElements();
		while(rs.next()){
		Vector v = new Vector();
		v.add(rs.getInt("kf_id"));
		v.add(rs.getInt("fzr_id"));
		v.add(rs.getString("address"));
		vec.add(v);
		}
		return vec;
	}
	/**
	 * 返回库房所有的编号
	 */
	public Vector Query1(String sql) throws SQLException {
		// TODO Auto-generated method stub
		try {
			conn=DB.getCon();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//加载SQL语句
		PreparedStatement pra = conn.prepareStatement(sql);
		//返回库房所有的编号
		ResultSet rs = pra.executeQuery();
		Vector v=new Vector();
		v.removeAllElements();
		while(rs.next()) {
			v.add(rs.getInt("kf_id"));
		}
		return v;
	}
	public boolean Add(Room room, String sql) throws SQLException {
		// TODO Auto-generated method stub
		try {
			conn=DB.getCon();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement pra = conn.prepareStatement(sql);
		pra.setInt(1, room.getKf_id());
		pra.setInt(2, room.getFzr_id());
		pra.setString(3, room.getAddress());
		pra.executeUpdate();
		pra.close();
		return true;
	}
	/**
	 * 删除库房
	 */
	@Override
	public boolean Delete(Room room, String sql) throws SQLException {
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
	 * 修改库房
	 */
	@Override
	public boolean Update(Room room, String sql) throws SQLException {
		// TODO Auto-generated method stub
		try {
			conn = DB.getCon();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement pra = conn.prepareStatement(sql);
		pra.setInt(1, room.getKf_id());
		pra.setInt(2, room.getFzr_id());
		pra.setString(3, room.getAddress());
		pra.executeUpdate();
		pra.close();
		return true;
	}

}
