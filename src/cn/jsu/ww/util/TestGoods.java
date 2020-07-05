package cn.jsu.ww.util;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.junit.jupiter.api.Test;

import cn.jsu.ww.factory.DAOFactory;
import cn.jsu.ww.factory.ServiceFactory;
import cn.jsu.ww.vo.Client;
import cn.jsu.ww.vo.Goods;
import junit.framework.TestCase;

class TestGoods {
/**
 * �Զ�����
 * @throws SQLException 
 * @throws ParseException 
 */
	@Test
	void test() throws SQLException, ParseException {
		Goods g=new Goods();
		//fail("Not yet implemented");
		for(int i=1;i<10000;i++)
		{
				Random r = new Random();
				int ghs_id=r.nextInt(10)+1;
				int kf_id=r.nextInt(10);
				int number=r.nextInt(10000)+1;
				String date="2020-";
				String[] type=new String[2] ;
				String[] name=new String[10];
				//��Ʒ���
				type[0]="����Ʒ";
				type[1]="ʳƷ";
				//��Ʒ��
				name[0]="����";
				name[1]="����";
				name[2]="���";
				name[3]="��ˢ";
				name[4]="����";
				name[5]="����";
				name[6]="��Ƭ";
				name[7]="��Ь";
				name[8]="ţ��";
				name[9]="ˮ��";
				int nameint;
				nameint=r.nextInt(10);
				g.setId(i);
				g.setGhs_id(ghs_id);
				g.setNumber(number);
				//��Stringת��ΪDate
				date=date+(Integer.toString(nameint+1))+"-"+(Integer.toString(r.nextInt(30)+1));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//yyyy-mm-dd, �����ʱ�䲻��, ��ΪСд��mm�Ǵ���: ��
				//��ת����ʱ���ĸ�ʽ
			    Date utilDate = sdf.parse(date);
			    //ת���ɱ�׼��ʽxxxx-xx-xx
			    Date d = new java.sql.Date(utilDate.getTime());
				g.setIn_date(d);
				//ż������ʳƷ
				if(nameint%2==0)
				{
					g.setType(type[0]);
				}
				else 
					{
					g.setType(type[1]);
					}
				g.setName(name[nameint]);
				g.setKf_id(kf_id);
				TestCase.assertTrue(ServiceFactory.getGoodsServiceInstance().Add(g, "insert into ��Ʒ(id,ghs_id,number,in_date,type,name,kf_id) values(?,?,?,?,?,?,?)"));
			}
		}
	public static void main(String[] args)
	{
		
	}
}
