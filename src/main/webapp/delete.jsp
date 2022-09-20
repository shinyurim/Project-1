<%@ page import = "service.Historyinfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>와이파이 삭제</title>
</head></body>
<body>
<%
	Historyinfo historyinfo = new Historyinfo();
	int result = historyinfo.DeleteH(Integer.parseInt(request.getParameter("id")));
	
	String answer = "삭제 실패.";
	
	if(result > 0){
		answer = "삭제 성공.";
	}
%>
<script>
	alert("<%=answer %>")
	location.href="HistoryList.jsp";
	</script>
	</body>
</html>