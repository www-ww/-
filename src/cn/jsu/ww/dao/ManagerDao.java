package cn.jsu.ww.dao;

import java.sql.SQLException;

import cn.jsu.ww.vo.Room;
import cn.jsu.ww.vo.User;
/**
 * 管理员用户管理IO
 * @author ww
 *
 */
public interface ManagerDao {
	/**
	 * 账户查询
	 * @param s
	 * @param filepath
	 * @return是否查询成功
	 * @throws Exception
	 */
	public boolean Query(String s,String filepath) throws Exception;
	/**
	 * 账户增加
	 * @param s
	 * @param filepath
	 * @return是否增加成功
	 * @throws Exception
	 */
	public boolean Add(String s,String filepath)throws Exception;
	/**
	 * 账户删除
	 * @param s
	 * @param filepath
	 * @return是否删除成功
	 * @throws Exception
	 */
	public boolean Delete(String s,String filepath)throws Exception;
	public boolean Update(String s, String filepath)throws Exception;
}
