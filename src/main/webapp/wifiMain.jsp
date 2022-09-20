<%@ page import = "Dtolist.History_Dto" %>
<%@ page import = "service.Historyinfo" %>
<%@ page import = "service.wifiInfo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Dtolist.Dto" %>
<%@ page import="Daolist.dao" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>와이파이 정보 구하기</title>
<%
String my_Lat = request.getParameter("Lat");
String my_Lnt = request.getParameter("Lnt");
%>
<style>
table {
	border-collapse: collapse;
	width: 100%;
	margin: 5px;
}
th, td {
	text-align: center;
	padding: 8px;
	border: solid 1px #eeeeee;
	background-colr: #white;
}
 tr:nth-child(even){background-color: #f2f2f2;}
 tr:hover {background-color: #ddd;}
th {
	background-color: #04AA6D;
	color: #f2f2f2;
}
</style>
</head>
<body>
<h1>와이파이 정보 구하기</h1>
		<div class = "list">
		<ul>
		<li>
			<a href ="wifiMain.jsp">홈</a> 
			</li>
			<li>
			<form action="">
				<a href = "HistoryList.jsp">위치 히스토리 목록</a>
			</form>
			</li>
			<li> 
			<form action="">
				<a href="wifisave.jsp">OPEN API 와이파이 정보 가져오기</a>
			</form>
			</ul>
			</div>
			
			<form action = "wifiMain.jsp" method="get">
			LAT:&nbsp;<input type="text" id="Lat" name="Lat" value=0.0>
			,&nbsp; LNT:&nbsp;<input type="text" id="Lnt" name="Lnt" value=0.0>
			<button onclick="findLocation()" type="button">내 위치 가져오기</button>
			<button type="submit">근처 WIFI 정보 찾기</button>
			</form>
			<script>
			function findLocation() {
				if (navigator.geolocation) {
					navigator.geolocation.getCurrentPosition(showYourLocation);
				} else {
					loc.innerHTML = "Geolocation API를 지원하지 않습니다.";
				}
			}
			
			function showYourLocation(position){
				
				document.getElementById("Lat").value = position.coords.latitude;
				document.getElementById("Lnt").value = position.coords.longitude;			
				}
			</script>
<table>
<tr>
				<th>거리(Km)</th>
				<th>관리번호</th>
				<th>자치구</th>
				<th>와이파이명</th>
				<th>도로명주소</th>
				<th>상세주소</th>
				<th>설치위치(층)</th>
				<th>설치유형</th>
				<th>설치기관</th>
				<th>서비스구분</th>
				<th>망종류</th>
				<th>설치년도</th>
				<th>실내외구분</th>
				<th>WIFI접속환경</th>
				<th>X좌표</th>
				<th>Y좌표</th>
				<th>작업일자</th>
			</tr>

			<%
			 List<Dto> wifilist = new ArrayList<>();
			if (my_Lat == null && my_Lnt == null || my_Lat.equals("0.0") && my_Lnt.equals("0.0")) {
			%>
			<tr>
			<td colspan = "17" style = "text-align : center">위치 정보를 입력한 후에 조회해 주세요.</td>
			</tr>
			<%
			}else{
				
				History_Dto history_dto = new History_Dto();
				history_dto.setHistory_X(my_Lnt);
				history_dto.setHistroy_Y(my_Lat);
				
				Historyinfo historyinfo = new Historyinfo();
				historyinfo.InsertH(history_dto);
				
				wifiInfo wifiinfo = new wifiInfo();
				List<Dto> wifiList = wifiinfo.nearAnswer(my_Lnt, my_Lat);
						
				
				dao daoservice = new dao();
				for(Dto dto : wifiList){
			%>
			<tr>
				<td><%=dto.getDistance()%></td>
				<td><%=dto.getMgnumber()%></td>
				<td><%=dto.getDistrict()%></td>
				<td><%=dto.getWifi_name()%></td>
				<td><%=dto.getRoad_Address()%></td>
				<td><%=dto.getDetail_Address()%></td>
				<% if(dto.getInstall_location() == null){%>
				<td></td>
				<%}else { %>
				<td><%=dto.getInstall_location()%></td>
				<% } %>
				<td><%=dto.getInstall_Type()%></td> 
				<td><%=dto.getInstall_Agency()%></td> 
				<td><%=dto.getService_Class()%></td> 
				<td><%=dto.getKind_Net()%></td>
				<td><%=dto.getInstall_Year()%></td>
				<td><%=dto.getIn_Out()%></td> 
				<% if(dto.getWifi_connect() == null){ %>
				<td></td>
				<%} else{ %>
				<td><%=dto.getWifi_connect()%></td>
				<% } %> 
				<td><%=dto.getY_coordinate()%></td> 
				<td><%=dto.getX_coordinate()%></td> 
				<td><%=dto.getOperation_Date()%></td> 
</tr>

<%
				}
%>
<%
			}
%>
</table>
</body>
</html>