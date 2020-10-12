package green;

public class Echo {

	private String msg=""; // 멤버변수
	//아래에 getter setter
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	//자바는 객체 지향 언어이므로 데이터 은닉(보호)해야 합니다. 
	//객체 지향의 3요소(은닉/다양성/상속)
	//멤버 변수는 private으로 보호하고
	//이 클래스 내에 public으로 getMsg메서드 호출
	//멤버변수의 값을 얻어옴(get/읽어옴)
	//값을 변경할 때 setMsg(...) 반환값은 없고 파라미터로
	//받은 값을 이용하여 멤버변수의 값을 변경함

	//문제 green 패키지내에 main함수를 포함한 클래스 생성하고 
	//main함수 내에서 이클래스를 이용하여 객체 생성하여 데이터에 값을 입력 및 출력하세요
	
}
