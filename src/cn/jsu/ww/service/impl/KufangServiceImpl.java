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
 * 库房管理服务层
 * @author ww
 *
 */
public class KufangServiceImpl implements KufangService {
	Connection dbc;
	@Override
	/**
	 * 返回库房集合
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
 * 增加库房
 */
	@Override
	public boolean Add(Room room, String sql) throws SQLException {
		// TODO Auto-generated method stub
		try {
			dbc=DB.getCon();
			String sq="select * from 库房  where kf_id=?";
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
 * 删除库房
 */
	@Override
	public boolean Delete(Room room, String sql) throws SQLException {
		// TODO Auto-generated method stub
		try {
			dbc=DB.getCon();
			String sq="select * from 库房 where kf_id=?";
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
 * 修改库房
 */
	@Override
	public boolean Update(Room room, String sql) throws SQLException {
		// TODO Auto-generated method stub
		try {
			dbc=DB.getCon();
			String sq="select * from 库房 where kf_id=?";
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
 * 查询所有库房编号
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
