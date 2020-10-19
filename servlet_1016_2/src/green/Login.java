package green;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet({ "/Login", "/login" })
public class Login extends HttpServlet {
	
	private Map<String, Score> scoreTable = new HashMap<String, Score>();
	
    public Login() {
       // super();
        // TODO Auto-generated constructor stub
    	scoreTable.put("1", new Green());
    	scoreTable.put("2", new Bus());
    	scoreTable.put("3", new Tire());
    	
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	//	if(request.getParameter("id").equals("1")) {
	//		Score green = new Green();
	//		PrintWriter out = response.getWriter();
	//		out.println(green.go(3, 4));
	//	}
	//	if(request.getParameter("id").equals("2")) {
	//		Score bus = new Bus();
	//		PrintWriter out = response.getWriter();
	//		out.println(bus.go(3, 4));
	//	}
	//	if(request.getParameter("id").equals("3")) {
	//		PrintWriter out = response.getWriter();
	//		out.println((new Tire()).go(3, 4));
	//	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String n = request.getParameter("id");
		Score score = scoreTable.get(n);
	
		

		doGet(request, response);
	}

}
