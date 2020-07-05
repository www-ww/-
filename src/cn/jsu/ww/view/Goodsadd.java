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
 * ������Ʒ
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
	//ʵ�ֵ�ѡ
	ButtonGroup bg;
	JTextField number;
    JComboBox kf_id;
	Goods goods = new Goods();
	
	public Goodsadd(int fzr_id) {
		super(fzr_id);
		init();
	}
	public boolean init() {
		Font d = new Font("����", Font.BOLD, 24);
		Font f = new Font("����", Font.BOLD, 18);
		JLabel goodstitle = new JLabel("�����Ʒ");
		JLabel goodsname = new JLabel("��Ʒ����");
		name = new JTextField();
		JLabel goodsstyle = new JLabel("��  �ͣ�");
		style1 = new JRadioButton("ʳƷ");
		style2=new JRadioButton("����Ʒ");
		JLabel goodsnumber = new JLabel("��  ����");
		number = new JTextField();
		JLabel storageid = new JLabel("�ֿ�ţ�"); 
		try {
			Vector v=new Vector();
			v=ServiceFactory.getKufangServiceInstance().Query1("select kf_id from �ⷿ");
		
			kf_id = new JComboBox(v);
		} catch (SQLException e2) {
			// TODO �Զ����ɵ� catch ��
			e2.printStackTrace();
		}
		JLabel goodsid=new JLabel("��Ʒ���");
		id=new JTextField();
		JLabel goodsghs=new JLabel("������");
		ghs_id=new JTextField();
		JLabel indate=new JLabel("�������");
		in_date=new JTextField();
		JButton submit = new JButton("�ύ");
		JButton reset = new JButton("����");
		panel=new JPanel();
		bg=new ButtonGroup();
		goodstitle.setBounds(330, 40, 100, 40);
		goodstitle.setFont(d);
		//���
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
		//�ұ�
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
					JOptionPane.showMessageDialog(null,"����������");
				} else {
					goods.setId(Integer.parseInt(id.getText()));
					goods.setGhs_id(Integer.parseInt(ghs_id.getText()));
					goods.setNumber(Integer.parseInt(number.getText()));
					//��Stringת��ΪDate
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//yyyy-mm-dd, �����ʱ�䲻��, ��ΪСд��mm�Ǵ���: ��
					//��ת����ʱ���ĸ�ʽ
				    Date utilDate;
					try {
						utilDate = sdf.parse(in_date.getText());
						//ת���ɱ�׼��ʽxxxx-xx-xx
					    Date d = new java.sql.Date(utilDate.getTime());
					    goods.setIn_date(d);
					} catch (ParseException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					if(style1.isSelected())
					{
						goods.setType("ʳƷ");
					}
					else
					{
						goods.setType("����Ʒ");
					}
					goods.setName(name.getText());
					goods.setKf_id(Integer.parseInt(kf_id.getSelectedItem().toString()));
					try {
						a=ServiceFactory.getGoodsServiceInstance().Add(goods, "insert into ��Ʒ(id,ghs_id,number,in_date,type,name,kf_id)" + "values(?,?,?,?,?,?,?)");
						if(a)
						{
							name.setText("");
							id.setText("");
							ghs_id.setText("");
							style1.setSelected(true);;
							number.setText("");
							in_date.setText("");
							JOptionPane.showMessageDialog(null, "��ӳɹ�");
							
						}
						else
						{
							JOptionPane.showMessageDialog(null, "���ʧ��");
						}
						} catch (SQLException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
				}
			}
		});
		return a;
	}
}