<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>${post.title}</h1>
	<p>${post.content}</p>
	<a href="/posts">Back to List</a>
	
	<button type="button" onclick="location.href='/posts/${post.id}/edit'">����</button>
	<button type="button" onclick="location.href='/posts/${post.id}/delete'">����</button>
</body>
</html>