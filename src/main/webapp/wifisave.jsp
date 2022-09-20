<%@ page import = "service.wifiInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.net.*, java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>와이파이 정보 가져오기</title>
<style>
	.wifiinformation{
	
		text-align : center;
		font-weight : 900;
		font-size : 180%;
	}
	.home-button{
		
		text-align : center;
	
	}
</style>
</head>
<body>
<p class = 'wifiinformation'>
<% 
	wifiInfo wifi = new wifiInfo();
	out.print(wifi.WifiInsert());
	wifi.WifiInsert();
	%>
	개의 WIFI정보를 정상적으로 저장하였습니다.
	<div class = 'home-button'>
	<a href="wifiMain.jsp">홈으로 가기</a>
	</div>
</body>
</html>