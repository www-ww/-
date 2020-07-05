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
 * 主界面
 * @author ww
 *
 */
public class Index extends JFrame {
	// 声明对象
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

	// 创建构造函数
	public Index(int fzr_id) {
		indexadmin();
		// 添加对象
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
		// 初始化矿建index
		index = new JFrame("欢迎使用本系统");
		// 设置框架大小和位置
		index.setBounds(500, 100, 700, 500);
		index.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 将菜单栏设置进框架
		index.setJMenuBar(management);
		index.setLayout(null);
		setImage("E:\\主背景2.jpg");
	}
    public void setImage(String s)
    {
    	// 设置背景
    			((JComponent) index.getContentPane()).setOpaque(false);
    			ImageIcon img = null;
    			img = new ImageIcon(s);
    			JLabel background = new JLabel(img);
    			index.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
    			background.setBounds(0, 20, img.getIconWidth(), img.getIconHeight());
    			index.setVisible(true);
    }
	public void indexadmin() {
		// 初始化对象
		Font f = new Font("楷体", Font.BOLD, 15);
		management = new JMenuBar();
		user = new JMenu(" 用户管理");
		user.setFont(f);
		goods = new JMenu(" 商品管理");
		goods.setFont(f);
		storage = new JMenu(" 仓库管理");
		storage.setFont(f);
		exit = new JMenuItem("用户管理");
		exit.setFont(f);
		usernews = new JMenuItem("修改个人信息");
		usernews.setFont(f);
		userupdate = new JMenuItem("查看个人信息");
		userupdate.setFont(f);
		goodsselect = new JMenuItem("商品浏览");
		goodsselect.setFont(f);
		ingoods = new JMenuItem("入库管理");
		ingoods.setFont(f);
		outgoods = new JMenuItem("出库管理");
		outgoods.setFont(f);
		deletegoods = new JMenuItem("删除物品");
		deletegoods.setFont(f);
		storageselect = new JMenuItem("仓库浏览");
		storageselect.setFont(f);

	}
/**
 * 跳转到用户管理界面
 * @param fzr_id
 */
	private void action(int fzr_id) {
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 界面转换
				index.setVisible(false);
				new ManagerLogin(fzr_id);
			}
		});
		/**
		 * 跳转到用户修改界面
		 */
		usernews.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 界面转换
				index.dispose();
				new UserChange(fzr_id);
			}
		});
		/**
		 * 跳转到用户查看界面
		 */
		userupdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 界面转换
				index.dispose();
				new UserSee(fzr_id);
			}
		});
		/**
		 * 跳转到物品查看
		 */
		goodsselect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 界面转换
				index.dispose();
				new GoodsSelect(fzr_id);
			}
		});
		storageselect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 界面转换
				index.dispose();
				new KufangSelect(fzr_id);
			}
		});
		ingoods.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 界面转换
				index.dispose();
				new Goodsadd(fzr_id);
			}
		});
		outgoods.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				// 界面转换
				index.dispose();
				new Goodsout(fzr_id);
			}
		});
		deletegoods.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				// 界面转换
				index.dispose();
				new Deletegoods(fzr_id);
			}
		});
	}
//	public static void main(String[] args) {
//		Index l = new Index(1);
//	}
}
