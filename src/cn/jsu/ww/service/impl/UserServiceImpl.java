package cn.jsu.ww.service.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.jsu.ww.factory.DAOFactory;
import cn.jsu.ww.service.UserService;
import cn.jsu.ww.util.DB;
import cn.jsu.ww.vo.User;
/**
 * �û���������
 * @author ww
 *
 */
public class UserServiceImpl implements UserService{
private java.sql.Connection dbc;
	@Override
	/**
	 * ��ѯ�û�
	 */
	public int Query(User user, String sql) throws SQLException {
		// TODO Auto-generated method stub
		try {
			dbc=DB.getCon();
			return  DAOFactory.getUseInstance().Query(user, sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			this.dbc.close();
		}
		return 0;
	}

	@Override
	/**
	 * �����û�
	 */
	public boolean Add(User user, String sql) throws SQLException {
		// TODO Auto-generated method stub
		try {
			dbc=DB.getCon();
			String sq="select * from �û� where fzr_id=?";
			PreparedStatement pra = dbc.prepareStatement(sq);
			pra.setInt(1, user.getFzr_id());
			ResultSet rs = pra.executeQuery();
			while(rs.next()){
				int id = rs.getInt("fzr_id");
				if(id==user.getFzr_id()) {
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
		return DAOFactory.getUseInstance().Add(user, sql);	
	}

	@Override
	/**
	 * ɾ���û�
	 */
	public boolean Delete(User user, String sql) throws SQLException {
		// TODO Auto-generated method stub
		try {
			dbc=DB.getCon();
			String sq="select * from �û� where fzr_id=?";
			PreparedStatement pra = dbc.prepareStatement(sq);
			pra.setInt(1, user.getFzr_id());
			ResultSet rs = pra.executeQuery();
			while(rs.next()){
				int id = rs.getInt("fzr_id");
				if(id==user.getFzr_id()) {
					return DAOFactory.getUseInstance().Delete(user, sql);	
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

	@Override
	/**
	 * �޸��û�
	 */
	public boolean Update(User user, String sql) throws SQLException {
		// TODO Auto-generated method stub
		try {
			dbc=DB.getCon();
			String sq="select * from �û� where fzr_id=?";
			PreparedStatement pra = dbc.prepareStatement(sq);
			pra.setInt(1, user.getFzr_id());
			ResultSet rs = pra.executeQuery();
			while(rs.next()){
				int id = rs.getInt("fzr_id");
				if(id==user.getFzr_id()) {
					return DAOFactory.getUseInstance().Update(user, sql);
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

	@Override
	/**
	 * ��ѯ�����û�
	 */
	public User Query1(User user, String sql) throws SQLException {
		// TODO Auto-generated method stub
		try {
			dbc=DB.getCon();
			return  DAOFactory.getUseInstance().Query1(user, sql);
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
