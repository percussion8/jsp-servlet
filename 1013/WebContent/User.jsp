<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="info" scope="page" class= "green.User" />
<jsp:setProperty property="name" name="info"/>
<jsp:setProperty property="num" name="info" param="id"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP beans 테스트</title>
<style>

.center{
	margin-left:auto;
	margin-right:auto;

}

</style>
</head>
<body>
  <form method="post">
    <table border=0 width = 300 class= center>         
            <tr>
                <th bgcolor="#996699" colspan="2">
                    <font color="white" size="+1">JSP beans 테스트 </font>
                </th>
            </tr>
            <tr>
                <th width="20%" bgcolor="#BB6699" width="40%">
                    <font color="white" size="-1">이름</font>
                </th>
                <td bgcolor="#99ccff" width="60%">
                    <input type="text" name="name" 
                    size="10" value= "<%=info.getName()%>" >
                </td>
            </tr>
            <tr>
                <th bgcolor="#BB6699" width="40%">
                    <font color="white" size="-1">학번</font>
                </th>
                <td bgcolor="#99ccff">
                    <input type="text" name="id" 
                    size="10" value= "<%=info.getNum()%>" >
                </td>
            </tr>
            <tr>
                <td colspan="2">
                <input type="submit" value="보내기">
                <input type="reset" value="다시쓰기">
                </td>
            </tr>           
        </table>
        </form>
        <jsp:include page = "setget.jsp" />
</body>
</html>