package cn.jsu.ww.factory;

import cn.jsu.ww.service.CustomerService;
import cn.jsu.ww.service.GoodsService;
import cn.jsu.ww.service.KufangService;
import cn.jsu.ww.service.ManagerService;
import cn.jsu.ww.service.UserService;
import cn.jsu.ww.service.impl.CustomerServiceImpl;
import cn.jsu.ww.service.impl.GoodsServiceImpl;
import cn.jsu.ww.service.impl.KufangServiceImpl;
import cn.jsu.ww.service.impl.ManagerServiceImpl;
import cn.jsu.ww.service.impl.UserServiceImpl;

public class ServiceFactory {
public static UserService getUserServiceInstance() {
	return new UserServiceImpl();
}
public static GoodsService getGoodsServiceInstance() {
	return new GoodsServiceImpl();
}
public static KufangService getKufangServiceInstance()
{
	return new KufangServiceImpl();
}
public static CustomerService getCustomerInstance()
{
	return new CustomerServiceImpl();
}
public static ManagerService getManagerInstance()
{
	return new ManagerServiceImpl();
}
}

