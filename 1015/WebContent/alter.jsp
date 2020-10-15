<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.*"%>
<% request.setCharacterEncoding("UTF-8"); %>
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

   //jdbc-odbc driver 등록
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
      System.out.println("db 연결 성공" + conn);
   }catch(SQLException e){
      out.print("<script>alert('가입처리 되지 않앗습니다')</script>");
   }
   
   //퀴리를 실행함
   try{
	   stmt = conn.createStatement();
	 	stmt.executeUpdate("alter table woori modify name char(10) not null");
	 	stmt.executeUpdate("alter table woori add email char(30)");
	 	stmt.executeUpdate("alter table woori add password integer");
	//테이블 구조를 바꿈 	      
	   
   }catch(SQLException e) {
	   
	   out.println(e); //이것은 예외시 무슨 예외가 발생했는지 알려줌
   }
   
   try{
	   rs= stmt.executeQuery("select * from woori");
	   System.out.println(rs);
	    ResultSetMetaData rsmd = rs.getMetaData(); // Metadata는 정보
	   out.println("새로운 테이블이 생성되었습니다. <br>");
	   out.println(rsmd.getColumnCount() + "개의 컬럼(필드)를 가지고 있습니다.");//
		for(int i =1; i<=rsmd.getColumnCount(); i++) {
			out.println("첫번쨰 칼럼은" + rsmd.getColumnName(i) + "<br>");//
			out.println("이고 유형은 " + rsmd.getColumnTypeName(i));
			out.println("이며 크기는" + rsmd.getPrecision(i) + "<br>");
		}
	 //  out.println("첫번쨰 칼럼은" + rsmd.getColumnName(1) + "<br>");//
	 //  out.println("두번쨰 칼럼은" +rsmd.getColumnName(2) + "<br>");// 
	   //out.println("첫번쨰 칼럼은" +rsmd.getColumnName(3) + "<br>");//
	   //out.println("두번쨰 칼럼은" +rsmd.getColumnName(4) + "<br>");//
	   rs.close();
	   stmt.close();
	   conn.close();
   }catch(SQLException e){
	   out.print(e);
	   
   }
   
   
   %>

<a href = main.html>메인으로</a>

</body>
</html>