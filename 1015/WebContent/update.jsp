<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import ="java.sql.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%
   String id = request.getParameter("id");
   //int password = Integer.parseInt(request.getParameter("password"));
   String name = request.getParameter("name");
   String email = request.getParameter("email");
   Connection conn = null;
   Statement stmt = null;
   String sql = null;
   
		   
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
   
   out.println(sql);
   //퀴리를 실행함
   try{
	   stmt = conn.createStatement();
	 	//질의어 수행
	 	
	 	sql = "update woori set ";
	 	sql = sql + "name ='"+name + "'," + "email ='" + email + "'";
	 	sql = sql+ " where id = '" + id + "'";
	 	System.out.println(sql);
	 	stmt.executeUpdate(sql);
	 	stmt.close();
	 	conn.close();
	
   }catch(SQLException e) {
	   
	   out.println(e); //이것은 예외시 무슨 예외가 발생했는지 알려줌
   }
   
   
%>
<jsp:forward page = "selectall.jsp"/>