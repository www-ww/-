package cn.jsu.ww.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.jsu.ww.dao.CustomerDao;
import cn.jsu.ww.util.DB;
import cn.jsu.ww.vo.Client;
import cn.jsu.ww.vo.Goods;
/**
 * 客户管理类
 * @author ww
 *
 */
public class CustomerDaoImpl implements CustomerDao {
	Connection conn;
	public CustomerDaoImpl() {

	}
	/**
	 * 增加用户
	 */
	@Override
	public boolean Add(Client cli, String sql) throws SQLException {
		// TODO Auto-generated method stub
		try {
			conn=DB.getCon();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement pra = conn.prepareStatement(sql);
		pra.setInt(1, cli.getKh_id());
		pra.setString(2, cli.getPhone());
		pra.setString(3, cli.getAddress());
		pra.setString(4, cli.getRemark());
		pra.setString(5, cli.getName());
		pra.setInt(6, cli.getId());
		pra.setInt(7, cli.getNumber());
		pra.executeUpdate();
		pra.close();
		return true;
	}
	

}
