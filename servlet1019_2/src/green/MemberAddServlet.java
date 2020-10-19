package green;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//response.setCharacterEncoding("UTF-8");
		out.println("<html><head><title>회원등록</title></head>");
		out.println("<body><h1>회원등록</h1>");
		out.println("<form action = 'MemberAddServlet' method ='post'>");
		out.println("이름:<input type ='text' name ='name'><br>");
		out.println("이메일:<input type ='text' name ='email'><br>");
		out.println("암호:<input type ='password' name ='password'><br>");
		out.println("<input type ='submit' value='추가'>");
		out.println("<input type ='reset' value='취소'>");
		out.println("</form>");
		out.println("</body></html>");
		
		
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
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL,dbId,dbPw);
            System.out.println("db 연결 성공" + conn);
            System.out.println(request);
            
            pst = conn.prepareStatement("insert into members (email, pwd, mname, cre_date, mod_date) values(?,?,?, now(), now())");
            pst.setString(1, request.getParameter("email")); //첫번째 물음표
            pst.setString(2, request.getParameter("password")); //두번째 물음표
            pst.setString(3, request.getParameter("name")); //세번째 물음표
            //request.setCharacterEncoding("utf-8");
            pst.executeUpdate();
            
            response.sendRedirect("list");
        }
        catch(Exception e) {
        	throw new ServletException();
        }
        finally {
            try {if(pst!= null) {pst.close();}} catch(Exception e) {System.out.println(e.getMessage());}
            try {if(conn != null) {conn.close();}} catch(Exception e) {System.out.println(e.getMessage());}
        }
	}



}
