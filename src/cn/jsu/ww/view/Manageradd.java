package cn.jsu.ww.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.jsu.ww.factory.ServiceFactory;
import cn.jsu.ww.vo.Client;
import cn.jsu.ww.vo.Goods;
/**
 * 增加管理员
 * @author ww
 *
 */
public class Manageradd extends Manager {
	JTextField id;
	JTextField name;
	JTextField pass;

	private JPanel contentPane;

	public Manageradd(int fzr_id) {
		super(fzr_id);
		init(fzr_id);
	}

	public void init(int fzr_id) {
		Font f = new Font("楷体", Font.BOLD, 18);
		JLabel setid = new JLabel("管理员id：");
		id=new JTextField();
		JLabel goodsname = new JLabel("管理员姓名：");
		name = new JTextField();
		JLabel pwd = new JLabel("密码：");
		pass = new JTextField();
		JButton submit = new JButton("提交");
		//设置参数
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
		//添加到面板
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
				boolean a;
				try {
					a=ServiceFactory.getManagerInstance().Add(s, "E:\\manager.txt");
					if(a)
					{
						name.setText("");
						id.setText("");
						pass.setText("");
						JOptionPane.showMessageDialog(null, "增加成功");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "增加失败");
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
