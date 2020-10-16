<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.*"%>
<% request.setCharacterEncoding("UTF-8"); %>

   <%
   String id = request.getParameter("id");
   int password = Integer.parseInt(request.getParameter("password"));
   String name = request.getParameter("name");
   String email = request.getParameter("email");
   String sql = null;
   
   Connection conn = null;
   Statement stmt = null;
   ResultSet rs = null;
   int cnt = 0;

   try {
	   
      Class.forName("com.mysql.cj.jdbc.Driver");
   } catch (ClassNotFoundException e) {
      out.print(e);
   }
   String dbURL = "jdbc:mysql://localhost:3306/member?serverTimezone=Asia/Seoul";
   String dbId = "root";
   String dbPw = "1234";
   //System.out.println(id);
   
   try{
	  System.out.println(id);
      conn = DriverManager.getConnection(dbURL,dbId,dbPw);
      stmt = conn.createStatement();
      rs = stmt.executeQuery("select * from woori where id ='" + id +"'");
      if(!(rs.next())) {
    	  //Statement 객체 생성
    	  sql = "insert into woori(id,password,name,email)";
    	  sql = sql + " values('" + id + "'," + password+",";
    	  sql = sql + "'" + name+"','"+ email + "')"; 
    	  //insert 문을 이용하여 데이터 추가
    	  cnt = stmt.executeUpdate(sql);
    	  if(cnt>0) out.println("데이터가 성공적으로 입력되었습니다.");
    	  else out.println("데이터가 입력되지 않았습니다.");
    	  
      }
      else {
      	out.println("id가 이미 등록되어 있습니다.");
      	stmt.close();
      	conn.close();
      }
      
   }catch(SQLException e){
      out.print("<script>alert('가입처리 되지 않앗습니다')</script>");
   }
   
   //퀴리를 실행함
   try{
	   stmt = conn.createStatement();
	 	//stmt.executeUpdate("create table woori(id char(10) primary key, name char(10))");
	   //out.print("새로운 테이블이 생성되었습니다. <br>");
	   
   }catch(SQLException e) {
	   
	   out.println(e); //이것은 예외시 무슨 예외가 발생했는지 알려줌
   }
   
   try{
	   rs= stmt.executeQuery("select * from woori");
	   System.out.println(rs);
	   /* ResultSetMetaData rsmd = rs.getMetaData(); // Metadata는 정보
	   out.println("새로운 테이블이 생성되었습니다. <br>");
	   out.println(rsmd.getColumnCount() + "개의 컬럼(필드)를 가지고 있습니다.");//
	   out.println("첫번쨰 칼럼은" + rsmd.getColumnName(1) + "<br>");//
	   out.println("두번쨰 칼럼은" +rsmd.getColumnName(2) + "<br>");// */
	   //out.println("첫번쨰 칼럼은" +rsmd.getColumnName(3) + "<br>");//
	   //out.println("두번쨰 칼럼은" +rsmd.getColumnName(4) + "<br>");//
	   rs.close();
	   stmt.close();
	   conn.close();
   }catch(SQLException e){
	   out.println(e);
	   
   }
   
   
%>

[<a href = main.html>메인으로</a>]
&nbsp; [<a href = "insert.html">회원등록페이지로</a>]