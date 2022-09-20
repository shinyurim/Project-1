package Daolist;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

// History 부분 dao 완
import Dtolist.History_Dto;

public class History_Dao {
	public void HistoryInsert(History_Dto history_dto) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.KOREA);
		String url = "jdbc:mariadb://3.36.226.175:3306/testdb1";
		String dbUserId = "rimmee";
		String dbPassword = "tlsdbfla9712!";
				
				//1. 드라이버로드
				//2. 커넥션 객체 생성
				//3. 스테이트먼트 객체 생성
				//4. 쿼리 실행
				//5. 결과 수행
				//6. 객체 연결 해제(close)
				
				try {
				Class.forName("org.mariadb.jdbc.Driver");
				}catch(ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				
				Connection connection = null;
				PreparedStatement preparedStatement = null;
		
				try {
					connection = DriverManager.getConnection(url, dbUserId, dbPassword);
					
					String sql = " insert into History_List(History_X,Histroy_Y,In_Date) "
							+ " VALUES (?, ?, ?); ";
					
					preparedStatement = connection.prepareStatement(sql);
					
					preparedStatement.setString(1, history_dto.getHistory_X());
					preparedStatement.setString(2, history_dto.getHistroy_Y());
					preparedStatement.setString(3, sdf.format(new Date())); 
					
					int affected = preparedStatement.executeUpdate();
					if(affected > 0) {
						System.out.println("저장 성공.");
					}
					else{
						System.out.println("저장 실패.");
			}
				}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			try {
			if(preparedStatement != null && !preparedStatement.isClosed()) {
				preparedStatement.close();
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
			if(connection != null && !connection.isClosed()) {
				connection.close();
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
		
	public List<History_Dto> history_dto(){ 
		List<History_Dto> history_dtolist = new ArrayList<>();
		
		String url = "jdbc:mariadb://3.36.226.175:3306/testdb1";
		String dbUserId = "rimmee";
		String dbPassword = "tlsdbfla9712!";
				
				//1. 드라이버로드
				//2. 커넥션 객체 생성
				//3. 스테이트먼트 객체 생성
				//4. 쿼리 실행
				//5. 결과 수행
				//6. 객체 연결 해제(close)
				
				try {
				Class.forName("org.mariadb.jdbc.Driver");
				}catch(ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				ResultSet rs = null;
		
				try {
					connection = DriverManager.getConnection(url, dbUserId, dbPassword);
					
					String sql = " SELECT * "
							+ " FROM History_List ";
					
					preparedStatement = connection.prepareStatement(sql);
					rs = preparedStatement.executeQuery();
					
					while(rs.next()) {
						int History_ID = rs.getInt("History_ID");
						String History_X = rs.getString("History_X");
						String Histroy_Y = rs.getString("Histroy_Y");
						String In_Date = rs.getString("In_Date");
						
						History_Dto history_dto = new History_Dto();
						history_dto.setHistory_ID(History_ID);
						history_dto.setHistory_X(History_X);
						history_dto.setHistroy_Y(Histroy_Y);
						history_dto.setIn_Date(In_Date);
						
						history_dtolist.add(history_dto);
	}
				}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(rs != null && !rs.isClosed()) {
					rs.close();
				}
				}catch (SQLException e) {
					e.printStackTrace();
				}
			try {
			if(preparedStatement != null && !preparedStatement.isClosed()) {
				preparedStatement.close();
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
			if(connection != null && !connection.isClosed()) {
				connection.close();
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
				return history_dtolist;
	}
		
	
	public int delete(int History_ID) { 
		int result = 0;
		
		String url = "jdbc:mariadb://3.36.226.175:3306/testdb1";
		String dbUserId = "rimmee";
		String dbPassword = "tlsdbfla9712!";
				
				//1. 드라이버로드
				//2. 커넥션 객체 생성
				//3. 스테이트먼트 객체 생성
				//4. 쿼리 실행
				//5. 결과 수행
				//6. 객체 연결 해제(close)
				
				try {
				Class.forName("org.mariadb.jdbc.Driver");
				}catch(ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				
				Connection connection = null;
				PreparedStatement preparedStatement = null;
		
				try {
					connection = DriverManager.getConnection(url, dbUserId, dbPassword);
					
					String sql = " DELETE FROM History_List "
							+ " WHERE History_ID = ? ";
					
					preparedStatement = connection.prepareStatement(sql.toString());	
					preparedStatement.setInt(1, History_ID);
					
					result = preparedStatement.executeUpdate();
				}catch(SQLException e) {
			e.printStackTrace();
		
		}finally {
			try {
			if(preparedStatement != null && !preparedStatement.isClosed()) {
				preparedStatement.close();
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
			if(connection != null && !connection.isClosed()) {
				connection.close();
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
				return result;
	}
	}





