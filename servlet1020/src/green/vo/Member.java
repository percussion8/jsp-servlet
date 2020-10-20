package green.vo;

import java.sql.Date;

public class Member {

	protected int no;
	protected String name;
	protected String email;
	protected String password;
	protected Date createdDate;
	protected Date modifiedDate;
	
	
	public Member() {
		// TODO Auto-generated constructor stub
		
	
	}
	public int getNo() {
		return no;
	}
	public Member setNo(int no) {
		this.no = no;
		return this;
	}
	public String getName() {
		return name;
	}
	public Member setName(String name) {
		this.name = name;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Member setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public Member setPassword(String password) {
		this.password = password;
		return this;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public Member setCreatedDate(Date createdDate) {
		this.createdDate = createdDate; //파라미터로 받은 값으로 멤버변수의 값을 저장
		return this; //체인을 적용하고자 자기 자신을 반환함
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public Member setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
		return this;
	}
	
	
}
