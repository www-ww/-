package cn.jsu.ww.view;

import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;

import cn.jsu.ww.factory.DAOFactory;
import cn.jsu.ww.factory.ServiceFactory;
import cn.jsu.ww.vo.User;
/**
 * �鿴�û���Ϣ
 * @author ww
 *
 */
public class UserSee extends Index{
	//��������
		JLabel uname;
		JLabel pwd;
		JLabel style;
		//ΪUser���ʼ��user����
		User user = new User();
		
		//���캯��
		public UserSee(int fzr_id) {
			super(fzr_id);
			init();
			//���û������ý�user����
			try {
				user=ServiceFactory.getUserServiceInstance().Query1(user, "select * from �û� where fzr_id= "+fzr_id);
				uname.setText(user.getUsername());
				pwd.setText(user.getPassword());
				style.setText(Integer.toString(fzr_id));
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		
		public void init() {
			//��ʼ������
			Font d = new Font("����", Font.BOLD, 24);
			Font f = new Font("����", Font.BOLD, 18);
			//��ʼ������
			JLabel usertitle = new JLabel("��ǰ�û���Ϣ");
			JLabel username = new JLabel("�û�����");
			uname = new JLabel();
			JLabel userpwd = new JLabel("��  �룺");
			pwd = new JLabel();
			JLabel userstyle = new JLabel("�û�id:");
			style = new JLabel();
			//���ö����С��λ�ú�����
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
			//��������ӽ����
			index.add(usertitle);
			index.add(username);
			index.add(uname);
			index.add(userpwd);
			index.add(pwd);
			index.add(style);
			index.add(userstyle);
		
		}
}
