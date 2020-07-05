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
 * ����Ա����������
 * @author ww
 *
 */
public class Manager extends JFrame {
	// ��������
		public JFrame index;
		private JMenuBar management;
		private JMenu user;
		private JMenuItem usernews;
		private JMenuItem userupdate;
		private JMenuItem userdelete;
		private JMenuItem exit;

		// �������캯��
		public Manager(int fzr_id) {
			indexadmin();
			// ��Ӷ���
			user.add(userupdate);
			user.add(usernews);
			user.add(userdelete);
			user.add(exit);
			management.add(user);
			init();
			action(fzr_id);
		}

		private void init() {
			// ��ʼ����index
			index = new JFrame("��ӭ��������Ա�û�ϵͳ");
			// ���ÿ�ܴ�С��λ��
			index.setBounds(500, 100, 600, 500);
			index.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			// ���˵������ý����
			index.setJMenuBar(management);
			index.setLayout(null);
			setImage("E:\\������.jpg");
		}
	    public void setImage(String s)
	    {
	    	// ���ñ���
	    			((JComponent) index.getContentPane()).setOpaque(false);
	    			ImageIcon img = null;
	    			img = new ImageIcon(s);
	    			JLabel background = new JLabel(img);
	    			index.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
	    			background.setBounds(0, 20, img.getIconWidth(), img.getIconHeight());
	    			index.setVisible(true);
	    }
		public void indexadmin() {
			// ��ʼ������
			Font f = new Font("����", Font.BOLD, 15);
			management = new JMenuBar();
			user = new JMenu(" �û�����");
			user.setFont(f);
			exit = new JMenuItem("�˳�");
			exit.setFont(f);
			usernews = new JMenuItem("���ӹ���Ա");
			usernews.setFont(f);
			userupdate = new JMenuItem("�޸ĸ�����Ϣ");
			userupdate.setFont(f);
			userdelete = new JMenuItem("ɾ������Ա");
			userdelete.setFont(f);
		}
	/**
	 * �˳������û�����
	 * @param fzr_id
	 */
		private void action(int fzr_id) {
			exit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// ����ת��
					index.dispose();
					new Index(fzr_id);
				}
			});
			/**
			 * ��ת�������û�����
			 */
			usernews.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// ����ת��
					index.dispose();
					new Manageradd(fzr_id);
				}
			});
			/**
			 * ��ת���޸��û�
			 */
			userupdate.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// ����ת��
					index.dispose();
					new Managerupdate(fzr_id);
				}
			});
			/**
			 * ɾ���û�����
			 */
			userdelete.addActionListener(new ActionListener()
		    {
				public void actionPerformed(ActionEvent e) {
					// ����ת��
					index.dispose();
					new ManagerDelete(fzr_id);
				}
			});
		}
//		public static void main(String[] args) {
//			Index l = new Index(1);
//		}
}
