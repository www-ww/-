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
 * ɾ����Ʒ����
 * @author ww
 *
 */
public class Deletegoods extends JFrame {
	public Deletegoods(int fzr_id) {
		init(fzr_id);
	}

	Font f = new Font("����", Font.BOLD, 15);
	// ��ʼ������
	private JTable table;
	JFrame logingui = new JFrame("ɾ����Ʒ");
	JLabel userlogin = new JLabel("��������Ʒ���:");
	JTextField name = new JTextField();
	JButton ack = new JButton("ȷ��");

	public void init(int fzr_id) {
		// ���ö���
		logingui.setBounds(450, 200, 400, 300);
		// �����˳�
		logingui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ȡ����ܸ�ʽ
		logingui.getContentPane().setLayout(null);
		// ����λ�á���С������
		userlogin.setBounds(10, 50, 130, 30);
		userlogin.setFont(f);
		name.setBounds(140, 50, 80, 30);
		name.setFont(f);
		ack.setBounds(270, 50, 80, 30);
		ack.setFont(f);
		// ��Ӷ���
		logingui.getContentPane().add(userlogin);
		logingui.getContentPane().add(name);
		logingui.getContentPane().add(ack);

		((JComponent) logingui.getContentPane()).setOpaque(false);
		ImageIcon img = null;
		img = new ImageIcon("E:\\������4.jpg");
		JLabel background = new JLabel(img);
		logingui.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 20, img.getIconWidth(), img.getIconHeight());
		logingui.setVisible(true);
		// ������ӻ�
		logingui.setVisible(true);
		// ��ȷ�ϰ�ť���ü����¼�
		ack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("aa");
				// Ϊ��һ������ֵ
				final Vector c = new Vector();
				// �������
				c.add("���");
				c.add("�����̱��");
				c.add("����");
				c.add("�������");
				c.add("���");
				c.add("��Ʒ��");
				c.add("�ⷿ���");
				// �������
				Vector g = null;
				try {
					g = ServiceFactory.getGoodsServiceInstance().Query("select * from ��Ʒ  where id=" + name.getText());

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// �ñ����ʾ
				table = new JTable(g, c);
				final JScrollPane js = new JScrollPane(table);
				js.setBounds(0, 130, 400, 40);
				logingui.add(js);
				table.setFont(f);
				JButton ackde = new JButton("ȷ��ɾ��");
				ackde.setBounds(60, 200, 100, 30);
				ackde.setFont(f);
				JButton ackup = new JButton("ȷ���޸�");
				ackup.setFont(f);

				ackup.setBounds(200, 200, 100, 30);
				logingui.getContentPane().add(ackde);
				logingui.getContentPane().add(ackup);

				ackde.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// ����ת��
						try {
							boolean boo;
							Goods a = new Goods();
							a.setId(Integer.parseInt(name.getText()));
							boo = ServiceFactory.getGoodsServiceInstance().Delete(a,
									"delete from ��Ʒ  where id=" + name.getText());
							if (boo) {
								JOptionPane.showMessageDialog(null, "ɾ���ɹ�");

							} else {
								JOptionPane.showMessageDialog(null, "ɾ��ʧ��");

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
						// ����ת��
						try {
							boolean boo;
							Goods a = new Goods();
							a.setId(Integer.parseInt(table.getValueAt(0, 0).toString()));
							a.setGhs_id(Integer.parseInt(table.getValueAt(0, 1).toString()));
							a.setNumber(Integer.parseInt(table.getValueAt(0, 2).toString()));
							// ��������
							Date utilDate;
							try {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// yyyy-mm-dd, �����ʱ�䲻��,
																							// ��ΪСд��mm�Ǵ���: ��
								utilDate = sdf.parse(table.getValueAt(0, 3).toString());
								// ת���ɱ�׼��ʽxxxx-xx-xx
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
									"update ��Ʒ set ghs_id=?,number=?,in_date=?,type=?,name=?,kf_id=? where id="
											+ a.getId());
							if (boo) {
								JOptionPane.showMessageDialog(null, "�޸ĳɹ�");

							} else {
								JOptionPane.showMessageDialog(null, "�޸�ʧ��");

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
