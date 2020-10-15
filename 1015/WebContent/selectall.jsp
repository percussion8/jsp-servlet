<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.*"%>
<% request.setCharacterEncoding("UTF-8"); %>

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

      }catch(SQLException e){
      out.print(e);
   }
   
   //퀴리를 실행함
   try{
	   stmt = conn.createStatement();
	   rs = stmt.executeQuery("select * from woori order by id");
	 	//stmt.executeUpdate("create table woori(id char(10) primary key, name char(10))");
	   //out.print("새로운 테이블이 생성되었습니다. <br>");
	   
	%>
<html>
<body>
   <center>
      <h3>우리 회원 정보 보기</h3>
      <table border="1">
         <tr>
            <th>사용자 id</th>
            <th>이름</th>
            <th>e-mail</th>
         </tr>
         <%if(!(rs.next())) {%>

               <tr>
                  <td colspan ="4">등록한 회원이 없습니다. </td>
               </tr>

        <% } else {
           do{
              out.println("<tr>");
              out.println("<td>" + rs.getString("id") + "</td>");
              out.println("<td>" + rs.getString("name") + "</td>");
              out.println("<td>" + rs.getString("email") + "</td>");
              out.println("</tr>");
           }while(rs.next());

        }
        rs.close();
        stmt.close();
        conn.close();
        } catch(SQLException e) {
        	System.out.println(e);
        }
        %>
         
      </table>
      [<a href = main.html>메인으로</a>]&nbsp; 
      	[<a href= "insert.html">회원등록페이지로</a>]
   </center>
</body>
</html>
