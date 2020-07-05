package cn.jsu.ww.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
/**
 * 管理员管理主界面
 * @author ww
 *
 */
public class Manager extends JFrame {
	// 声明对象
		public JFrame index;
		private JMenuBar management;
		private JMenu user;
		private JMenuItem usernews;
		private JMenuItem userupdate;
		private JMenuItem userdelete;
		private JMenuItem exit;

		// 创建构造函数
		public Manager(int fzr_id) {
			indexadmin();
			// 添加对象
			user.add(userupdate);
			user.add(usernews);
			user.add(userdelete);
			user.add(exit);
			management.add(user);
			init();
			action(fzr_id);
		}

		private void init() {
			// 初始化矿建index
			index = new JFrame("欢迎来到管理员用户系统");
			// 设置框架大小和位置
			index.setBounds(500, 100, 600, 500);
			index.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			// 将菜单栏设置进框架
			index.setJMenuBar(management);
			index.setLayout(null);
			setImage("E:\\主背景.jpg");
		}
	    public void setImage(String s)
	    {
	    	// 设置背景
	    			((JComponent) index.getContentPane()).setOpaque(false);
	    			ImageIcon img = null;
	    			img = new ImageIcon(s);
	    			JLabel background = new JLabel(img);
	    			index.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
	    			background.setBounds(0, 20, img.getIconWidth(), img.getIconHeight());
	    			index.setVisible(true);
	    }
		public void indexadmin() {
			// 初始化对象
			Font f = new Font("楷体", Font.BOLD, 15);
			management = new JMenuBar();
			user = new JMenu(" 用户管理");
			user.setFont(f);
			exit = new JMenuItem("退出");
			exit.setFont(f);
			usernews = new JMenuItem("增加管理员");
			usernews.setFont(f);
			userupdate = new JMenuItem("修改个人信息");
			userupdate.setFont(f);
			userdelete = new JMenuItem("删除管理员");
			userdelete.setFont(f);
		}
	/**
	 * 退出管理用户界面
	 * @param fzr_id
	 */
		private void action(int fzr_id) {
			exit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// 界面转换
					index.dispose();
					new Index(fzr_id);
				}
			});
			/**
			 * 跳转到增加用户界面
			 */
			usernews.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// 界面转换
					index.dispose();
					new Manageradd(fzr_id);
				}
			});
			/**
			 * 跳转到修改用户
			 */
			userupdate.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// 界面转换
					index.dispose();
					new Managerupdate(fzr_id);
				}
			});
			/**
			 * 删除用户界面
			 */
			userdelete.addActionListener(new ActionListener()
		    {
				public void actionPerformed(ActionEvent e) {
					// 界面转换
					index.dispose();
					new ManagerDelete(fzr_id);
				}
			});
		}
//		public static void main(String[] args) {
//			Index l = new Index(1);
//		}
}
