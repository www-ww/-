package cn.jsu.ww.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cn.jsu.ww.factory.DAOFactory;
import cn.jsu.ww.factory.ServiceFactory;
import cn.jsu.ww.vo.Client;
import cn.jsu.ww.vo.Goods;
/**
 * ��Ʒ����
 * @author ww
 *
 */
public class Goodsout extends Index {
	boolean a=true;
	
	JTextField kh_id;
	JTextField phone;
	JTextField address;
	JTextArea remark;
	JTextField name;
	JTextField id;
	JTextField number;
	
//	Goods goods = new Goods();
	public Goodsout(int fzr_id) {
		super(fzr_id);
		init();
	}
	public boolean init() {
		Font d = new Font("����", Font.BOLD, 24);
		Font f = new Font("����", Font.BOLD, 18);
		JLabel title = new JLabel("��Ʒ����");
		JLabel cusid = new JLabel("�ͻ����"); 
		kh_id=new JTextField();
		JLabel cusphone = new JLabel("�绰����");
		phone=new JTextField();
		JLabel cusaddress=new JLabel("�ͻ���ַ");
		address=new JTextField();
		JLabel cusremark=new JLabel("�ͻ���ע");
		remark=new JTextArea();
        remark.setLineWrap(true);
		JLabel cusname = new JLabel("�ͻ�����");
		name = new JTextField();
		JLabel cusnumber = new JLabel("��������");
		number = new JTextField();
		JLabel goodsid=new JLabel("��Ʒ���");
		id=new JTextField();
		JButton submit = new JButton("�ύ");
		JButton reset = new JButton("����");
		
		title.setBounds(330, 40, 100, 40);
		title.setFont(d);
		//���
		cusid.setBounds(60, 120, 80, 30);
		cusid.setFont(f);
		kh_id.setBounds(140, 120, 150, 30);
		kh_id.setFont(f);
		cusphone.setBounds(60, 180, 80, 30);
		cusphone.setFont(f);
		phone.setBounds(140, 180, 150, 30);
		phone.setFont(f);
		cusaddress.setBounds(60, 240, 80, 30);
		cusaddress.setFont(f);
		address.setBounds(140, 240, 150, 30);
		address.setFont(f);
		cusremark.setBounds(60, 300, 80, 30);
		cusremark.setFont(f);
		remark.setBounds(140, 300, 450, 80);
		remark.setFont(f);
		//�ұ�
		cusname.setBounds(350, 120, 80, 30);
		cusname.setFont(f);
		name.setBounds(430,120,150,30);
		name.setFont(f);
		cusnumber.setBounds(350, 180, 80, 30);
		cusnumber.setFont(f);
		number.setBounds(430, 180, 150, 30);
		number.setFont(f);
		goodsid.setBounds(350, 240, 80, 30);
		goodsid.setFont(f);
		id.setBounds(430, 240, 150, 30);
		id.setFont(f);
		submit.setBounds(150, 400, 80, 30);
		submit.setFont(f);
		reset.setBounds(450, 400, 80, 30);
		reset.setFont(f);
		
		index.add(title);
		index.add(cusid);
		index.add(kh_id);
		index.add(cusphone);
		index.add(phone);
		index.add(cusaddress);
		index.add(address);
		index.add(cusremark);
		index.add(remark);
		index.add(goodsid);
		index.add(id);
		index.add(cusname);
		index.add(name);
		index.add(cusnumber);
		index.add(number);
		index.add(submit);
		index.add(reset);
		
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				kh_id.setText("");
				phone.setText("");
				address.setText("");
				remark.setText("");
				name.setText("");
				id.setText("");
				number.setText("");
			}
		});
		submit.addActionListener(new ActionListener() {
			Client cli=new Client();
			@Override
			public void actionPerformed(ActionEvent e) {
				if(name.getText().equals("") || id.getText().equals("") || number.getText().equals("")||number.getText().equals("")||kh_id.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"����������");
				} else {
					cli.setKh_id(Integer.parseInt(kh_id.getText()));
					cli.setPhone(phone.getText());
					cli.setAddress(address.getText());
					cli.setRemark(remark.getText());
					cli.setName(name.getText());
					cli.setId(Integer.parseInt(id.getText()));
					cli.setNumber(Integer.parseInt(number.getText()));
					try {
						Goods g=new Goods();
						a=ServiceFactory.getCustomerInstance().Add(cli, "insert into �ͻ�(kh_id,phone,address,remark,name,id,number)" + "values(?,?,?,?,?,?,?)");
						ServiceFactory.getGoodsServiceInstance().Delete(g,"update ��Ʒ set number=number-"+cli.getNumber().toString()+" where id="+cli.getId().toString());
						if(a)
						{
							kh_id.setText("");
							phone.setText("");
							address.setText("");
							remark.setText("");
							name.setText("");
							id.setText("");
							number.setText("");
							JOptionPane.showMessageDialog(null, "����ɹ�");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "����ʧ��");
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
