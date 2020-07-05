package cn.jsu.ww.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import cn.jsu.ww.factory.DAOFactory;
import cn.jsu.ww.service.KufangService;
import cn.jsu.ww.util.DB;
import cn.jsu.ww.vo.Room;
/**
 * �ⷿ��������
 * @author ww
 *
 */
public class KufangServiceImpl implements KufangService {
	Connection dbc;
	@Override
	/**
	 * ���ؿⷿ����
	 */
	public Vector<Room> Query(String sql) throws SQLException {
		// TODO Auto-generated method stub
		Vector v=new Vector();
		try {
			dbc=DB.getCon();
			v=DAOFactory.getKufangInstance().Query(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			this.dbc.close();
		}
		return v;
	}
/**
 * ���ӿⷿ
 */
	@Override
	public boolean Add(Room room, String sql) throws SQLException {
		// TODO Auto-generated method stub
		try {
			dbc=DB.getCon();
			String sq="select * from �ⷿ  where kf_id=?";
			PreparedStatement pra = dbc.prepareStatement(sq);
			pra.setInt(1,room.getKf_id());
			ResultSet rs = pra.executeQuery();
			while(rs.next()){
				int id = rs.getInt("kf_id");
				if(id==room.getKf_id()) {
					this.dbc.close();
					return false;
				}
		} 
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			this.dbc.close();
		}
		return DAOFactory.getKufangInstance().Add(room, sql);	

	}
/**
 * ɾ���ⷿ
 */
	@Override
	public boolean Delete(Room room, String sql) throws SQLException {
		// TODO Auto-generated method stub
		try {
			dbc=DB.getCon();
			String sq="select * from �ⷿ where kf_id=?";
			PreparedStatement pra = dbc.prepareStatement(sq);
			pra.setInt(1, room.getKf_id());
			ResultSet rs = pra.executeQuery();
			while(rs.next()){
				int id = rs.getInt("kf_id");
				if(id==room.getKf_id()) {
					return DAOFactory.getKufangInstance().Delete(room, sql);	
		} 
		}
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			this.dbc.close();
		}
		
		return false;
	}
/**
 * �޸Ŀⷿ
 */
	@Override
	public boolean Update(Room room, String sql) throws SQLException {
		// TODO Auto-generated method stub
		try {
			dbc=DB.getCon();
			String sq="select * from �ⷿ where kf_id=?";
			PreparedStatement pra = dbc.prepareStatement(sq);
			pra.setInt(1, room.getKf_id());
			ResultSet rs = pra.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				if(id==room.getKf_id()) {
					return DAOFactory.getKufangInstance().Update(room, sql);
				}
		}
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			this.dbc.close();
		}
		return false;
	}
/**
 * ��ѯ���пⷿ���
 */
	@Override
	public Vector Query1(String sql) throws SQLException {
		// TODO Auto-generated method stub
		try {
			dbc=DB.getCon();
			return DAOFactory.getKufangInstance().Query1(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			this.dbc.close();
		}
		return null;
	}

}
