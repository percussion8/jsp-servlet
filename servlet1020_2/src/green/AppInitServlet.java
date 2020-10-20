package green;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class AppInitServlet
 */
@SuppressWarnings("serial")
@WebServlet("/AppInitServlet")
public class AppInitServlet extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("AppInitServlet 준비...");
		super.init(config); //부모클래스(HttpServlet)의 메서드 init에게 파라미터로 받은 config 전달 
		String dbURL = "jdbc:mysql://localhost:3306/studydb?serverTimezone=Asia/Seoul";
        String dbId = "root";
        String dbPw = "1234";
		try {
			  ServletContext sc = this.getServletContext();
			  Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn = DriverManager.getConnection(dbURL,dbId,dbPw);
	          System.out.println("db 연결 성공" + conn);
	          sc.setAttribute("conn", conn);
		}catch(Throwable e) {
			throw new ServletException();
		}
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("AppInitServlet 마무리...");
		super.destroy();
		Connection conn = (Connection)this.getServletContext().getAttribute("conn");
		//this는 serveletContext
		//ServletContext conn = this.getServletContext();
		try {
			if(conn != null && conn.isClosed() == false) {
				conn.close();
			}
		}catch(Exception e) {
			
		}
	}

}
