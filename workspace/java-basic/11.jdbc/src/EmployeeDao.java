import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 데이터베이스 연동 (JDBC)을 구현하는 클래스
 * @author C
 *
 */
public class EmployeeDao {

	public List<EmployeeVO> selectEmployees(String key) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 조회 결과 데이터를 저장할 VO 컬렉션 객체 만들기
		ArrayList<EmployeeVO> employees = new ArrayList<>();
		
		try {
			// 1. 드라이버 준비(로딩)
//			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			Class.forName("oracle.jdbc.OracleDriver");
			
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			
			// 3. SQL 작성 + 명령 객체 만들기
			StringBuilder sb = new StringBuilder(256); 
			sb.append(" SELECT employee_id, first_name, last_name, email ");
			sb.append(" FROM employees ");
			sb.append(" WHERE first_name LIKE ? ");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1,  "%" + key + "%");
			
			// 4. 명령 실행
			rs = pstmt.executeQuery();
			
			// 5. 결과가 있는 경우(select query) 결과 처리
			while(rs.next()) { // rs.next() : 결과 집합의 다음 행으로 이동(읽을 데이터가 없으면 false를 반환)
				EmployeeVO employee = new EmployeeVO();
				employee.setEmployeeId(rs.getInt(1));
				employee.setFirstName(rs.getString(2));
				employee.setLastName(rs.getString(3));
				employee.setEmail(rs.getString(4));
				employees.add(employee);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6. 연결 닫기
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return employees;
	}
	
	
	
}
