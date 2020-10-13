package green;

public class Counter {
	private int count;
	//생성자 
	public Counter() {
		this.count =0;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public void plusCount() { //플러스되는 메서드 
		this.count++; 
	}
	
}
