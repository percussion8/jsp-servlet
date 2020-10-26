package green;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import green.vo.Member;


@SuppressWarnings("serial")
@WebServlet({"/member/list"})
public class MemberListServlet extends HttpServlet {
   

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Connection conn = null;
         Statement stmt = null;
         ResultSet rs = null;

//         Member member = new Member();
//         member.setName("이재오")
//         		.setEmail("fff@test.com")
//         		.setNo(5)
//         		.setPassword("1234");
//         
//         System.out.println("이름은 " + member.getName() +
//        		 	" 이메일 " + member.getEmail() + " 번호는 " + member.getNo() + " 암호는 " + member.getPassword()
//        		 );
//         Calendar cal = Calendar.getInstance();
//         Date date = new Date();
//         Member[] members = new Member[3];
//        
//         for(int i =0; i<3; i++) {
//        	 members[i] = new Member();
//        	 members[i].setName("이름");
//
//         }
//   
//         for(Member i : members) {
//        	 i.getName();
//         }
//         
//         List<Member> alMembers = new ArrayList<Member>();   
//         for(int i =0; i<3; i++) {
//        	 alMembers.add(new Member().setName("아알"));
//         }   
//         
//         
//         Map<String, Member> mapMembers = new HashMap<String, Member>();
//         //여기 배열에 객체 추가하여 멤버 변수의 데이터 추가한 후 
//         //저장된 값들을 getter 호출하여 화면에 출력하세요
//    
//        	 mapMembers.put("1", members[1].setName("이름")
//        			 					.setNo(1).setEmail(1 + "ff@test.com").setPassword("1234"));
//        	 
//         
//         System.out.println(mapMembers.get("1").getName());
//         
         
         try{
        	ServletContext sc = this.getServletContext();
        	conn = (Connection)sc.getAttribute("conn");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select mno, mname, email, cre_date from members order by mno asc");
            //조회
            response.setContentType("text/html; charset=utf-8"); //실험
            //데이터 베이스에서 회원 정보를 가져와 Member에 담는다 
            //그리고 Member객체에 ArrayList를 추가 
            ArrayList<Member> members = new ArrayList<Member>();
            
            while(rs.next()) { //DB로부터 가져온 데이터 ResultSet에서 하나씩 가져옴 
              members.add(new Member()
            		  	.setNo(rs.getInt("mno"))
            		  	.setName(rs.getString("mname"))
            		  	.setEmail(rs.getString("email"))
            		  	.setCreatedDate(rs.getDate("cre_date"))
            		  );
              
            }
            //request 회원 목록 데이터 보관
           request.setAttribute("members", members);
           //jsp로 출력을 위임함
           RequestDispatcher rd = request.getRequestDispatcher(
        		   "../member/memberlist.jsp"
        		   );
           rd.include(request, response);
           //에러 페이지면 jsp로 가서 안오는 forward쓸것
           //include는 보냈다가 다시 옴 (제어권이 넘어옴)
         }catch(Exception e){
            throw new ServletException();//예외를 던짐   
         } finally {
            try {if(rs != null) {rs.close();}} catch(Exception e) {System.out.println(e.getMessage());}
            try {if(stmt!= null) {stmt.close();}} catch(Exception e) {System.out.println(e.getMessage());}
           // try {if(conn != null) {conn.close();}} catch(Exception e) {System.out.println(e.getMessage());}
         }
   }

}