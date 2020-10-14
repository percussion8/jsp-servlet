<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%
      Connection conn = null;
   Statement stmt = null;
   ResultSet rs = null;

   try {
      Class.forName("com.mysql.cj.jdbc.Driver");
   } catch (ClassNotFoundException e) {
      out.print(e);
   }
   String dbURL = "jdbc:mysql://localhost:3306/member?serverTimezone=Asia/Seoul";
   String dbId = "root";
   String dbPw = "1234";
   
   try{
      conn = DriverManager.getConnection(dbURL,dbId,dbPw);
      System.out.println("db 연결 성공");
   }catch(SQLException e){
      out.print("<script>alert('가입처리 되지 않앗습니다')</script>");
   }
   
   %>


</body>
</html>