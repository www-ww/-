package cn.jsu.ww.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.jsu.ww.dao.UseDao;
import cn.jsu.ww.util.DB;
import cn.jsu.ww.vo.User;

/**
 * 用户登录实现类
 * 
 * @author ww
 *
 */
public class UseDaoImpl implements UseDao {
	Connection conn;

	public UseDaoImpl() {

	}

	/**
	 * 查询方法检查登录
	 */
	@Override
	public int Query(User user, String sql) throws SQLException {
		// TODO Auto-generated method stub
		// 获取数据库连接
		try {
			conn = DB.getCon();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement pra = conn.prepareStatement(sql);
		ResultSet rs = pra.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("fzr_id");
			String name = rs.getString("username");
			String pass = rs.getString("password");
			if (name.equals(user.getUsername()) && pass.equals(user.getPassword())) {
				user.setFzr_id(id);
				user.setPassword(pass);
				user.setUsername(name);
				return id;
			}
		}
		return 0;
	}

	@Override
	/**
	 * 添加用户方法
	 */
	public boolean Add(User user, String sql) throws SQLException {
		// TODO Auto-generated method stub
		// 获取数据库连接
		try {
			conn = DB.getCon();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement pra = conn.prepareStatement(sql);
		pra.setInt(1, user.getFzr_id());
		pra.setString(2, user.getPassword());
		pra.setString(3, user.getUsername());
		pra.executeUpdate();
		pra.close();
		return true;
	}

	/**
	 * 删除用户方法
	 */
	@Override
	public boolean Delete(User user, String sql) throws SQLException {
		// TODO Auto-generated method stub
		// 获取数据库连接
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
	 * 修改用户信息
	 * 
	 * @return
	 */
	@Override
	public boolean Update(User user, String sql) throws SQLException {
		// TODO Auto-generated method stub
		// 获取数据库连接
		try {
			conn = DB.getCon();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement pra = conn.prepareStatement(sql);
		pra.setString(1, user.getUsername());
		pra.setString(2, user.getPassword());
		pra.executeUpdate();
		pra.close();
		return true;
	}
/**
 * 返回用户
 */
	public User Query1(User user, String sql) throws SQLException {
		// TODO Auto-generated method stub
		// 获取数据库连接
		try {
			conn = DB.getCon();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement pra = conn.prepareStatement(sql);
		ResultSet rs = pra.executeQuery();
		while(rs.next())
		{
		int id = rs.getInt("fzr_id");
		String name = rs.getString("username");
		String pass = rs.getString("password");
		user.setFzr_id(id);
		user.setPassword(pass);
		user.setUsername(name);
		}
		return user;
	}

//	public static void main(String[] args) throws SQLException {
//		// TODO Auto-generated method stub
//		User a = new User();
//		a.setFzr_id(4);
//		a.setUsername("李周");
//		a.setPassword("123");
//		UseDaoImpl b = new UseDaoImpl();
//		// 查询"select * from 用户 where username=? and password=?"
//		// 添加 "insert into 用户(fzr_id,password,username) values(?,?,?)" 主键不能重复
//		// 修改"update 用户 set username=?,password=? where fzr_id=?"
//		// 
//		//String h="update 用户 set username=?,password=? where"+" fzr_id="+a.getFzr_id();
//		boolean s = b.Delete(a,"delete from 用户 where fzr_id=4" );
//		System.out.println(s);
//	}

}
