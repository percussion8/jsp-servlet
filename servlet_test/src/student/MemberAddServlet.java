package student;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;

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
				"/member/memberform.jsp" //member 폴더 안의 meberform.jsp를 실행 > 웹에서 페이지 보임 
				
				);
				
		rd.forward(request, response); // forward는 다시 돌아 오지 않음 
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		Connection conn =null;
		PreparedStatement pst = null;
        String dbURL = "jdbc:mysql://localhost:3306/greendb?serverTimezone=Asia/Seoul";
        String dbId = "root";
        String dbPw = "1234";
        int avgScore = 0;
        String rankScore = "";
        System.out.println("되냐");
        
        try {
        	System.out.println("들어오나");
        	Class.forName("com.mysql.cj.jdbc.Driver");
  	       	conn = DriverManager.getConnection(dbURL,dbId,dbPw);
            System.out.println("db 연결 성공" + conn);
            System.out.println(request);
            
            pst = conn.prepareStatement("insert into student (sname, kor, eng, math, totalScore, avgScore, rankScore) values(?,?,?,?,?,?,?)");
            pst.setString(1, request.getParameter("sname")); //첫번째 물음표
            pst.setInt(2, Integer.parseInt(request.getParameter("kor"))); //두번째 물음표
            pst.setInt(3, Integer.parseInt(request.getParameter("eng"))); //세번째 물음표
            pst.setInt(4, Integer.parseInt(request.getParameter("math"))); //네번째 물음표
            int totalScore = 
            		(Integer.parseInt(request.getParameter("kor"))) + (Integer.parseInt(request.getParameter("eng"))) 
            		+ (Integer.parseInt(request.getParameter("math")));
            pst.setInt(5, totalScore);
            //request.setCharacterEncoding("utf-8");
            avgScore = totalScore/3;
            System.out.println(avgScore);
            pst.setInt(6, avgScore);
          
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
            pst.setString(7,rankScore);
            
            pst.executeUpdate();
            //리다이렉트를 이용한 리프레시
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
