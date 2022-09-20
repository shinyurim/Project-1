
package service;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Daolist.dao;
import Dtolist.Dto;

public class wifiInfo { 
	public int urlin() throws IOException {

			StringBuilder url = new StringBuilder("http://openapi.seoul.go.kr:8088");	//URL 만들기 위한 StringBuilder	
			
			//오픈 api 요청 규격에 맞는 파라미터 생성
			url.append("/" + URLEncoder.encode("664c5146487979793531796f544a45", "UTF-8")); 
			url.append("/" + URLEncoder.encode("json", "UTF-8"));
			url.append("/" + URLEncoder.encode("TbPublicWifiInfo", "UTF-8"));
			url.append("/" + URLEncoder.encode("1", "UTF-8"));
			url.append("/" + URLEncoder.encode("1", "UTF-8"));
			
			//url 객체생성
			URL urlinfo = new URL(url.toString());
			
			// URL과 통신하기 위한 Connection 객체 생성
			HttpURLConnection conn = (HttpURLConnection)urlinfo.openConnection();
			
			// 통신을 위한 메소드 SET
			conn.setRequestMethod("GET");
			
			//통신을 위한 Content-type set
			conn.setRequestProperty("content-type", "application/json");
			
			// 전달받은 데이터를 BufferedReader 객체로 저장 / 오류가 날경우 error 발생
			BufferedReader rd;
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader((conn.getInputStream()))); 
			}else {
				rd = new BufferedReader(new InputStreamReader((conn.getErrorStream())));
			}
			
			//저장된 데이터를 라인별로 읽어 StringBuilder 객체로 저장
			StringBuilder sb = new StringBuilder();
			String line;
			while((line = rd.readLine())!= null) {
				sb.append(line);
			}
			
			
			//객체해제
			rd.close();
			conn.disconnect();
			
			String total = sb.substring(40,45); 
			return Integer.parseInt(total);
	}
	
	public long WifiInsert() throws Exception{
				long total = 0;
				List<Dto> list = new ArrayList<>();
				JSONParser parser = new JSONParser();

				for(int i = 0; i < 15; i++) {
					StringBuilder sb = new StringBuilder();
					StringBuilder url = new StringBuilder("http://openapi.seoul.go.kr:8088");	
					
					url.append("/" + URLEncoder.encode("664c5146487979793531796f544a45", "UTF-8")); 
					url.append("/" + URLEncoder.encode("json", "UTF-8"));
					url.append("/" + URLEncoder.encode("TbPublicWifiInfo", "UTF-8"));
					url.append("/" + URLEncoder.encode(String.valueOf(1+(i*1000)),"UTF-8")); 
					url.append("/" + URLEncoder.encode(String.valueOf(1000+(i*1000)),"UTF-8")); 
					
					URL urlin = new URL(url.toString());
					HttpURLConnection conn = (HttpURLConnection)urlin.openConnection();
					conn.setRequestMethod("GET");
					conn.setRequestProperty("content-type", "application/json");
					System.out.println("Response code: " + conn.getResponseCode());
					
					BufferedReader rd;
					
					if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
						rd = new BufferedReader(new InputStreamReader((conn.getInputStream()))); 
					}else {
						rd = new BufferedReader(new InputStreamReader((conn.getErrorStream())));
					}
					
					String line;
					
					
					while((line = rd.readLine())!= null) {
						sb.append(line);
				}
					rd.close();
					conn.disconnect();
					
					JSONObject jsonObj = (JSONObject)parser.parse(sb.toString());
					JSONObject TbPublicWifiInfo = (JSONObject) jsonObj.get("TbPublicWifiInfo");
					total = (long) TbPublicWifiInfo.get("list_total_count");
					JSONArray row = (JSONArray) TbPublicWifiInfo.get("row");

                     
                     for(int j = 0; j < row.size(); j++) {
                    	JSONObject obj = (JSONObject) row.get(j);
                    	Dto dto = new Dto();
                    	dto.setMgnumber(String.valueOf(obj.get("X_SWIFI_MGR_NO"))); //관리번호
                    	dto.setX_coordinate(String.valueOf(obj.get("LAT"))); // x좌표
                    	dto.setY_coordinate(String.valueOf(obj.get("LNT"))); // y좌표
                    	dto.setDistrict(String.valueOf(obj.get("X_SWIFI_WRDOFC"))); // 자치구
                    	dto.setWifi_name(String.valueOf(obj.get("X_SWIFI_MAIN_NM"))); // 와이파이명
                    	dto.setRoad_Address(String.valueOf(obj.get("X_SWIFI_ADRES1"))); // 도로명 주소
                    	dto.setDetail_Address(String.valueOf(obj.get("X_SWIFI_ADRES2"))); // 상세주소
                    	dto.setInstall_location(String.valueOf(obj.get("X_SWIFI_INSTL_FLOOR"))); // 설치위치
                    	dto.setInstall_Type(String.valueOf(obj.get("X_SWIFI_INSTL_TY"))); // 설치유형
                    	dto.setInstall_Agency(String.valueOf(obj.get("X_SWIFI_INSTL_MBY"))); // 설치기관
                    	dto.setService_Class(String.valueOf(obj.get("X_SWIFI_SVC_SE"))); // 서비스 구분
                    	dto.setKind_Net(String.valueOf(obj.get("X_SWIFI_CMCWR"))); // 망종류
                    	dto.setInstall_Year(String.valueOf(obj.get("X_SWIFI_CNSTC_YEAR"))); // 설치년도
                    	dto.setIn_Out(String.valueOf(obj.get("X_SWIFI_INOUT_DOOR"))); // 실내외구분
                    	dto.setWifi_connect(String.valueOf(obj.get("X_SWIFI_REMARS3"))); // 와이파이 접속환경
                    	dto.setOperation_Date(String.valueOf(obj.get("WORK_DTTM"))); // 작업일자
                    	
                    	list.add(dto);
                     }
				}
                     dao daolist = new dao();
                     daolist.insert(list);
                     return total;
	}
	
	
	public List<Dto> nearAnswer(String my_Lnt, String my_Lat){
		dao daoinput = new dao();
		return daoinput.nearWifi(my_Lnt, my_Lat);
		
	}
	}