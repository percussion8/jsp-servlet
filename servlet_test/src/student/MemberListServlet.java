package student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.vo.Score;


@SuppressWarnings("serial")
@WebServlet({"/member/list"})
public class MemberListServlet extends HttpServlet {
   

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Connection conn = null;
         Statement stmt = null;
         ResultSet rs = null;
         String dbURL = "jdbc:mysql://localhost:3306/greendb?serverTimezone=Asia/Seoul";
	        String dbId = "root";
	        String dbPw = "1234";
         
         System.out.println("들어오나");
         
         try{
        	System.out.println("들어오나");
        	Class.forName("com.mysql.cj.jdbc.Driver");
  	       	conn = DriverManager.getConnection(dbURL,dbId,dbPw);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select sno, sname, kor, eng, math, totalScore, avgScore, rankScore from student order by sno asc");
            //조회
            System.out.println("들어오나");
            response.setContentType("text/html; charset=utf-8"); //실험
            //데이터 베이스에서 회원 정보를 가져와 Member에 담는다 
            //그리고 Member객체에 ArrayList를 추가 
            ArrayList<Score> student = new ArrayList<Score>();
            System.out.println("들어오나");
            
            while(rs.next()) { //DB로부터 가져온 데이터 ResultSet에서 하나씩 가져옴 
            	student.add(new Score()
            		  	.setSno(rs.getInt("sno"))
            		  	.setSname(rs.getString("sname"))
            		  	.setKor(rs.getInt("kor"))
            		  	.setEng(rs.getInt("eng"))
            		  	.setMath(rs.getInt("math"))
            		  	.setTotalScore(rs.getInt("totalScore"))
            		  	.setAvgScore(rs.getInt("avgScore"))
            		  	.setRankScore(rs.getString("rankScore"))
            		  	
            		  );
            }
            System.out.println("들어오나");
            //request 회원 목록 데이터 보관
           request.setAttribute("student", student);
           //jsp로 출력을 위임함
           System.out.println("들어오나");
           RequestDispatcher rd = request.getRequestDispatcher(
        		   "/member/memberlist.jsp"
        		   );
           rd.include(request, response);
           //에러 페이지면 jsp로 가서 안오는 forward쓸것
           //include는 보냈다가 다시 옴 (제어권이 넘어옴)
         }catch(Exception e){
            throw new ServletException();//예외를 던짐   
         } finally {
            try {if(rs != null) {rs.close();}} catch(Exception e) {System.out.println(e.getMessage());}
            try {if(stmt!= null) {stmt.close();}} catch(Exception e) {System.out.println(e.getMessage());}
            try {if(conn != null) {conn.close();}} catch(Exception e) {System.out.println(e.getMessage());}
         }
   }

}