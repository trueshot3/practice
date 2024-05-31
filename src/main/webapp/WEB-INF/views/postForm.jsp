<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Post Form</title>
</head>
<body>
	<h1>Write</h1>
	<form action="/posts/form" method="post">
		<div>
			<label for="title">Title : </label>
			<input type="text" name="title"	required />
		</div>
		<div>
			<label for="content">Content : </label>
			<input type="text" name="content" required />
		</div>
		<button type="submit">완료</button>
	</form>
</body>
</html>