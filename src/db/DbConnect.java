package db;

import java.sql.*;

public class DbConnect {
	public static Connection con;
	public static Connection getConnection(){
		//1.��Ŀ�м���jar������jdbc���ݿ���������
		try {
			//2.�������ݿ�����
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();    
			//3.���ݿ����ӵ�ַ�����ݿ�����swxy�����ݿ��˻���root/root
			String url ="jdbc:mysql://localhost/swxy?user=root&password=root"
					+ "&useUnicode=true&characterEncoding=utf-8&useSSL=true"; 
			//4.���������ݿ������
			con=DriverManager.getConnection(url); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
