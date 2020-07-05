package cn.jsu.ww.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.jsu.ww.factory.DAOFactory;
import cn.jsu.ww.service.CustomerService;
import cn.jsu.ww.util.DB;
import cn.jsu.ww.vo.Client;
/**
 * 客户管理类
 * @author ww
 *
 */
public class CustomerServiceImpl implements CustomerService {
	Connection dbc;
	@Override
	/**
	 * 增加客户
	 */
	public boolean Add(Client cli, String sql) throws SQLException {
		// TODO Auto-generated method stub
		try {
			dbc=DB.getCon();
			String sq="select * from 客户 where kh_id=?";
			PreparedStatement pra = dbc.prepareStatement(sq);
			pra.setInt(1, cli.getKh_id());
			ResultSet rs = pra.executeQuery();
			while(rs.next()){
				int id = rs.getInt("kh_id");
				if(id==cli.getId()) {
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
		return DAOFactory.getCustomerInstance().Add(cli, sql);	
}
}
