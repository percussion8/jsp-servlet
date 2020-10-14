<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*" %>    
    

 <%
 	//파일 입출력 연습
 	/*
 	파일 클래스는 파일을 처리하기 위한 클래스
 	입출력을 위해 필요한 파일과 폴더를 다루며 파일의 날짜와
 	시간 표식도 관리하고 서브 폴더 계층도 관리
 	(방법1) File dir = new File("c:\\temp\\myfile");
 	File dir = new File("c:/temp/myfile");
 	(방법2) 특정 파일을 위한 File 클래스의 객체 생성
 	File infile = new File("c:\\temp\\myfile", "count.txt");
 	(방법3) 방법2와 비슷하지만 String 유형의 값으로 경로를 지정하는 대신 
 	이전에 File 객체로 생성한 객체이름을 전달함 
 	File dir = new File("c:/temp/myfile");
 	File infile = new File(dir, count.txt);
 	File infile = new File(new File("c:/temp/myfile"), count.txt);
 	1) 메서드 exists() => 파일이 존재하면 true, 없으면 false;
 	getName(): 파일이름을 문자열로 반환
 	getParent() : 상위 폴더의 이름 반환, 존재하지 않을 경우 null 반환
 	isDirectory() : 현재의 객체가 폴더이면 true 반환
 	length() :파일을 바이트 반환
 	list() : 파일 클래스의 폴더 내용 열거, 각 파일과 폴더 이름을 배열로 반환
 	폴더인 파일 클래스 객체에만 동작
 	mkdir() : 현재 폴더와 관련된 File 클래스에 폴더 생성
 	성공적으로 생성되면 true 반환, 지정된 상위 폴더는 반드시 존재해야 함
 	mkdirs() : mkdir()과 비슷하지만 경로를 지정한 폴더가 상위 폴더가 존재하지 않으면
 	그 폴더들까지 만든 다음 지정한 폴더 생성
 	*/

 	String indir = "c:/jsp";
 
 	String infile = "count.txt";
 	
 	int i =0;
 	File dir = new File(indir);
 	File afile = null;
 	File check = new File(indir, infile);
 	System.out.println(indir);
 	
 	if(check.exists())
 		out.println(indir+"경로에" + infile + "파일이 존재합니다. <br>");
 	else //infile 변수 값의 파일명이 경로에 없으면 다음 소스 출력 
 		out.println(indir+"경로에" + infile + "파일은 없습니다.<br>");
 	out.println("<p>");
 	String [] dirlist = dir.list();
 	for(int j =0; j< dirlist.length ; j++) {
 		System.out.println(dirlist[j]);	
 	}
 	for(String a : dirlist) System.out.println(a); // advanced for문
 	
 	out.println("디렉토리/폴더들<br>");
 	out.println("<select size = 10>");
 	
 	for(i=0; i<dirlist.length; i++) {
 		afile = new File(indir, dirlist[i]);
 		out.print("<option>" + dirlist[i] + "<br>");
 		if(afile.isFile())
 			out.print("(" + afile.length() + "Byte)");
 	}
 	
 	out.print("what");
    
 %>