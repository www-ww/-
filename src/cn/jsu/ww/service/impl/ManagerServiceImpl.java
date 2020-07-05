package cn.jsu.ww.service.impl;

import cn.jsu.ww.factory.DAOFactory;
import cn.jsu.ww.service.ManagerService;

public class ManagerServiceImpl implements ManagerService{
	/**
	 * 实现管理员账号密码的查询操作,调用的是ManagerDao.Add方法
	 * @param s
	 * @param filepath
	 * @return
	 * @throws Exception
	 */
	public boolean Query(String s,String filepath) throws Exception
	{
		return DAOFactory.getManagerInstance().Query(s, filepath);
	}
	/**
	 * 实现管理员的增加操作,调用的是ManagerDao.Add方法
	 * @param s
	 * @param filepath
	 * @return
	 * @throws Exception
	 */
	public boolean Add(String s,String filepath)throws Exception
	{
		return DAOFactory.getManagerInstance().Add(s, filepath);
	}
	/**
	 * 实现管理员的删除操作,调用的是ManagerDao.Delete方法
	 * @param s
	 * @param filepath
	 * @return
	 * @throws Exception
	 */
	public boolean Delete(String s,String filepath)throws Exception
	{
		return DAOFactory.getManagerInstance().Delete(s, filepath);

	}
	/**
	 * 实现管理员的修改操作,调用的是ManagerDao.Update方法
	 * @param old
	 * @param news
	 * @param filepath
	 * @return
	 * @throws Exception
	 */
	public boolean Update(String s, String filepath)throws Exception
	{
		return DAOFactory.getManagerInstance().Update(s,filepath);

	}
}
