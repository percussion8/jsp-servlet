<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import= "java.lang.*" %>
<jsp:useBean id="cnt" scope="application" class="green.Counter">
</jsp:useBean>

<%
	int count=0;
	session = request.getSession(); //세션 얻어옴 (생성)
	//session 선언도 안하고 그냥 할 수 있는 이유 : 내장객체라서
	session.setMaxInactiveInterval(1); //1초 세션 유지
	String first = (String) session.getValue("checkFirst");
	
	
	String count_file = "c:/jsp/count.txt"; //저장할 내용의 파일 생성
	if(cnt.getCount() == 0) {
		int j =0;
		String old = null;
		File infile = new File(count_file); //파일객체 생성, 생성자의 파라미터로 파일
		try{//파일 입출력 또는 데이터 베이스 접근은 try catch로 감쌈
			if(infile.exists()) {
				BufferedReader input = new BufferedReader(new FileReader(infile));
				if((old = input.readLine())!=null) { // 한 줄씩 읽어들임 
					int i = Integer.parseInt(old);
					for(j=0; j<i; j++) {
						System.out.println("파일의 내용을 읽은 값은 무언가?" +old); //추가
						cnt.plusCount();
						System.out.println("파일의 내용을 읽은 값은 무언가?" +cnt.getCount()); //추가
					}
					input.close(); //파일 닫기
				}
			}
		}catch (IOException e) {
			out.println(e.getMessage());
		}
	}
	
	if(first != null) {
		count = cnt.getCount();
	}
	else {
		cnt.plusCount();
		count = cnt.getCount();
		session.putValue("checkFirst", "first");
	}
	
	if(count%10 ==0) {
		try{
			
			count_file = "c:/jsp/count.txt";
			PrintWriter pw = new PrintWriter(new FileWriter(count_file));
			pw.println(count);
			pw.close();
		
		}catch (IOException e){
			out.println(e.getMessage());
			}
		
		
	}
	out.println("현재까지 방문자 수 : " + count );
	
	//세션 예시 
	//session.putValue("key", "value");
	//session.putValue("key1", "value1");
	//session.getValue("key", "value");
	//session.getValue("key1", "value1");
	//session.getAttribute("key", "value");
	//session.getAttribute("key1", "value1");
%>