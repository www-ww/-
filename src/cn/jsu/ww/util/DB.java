package cn.jsu.ww.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * �������ݿ�������
 * @author ww
 *
 */
public class DB {
	private static String driverName="com.mysql.jdbc.Driver";
	private static Connection conn;
	private static String url="jdbc:mysql://localhost:3306/ks?useSSL=true";
	private static String user="root";
	private static String password="123456";
	public DB() throws ClassNotFoundException, SQLException
	{
		//��������
		Class.forName(driverName);
		conn=DriverManager.getConnection(url,user,password);
		
	}
	/**
	 * �������ݿ�����
	 * @return Connection
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static Connection getCon() throws ClassNotFoundException, SQLException
	{
		conn=null;
		if(conn==null)
		{
			new DB();
		}
		return conn;
	}
//	public static void main(String[] args) throws ClassNotFoundException, SQLException
//	{
//		
//		System.out.println(DB.getCon().getMetaData().getUserName());
//		DB.closeConn();
//		System.out.println("�ر�");
//	}
}
