package green;

public class User {
	
	//private으로 범위 
	private String name;
	private int num;
	
	
	//기본 생성자(파라미터 없는 생성자)
	//기능 멤버변수 name = null;
	//num = 0;
	public User() { //생성자에 무조건 public 넣기
		this.name = null; //String이 클래스라서 name이 참조 변수라고 생각하면 주소값을 넣는 것이기 때문에 null로 줌 
		this.num = 0;
	}
	
	//getter, setter	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	

}
