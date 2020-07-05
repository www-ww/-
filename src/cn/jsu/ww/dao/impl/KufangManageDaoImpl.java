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
 * �ⷿ����
 * @author ww
 *
 */
public class KufangManageDaoImpl implements KufangManageDao {
	Connection conn;
	public KufangManageDaoImpl()
	{
		
	}
	/**
	 * �������пⷿ��Ϣ
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
	 * ���ؿⷿ���еı��
	 */
	public Vector Query1(String sql) throws SQLException {
		// TODO Auto-generated method stub
		try {
			conn=DB.getCon();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����SQL���
		PreparedStatement pra = conn.prepareStatement(sql);
		//���ؿⷿ���еı��
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
	 * ɾ���ⷿ
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
	 * �޸Ŀⷿ
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
