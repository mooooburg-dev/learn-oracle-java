import java.io.Serializable;

/**
 * 연락처 정보를 저장하는 클래스<br>
 * 
 * 이름, 전화번호, 이메일 정보 저장
 * 
 */
public class Contact implements Serializable {

	private String name;
	private String phone;
	private String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return String.format("[%20s][%15s][%s]", name, phone, email);
	}
	
}







