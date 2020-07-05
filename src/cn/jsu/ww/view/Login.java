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
 * �û���¼����
 * 
 * @author ww
 *
 */
public class Login extends JFrame {
	public Login() {
	}

	// ��ʼ������
	Font d = new Font("����", Font.BOLD, 22);
	Font f = new Font("����", Font.BOLD, 15);
	// ��ʼ������
	JFrame logingui = new JFrame("�û���¼����");
	JLabel userlogin = new JLabel("�û���¼");
	JLabel username = new JLabel("�û�����");
	JLabel password = new JLabel("�� �룺");
	JTextField name = new JTextField();
	JTextField pwd = new JPasswordField();
	JButton login = new JButton("��½");
	// ��User���ʼ������user
	User user = new User();
	public void LoginGui() {
		// ���ö���
		logingui.setBounds(450, 200, 400, 300);
		// �����˳�
		logingui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ȡ����ܸ�ʽ
		logingui.getContentPane().setLayout(null);
		// ����λ�á���С������
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
		// ��Ӷ���
		logingui.getContentPane().add(userlogin);
		logingui.getContentPane().add(username);
		logingui.getContentPane().add(password);
		logingui.getContentPane().add(name);
		logingui.getContentPane().add(pwd);
		logingui.getContentPane().add(login);
		((JComponent) logingui.getContentPane()).setOpaque(false);
		ImageIcon img = null;
		img = new ImageIcon("E:\\��¼����.jpg");
		JLabel background = new JLabel(img);
		logingui.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 20, img.getIconWidth(), img.getIconHeight());
		logingui.setVisible(true);
		// ������ӻ�
		logingui.setVisible(true);
			// ����¼��ť���ü����¼�
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ��ȡ�ı�������û���������
				String name_text = name.getText();
				String pwd_text = pwd.getText();
				// ���õ���ֵ����user��������
				user.setFzr_id(3);
				user.setUsername(name_text);
				user.setPassword(pwd_text);
				try {			
					int flag = ServiceFactory.getUserServiceInstance().Query(user, "select * from �û�  ");
					if (flag!=0) {
						// �ı���ʾ��
						JOptionPane.showMessageDialog(null, "��½�ɹ�");
						logingui.setVisible(false);	
						new Index(flag);
					} else {
						// �ı���ʾ��
						JOptionPane.showMessageDialog(null, "��½ʧ�ܣ������û���������");
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
