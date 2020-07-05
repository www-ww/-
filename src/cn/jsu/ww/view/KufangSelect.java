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
 * չʾ�ⷿ��Ϣ
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
		Font t = new Font("����",Font.BOLD, 24);
		final Font f = new Font("����",Font.BOLD, 15);
		JLabel title = new JLabel("�ⷿ��Ϣ");
		title.setFont(t);
		title.setBounds(330, 0, 100, 40);
		//Ϊ��һ������ֵ
		final Vector c = new Vector();
		//�������
		c.add("�ⷿ���");
		c.add("�ⷿ�����˱��");
		c.add("�ⷿ��ַ");
		//�������
		Vector g = null;
		try {
			g = ServiceFactory.getKufangServiceInstance().Query("select * from �ⷿ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ñ����ʾ
		table = new JTable(g,c);
		table.setFont(f);
		//����Jscrollpane
		final JScrollPane js = new JScrollPane(table);
		js.setBounds(0,35, 700, 480);
		index.add(title);
		index.add(js);
	}

}
