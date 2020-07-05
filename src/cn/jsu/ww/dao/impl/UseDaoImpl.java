package cn.jsu.ww.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.jsu.ww.dao.UseDao;
import cn.jsu.ww.util.DB;
import cn.jsu.ww.vo.User;

/**
 * �û���¼ʵ����
 * 
 * @author ww
 *
 */
public class UseDaoImpl implements UseDao {
	Connection conn;

	public UseDaoImpl() {

	}

	/**
	 * ��ѯ��������¼
	 */
	@Override
	public int Query(User user, String sql) throws SQLException {
		// TODO Auto-generated method stub
		// ��ȡ���ݿ�����
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
	 * ����û�����
	 */
	public boolean Add(User user, String sql) throws SQLException {
		// TODO Auto-generated method stub
		// ��ȡ���ݿ�����
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
	 * ɾ���û�����
	 */
	@Override
	public boolean Delete(User user, String sql) throws SQLException {
		// TODO Auto-generated method stub
		// ��ȡ���ݿ�����
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
	 * �޸��û���Ϣ
	 * 
	 * @return
	 */
	@Override
	public boolean Update(User user, String sql) throws SQLException {
		// TODO Auto-generated method stub
		// ��ȡ���ݿ�����
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
 * �����û�
 */
	public User Query1(User user, String sql) throws SQLException {
		// TODO Auto-generated method stub
		// ��ȡ���ݿ�����
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
//		a.setUsername("����");
//		a.setPassword("123");
//		UseDaoImpl b = new UseDaoImpl();
//		// ��ѯ"select * from �û� where username=? and password=?"
//		// ��� "insert into �û�(fzr_id,password,username) values(?,?,?)" ���������ظ�
//		// �޸�"update �û� set username=?,password=? where fzr_id=?"
//		// 
//		//String h="update �û� set username=?,password=? where"+" fzr_id="+a.getFzr_id();
//		boolean s = b.Delete(a,"delete from �û� where fzr_id=4" );
//		System.out.println(s);
//	}

}
