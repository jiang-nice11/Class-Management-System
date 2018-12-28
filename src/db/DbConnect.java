package db;

import java.sql.*;

public class DbConnect {
	public static Connection con;
	public static Connection getConnection(){
		//1.项目中加入jar包，及jdbc数据库连接驱动
		try {
			//2.加载数据库驱动
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();    
			//3.数据库连接地址，数据库名：swxy，数据库账户：root/root
			String url ="jdbc:mysql://localhost/swxy?user=root&password=root"
					+ "&useUnicode=true&characterEncoding=utf-8&useSSL=true"; 
			//4.创建与数据库的连接
			con=DriverManager.getConnection(url); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
