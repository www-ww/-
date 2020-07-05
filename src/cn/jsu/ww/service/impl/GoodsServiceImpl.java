package cn.jsu.ww.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import cn.jsu.ww.factory.DAOFactory;
import cn.jsu.ww.service.GoodsService;
import cn.jsu.ww.util.DB;
import cn.jsu.ww.vo.Goods;
/**
 * ��Ʒ�����������
 * @author ww
 *
 */
public class GoodsServiceImpl implements GoodsService {
	Connection dbc;
	@Override
	/**
	 * ��Ʒ��ѯ
	 */
	public Vector<Goods> Query(String sql) throws SQLException {
		// TODO Auto-generated method stub
		Vector vec=new Vector();
		try {
			dbc=DB.getCon();
			vec=DAOFactory.getGoodsInstance().Query(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			this.dbc.close();
		}
		return vec;
	}
/**
 * ������Ʒ
 */
	@Override
	public boolean Add(Goods goods, String sql) throws SQLException {
		// TODO Auto-generated method stub
		try {
			dbc=DB.getCon();
			String sq="select * from ��Ʒ where id=?";
			PreparedStatement pra = dbc.prepareStatement(sq);
			pra.setInt(1, goods.getId());
			ResultSet rs = pra.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				if(id==goods.getId()) {
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
		return DAOFactory.getGoodsInstance().Add(goods, sql);	
	}
/**
 * ɾ����Ʒ
 */
	@Override
	public boolean Delete(Goods goods, String sql) throws SQLException {
		// TODO Auto-generated method stub
		try {
			dbc=DB.getCon();
			String sq="select * from ��Ʒ where id=?";
			PreparedStatement pra = dbc.prepareStatement(sq);
			pra.setInt(1, goods.getId());
			ResultSet rs = pra.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				if(id==goods.getId()) {
					return DAOFactory.getGoodsInstance().Delete(goods, sql);	
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
 * �޸���Ʒ
 */
	@Override
	public boolean Update(Goods goods, String sql) throws SQLException {
		// TODO Auto-generated method stub
		try {
			dbc=DB.getCon();
			String sq="select * from ��Ʒ where id=?";
			PreparedStatement pra = dbc.prepareStatement(sq);
			pra.setInt(1, goods.getId());
			ResultSet rs = pra.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				if(id==goods.getId()) {
					return DAOFactory.getGoodsInstance().Update(goods, sql);
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
}
