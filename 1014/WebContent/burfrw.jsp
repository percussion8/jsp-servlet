<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*"%>


<%

	String infile = "c:/jsp/filew.jsp"; 
	String outfile = "c:/jsp/filecopy.txt";
	String strline = null;
	
	
	FileReader filer = new FileReader(new File(infile));
	FileWriter filew = new FileWriter(new File(outfile));
	BufferedReader bufr = new BufferedReader(filer);
	BufferedWriter bufw = new BufferedWriter(filew);
	try{
		while((strline=bufr.readLine()) != null) {
			strline = strline+ "<br>";
			bufw.write(strline, 0, strline.length());
			//void write(char[] cbuf, int off, int len) 배열 cbuf에서 off를 시작지점으로 len만큼의 문자를 출력
			bufw.newLine();
		}
		bufw.close();
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