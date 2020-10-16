package green;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet({ "/Register", "/r" })
public class Register extends HttpServlet {
    

    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("잘들어오나");
		response.getWriter().append("hello: ").append(request.getContextPath());
		//웹브라우저에는 append 뒤에가 나옴
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String n = request.getParameter("userName");
		String p = request.getParameter("userPass");
		String e = request.getParameter("userEmail");
		String c = request.getParameter("userCountry");
		
		String dbURL = "jdbc:mysql://localhost:3306/member?serverTimezone=Asia/Seoul";
		String dbId = "root";
		String dbPw = "1234";
		String sql = "insert into registerUser values(?,?,?,?)";
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //드라이버 로딩
			Connection conn = DriverManager.getConnection(dbURL,dbId,dbPw); //DB연결
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, n);
			ps.setString(2, p);
			ps.setString(3, e);
			ps.setString(4, c);
			int i = ps.executeUpdate();
			if(i>0) out.print("성공적으로 계정이 등록되었습니다.");
			
		}catch(Exception e2) {
			out.println(e2);
			e2.getMessage();
			out.close();
		}
		
		
		
		System.out.println("포스트 잘들어오나" + " " + request.getParameter("userName"));
		doGet(request, response);
	}

}
