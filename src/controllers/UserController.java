package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DataSource datasource = null;
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet rs = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void init(ServletConfig servletconfig) {
		System.out.println("hello");
		/*try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			datasource = (DataSource) envContext.lookup("jdbc/project");
			System.out.println("Using JNDI LOOKUP" + datasource);

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	/*	String username = request.getParameter("username");
		String password = request.getParameter("password");

		String sql = "select * from User where username=? AND password=?";
		try {
			connection = datasource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,username);
			preparedStatement.setString(2,password);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String username1 = rs.getString(1);
				String password1 = rs.getString(2);
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("username is" + username1 + "");
				out.println("password is" + password1 + "");
			}
		} catch (SQLException sqe) {
			try {
				preparedStatement.close();
				connection.close();
			} catch (Exception e) {
			}
		}*/
		 response.setContentType("text/html");  
	        PrintWriter out = response.getWriter();  
	         
	        RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
	        rd.forward(request, response);
	        out.print("welcome ADMIN");
	        out.close(); 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		// TODO Auto-generated method stub
	}

}
