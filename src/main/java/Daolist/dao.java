
package Daolist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Dtolist.Dto;

public class dao {
	public void insert(List<Dto> wifilist) throws SQLException {
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
			
			Connection conn = getConnection();
			PreparedStatement preparedStatement = null;
			
	
			try {
				conn = DriverManager.getConnection(url, dbUserId, dbPassword);
				conn.setAutoCommit(false);
				String sql = " insert into  Wifi_Information "
						+ " (Mgnumber,X_coordinate,Y_coordinate,District,Wifi_name,Road_Address,Detail_Address,Install_Type, "
						+ " Install_Agency,Service_Class,Kind_Net,Install_Year,In_Out,Operation_Date,Install_location,Wifi_connect) "
						+ " values " 
						+ " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
				
				preparedStatement = conn.prepareStatement(sql);
				int cnt = 0;
				for(Dto dto : wifilist) {
				
				preparedStatement.setString(1, dto.getMgnumber());
				preparedStatement.setString(2, dto.getX_coordinate());
				preparedStatement.setString(3, dto.getY_coordinate());
				preparedStatement.setString(4, dto.getDistrict());
				preparedStatement.setString(5, dto.getWifi_name());
				preparedStatement.setString(6, dto.getRoad_Address());
				preparedStatement.setString(7, dto.getDetail_Address());
				preparedStatement.setString(8, dto.getInstall_Type());
				preparedStatement.setString(9, dto.getInstall_Agency());
				preparedStatement.setString(10, dto.getService_Class());
				preparedStatement.setString(11, dto.getKind_Net());
				preparedStatement.setString(12, dto.getInstall_Year());
				preparedStatement.setString(13, dto.getIn_Out());
				preparedStatement.setString(14, dto.getOperation_Date());
				preparedStatement.setString(15, dto.getInstall_location());
				preparedStatement.setString(16, dto.getWifi_connect());
				cnt++;
				preparedStatement.addBatch();
				preparedStatement.clearParameters();
				if(cnt % 1000 == 0) {
					preparedStatement.executeBatch();
					preparedStatement.clearBatch();
					conn.commit();
				}
			preparedStatement.executeBatch();
			preparedStatement.clearParameters();
			conn.commit();
			System.out.println("저장 성공.");
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
		if(conn != null && !conn.isClosed()) {
			conn.close();
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

			private Connection getConnection() {
				
		return null;
	}

			public List<Dto> nearWifi(String my_Lnt, String my_Lat){ // 주변 wifi 찾기
				List<Dto> wifilist = new ArrayList<>();
						
				
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
							
							String sql = " select * , "
									+ " round (6371*acos(cos(radians(?))*cos(radians(Y_coordinate))*cos(radians(X_coordinate)-radians(?))+ sin(radians(?))*sin(radians(Y_coordinate))), 4) " // 조건절 (6371 *acos(cos(radians(기준위도))*cos(radians(위도))*cos(radians((경도-기준경도)))+sin(radians(기준위도))*sin(radians(위도)))) ASC 이다.
									+ " as Distancefinal " 
									+ " from Wifi_Information "
									+ " order by Distancefinal " //거리순 데이터 정리
									+ " limit 20 "; //한페이지에 20개 보여주기
								
							
							preparedStatement = connection.prepareStatement(sql);
						

							preparedStatement.setString(1, String.valueOf(my_Lat));
							preparedStatement.setString(2, String.valueOf(my_Lnt)); 
							preparedStatement.setString(3, String.valueOf(my_Lat)); 

							rs = preparedStatement.executeQuery();
							
				while(rs.next()) {

	                String distance = rs.getString("Distancefinal");
	                String mgnumber = rs.getString("Mgnumber");
	                String x_coordinate = rs.getString("X_coordinate");
	                String y_coordinate = rs.getString("Y_coordinate");
	                String district = rs.getString("District");
	                String wifi_name = rs.getString("Wifi_name");
	                String road_Address = rs.getString("Road_Address");
	                String detail_Address = rs.getString("Detail_Address");
	                String install_location = rs.getString("Install_location");
	                String install_Type = rs.getString("Install_Type");
	                String install_Agency = rs.getString("Install_Agency");
	                String service_Class = rs.getString("Service_Class");
	                String kind_Net = rs.getString("Kind_Net");
	                String install_Year = rs.getString("Install_Year");
	                String in_Out = rs.getString("In_Out");
	                String operation_date = rs.getString("Operation_Date");
	                String wifi_connect = rs.getString("Wifi_connect");
	                					
					
	                Dto dto = new Dto();
	                dto.setDistance(distance);
	                dto.setMgnumber(mgnumber);
	                dto.setX_coordinate(x_coordinate);
	                dto.setY_coordinate(y_coordinate);
	                dto.setDistrict(district);
	                dto.setWifi_name(wifi_name);
	                dto.setRoad_Address(road_Address);
	                dto.setDetail_Address(detail_Address);
	                dto.setInstall_location(install_location);
	                dto.setInstall_Type(install_Type);
	                dto.setInstall_Agency(install_Agency);
	                dto.setService_Class(service_Class);
	                dto.setKind_Net(kind_Net);
	                dto.setInstall_Year(install_Year);
	                dto.setIn_Out(in_Out);
	                dto.setOperation_Date(operation_date);
	                dto.setWifi_connect(wifi_connect);
	                
	                wifilist.add(dto);
	                
				}
			} catch(SQLException e) {
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
						return wifilist;
			}
			
}
