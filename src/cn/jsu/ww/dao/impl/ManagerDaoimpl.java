package cn.jsu.ww.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import cn.jsu.ww.dao.ManagerDao;
/**
 * ����Ա�û�������
 * @author ww
 *
 */
public class ManagerDaoimpl implements ManagerDao {
	// ����BufferedReader����
	public static BufferedReader buf;

	public ManagerDaoimpl() {

	}
	@Override
	/**
	 * ��ѯ�û���Ϣ
	 */
	public boolean Query(String s, String filepath) throws Exception {
		// TODO Auto-generated method stub
		FileReader file = new FileReader(filepath);
		buf = new BufferedReader(file);
		String read;
		while ((read = buf.readLine()) != null) {
			if (read.equals(s)) {
				buf.close();
				file.close();
				return true;
			}
		}
		buf.close();
		file.close();
		return false;
	}
/**
 * ����Ա����
 */
	public boolean Add(String s, String filepath) throws Exception {
		// TODO Auto-generated method stub
		FileWriter filew = new FileWriter(filepath,true);
		BufferedWriter bufw = new BufferedWriter(filew);
		bufw.write(s);
		bufw.write("\r\n");
		bufw.close();
		filew.close();
		return true;
	}
/**
 * ����Աɾ��
 */
	@Override
	public boolean Delete(String s, String filepath)throws Exception {
		// TODO Auto-generated method stub
		FileReader file = new FileReader(filepath);
		buf = new BufferedReader(file);
		ArrayList<String> gets=new ArrayList<String>();
		int i=0,flag=0; 
		String read;
		while ((read = buf.readLine()) != null) {
			String a=read.split(" ")[0];
			if (a.equals(s)) {
				flag=1;
			}
			else
				{
				gets.add(read);
				}
			i++;
		}
		buf.close();
		file.close();
		if(flag!=0)
		{
		FileWriter filew = new FileWriter(filepath);
		for(String j:gets)
		{
		filew.write(j+"\r\n");
		}
		filew.close();
         return true;
		}
		else
		{
			return false;
		}	
	}
/**
 * ����Ա�޸�
 */
	@Override
	public boolean Update(String s, String filepath) throws Exception {
		// TODO Auto-generated method stub
		FileReader file = new FileReader(filepath);
		buf = new BufferedReader(file);
		String[] gets=new String[50];
		int i=0,flag=0; 
		String read;
		String a=s.split(" ")[0];
		//System.out.println("a"+a);
		while ((read = buf.readLine()) != null) {
			String b=read.split(" ")[0];
			//System.out.println("b"+b);
			if (a.equals(b)) {
				flag=1;
				gets[i]=s;
			}
			else
				{
				gets[i]=read;
				}
			i++;
		}
		buf.close();
		file.close();
		if(flag!=0)
		{
		FileWriter filew = new FileWriter(filepath);
		BufferedWriter bufw = new BufferedWriter(filew);
		int j=0;
		while(j<i)
		{
			//System.out.println(gets[j]);
		bufw.write(gets[j]);
		bufw.write("\r\n");
		j++;
		}
		bufw.close();
		filew.close();
         return true;
		}
		else
		{
			return false;
		}				
	}

//	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//		ManagerDaoimpl a=new ManagerDaoimpl();
//		String s="3";
//		System.out.println(a.Delete(s,"E:\\manager.txt"));
//	}

}
