<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script>
	if("${url}" != ""){
		location.href = "${url}";	
	}else{
		alert("Page not Found !! ");
	}
	
</script>
</head>
<body>
<a href="/">HOME</a>
</body>
</html>