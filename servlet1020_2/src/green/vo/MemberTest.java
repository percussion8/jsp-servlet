package green.vo;

public class MemberTest {

	Member member = new Member();
	
	// 서블릿 코드 정리 
	// 서블릿으로 화면 출력 (PrintWriter)를 이용하려 하였고
	// 그 다음 
	// jsp 파일을 만들어서 PrintWriter를 제거하고 jsp파일에서
	// 화면 출력 
	// 화면 출력할때는 스크립트릿, 표현식 (<%= %>
	// 그다음 
	// 데이터 베이스에 접속할 때 서블릿(컨트롤러)에 하던 것을 
	// AppInitServlet의 init 메서드에서 하도록 수정 
	// web.xml에 서블릿 등록 
	// load-on-startup 사용하여 등록 
	
	// 서블릿에서 데이터베이스 관련(CRUD)를 dao 패키지에 있는
	// MemberDao 클래스 생성하여 여기에서 database조회 
	// selectList, 추가(insert), 삭제(delete), 수정(update)를 하였고 
	
	// util 패키지에 DBConnectionPool 생성 
	// getConncection 호출하면 Connection 객체를 MemberDao 의 
	// selectList, insert, delete, update에서 getConnection을 호출하여 
	// Connection을 받아서 mySql 데이터베이스에 접속하여 CRUD를 함 
	
	// 서블릿에서 하는 것은 
	// ServletContext의 참조변수 sc.getAttribute("memberDao")
	// 이렇게 하면 MemberDao 객체를 얻을 수 있고 
	// MemberDao 객체의 메서드 (selectList, update, insert, delete)를 
	// 호출하여 setAttribute로 key값에 데이터를 연결하고
	// RequestDispatcher로 jsp로 화면을 구현하기 위해 실어서 보냄
	// 그러면 jsp에서 그 key값을 받아서 getAttribute(key)를 이용하거나
	// 또는 jstl, el태그를 이용하여
	// <c:ForEach var = "i" items = "${key}"이렇게
	// 데이터 베이스의 조회된 갯수만큼 반복하여 출력함
	// ${i.no}
	// ${i.name}
	
}
