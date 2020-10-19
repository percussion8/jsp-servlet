package green;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberUpdateServlet
 */
//@WebServlet({ "/MemberUpdateServlet", "/member/update" })
@SuppressWarnings("serial")
public class MemberUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Connection conn = null;
	      Statement stmt = null;
	      ResultSet rs = null;
	      
	      try{
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         conn = DriverManager.getConnection(
	        		 this.getInitParameter("url"),
	        		 this.getInitParameter("username"),
	        		 this.getInitParameter("password")
	        		 );
	       stmt = conn.createStatement();
	       System.out.println("잘들어오나");
	       rs = stmt.executeQuery(
	    		   "select mno, email, mname, cre_date from members where mno = " + request.getParameter("no")
 
	        		 );	
	       	rs.next();
	       	response.setContentType("text/html; charset=utf-8");
	       	PrintWriter out = response.getWriter();
	       	out.println("<html><head><title>회원정보</title></head>");
	       	out.println("<body><h1>회원정보</h1>");
	       	out.println("<form action = 'update' method = 'post'>");
	       	out.println("번호 : <input type = 'text' name='no' value='" +
	       			request.getParameter("no") + "' readonly><br>"
	       			);
	       	out.println("이름 : <input type = 'text' name = 'name'" +
	       			"value = " + rs.getString("mname") +"><br>");
	       	out.println("이메일 : <input type = 'text' name = 'email'" +
	       			"value = " + rs.getString("email") +"><br>");
	       	out.println("가입일 : <input type = 'text' name = 'cre_date'" +
	       			"value = " + rs.getDate("cre_date") +"><br>");
	       	out.println("<input type ='submit' value ='저장'>");
	       	out.println("<input type ='button' value ='취소'" + " onclick= 'location.href= \"list\" '>");
	       	out.println("</form>");
	       	out.println("</body></html>");
	         }catch(Exception e) {
	        	 throw new ServletException(e);
	         } finally {
	        	 try {if(rs!= null) {rs.close();}} catch(Exception e) {System.out.println(e.getMessage());}
	        	 try {if(stmt!= null) {stmt.close();}} catch(Exception e) {System.out.println(e.getMessage());}
	        	 try {if(conn != null) {conn.close();}} catch(Exception e) {System.out.println(e.getMessage());}
	        	 
	         }
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("잘들어오나 확인");
		request.setCharacterEncoding("utf-8");
		
		Connection conn =null;
		PreparedStatement stmt = null;
        String dbURL = "jdbc:mysql://localhost:3306/studydb?serverTimezone=Asia/Seoul";
        String dbId = "root";
        String dbPw = "1234";
		
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL,dbId,dbPw);
            stmt = conn.prepareStatement("update members set email=?, mname =?, mod_date=now() where mno =?");
            stmt.setString(1, request.getParameter("email"));
            stmt.setString(2, request.getParameter("name"));
            stmt.setInt(3, Integer.parseInt(request.getParameter("no")));
            stmt.executeUpdate();
            
            response.sendRedirect("list");
            
            
        }catch(Exception e) {
        	throw new ServletException(e);
        } finally {
    
       	 try {if(stmt!= null) {stmt.close();}} catch(Exception e) {System.out.println(e.getMessage());}
       	 try {if(conn != null) {conn.close();}} catch(Exception e) {System.out.println(e.getMessage());}
       	 
        }
        
		
		
		
		doGet(request, response);
	}



}
