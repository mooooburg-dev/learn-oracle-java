import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDemo {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 1. 드라이버 준비(로딩)
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			
			// 3. SQL 작성 + 명령 객체 만들기
			String sql = "SELECT employee_id, first_name, last_name FROM employees";
			pstmt = conn.prepareStatement(sql);
			
			// 4. 명령 실행
			rs = pstmt.executeQuery();
			
			// 5. 결과가 있는 경우(select query) 결과 처리
			while(rs.next()) {
				System.out.printf("[%s][%s][%s]\n", rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 연결 닫기
			try { rs.close(); } catch ( Exception ex) {}
			try { pstmt.close(); } catch ( Exception ex) {}
			try { conn.close(); } catch ( Exception ex) {}
		}
		
	}

}



