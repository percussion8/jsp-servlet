<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    스크립트 태그(<% %>) 내에서는 자바 코드를 사용할 수 있으며 
    일반적인 자바 코드와 마찬가지로 각 문장은 세미콜론으로 끝난다.
    또한 한줄의 문장으로 끝낼 수 없는 문장은 여러줄에 기록 가능 
<%! 

	public int sum() { // 함수 선언 
		int a =10, b =20, c;
		c = a+b;
		return c;
	}
%>

여기에 함수의 값이 출력되도록 해보세요
<%= sum()
%>