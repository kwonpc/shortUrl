<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>URL SHORT</title>
<script>

function submit(){
	document.frm.submit();
}

</script>
</head>
<body>
<h1>
	URL Shortening
</h1>

<form name="frm" action="/shorturl/generate" method="post">
<input type="text" name="url" >
</form>
<a href="javascript:submit()">submit</a>
</body>
</html>
