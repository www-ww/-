package cn.jsu.ww.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.jsu.ww.factory.ServiceFactory;
import cn.jsu.ww.vo.User;

/**
 * 用户登录界面
 * 
 * @author ww
 *
 */
public class Login extends JFrame {
	public Login() {
	}

	// 初始化字体
	Font d = new Font("楷体", Font.BOLD, 22);
	Font f = new Font("楷体", Font.BOLD, 15);
	// 初始化对象
	JFrame logingui = new JFrame("用户登录界面");
	JLabel userlogin = new JLabel("用户登录");
	JLabel username = new JLabel("用户名：");
	JLabel password = new JLabel("密 码：");
	JTextField name = new JTextField();
	JTextField pwd = new JPasswordField();
	JButton login = new JButton("登陆");
	// 给User类初始化对象user
	User user = new User();
	public void LoginGui() {
		// 设置对象
		logingui.setBounds(450, 200, 400, 300);
		// 设置退出
		logingui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 取消框架格式
		logingui.getContentPane().setLayout(null);
		// 设置位置、大小和字体
		userlogin.setBounds(140, 30, 150, 30);
		userlogin.setFont(d);
		username.setBounds(50, 80, 100, 30);
		username.setFont(f);
		password.setBounds(50, 120, 100, 30);
		password.setFont(f);
		name.setBounds(140, 80, 180, 30);
		name.setFont(f);
		pwd.setBounds(140, 120, 180, 30);
		login.setBounds(150, 200, 80, 30);
		login.setFont(f);
		// 添加对象
		logingui.getContentPane().add(userlogin);
		logingui.getContentPane().add(username);
		logingui.getContentPane().add(password);
		logingui.getContentPane().add(name);
		logingui.getContentPane().add(pwd);
		logingui.getContentPane().add(login);
		((JComponent) logingui.getContentPane()).setOpaque(false);
		ImageIcon img = null;
		img = new ImageIcon("E:\\登录背景.jpg");
		JLabel background = new JLabel(img);
		logingui.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 20, img.getIconWidth(), img.getIconHeight());
		logingui.setVisible(true);
		// 窗体可视化
		logingui.setVisible(true);
			// 给登录按钮设置监听事件
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 提取文本框里的用户名和密码
				String name_text = name.getText();
				String pwd_text = pwd.getText();
				// 将得到的值存入user对象里面
				user.setFzr_id(3);
				user.setUsername(name_text);
				user.setPassword(pwd_text);
				try {			
					int flag = ServiceFactory.getUserServiceInstance().Query(user, "select * from 用户  ");
					if (flag!=0) {
						// 文本提示框
						JOptionPane.showMessageDialog(null, "登陆成功");
						logingui.setVisible(false);	
						new Index(flag);
					} else {
						// 文本提示框
						JOptionPane.showMessageDialog(null, "登陆失败，请检查用户名和密码");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	public static void main(String[] args) {
		Login l = new Login();
		l.LoginGui();
	}
}
