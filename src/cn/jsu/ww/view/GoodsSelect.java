package cn.jsu.ww.view;

import java.awt.Font;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import cn.jsu.ww.dao.impl.GoodsManageDaoImpl;
import cn.jsu.ww.factory.DAOFactory;
import cn.jsu.ww.factory.ServiceFactory;
/**
 * 展示所有物品
 * @author ww
 *
 */
public class GoodsSelect extends Index{

	private JTable table;
	int id ;
	public GoodsSelect(int fzr_id)
	{
		super(fzr_id);
		init();
	}
	public void init() {
		Font t = new Font("楷体",Font.BOLD, 24);
		final Font f = new Font("楷体",Font.BOLD, 15);
		JLabel title = new JLabel("商品信息");
		title.setFont(t);
		title.setBounds(330, 0, 100, 40);
		//为第一行设置值
		final Vector c = new Vector();
		//添加数据
		c.add("编号");
		c.add("供货商编号");
		c.add("数量");
		c.add("入库日期");
		c.add("类别");
		c.add("产品名");
		c.add("库房编号");
		//创建表格
		Vector g = null;
		try {
			g = ServiceFactory.getGoodsServiceInstance().Query("select * from 物品");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//用表格显示
		table = new JTable(g,c);
		table.setFont(f);
		//创建Jscrollpane
		final JScrollPane js = new JScrollPane(table);
		js.setBounds(0,35, 700, 480);
		index.add(title);
		index.add(js);
	}
}
