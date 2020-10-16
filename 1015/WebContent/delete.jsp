<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.*"%>

   <%
   //Connection은 database와 연결을 담당
   Connection conn = null;
   //statement 정적 SQL문을 실행하고 생성된 결과를 반환 
   Statement stmt = null;
   String sql = null;
   
   String id = request.getParameter("id");

   try {
      Class.forName("com.mysql.cj.jdbc.Driver");
   } catch (ClassNotFoundException e) {
      out.print(e);
   }
   String dbURL = "jdbc:mysql://localhost:3306/member?serverTimezone=Asia/Seoul";
   String dbId = "root";
   String dbPw = "1234";
   //DB와 연결 
   try{
      conn = DriverManager.getConnection(dbURL,dbId,dbPw);
      System.out.println("db 연결 성공");
      //statement 객체 생성
      stmt = conn.createStatement();
      sql = "delete from woori where id = '" + id + "'";
      
      stmt.executeQuery(sql);
      stmt.close();
      conn.close();
      
   }catch(SQLException e){
      out.print("<script>alert('가입처리 되지 않앗습니다')</script>");
   }
   
   
   %>

<jsp:forward page = "selectall.jsp" />
</body>
</html>