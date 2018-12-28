package cnServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DbConnect;

/**
 * Servlet implementation class SignCheck
 */
@WebServlet("/SignCheck")
public class SignCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ѯ���ݿ����Ƿ��е�¼�û�
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String Sname = request.getParameter("account_name");
		String password = request.getParameter("user_password");
		// ��ȡ���ݿ������
		Connection con = DbConnect.getConnection();
		String sql = "select * from student where Sname=? and Spassword=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Sname);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				HttpSession session = request.getSession();
				// ����session��Чʱ��Ϊ2Сʱ
				session.setMaxInactiveInterval(7200);
				session.setAttribute("rs", rs);
				out.println("��¼�ɹ�");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
