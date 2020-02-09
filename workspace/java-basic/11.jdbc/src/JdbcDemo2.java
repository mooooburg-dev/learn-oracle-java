import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcDemo2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("검색어 : ");
		String key = scanner.nextLine();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 1. 드라이버 준비(로딩)
//			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			Class.forName("oracle.jdbc.OracleDriver");
			
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			
			// 3. SQL 작성 + 명령 객체 만들기
			String sql = "SELECT employee_id, first_name, last_name FROM employees WHERE first_name LIKE '%" + key + "%'";
			pstmt = conn.prepareStatement(sql);
			
			// 4. 명령 실행
			rs = pstmt.executeQuery();
			
			// 5. 결과가 있는 경우(select query) 결과 처리
			while(rs.next()) { // rs.next() : 결과 집합의 다음 행으로 이동(읽을 데이터가 없으면 false를 반환)
				System.out.printf("[%s][%s][%s]\n", rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 6. 연결 닫기
			try { rs.close(); } catch ( Exception ex) {}
			try { pstmt.close(); } catch ( Exception ex) {}
			try { conn.close(); } catch ( Exception ex) {}
		}
		
	}

}



