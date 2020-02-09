import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class JdbcDemo4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("검색어 : ");
		String key = scanner.nextLine();
		
		// 데이터 조회 -> Dao 객체에게 요청
		EmployeeDao dao = new EmployeeDao();
		List<EmployeeVO> employees = dao.selectEmployees(key);
		
		// 결과 출력(사용자에게 보여주기)
		for(EmployeeVO employee : employees) {
			System.out.println(employee.toString());
		}
		
		scanner.close();
	}

}



