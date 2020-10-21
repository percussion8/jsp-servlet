package student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import student.vo.Score;

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
		        		 this.getInitParameter("password"));
	       stmt = conn.createStatement();
	       System.out.println("잘들어오나");
	       rs = stmt.executeQuery("select sno, sname, kor, eng, math, totalScore, avgScore, rankScore from student where sno = " + request.getParameter("sno"));
	    //   ArrayList<Member> student = new ArrayList<Member>();
	       System.out.println(request.getParameter("sno"));
	       	if(rs.next()) {
	       	 //DB로부터 가져온 데이터 ResultSet에서 하나씩 가져옴 
	       		request.setAttribute("student",new Score()
	       				.setSno(rs.getInt("sno"))
            		  	.setSname(rs.getString("sname"))
            		  	.setKor(rs.getInt("kor"))
            		  	.setEng(rs.getInt("eng"))
            		  	.setMath(rs.getInt("math"))
            		  	.setTotalScore(rs.getInt("totalScore"))
            		  	.setAvgScore(rs.getInt("avgScore"))
            		  	.setRankScore(rs.getString("rankScore"))
            		  	
            		  );
	       		System.out.println("되냐");
	       		
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
        String dbURL = "jdbc:mysql://localhost:3306/greendb?serverTimezone=Asia/Seoul";
        String dbId = "root";
        String dbPw = "1234";
        String rankScore = "";
        int avgScore = 0;
        
        System.out.println("아아");
		
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL,dbId,dbPw);
            stmt = conn.prepareStatement("update student set sname=?, kor=?, eng=?, math=?, totalScore=?, avgScore=?, rankScore=? where sno =?");
            
            stmt.setString(1, request.getParameter("sname")); //첫번째 물음표
            stmt.setInt(2, Integer.parseInt(request.getParameter("kor"))); //두번째 물음표
            stmt.setInt(3, Integer.parseInt(request.getParameter("eng"))); //세번째 물음표
            stmt.setInt(4, Integer.parseInt(request.getParameter("math"))); //네번째 물음표
            int totalScore = 
            		(Integer.parseInt(request.getParameter("kor"))) + (Integer.parseInt(request.getParameter("eng"))) 
            		+ (Integer.parseInt(request.getParameter("math")));
            stmt.setInt(5, totalScore);
            //request.setCharacterEncoding("utf-8");
            avgScore = totalScore/3;
            stmt.setInt(6, avgScore);
          
            if(avgScore >= 90) {
            	rankScore = "수";
            }
            else if(avgScore >= 80) {
            	rankScore = "우";
            }
            else if(avgScore >= 70) {
            	rankScore = "미";
            }
            else if(avgScore >= 60) {
            	rankScore = "양";
            }
            else {
            	rankScore = "가";
            }
            stmt.setString(7,rankScore);
            stmt.setInt(8, Integer.parseInt(request.getParameter("sno")));
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
