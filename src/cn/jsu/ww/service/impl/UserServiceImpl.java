package cn.jsu.ww.service.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.jsu.ww.factory.DAOFactory;
import cn.jsu.ww.service.UserService;
import cn.jsu.ww.util.DB;
import cn.jsu.ww.vo.User;
/**
 * 用户管理服务层
 * @author ww
 *
 */
public class UserServiceImpl implements UserService{
private java.sql.Connection dbc;
	@Override
	/**
	 * 查询用户
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
	 * 增加用户
	 */
	public boolean Add(User user, String sql) throws SQLException {
		// TODO Auto-generated method stub
		try {
			dbc=DB.getCon();
			String sq="select * from 用户 where fzr_id=?";
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
	 * 删除用户
	 */
	public boolean Delete(User user, String sql) throws SQLException {
		// TODO Auto-generated method stub
		try {
			dbc=DB.getCon();
			String sq="select * from 用户 where fzr_id=?";
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
	 * 修改用户
	 */
	public boolean Update(User user, String sql) throws SQLException {
		// TODO Auto-generated method stub
		try {
			dbc=DB.getCon();
			String sq="select * from 用户 where fzr_id=?";
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
	 * 查询返回用户
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
