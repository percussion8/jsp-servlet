<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	int a = 10, b =20, c;
	float fa =10.5f, fb =20.0f, fc;
	
	//정수와 문자의 연산시 정수형으로 자동형 변환된다. 
	c = a + 'A';
	out.print("c의 값은 : " + c + "<p>");
	//정수와 정수의 연산시 결과는 정수형이 된다. 
	c = a+b;
	out.print("c의 값은 :" + c + "<p>");
	
	//정수와 실수, 실수와 정수 또는 실수간의 연산시 실수형으로 자동형변환 된다. 
	fc = a+fb; //upcasting (자동으로 형변환) downcasting(강제로)
	out.print("fc의 값은 : " + fc + "<p>");
	fc = fb +a;
	out.print("fc의 값은 : " + fc + "<p>");
	fc = fa+fb;
	out.print("fc의 값은 : " + fc  + "<p>");

%>