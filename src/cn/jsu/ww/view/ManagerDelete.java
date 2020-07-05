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
 * 删除管理员
 * @author ww
 *
 */
public class ManagerDelete extends Manager {
	public ManagerDelete(int fzr_id) {
		super(fzr_id);
		init(fzr_id);
	}
	Font f = new Font("楷体", Font.BOLD, 15);
	JFrame logingui = new JFrame("删除管理员账号");
	JLabel userlogin = new JLabel("请输入编号:");
	JTextField name = new JTextField();
	JButton ack=new JButton("确认删除");

	public void init(int fzr_id) {
		// 设置对象
		logingui.setBounds(450, 200, 400, 300);
		// 设置退出
		logingui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 取消框架格式
		logingui.getContentPane().setLayout(null);
		// 设置位置、大小和字体
		userlogin.setBounds(10, 100, 130, 30);
		userlogin.setFont(f);
		name.setBounds(110, 100, 80, 30);
		name.setFont(f);
		ack.setBounds(220, 100, 120, 30);
		ack.setFont(f);
		// 添加对象
		logingui.getContentPane().add(userlogin);
		logingui.getContentPane().add(name);
		logingui.getContentPane().add(ack);
		// 设置背景
		((JComponent) logingui.getContentPane()).setOpaque(false);
		ImageIcon img = null;
		img = new ImageIcon("E:\\主背景4.jpg");
		JLabel background = new JLabel(img);
		logingui.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 20, img.getIconWidth(), img.getIconHeight());
		logingui.setVisible(true);
		ack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 界面转换
				try {
					boolean boo;
					String s=name.getText();
					boo=ServiceFactory.getManagerInstance().Delete(s, "E:\\manager.txt");
					if (boo) {
						name.setText("");
						JOptionPane.showMessageDialog(null, "删除成功");

					} else {
						JOptionPane.showMessageDialog(null, "删除失败");

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
