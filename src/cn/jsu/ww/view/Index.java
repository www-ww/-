package cn.jsu.ww.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * ������
 * @author ww
 *
 */
public class Index extends JFrame {
	// ��������
	public JFrame index;
	private JMenuBar management;
	private JMenu user;
	private JMenu goods;
	private JMenu storage;
	private JMenuItem exit;
	private JMenuItem usernews;
	private JMenuItem userupdate;
	private JMenuItem goodsselect;
	private JMenuItem storageselect;
	private JMenuItem ingoods;
	private JMenuItem outgoods;
	private JMenuItem deletegoods;

	// �������캯��
	public Index(int fzr_id) {
		indexadmin();
		// ��Ӷ���
		user.add(userupdate);
		user.add(usernews);
		user.add(exit);
		goods.add(goodsselect);
		goods.add(ingoods);
		goods.add(outgoods);
		goods.add(deletegoods);
		storage.add(storageselect);
		management.add(goods);
		management.add(storage);
		management.add(user);
		init();
		action(fzr_id);
	}

	private void init() {
		// ��ʼ����index
		index = new JFrame("��ӭʹ�ñ�ϵͳ");
		// ���ÿ�ܴ�С��λ��
		index.setBounds(500, 100, 700, 500);
		index.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ���˵������ý����
		index.setJMenuBar(management);
		index.setLayout(null);
		setImage("E:\\������2.jpg");
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
		goods = new JMenu(" ��Ʒ����");
		goods.setFont(f);
		storage = new JMenu(" �ֿ����");
		storage.setFont(f);
		exit = new JMenuItem("�û�����");
		exit.setFont(f);
		usernews = new JMenuItem("�޸ĸ�����Ϣ");
		usernews.setFont(f);
		userupdate = new JMenuItem("�鿴������Ϣ");
		userupdate.setFont(f);
		goodsselect = new JMenuItem("��Ʒ���");
		goodsselect.setFont(f);
		ingoods = new JMenuItem("������");
		ingoods.setFont(f);
		outgoods = new JMenuItem("�������");
		outgoods.setFont(f);
		deletegoods = new JMenuItem("ɾ����Ʒ");
		deletegoods.setFont(f);
		storageselect = new JMenuItem("�ֿ����");
		storageselect.setFont(f);

	}
/**
 * ��ת���û��������
 * @param fzr_id
 */
	private void action(int fzr_id) {
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ����ת��
				index.setVisible(false);
				new ManagerLogin(fzr_id);
			}
		});
		/**
		 * ��ת���û��޸Ľ���
		 */
		usernews.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ����ת��
				index.dispose();
				new UserChange(fzr_id);
			}
		});
		/**
		 * ��ת���û��鿴����
		 */
		userupdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ����ת��
				index.dispose();
				new UserSee(fzr_id);
			}
		});
		/**
		 * ��ת����Ʒ�鿴
		 */
		goodsselect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ����ת��
				index.dispose();
				new GoodsSelect(fzr_id);
			}
		});
		storageselect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ����ת��
				index.dispose();
				new KufangSelect(fzr_id);
			}
		});
		ingoods.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ����ת��
				index.dispose();
				new Goodsadd(fzr_id);
			}
		});
		outgoods.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				// ����ת��
				index.dispose();
				new Goodsout(fzr_id);
			}
		});
		deletegoods.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				// ����ת��
				index.dispose();
				new Deletegoods(fzr_id);
			}
		});
	}
//	public static void main(String[] args) {
//		Index l = new Index(1);
//	}
}
