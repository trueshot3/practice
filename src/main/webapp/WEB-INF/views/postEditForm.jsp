<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Edit</title>
</head>
<body>
	<h1>Edit</h1>
	<form action="/posts/${post.id}/edit" method="post">
		<div>
			<label for="title">Title : </label>
			<input type="text" name="title" value="${post.title}" required />
		</div>
		<div>
			<label for="content">Content : </label>
			<input type="text" name="content" value="${post.content}" required />
		</div>
		<button type="submit">완료</button>
	</form>
</body>
</html>