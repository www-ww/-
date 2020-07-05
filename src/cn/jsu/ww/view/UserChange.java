package cn.jsu.ww.view;

import java.awt.Font;
import java.awt.Toolkit;
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

import cn.jsu.ww.factory.DAOFactory;
import cn.jsu.ww.factory.ServiceFactory;
import cn.jsu.ww.vo.User;
/**
 * �޸��û�
 * @author ww
 *
 */
public class UserChange extends JFrame {

	JFrame a=new JFrame("�û��޸�");
	//JPane b=new JPane();
	JTextField uname;
	JTextField pass = new JPasswordField();
	User user = new User();
	public UserChange(int fzr_id) {
		init(fzr_id);
	}

	public void init(int fzr_id) {
		a.getContentPane().setLayout(null);
		a.setIconImage(Toolkit.getDefaultToolkit().getImage(UserChange.class.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
		a.setVisible(true);
		user.setFzr_id(fzr_id);
		Font d = new Font("����", Font.BOLD, 24);
		Font f = new Font("����", Font.BOLD, 18);
		JLabel usertitle = new JLabel("�޸��û������ID��" + fzr_id);
		JLabel username = new JLabel("��  ��  ����");
		uname = new JTextField();
		JLabel userpwd = new JLabel("��  ��  �룺");
		pass = new JTextField();
		JButton submit = new JButton("�޸�");
		JButton reset = new JButton("����");
		a.setBounds(600, 150, 600, 400);
		a.setFont(f);
		usertitle.setBounds(170, 60, 300, 40);
		usertitle.setFont(d);
		username.setBounds(170, 140, 140, 30);
		username.setFont(f);
		uname.setBounds(290, 140, 150, 30);
		uname.setFont(f);
		userpwd.setBounds(170, 219, 140, 30);
		userpwd.setFont(f);
		pass.setBounds(290, 220, 150, 30);
		pass.setFont(f);
		submit.setBounds(187, 289, 80, 30);
		submit.setFont(f);
		reset.setBounds(320, 289, 80, 30);
		reset.setFont(f);
		a.setBounds(500, 100, 600, 400);
		((JComponent) a.getContentPane()).setOpaque(false);
		ImageIcon img = null;
		img = new ImageIcon("E:\\������.jpg");
		JLabel background = new JLabel(img);
		a.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 20, img.getIconWidth(), img.getIconHeight());
		a.setVisible(true);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.getContentPane().add(usertitle);
		a.getContentPane().add(username);
		a.getContentPane().add(uname);
		a.getContentPane().add(userpwd);
		a.getContentPane().add(pass);
		a.getContentPane().add(submit);
		a.getContentPane().add(reset);	
		
	   
	reset.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO �Զ����ɵķ������
					uname.setText("");
					pass.setText("");
				}
			});
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				try {
						user.setUsername(uname.getText());
						user.setPassword(pass.getText());
						ServiceFactory.getUserServiceInstance().Update(user,"update �û� set username=?,password=? where fzr_id=" + fzr_id);
						JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
						a.dispose();
						new Index(fzr_id);
						
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
			}		
}
