package green.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import green.dao.MemberDao;
import green.vo.Member;

@SuppressWarnings("serial")
@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//지역변수 선언
		
		//DB와 연결
		try {
			ServletContext sc = this.getServletContext();
			MemberDao memberDao = (MemberDao) sc.getAttribute("memberDao");
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(
//					"SELECT MNO,MNAME,EMAIL,CRE_DATE" + 
//					" FROM MEMBERS" +
//					" ORDER BY MNO ASC");
//			
//			response.setContentType("text/html; charset=UTF-8");
//			ArrayList<Member> members = new ArrayList<Member>();//추가 
//			// 데이터베이스에서 회원 정보를 가져와 Member에 담는다.
//			// 그리고 Member객체를 ArrayList에 추가한다.
			//문제
			//MemberDao 객체 생성, 참조 변수 memberDao
			request.setAttribute("members", memberDao.selectlist());
			response.setContentType("text/html; charset=UTF-8");
			RequestDispatcher rd = request.getRequestDispatcher("/member/MemberList.jsp");
			rd.include(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}

	}
}
