<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*"%>


<%
	//bufferedwriter와 같음 
	String infile = "c:/jsp/filew.jsp"; 
	String outfile = "c:/jsp/filecopy.txt";
	String strline = null;
	
	
	FileReader filer = new FileReader(new File(infile));
	FileWriter filew = new FileWriter(new File(outfile));
	BufferedReader bufr = new BufferedReader(filer);
	PrintWriter pw = new PrintWriter(filew);
	//파일 입출력과 같은 CRUD는 무조건 try catch 필요
	try{
		while((strline=bufr.readLine()) != null) {
			//strline = strline+ "<br>";
			pw.println(strline+ "<br>");
			
		}
		pw.close();
	}catch(IOException e){
		out.println(e.getMessage());	
	}
	bufr = new BufferedReader(new FileReader(outfile));
	try{
		while((strline=bufr.readLine()) != null) {
			out.println(strline);
		}
		
	}catch(IOException e){
		out.println(e.getMessage());	
	}
	bufr.close();
%>