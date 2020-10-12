<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	int score =96;
	char grade;
	
	switch(score/10) {
	case 10: 
	case 9:
		grade = 'A';
		out.print("점수는 :" + score + "이고 학점은 :" + grade);
		break;
	case 8:
		grade = 'B';
		out.print("점수는 :" + score + "이고 학점은 :" + grade);
		break;
	case 7:
		grade = 'C';
		out.print("점수는 :" + score + "이고 학점은 :" + grade);
		break;
	case 6:
		grade = 'D';
		out.print("점수는 :" + score + "이고 학점은 :" + grade);
		break;
	default:
		grade = 'F';
		out.print("점수는 :" + score + "이고 학점은 :" + grade);
		break;
	}
	
	
%>