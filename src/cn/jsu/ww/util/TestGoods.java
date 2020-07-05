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
 * 自动测试
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
				//产品类别
				type[0]="日用品";
				type[1]="食品";
				//产品名
				name[0]="蛋糕";
				name[1]="杯子";
				name[2]="面包";
				name[3]="牙刷";
				name[4]="火腿";
				name[5]="牙膏";
				name[6]="薯片";
				name[7]="拖鞋";
				name[8]="牛奶";
				name[9]="水盆";
				int nameint;
				nameint=r.nextInt(10);
				g.setId(i);
				g.setGhs_id(ghs_id);
				g.setNumber(number);
				//将String转换为Date
				date=date+(Integer.toString(nameint+1))+"-"+(Integer.toString(r.nextInt(30)+1));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//yyyy-mm-dd, 会出现时间不对, 因为小写的mm是代表: 秒
				//先转换成时区的格式
			    Date utilDate = sdf.parse(date);
			    //转换成标准格式xxxx-xx-xx
			    Date d = new java.sql.Date(utilDate.getTime());
				g.setIn_date(d);
				//偶数就是食品
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
				TestCase.assertTrue(ServiceFactory.getGoodsServiceInstance().Add(g, "insert into 物品(id,ghs_id,number,in_date,type,name,kf_id) values(?,?,?,?,?,?,?)"));
			}
		}
	public static void main(String[] args)
	{
		
	}
}
