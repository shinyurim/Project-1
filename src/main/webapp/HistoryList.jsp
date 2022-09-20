<%@ page import = "service.Historyinfo" %>
<%@ page import = "Dtolist.History_Dto" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>와이파이 정보 구하기</title>
<script type="text/javascript">
	function del(ID){
		location.href="delete.jsp?id=" + ID;
	}
</script>
</head>
<body>
	<table>
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
			<h1>위치 히스토리 목록</h1>
			<div>
			<a href="wifiMain.jsp">홈</a>
			<a>|</a>
			<a href="HistoryList.jsp">위치 히스토리 목록</a>
			<a>|</a>
			<a href="wifisave.jsp">Open API 와이파이 정보 가져오기</a>
			</div>
			<thead>
		<tr>
			<th>ID</th>
			<th>X좌표</th>
			<th>Y좌표</th>
			<th>조회일자</th>
			<th>비고</th>
		</tr>
		 <%
		 Historyinfo historyinfo = new Historyinfo();
        List<History_Dto> historyWifiList = historyinfo.historyList();
        
        for(History_Dto history_dto : historyWifiList) {
    %>
    <tr>
    	<td><%=history_dto.getHistory_ID() %></td>
		<td><%=history_dto.getHistory_X() %></td>
		<td><%=history_dto.getHistroy_Y() %></td>
		<td><%=history_dto.getIn_Date() %></td>
        <td>
           <button type = submit onclick="location.href= 'delete.jsp?id=<%=history_dto.getHistory_ID() %>'">
                삭제</button>
        </td>
        </tr>
        <%
        }
        %>
	</thead>
	</table>
</body>
</html>