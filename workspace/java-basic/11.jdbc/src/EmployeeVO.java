import lombok.Data;

/**
 * HR 계정의 Employees 테이블 데이터를 저장하는 VO 클래스
 * @author C
 *
 */

@Data	// getter, setter, toString, ... 등 자동으로 만들어준다.
public class EmployeeVO {

	// VO 클래스의 멤버는 대상 테이블의 컬럼 정보를 반영해서 작성
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	
}
