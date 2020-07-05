package cn.jsu.ww.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.jsu.ww.factory.ServiceFactory;
/**
 * �޸Ĺ���Ա��Ϣ
 * @author ww
 *
 */
public class Managerupdate extends Manager {
	JTextField name;
	JTextField pass;

	private JPanel contentPane;

	public Managerupdate(int fzr_id) {
		super(fzr_id);
		init(fzr_id);
	}

	public void init(int fzr_id) {
		Font f = new Font("����", Font.BOLD, 18);
		JLabel setid = new JLabel("���id��");
		JLabel id=new JLabel(Integer.toString(fzr_id));
		JLabel goodsname = new JLabel("�޸��ǳƣ�");
		name = new JTextField();
		JLabel pwd = new JLabel("���룺");
		pass = new JTextField();
		JButton submit = new JButton("�ύ");
		//���ò���
		setid.setBounds(150, 120, 120, 30);
		setid.setFont(f);
		id.setBounds(300,120,150,30);
		id.setFont(f);
		goodsname.setBounds(150, 180, 120, 30);
		goodsname.setFont(f);
		name.setBounds(300, 180, 150, 30);
		name.setFont(f);
		pwd.setBounds(150, 240, 120, 30);
		pwd.setFont(f);
		pass.setBounds(300, 240, 150, 30);
		pass.setFont(f);
		submit.setBounds(270, 360, 80, 30);
		submit.setFont(f);
		//��ӵ����
		index.add(setid);
		index.add(id);
		index.add(goodsname);
		index.add(name);
		index.add(pwd);
		index.add(pass);
		index.add(submit);
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s=id.getText()+" "+name.getText()+" "+pass.getText();
				System.out.println(s);
				boolean a;
				try {
					a=ServiceFactory.getManagerInstance().Update(s, "E:\\manager.txt");
					if(a)
					{
						name.setText("");
						pass.setText("");
						JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "�޸�ʧ��");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	});
		}
//	public static void main(String[] args) {
//		Manageradd a = new Manageradd(1);
//
//	}

}
