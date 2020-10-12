<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%!
	public int show(float f, int b) {
		float result = f* 5.0f +b;
		return (int)result;
	}

%>

<!-- 정수 메서드의 매개변수인 float 자료형으로 자동형변환된다.   -->
<%=
	"show()메서드의 호출 결과는 : " + show(5.0f, 1)
%>

