package green;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import green.vo.Member;

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
	       ServletContext sc = this.getServletContext();
	       conn = (Connection)sc.getAttribute("conn");
	       stmt = conn.createStatement();
	       System.out.println("잘들어오나");
	       rs = stmt.executeQuery(
	    		   "select mno, email, mname, cre_date from members where mno = " + request.getParameter("no")
 
	        		 );	
	       ArrayList<Member> members = new ArrayList<Member>();
	       	if(rs.next()) {
	       	 //DB로부터 가져온 데이터 ResultSet에서 하나씩 가져옴 
	              members.add(new Member()
	            		  	.setNo(rs.getInt("mno"))
	            		  	.setName(rs.getString("mname"))
	            		  	.setEmail(rs.getString("email"))
	            		  	.setCreatedDate(rs.getDate("cre_date"))
	            		  );
	         	
	       	} else {
	       		throw new Exception("해당 번호의 회원을 찾을 수 없습니다.");
	       	}
	       	
	       	RequestDispatcher rd = request.getRequestDispatcher(
	       			"/member/memberupdateform.jsp"
	       			);
	       	rd.forward(request, response);
	       	
	         }catch(Exception e) {
	        	 e.printStackTrace();
	        	 request.setAttribute("error", e);
	        	 RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
	         } finally {
	        	 try {if(rs!= null) {rs.close();}} catch(Exception e) {System.out.println(e.getMessage());}
	        	 try {if(stmt!= null) {stmt.close();}} catch(Exception e) {System.out.println(e.getMessage());}
	        	// try {if(conn != null) {conn.close();}} catch(Exception e) {System.out.println(e.getMessage());}
	        	 
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
