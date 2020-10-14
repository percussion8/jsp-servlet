<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*" %>

<%

	String infile = "c:/jsp/filew.jsp"; 
	String outfile = "c:/jsp/filecopy.txt";
	
	int ch = 0;
	File inf = new File(infile);
	File ouf = new File(outfile);
	FileReader filer = new FileReader(inf);
	FileWriter filew = new FileWriter(ouf);
	try{
		while((ch=filer.read()) != -1) {
			filew.write(ch);
		}
		filer.close();
		filew.close();
	}catch(IOException e){
		out.println(e.getMessage());	
	}

%>