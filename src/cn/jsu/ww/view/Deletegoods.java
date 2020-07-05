package cn.jsu.ww.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import cn.jsu.ww.factory.DAOFactory;
import cn.jsu.ww.factory.ServiceFactory;
import cn.jsu.ww.vo.Goods;
/**
 * 删除物品界面
 * @author ww
 *
 */
public class Deletegoods extends JFrame {
	public Deletegoods(int fzr_id) {
		init(fzr_id);
	}

	Font f = new Font("楷体", Font.BOLD, 15);
	// 初始化对象
	private JTable table;
	JFrame logingui = new JFrame("删除物品");
	JLabel userlogin = new JLabel("请输入物品编号:");
	JTextField name = new JTextField();
	JButton ack = new JButton("确认");

	public void init(int fzr_id) {
		// 设置对象
		logingui.setBounds(450, 200, 400, 300);
		// 设置退出
		logingui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 取消框架格式
		logingui.getContentPane().setLayout(null);
		// 设置位置、大小和字体
		userlogin.setBounds(10, 50, 130, 30);
		userlogin.setFont(f);
		name.setBounds(140, 50, 80, 30);
		name.setFont(f);
		ack.setBounds(270, 50, 80, 30);
		ack.setFont(f);
		// 添加对象
		logingui.getContentPane().add(userlogin);
		logingui.getContentPane().add(name);
		logingui.getContentPane().add(ack);

		((JComponent) logingui.getContentPane()).setOpaque(false);
		ImageIcon img = null;
		img = new ImageIcon("E:\\主背景4.jpg");
		JLabel background = new JLabel(img);
		logingui.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 20, img.getIconWidth(), img.getIconHeight());
		logingui.setVisible(true);
		// 窗体可视化
		logingui.setVisible(true);
		// 给确认按钮设置监听事件
		ack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("aa");
				// 为第一行设置值
				final Vector c = new Vector();
				// 添加数据
				c.add("编号");
				c.add("供货商编号");
				c.add("数量");
				c.add("入库日期");
				c.add("类别");
				c.add("产品名");
				c.add("库房编号");
				// 创建表格
				Vector g = null;
				try {
					g = ServiceFactory.getGoodsServiceInstance().Query("select * from 物品  where id=" + name.getText());

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// 用表格显示
				table = new JTable(g, c);
				final JScrollPane js = new JScrollPane(table);
				js.setBounds(0, 130, 400, 40);
				logingui.add(js);
				table.setFont(f);
				JButton ackde = new JButton("确认删除");
				ackde.setBounds(60, 200, 100, 30);
				ackde.setFont(f);
				JButton ackup = new JButton("确认修改");
				ackup.setFont(f);

				ackup.setBounds(200, 200, 100, 30);
				logingui.getContentPane().add(ackde);
				logingui.getContentPane().add(ackup);

				ackde.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 界面转换
						try {
							boolean boo;
							Goods a = new Goods();
							a.setId(Integer.parseInt(name.getText()));
							boo = ServiceFactory.getGoodsServiceInstance().Delete(a,
									"delete from 物品  where id=" + name.getText());
							if (boo) {
								JOptionPane.showMessageDialog(null, "删除成功");

							} else {
								JOptionPane.showMessageDialog(null, "删除失败");

							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						logingui.dispose();
						new Index(fzr_id);
					}
				});
				ackup.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 界面转换
						try {
							boolean boo;
							Goods a = new Goods();
							a.setId(Integer.parseInt(table.getValueAt(0, 0).toString()));
							a.setGhs_id(Integer.parseInt(table.getValueAt(0, 1).toString()));
							a.setNumber(Integer.parseInt(table.getValueAt(0, 2).toString()));
							// 设置日期
							Date utilDate;
							try {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// yyyy-mm-dd, 会出现时间不对,
																							// 因为小写的mm是代表: 秒
								utilDate = sdf.parse(table.getValueAt(0, 3).toString());
								// 转换成标准格式xxxx-xx-xx
								Date d = new java.sql.Date(utilDate.getTime());
								a.setIn_date(d);
							} catch (ParseException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							a.setType(table.getValueAt(0, 4).toString());
							a.setName(table.getValueAt(0, 5).toString());
							a.setKf_id(Integer.parseInt(table.getValueAt(0, 6).toString()));
							boo = ServiceFactory.getGoodsServiceInstance().Update(a,
									"update 物品 set ghs_id=?,number=?,in_date=?,type=?,name=?,kf_id=? where id="
											+ a.getId());
							if (boo) {
								JOptionPane.showMessageDialog(null, "修改成功");

							} else {
								JOptionPane.showMessageDialog(null, "修改失败");

							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						logingui.dispose();
						new Index(fzr_id);
					}
				});
			}
		});
	}

//	public static void main(String[] args) {
//		Deletegoods a = new Deletegoods(1);
//
//	}
}
