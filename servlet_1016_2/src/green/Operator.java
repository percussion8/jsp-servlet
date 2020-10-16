package green;

public interface Operator {
	//메서드 생성 메서드명 getName, 파라미터 없음, 반환타입 문자열, 함수정의만 추상메서드 
	//메서드 생성, execute, 파라미터는 double형, 2개, 반환타입은 double
	//이 메서드는 throws Exception을 함수정의 옆에 추가 
	String getName();
	
	double execute(double a, double b) throws Exception;
	

}
