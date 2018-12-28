package cnServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import db.DbConnect;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 添加用户
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String Sname = request.getParameter("account_name");
		String password = request.getParameter("user_password");
		int Sno = Integer.parseInt(request.getParameter("sno"));
		String Ssex = request.getParameter("sex");
		String Smajor = request.getParameter("major");
		Student stu = new Student(Sname, password, Sno, Ssex, Smajor);
		Connection con = DbConnect.getConnection();
		String sql = "insert into student(Sname,Spassword,Sno,Ssex,Smajor)values(?,?,?,?,?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, stu.getName());
			ps.setString(2, stu.getPassword());
			ps.setInt(3, stu.getSno());
			ps.setString(4, stu.getSex());
			ps.setString(5, stu.getSmajor());
			int i = ps.executeUpdate();
			HttpSession session = request.getSession();
			if(i==1){
				String sql1 = "select * from student";
				ps = con.prepareStatement(sql1);
				rs = ps.executeQuery();
				//设置session有效时间为2小时
				session.setMaxInactiveInterval(7200);
				session.setAttribute("rs", rs);
				out.print("成功");
			}else{
				session.setAttribute("message", "添加失败！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
