package green;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberAddServlet
 */
@SuppressWarnings("serial")
@WebServlet({"/MemberAddServlet" , "/member/add"})
public class MemberAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher rd = request.getRequestDispatcher(
				"/member/memberform.jsp"
				
				);
				
		rd.forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		Connection conn =null;
		PreparedStatement pst = null;
        String dbURL = "jdbc:mysql://localhost:3306/studydb?serverTimezone=Asia/Seoul";
        String dbId = "root";
        String dbPw = "1234";
        System.out.println("되냐");
        
        try {
        	System.out.println("되냐");
            
 	       	ServletContext sc = this.getServletContext();
 	       	conn = (Connection)sc.getAttribute("conn");
            System.out.println("db 연결 성공" + conn);
            System.out.println(request);
            
            pst = conn.prepareStatement("insert into members (email, pwd, mname, cre_date, mod_date) values(?,?,?, now(), now())");
            pst.setString(1, request.getParameter("email")); //첫번째 물음표
            pst.setString(2, request.getParameter("password")); //두번째 물음표
            pst.setString(3, request.getParameter("name")); //세번째 물음표
            //request.setCharacterEncoding("utf-8");
            pst.executeUpdate();
            //리다이렉트를 이용한 리프레시
            response.sendRedirect("list");
        }
        catch(Exception e) {
        	throw new ServletException();
        }
        finally {
            try {if(pst!= null) {pst.close();}} catch(Exception e) {System.out.println(e.getMessage());}
          //  try {if(conn != null) {conn.close();}} catch(Exception e) {System.out.println(e.getMessage());}
        }
	}



}
