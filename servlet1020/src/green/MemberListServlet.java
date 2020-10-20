package green;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import green.vo.Member;
import java.util.Date;


@SuppressWarnings("serial")
@WebServlet({"/member/list"})
public class MemberListServlet extends HttpServlet {
   

   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Connection conn = null;
         Statement stmt = null;
         ResultSet rs = null;
         String dbURL = "jdbc:mysql://localhost:3306/studydb?serverTimezone=Asia/Seoul";
         String dbId = "root";
         String dbPw = "1234";
//         Member member = new Member();
//         member.setName("이재오")
//         		.setEmail("fff@test.com")
//         		.setNo(5)
//         		.setPassword("1234");
//         
//         System.out.println("이름은 " + member.getName() +
//        		 	" 이메일 " + member.getEmail() + " 번호는 " + member.getNo() + " 암호는 " + member.getPassword()
//        		 );
         Calendar cal = Calendar.getInstance();
         Date date = new Date();
         Member[] members = new Member[3];
        
         for(int i =0; i<3; i++) {
        	 members[i] = new Member();
        	 members[i].setName("이름");

         }
   
         for(Member i : members) {
        	 i.getName();
         }
         
         List<Member> alMembers = new ArrayList<Member>();   
         for(int i =0; i<3; i++) {
        	 alMembers.add(new Member().setName("아알"));
         }   
         
         
         Map<String, Member> mapMembers = new HashMap<String, Member>();
         //여기 배열에 객체 추가하여 멤버 변수의 데이터 추가한 후 
         //저장된 값들을 getter 호출하여 화면에 출력하세요
    
        	 mapMembers.put("1", members[1].setName("이름")
        			 					.setNo(1).setEmail(1 + "ff@test.com").setPassword("1234"));
        	 
         
         System.out.println(mapMembers.get("1").getName());
         
         
         try{
           Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL,dbId,dbPw);
            System.out.println("db 연결 성공" + conn);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select mno, mname, email, cre_date from members order by mno asc");
            response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<html><head><title>회원목록</title></head>");
            out.println("<body><h1>회원목록</h1>");
            out.println("<p><a href='add'> 신규회원 </a></p>");
            while(rs.next()) { //DB로부터 가져온 데이터 ResultSet에서 하나씩 가져옴 
               out.println(rs.getInt("mno") + ", " + 
            		   "<a href='update?no=" +rs.getInt("mno")+"'>" +
            		   rs.getString("mname") + ", " + 
            		   rs.getString("email")  + ", "
            		   + rs.getDate("cre_date") 
            		   + "<br>");
            }
            out.println("</body></html>");
            
            
         }catch(Exception e){
            throw new ServletException();//예외를 던짐   
         } finally {
            try {if(rs != null) {rs.close();}} catch(Exception e) {System.out.println(e.getMessage());}
            try {if(stmt!= null) {stmt.close();}} catch(Exception e) {System.out.println(e.getMessage());}
            try {if(conn != null) {conn.close();}} catch(Exception e) {System.out.println(e.getMessage());}
         }
   }

}