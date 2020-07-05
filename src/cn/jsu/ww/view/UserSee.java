package cn.jsu.ww.view;

import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;

import cn.jsu.ww.factory.DAOFactory;
import cn.jsu.ww.factory.ServiceFactory;
import cn.jsu.ww.vo.User;
/**
 * 查看用户信息
 * @author ww
 *
 */
public class UserSee extends Index{
	//声明对象
		JLabel uname;
		JLabel pwd;
		JLabel style;
		//为User类初始化user对象
		User user = new User();
		
		//构造函数
		public UserSee(int fzr_id) {
			super(fzr_id);
			init();
			//将用户名设置进user对象
			try {
				user=ServiceFactory.getUserServiceInstance().Query1(user, "select * from 用户 where fzr_id= "+fzr_id);
				uname.setText(user.getUsername());
				pwd.setText(user.getPassword());
				style.setText(Integer.toString(fzr_id));
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		public void init() {
			//初始化字体
			Font d = new Font("楷体", Font.BOLD, 24);
			Font f = new Font("楷体", Font.BOLD, 18);
			//初始化对象
			JLabel usertitle = new JLabel("当前用户信息");
			JLabel username = new JLabel("用户名：");
			uname = new JLabel();
			JLabel userpwd = new JLabel("密  码：");
			pwd = new JLabel();
			JLabel userstyle = new JLabel("用户id:");
			style = new JLabel();
			//设置对象大小、位置和字体
			usertitle.setBounds(250, 60, 200, 40);
			usertitle.setFont(d);
			username.setBounds(260, 130, 80, 30);
			username.setFont(f);
			uname.setBounds(340, 130, 150, 30);
			uname.setFont(f);
			userpwd.setBounds(260, 190, 80, 30);
			userpwd.setFont(f);
			pwd.setBounds(340, 190, 150, 30);
			pwd.setFont(f);
			userstyle.setBounds(260, 250, 80, 30);
			userstyle.setFont(f);
			style.setBounds(340, 250, 80, 30);
			style.setFont(f);
			uname.setBounds(340, 130, 150, 30);
			uname.setFont(f);
			//将对象添加进框架
			index.add(usertitle);
			index.add(username);
			index.add(uname);
			index.add(userpwd);
			index.add(pwd);
			index.add(style);
			index.add(userstyle);
		
		}
}
