package com.springdemoweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.springdemoweb.vo.Member;
import com.springdemoweb.vo.Upload;
import com.springdemoweb.vo.UploadFile;

@Repository("uploadDao2") // == @Component("uploadDao2") :  가독성의 차이, 의미의 차이만 있음
public class UploadDaoImpl2 implements UploadDao {

	
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource; // new BasicDataSource
	
	//반환 값은 UPLOAD 테이블에 새로 INSERT된 데이터의 UPLOADNO (NEXTVAL한 후의 CURRVAL)
	@Override
	public int insertUpload(Upload upload) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int newUploadNo = -1;
		
		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//			
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", // 연결할 서버 정보
//					"demoweb", "oraclejava"); // 계정 정보
			
			conn = dataSource.getConnection();	// DataSource를 통해서 DB에 접속한다
			
			String sql = 
					"INSERT INTO UPLOAD (UPLOADNO, TITLE, UPLOADER, CONTENT) " +
					"VALUES (UPLOAD_SEQUENCE.NEXTVAL, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, upload.getTitle());
			pstmt.setString(2, upload.getUploader());
			pstmt.setString(3, upload.getContent());
			pstmt.executeUpdate();//executeUpdate : insert, update, delete 구문에 사용
			
			pstmt.close();
			
			//SEQUENCE.CURRVAL : 마지막 NEXTVAL의 값을 가져오는 ORACLE 표현
			sql = "SELECT UPLOAD_SEQUENCE.CURRVAL FROM DUAL";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			newUploadNo = rs.getInt(1);
						
		} catch (Exception ex) {
			ex.printStackTrace(); //오류 메시지를 화면에 출력
		} finally {
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return newUploadNo;
		
	}
	
	@Override
	public void insertUploadFile(UploadFile file) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", // 연결할 서버 정보
					"demoweb", "oracle"); // 계정 정보
			
			String sql = 
					"INSERT INTO UPLOADFILE (UPLOADFILENO, UPLOADNO, SAVEDFILENAME, USERFILENAME) " +
					"VALUES (UPLOADFILE_SEQUENCE.NEXTVAL, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, file.getUploadNo());
			pstmt.setString(2, file.getSavedFileName());
			pstmt.setString(3, file.getUserFileName());
			
			pstmt.executeUpdate();//executeUpdate : insert, update, delete 구문에 사용			
						
		} catch (Exception ex) {
			ex.printStackTrace(); //오류 메시지를 화면에 출력
		} finally {
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
	}
	
	@Override
	public ArrayList<Upload> selectUploads() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//DB에서 조회한 게시글 목록 저장할 객체
		ArrayList<Upload> uploads = new ArrayList<Upload>();
		
		try {
//			//1. 드라이버 준비
//			//DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
//			Class.forName("oracle.jdbc.OracleDriver");
//			
//			//2. 연결 (연결 객체 반환)
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", // 연결할 서버 정보
//					"demoweb", "oraclejava"); // 계정 정보
			
			conn = dataSource.getConnection();	// DataSource를 통해서 DB에 접속한다
			
			//3. SQL 작성 + 명령 객체 가져오기
			String sql = "SELECT UPLOADNO, TITLE, UPLOADER, REGDATE " + 
						 "FROM UPLOAD " +
						 "WHERE DELETED = '0' " + 
						 "ORDER BY UPLOADNO DESC";
			pstmt = conn.prepareStatement(sql);
			
			//4. 명령 실행
			rs = pstmt.executeQuery();
			
			//5. 명령 실행 결과가 있다면 결과 사용 (처리)
			while (rs.next()) { // 결과집합의 다음 행으로 이동 (더 이상 데이터가 없으면 false 반환)
				Upload upload = new Upload();
				upload.setUploadNo(rs.getInt(1));
				upload.setTitle(rs.getString(2));
				upload.setUploader(rs.getString(3));
				upload.setRegDate(rs.getDate(4));	
				
				uploads.add(upload);
			}
		} catch (Exception ex) {
			ex.printStackTrace(); //오류 메시지를 화면에 출력
		} finally {
			//6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return uploads; //호출한 곳으로 조회한 데이터를 반환
		
	}

	@Override
	public Upload selectUploadByUploadNo(int uploadNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//DB에서 조회한 게시글을 저장할 객체
		Upload upload = null;
		
		try {
			//1. 드라이버 준비
			//DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. 연결 (연결 객체 반환)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", // 연결할 서버 정보
					"demoweb", "oraclejava"); // 계정 정보
			
			//3. SQL 작성 + 명령 객체 가져오기
			String sql = "SELECT UPLOADNO, TITLE, UPLOADER, REGDATE, CONTENT, READCOUNT " + 
						 "FROM UPLOAD " +
						 "WHERE UPLOADNO = ? AND DELETED='0'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uploadNo);
			
			//4. 명령 실행
			rs = pstmt.executeQuery();
			
			//5. 명령 실행 결과가 있다면 결과 사용 (처리)
			if (rs.next()) { // 결과집합의 다음 행으로 이동 (더 이상 데이터가 없으면 false 반환)
				upload = new Upload();
				upload.setUploadNo(rs.getInt(1));
				upload.setTitle(rs.getString(2));
				upload.setUploader(rs.getString(3));
				upload.setRegDate(rs.getDate(4));
				upload.setContent(rs.getString(5));
				upload.setReadCount(rs.getInt(6));
			}
		} catch (Exception ex) {
			ex.printStackTrace(); //오류 메시지를 화면에 출력
		} finally {
			//6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return upload; //호출한 곳으로 조회한 데이터를 반환
	}

	@Override
	public ArrayList<UploadFile> selectUploadFilesByUploadNo(int uploadNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//DB에서 조회한 게시글 목록 저장할 객체
		ArrayList<UploadFile> files = new ArrayList<>();
		
		try {
			//1. 드라이버 준비
			//DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. 연결 (연결 객체 반환)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", // 연결할 서버 정보
					"demoweb", "oracle"); // 계정 정보
			
			//3. SQL 작성 + 명령 객체 가져오기
			String sql = "SELECT UPLOADFILENO, UPLOADNO, SAVEDFILENAME, USERFILENAME, DOWNLOADCOUNT " + 
						 "FROM UPLOADFILE " +
						 "WHERE UPLOADNO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uploadNo);
			
			//4. 명령 실행
			rs = pstmt.executeQuery();
			
			//5. 명령 실행 결과가 있다면 결과 사용 (처리)
			while (rs.next()) { // 결과집합의 다음 행으로 이동 (더 이상 데이터가 없으면 false 반환)
				UploadFile file = new UploadFile();
				file.setUploadFileNo(rs.getInt(1));
				file.setUploadNo(rs.getInt(2));
				file.setSavedFileName(rs.getString(3));
				file.setUserFileName(rs.getString(4));
				file.setDownloadCount(rs.getInt(5));
				
				files.add(file);
			}
		} catch (Exception ex) {
			ex.printStackTrace(); //오류 메시지를 화면에 출력
		} finally {
			//6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return files; //호출한 곳으로 조회한 데이터를 반환
	}

	@Override
	public UploadFile selectUploadFileByUploadFileNo(int fileNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		UploadFile file = null;
		
		try {
			//1. 드라이버 준비
			//DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. 연결 (연결 객체 반환)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", // 연결할 서버 정보
					"demoweb", "oracle"); // 계정 정보
			
			//3. SQL 작성 + 명령 객체 가져오기
			String sql = "SELECT UPLOADFILENO, UPLOADNO, SAVEDFILENAME, USERFILENAME, DOWNLOADCOUNT " + 
						 "FROM UPLOADFILE " +
						 "WHERE UPLOADFILENO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fileNo);
			
			//4. 명령 실행
			rs = pstmt.executeQuery();
			
			//5. 명령 실행 결과가 있다면 결과 사용 (처리)
			while (rs.next()) { // 결과집합의 다음 행으로 이동 (더 이상 데이터가 없으면 false 반환)
				file = new UploadFile();
				file.setUploadFileNo(rs.getInt(1));
				file.setUploadNo(rs.getInt(2));
				file.setSavedFileName(rs.getString(3));
				file.setUserFileName(rs.getString(4));
				file.setDownloadCount(rs.getInt(5));				
			}
		} catch (Exception ex) {
			ex.printStackTrace(); //오류 메시지를 화면에 출력
		} finally {
			//6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return file; //호출한 곳으로 조회한 데이터를 반환
	}

	@Override
	public void deleteUpload(int uploadNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//1. 드라이버 준비
			//DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. 연결 (연결 객체 반환)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", // 연결할 서버 정보
					"demoweb", "oraclejava"); // 계정 정보
			
			//3. SQL 작성 + 명령 객체 가져오기
			String sql = "UPDATE UPLOAD " + 
						 "SET DELETED = '1' " +
						 "WHERE UPLOADNO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uploadNo);
			
			//4. 명령 실행
			pstmt.executeUpdate();
			
		} catch (Exception ex) {
			ex.printStackTrace(); //오류 메시지를 화면에 출력
		} finally {
			//6. 연결 종료
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
				
	}

	@Override
	public void deleteUploadFile(int fileNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//1. 드라이버 준비
			//DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. 연결 (연결 객체 반환)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", // 연결할 서버 정보
					"demoweb", "oracle"); // 계정 정보
			
			//3. SQL 작성 + 명령 객체 가져오기
			String sql = "DELETE FROM UPLOADFILE " +
						 "WHERE UPLOADFILENO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fileNo);
			
			//4. 명령 실행
			pstmt.executeUpdate();
			
		} catch (Exception ex) {
			ex.printStackTrace(); //오류 메시지를 화면에 출력
		} finally {
			//6. 연결 종료
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
	}

	@Override
	public void updateUpload(Upload upload) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//1. 드라이버 준비
			//DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. 연결 (연결 객체 반환)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", // 연결할 서버 정보
					"demoweb", "oracle"); // 계정 정보
			
			//3. SQL 작성 + 명령 객체 가져오기
			String sql = "UPDATE UPLOAD " +
						 "SET TITLE = ?, CONTENT = ? " +
						 "WHERE UPLOADNO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, upload.getTitle());
			pstmt.setString(2, upload.getContent());
			pstmt.setInt(3, upload.getUploadNo());
			
			//4. 명령 실행
			pstmt.executeUpdate();
			
		} catch (Exception ex) {
			ex.printStackTrace(); //오류 메시지를 화면에 출력
		} finally {
			//6. 연결 종료
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
	}
	
}




















