package cn.jsu.ww.factory;

import cn.jsu.ww.dao.CustomerDao;
import cn.jsu.ww.dao.GoodsManageDao;
import cn.jsu.ww.dao.KufangManageDao;
import cn.jsu.ww.dao.ManagerDao;
import cn.jsu.ww.dao.UseDao;
import cn.jsu.ww.dao.impl.CustomerDaoImpl;
import cn.jsu.ww.dao.impl.GoodsManageDaoImpl;
import cn.jsu.ww.dao.impl.KufangManageDaoImpl;
import cn.jsu.ww.dao.impl.ManagerDaoimpl;
import cn.jsu.ww.dao.impl.UseDaoImpl;


public class DAOFactory {
public static ManagerDao getManagerInstance()
{
	return new ManagerDaoimpl();
	
}
public static UseDao getUseInstance()
{
	return new UseDaoImpl();
}
public static GoodsManageDao getGoodsInstance()
{
	return new GoodsManageDaoImpl();
}
public static KufangManageDao getKufangInstance()
{
	return new KufangManageDaoImpl();
}
public static CustomerDao getCustomerInstance()
{
	return new CustomerDaoImpl();
}
}
