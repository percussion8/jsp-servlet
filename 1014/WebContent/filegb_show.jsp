<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*" %>    

<html>
<head>
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>

<%

//File 객체 생성하세요, 참조변수는 board_file
File board_file = new File("c:/jsp/write.txt");
//생성자의 파라미터는 "c:/jsp/write.txt"

//문자열 변수 s 선언 후 null 값 대입
String s = null;
//try catch문으로 감싸서 
try{
	FileReader in1 = new FileReader(board_file);
	BufferedReader in2 = new BufferedReader(in1);
	while((s=in2.readLine()) != null ) {
		out.println(s);
	}
	in2.close();
}catch(IOException e){
	out.println(e.getMessage());	
}
//FileReader 객체 in1 을 생성, 생성자의 파라미터는 board_file
//BufferedReader 객체 생성 in2, 생성자의 파라미터는 in1
//while(in2 의 메서드 readLine의 반환 값을 s에 대입하고 대입한 결과가 null이 아닌동안 반복함),
//반복하면서 out.println(s); //출력
//while문 밖에서 in2.close()
//catch문에서 out.println(e.getMessage());


%>

<center>
    <a href="filegb_write.html">
    <img src="image/write.gif" alt="" with="54" height="19" border="0">
    </a>

</center>


</body>

</html>