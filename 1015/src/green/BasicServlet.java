package green;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({ "/BasicServlet", "/b" })
public class BasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public BasicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기 잘 들어오나" + request.getParameter("kor"));
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//html 내 form 태그의 method 속성이 get일 경우 호출
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("여기 잘 들어오나" + request.getParameter("kor"));
		//html 내 form 태그의 method 속성이 post일 경우 호출
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
