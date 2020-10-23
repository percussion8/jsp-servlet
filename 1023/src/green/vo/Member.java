package green.vo;

import java.util.Date;

public class Member {
	protected int no;
	protected String name;
	protected String email;
	protected String password;
	protected Date createdDate;
	protected Date modifiedDate;
	
	public Member() {
	}
	public Member(int no, String name, String email, String password) {
		this.no = no;
		this.name = name; 
		this.email = email;
		this.password = password;
	}
	// getter / setter
	public int getNo() {return this.no;}
	public Member setNo(int no) 
	{
		this.no = no; // 파라미터로 받은 값으로 멤버변수의 값을 저장하고
		return this;  // 체인을 적용하고자 자기 자신을 반환한다.
	}
	public String getName() {return this.name;}
	public Member setName(String name) {this.name = name; return this;}
	
	public String getEmail() {return this.email;}
	public Member setEmail(String email) {this.email = email; return this;}
	
	public String getPassword() {return this.password;}
	public Member setPassword(String password) {this.password = password; return this;}
	
	public Date getCreatedDate() {return this.createdDate;}
	public Member setCreatedDate(Date date) {this.createdDate = date; return this;}
	
	public Date getModifiedDate() {return this.modifiedDate;}
	public Member setModifiedDate(Date date) {this.modifiedDate = date; return this;}
}
