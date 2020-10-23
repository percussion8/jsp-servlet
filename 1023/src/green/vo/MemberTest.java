package green.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class MemberTest {

	public static void main(String[] args) {
		Member[] members = new Member[3];
		for (int i=0; i<members.length; i++) {
			members[i] = new Member().setName("노승환"+i)
									  .setEmail("aaa"+i+"@naver.com")
									  .setNo(i)
									  .setPassword("123"+i);
			System.out.println(
							   "객체배열 : " + "\n" +
							   "이름 : " + members[i].getName() + "\n" + 
							   "이메일 : " + members[i].getEmail() + "\n" +
							   "번호 : " + members[i].getNo() + "\n" +
							   "패스워드 : " + members[i].getPassword());
		}
		System.out.println("===============================");
		// 객체가 반환하는게 자기 자신이기 때문에 코드를 간결하게 할 수 있다.
		Map<String, Member> mapMembers = new HashMap<String, Member>();
		for(int i=0; i<3; i++) {
			String hashKey = Integer.toString(i);
			mapMembers.put(hashKey, new Member().setName("노승환"+i)
												 .setEmail("nnn"+i)
												 .setNo(1+i)
												 .setPassword("pppp"+i));
			Member output = mapMembers.get(hashKey);
			System.out.println(
					"HashMap : " + "\n" +
				    "이름 : " + output.getName() + "\n" +
				    "이메일 : " +output.getEmail() + "\n" + 
				    "번호 : " + output.getNo() + "\n" +
				    "패스워드 : " + output.getPassword() + "\n");
		}
		System.out.println("===============================");
		
		// ArrayList(배열)
		ArrayList<Member> arrList = new ArrayList<Member>();
		for (int i=0; i<3; i++) {
			arrList.add(new Member());
			Member re1 = arrList.get(i);
			re1.setName("노승환"+i);
			re1.setEmail("이메일"+i);
			re1.setNo(i);
			re1.setPassword("123"+i);
		}
		for (Member resultArray : arrList) {
			System.out.println(
					"ArrayList(배열) : " + "\n" +
				    "이름 : " + resultArray.getName() + "\n" +
				    "이메일 : " +resultArray.getEmail() + "\n" + 
				    "번호 : " + resultArray.getNo() + "\n" +
				    "패스워드 : " + resultArray.getPassword() + "\n");
		}
		System.out.println("===============================");
		
		// 키보드 입력
		Scanner scan = new Scanner(System.in);
		ArrayList<Member> arrListScan = new ArrayList<Member>();
		for(int i=0; i<3; i++) {
			arrListScan.add(new Member());
			Member inputValue = arrListScan.get(i);
			System.out.print("이름을 입력하세요 : ");
			inputValue.setName(scan.next());
			System.out.print("이메일을 입력하세요 : ");
			inputValue.setEmail(scan.next());
			System.out.print("번호를 입력하세요 : ");
			inputValue.setNo(scan.nextInt());
			System.out.print("패스워드를 입력하세요 : ");
			inputValue.setPassword(scan.next());
		}
		for(Member a : arrListScan) {
			System.out.println(
					"ArrayList(advanced for loop) : " + "\n" +
				    "이름 : " + a.getName() + "\n" +
				    "이메일 : " +a.getEmail() + "\n" + 
				    "번호 : " + a.getNo() + "\n" +
				    "패스워드 : " + a.getPassword() + "\n" +
				    "===============================");
		}
	}
}
