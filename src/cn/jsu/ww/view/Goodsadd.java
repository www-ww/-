package cn.jsu.ww.view;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import cn.jsu.ww.factory.DAOFactory;
import cn.jsu.ww.factory.ServiceFactory;
import cn.jsu.ww.vo.Goods;
/**
 * 增加物品
 * @author ww
 *
 */
public class Goodsadd extends Index{
	boolean a;
	JTextField name;
	JTextField id;
	JTextField ghs_id;
	JTextField in_date;
	JRadioButton style1;
	JRadioButton style2;
	JPanel panel;
	//实现单选
	ButtonGroup bg;
	JTextField number;
    JComboBox kf_id;
	Goods goods = new Goods();
	
	public Goodsadd(int fzr_id) {
		super(fzr_id);
		init();
	}
	public boolean init() {
		Font d = new Font("楷体", Font.BOLD, 24);
		Font f = new Font("楷体", Font.BOLD, 18);
		JLabel goodstitle = new JLabel("添加商品");
		JLabel goodsname = new JLabel("商品名：");
		name = new JTextField();
		JLabel goodsstyle = new JLabel("类  型：");
		style1 = new JRadioButton("食品");
		style2=new JRadioButton("日用品");
		JLabel goodsnumber = new JLabel("数  量：");
		number = new JTextField();
		JLabel storageid = new JLabel("仓库号："); 
		try {
			Vector v=new Vector();
			v=ServiceFactory.getKufangServiceInstance().Query1("select kf_id from 库房");
		
			kf_id = new JComboBox(v);
		} catch (SQLException e2) {
			// TODO 自动生成的 catch 块
			e2.printStackTrace();
		}
		JLabel goodsid=new JLabel("商品编号");
		id=new JTextField();
		JLabel goodsghs=new JLabel("供货商");
		ghs_id=new JTextField();
		JLabel indate=new JLabel("入库日期");
		in_date=new JTextField();
		JButton submit = new JButton("提交");
		JButton reset = new JButton("重置");
		panel=new JPanel();
		bg=new ButtonGroup();
		goodstitle.setBounds(330, 40, 100, 40);
		goodstitle.setFont(d);
		//左边
		goodsname.setBounds(60, 120, 80, 30);
		goodsname.setFont(f);
		name.setBounds(140, 120, 150, 30);
		name.setFont(f);
		goodsstyle.setBounds(60, 180, 80, 30);
		goodsstyle.setFont(f);
		bg.add(style1);
		bg.add(style2);
		panel.add(style1);
		panel.add(style2);
		style1.setSelected(true);
		panel.setBounds(140, 180, 150, 30);
		goodsnumber.setBounds(60, 240, 80, 30);
		goodsnumber.setFont(f);
		number.setBounds(140, 240, 150, 30);
		number.setFont(f);
		storageid.setBounds(60, 300, 80, 30);
		storageid.setFont(f);
		kf_id.setBounds(140, 300, 150, 30);
		kf_id.setFont(f);
		//右边
		goodsid.setBounds(350, 120, 80, 30);
		goodsid.setFont(f);
		id.setBounds(430,120,150,30);
		id.setFont(f);
		goodsghs.setBounds(350, 180, 80, 30);
		goodsghs.setFont(f);
		ghs_id.setBounds(430, 180, 150, 30);
		indate.setBounds(350, 240, 80, 30);
		indate.setFont(f);
		in_date.setBounds(430, 240, 150, 30);
		submit.setBounds(120, 360, 80, 30);
		submit.setFont(f);
		reset.setBounds(450, 360, 80, 30);
		reset.setFont(f);
		
		index.add(goodstitle);
		index.add(goodsname);
		index.add(name);
		index.add(goodsstyle);
		index.add(panel);
		index.add(goodsnumber);
		index.add(number);
		index.add(storageid);
		index.add(kf_id);
		index.add(goodsid);
		index.add(id);
		index.add(goodsghs);
		index.add(ghs_id);
		index.add(indate);
		index.add(in_date);
		index.add(submit);
		index.add(reset);
		
		
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				name.setText("");
				number.setText("");
			}
		});
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(name.getText().equals("") || id.getText().equals("") || number.getText().equals("")||ghs_id.getText().equals("")||in_date.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"请输入内容");
				} else {
					goods.setId(Integer.parseInt(id.getText()));
					goods.setGhs_id(Integer.parseInt(ghs_id.getText()));
					goods.setNumber(Integer.parseInt(number.getText()));
					//将String转换为Date
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//yyyy-mm-dd, 会出现时间不对, 因为小写的mm是代表: 秒
					//先转换成时区的格式
				    Date utilDate;
					try {
						utilDate = sdf.parse(in_date.getText());
						//转换成标准格式xxxx-xx-xx
					    Date d = new java.sql.Date(utilDate.getTime());
					    goods.setIn_date(d);
					} catch (ParseException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					if(style1.isSelected())
					{
						goods.setType("食品");
					}
					else
					{
						goods.setType("日用品");
					}
					goods.setName(name.getText());
					goods.setKf_id(Integer.parseInt(kf_id.getSelectedItem().toString()));
					try {
						a=ServiceFactory.getGoodsServiceInstance().Add(goods, "insert into 物品(id,ghs_id,number,in_date,type,name,kf_id)" + "values(?,?,?,?,?,?,?)");
						if(a)
						{
							name.setText("");
							id.setText("");
							ghs_id.setText("");
							style1.setSelected(true);;
							number.setText("");
							in_date.setText("");
							JOptionPane.showMessageDialog(null, "添加成功");
							
						}
						else
						{
							JOptionPane.showMessageDialog(null, "添加失败");
						}
						} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
			}
		});
		return a;
	}
}