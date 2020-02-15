package com.demoweb.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.demoweb.vo.MemberVO;

public class MemberRepository {

	public void insertMember(MemberVO member) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", // 연결할 서버 정보
					"demoweb", "oraclejava"); // 계정 정보
			
			String sql = 
					"INSERT INTO MEMBER (MEMBERID, PASSWD, EMAIL) " +
					"VALUES (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId()); 	//SQL에 포함된 1번째 ?에 사용할 데이터
			pstmt.setString(2, member.getPasswd()); 	//SQL에 포함된 2번째 ?에 사용할 데이터
			pstmt.setString(3, member.getEmail()); 		//SQL에 포함된 3번째 ?에 사용할 데이터
			
			pstmt.executeUpdate();//executeUpdate : insert, update, delete 구문에 사용			
						
		} catch (Exception ex) {
			ex.printStackTrace(); //오류 메시지를 화면에 출력
		} finally {
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
	}
	
	public MemberVO selectMemberByIdAndPasswd(String id, String passwd) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//DB에서 조회한 회원 정보를 저장할 객체
		MemberVO member = null;
		
		try {
			//1. 드라이버 준비
			//DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. 연결 (연결 객체 반환)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", // 연결할 서버 정보
					"demoweb", "oraclejava"); // 계정 정보
			
			//3. SQL 작성 + 명령 객체 가져오기
			String sql = "SELECT MEMBERID, EMAIL, USERTYPE, REGDATE, ACTIVE " + 
						 "FROM MEMBER " +
						 "WHERE MEMBERID = ? AND PASSWD = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			
			//4. 명령 실행
			rs = pstmt.executeQuery();
			
			//5. 명령 실행 결과가 있다면 결과 사용 (처리)
			while (rs.next()) { // 결과집합의 다음 행으로 이동 (더 이상 데이터가 없으면 false 반환)
				member = new MemberVO();
				member.setMemberId(rs.getString(1));
				member.setEmail(rs.getString(2));
				member.setUserType(rs.getString(3));
				member.setRegDate(rs.getDate(4));
				member.setActive(rs.getBoolean(5));				
			}
		} catch (Exception ex) {
			ex.printStackTrace(); //오류 메시지를 화면에 출력
		} finally {
			//6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return member; //호출한 곳으로 조회한 데이터를 반환
		
	}
	
}




















