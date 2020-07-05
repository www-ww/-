package cn.jsu.ww.service;

public interface ManagerService {
	/**
	 * 实现管理员账号密码的查询操作,调用的是ManagerDao.Add方法
	 * @param s
	 * @param filepath
	 * @return
	 * @throws Exception
	 */
	public boolean Query(String s,String filepath) throws Exception;
	/**
	 * 实现管理员的增加操作,调用的是ManagerDao.Add方法
	 * @param s
	 * @param filepath
	 * @return
	 * @throws Exception
	 */
	public boolean Add(String s,String filepath)throws Exception;
	/**
	 * 实现管理员的删除操作,调用的是ManagerDao.Delete方法
	 * @param s
	 * @param filepath
	 * @return
	 * @throws Exception
	 */
	public boolean Delete(String s,String filepath)throws Exception;
	/**
	 * 实现管理员的修改操作,调用的是ManagerDao.Update方法
	 * @param old
	 * @param news
	 * @param filepath
	 * @return
	 * @throws Exception
	 */
	public boolean Update(String s, String filepath)throws Exception;
}
