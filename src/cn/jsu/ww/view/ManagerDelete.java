package cn.jsu.ww.view;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import cn.jsu.ww.factory.ServiceFactory;
/**
 * ɾ������Ա
 * @author ww
 *
 */
public class ManagerDelete extends Manager {
	public ManagerDelete(int fzr_id) {
		super(fzr_id);
		init(fzr_id);
	}
	Font f = new Font("����", Font.BOLD, 15);
	JFrame logingui = new JFrame("ɾ������Ա�˺�");
	JLabel userlogin = new JLabel("��������:");
	JTextField name = new JTextField();
	JButton ack=new JButton("ȷ��ɾ��");

	public void init(int fzr_id) {
		// ���ö���
		logingui.setBounds(450, 200, 400, 300);
		// �����˳�
		logingui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ȡ����ܸ�ʽ
		logingui.getContentPane().setLayout(null);
		// ����λ�á���С������
		userlogin.setBounds(10, 100, 130, 30);
		userlogin.setFont(f);
		name.setBounds(110, 100, 80, 30);
		name.setFont(f);
		ack.setBounds(220, 100, 120, 30);
		ack.setFont(f);
		// ��Ӷ���
		logingui.getContentPane().add(userlogin);
		logingui.getContentPane().add(name);
		logingui.getContentPane().add(ack);
		// ���ñ���
		((JComponent) logingui.getContentPane()).setOpaque(false);
		ImageIcon img = null;
		img = new ImageIcon("E:\\������4.jpg");
		JLabel background = new JLabel(img);
		logingui.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 20, img.getIconWidth(), img.getIconHeight());
		logingui.setVisible(true);
		ack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ����ת��
				try {
					boolean boo;
					String s=name.getText();
					boo=ServiceFactory.getManagerInstance().Delete(s, "E:\\manager.txt");
					if (boo) {
						name.setText("");
						JOptionPane.showMessageDialog(null, "ɾ���ɹ�");

					} else {
						JOptionPane.showMessageDialog(null, "ɾ��ʧ��");

					}
				} catch ( Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				logingui.dispose();
			}
		});
	}
//	public static void main(String[] args)
//	{
//		ManagerDelete a=new ManagerDelete(1);
//		
//	}
}
