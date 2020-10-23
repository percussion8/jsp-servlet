package green.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import green.vo.Member;
import green.dao.*;

@SuppressWarnings("serial")
@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//지역변수 선언 
				//Connection conn = null;
				//Statement  stmt = null;
			
				
				try {
					ServletContext sc = this.getServletContext();
					MemberDao memberDao = (MemberDao) sc.getAttribute("memberDao");
					
					Member member = memberDao.selectOne(Integer.parseInt(request.getParameter("no")));
					request.setAttribute("member", member);
					
					RequestDispatcher rd = request.getRequestDispatcher("/member/MemberUpdateForm.jsp");
					rd.forward(request, response);	
				} catch(Exception e) {
					e.printStackTrace();
					request.setAttribute("error", e);
					RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
					rd.forward(request, response);
		
				}finally {
		
		//try {if(stmt!=null) stmt.close();} catch(Exception e) {}
		//try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Connection conn =null;
		//PreparedStatement stmt = null;
		//DB와 연결
		try {
			ServletContext sc = this.getServletContext();
			MemberDao memberDao = (MemberDao) sc.getAttribute("memberDao");
			memberDao.update(new Member().setNo(Integer.parseInt(request.getParameter("no")))
					.setName(request.getParameter("name"))
					.setEmail(request.getParameter("email")));
			//setConnection 메서드 호출 
			//update 메서드 호출
			//호출시 파라미터로 Member 객체 생성과 동시에
			
			response.sendRedirect("list");
			
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response); //예외를 던짐
		} 
		
	}
	
	
	
}
