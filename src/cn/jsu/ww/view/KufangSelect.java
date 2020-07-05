package cn.jsu.ww.view;

import java.awt.Font;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import cn.jsu.ww.factory.DAOFactory;
import cn.jsu.ww.factory.ServiceFactory;
/**
 * 展示库房信息
 * @author ww
 *
 */
public class KufangSelect extends Index {

	private JTable table;
	int id ;
	public KufangSelect(int fzr_id)
	{
		super(fzr_id);
		init();
	}
	public void init() {
		Font t = new Font("楷体",Font.BOLD, 24);
		final Font f = new Font("楷体",Font.BOLD, 15);
		JLabel title = new JLabel("库房信息");
		title.setFont(t);
		title.setBounds(330, 0, 100, 40);
		//为第一行设置值
		final Vector c = new Vector();
		//添加数据
		c.add("库房编号");
		c.add("库房负责人编号");
		c.add("库房地址");
		//创建表格
		Vector g = null;
		try {
			g = ServiceFactory.getKufangServiceInstance().Query("select * from 库房");
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
