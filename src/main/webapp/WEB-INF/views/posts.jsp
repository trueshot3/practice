<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Posts</title>
<style>
.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
}

.pagination a.active {
	background-color: dodgerblue;
	color: white;
	border-radius: 5px;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
	border-radius: 5px;
}
</style>
</head>
<body>
	<h1>Posts</h1>
	<table border="1">
		<thead>
			<tr>
				<td>ID</td>
				<td>Title</td>
				<td>Content</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="post" items="${posts}">
				<tr>
					<td>${post.id}</td>
					<td><a href="/posts/${post.id}">${post.title}</a></td>
					<td>${post.content}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">
		<c:forEach var="i" begin="0" end="${totalPages - 1}">
			<a href="?page=${i}&size=${pageSize}&keyword=${keyword}"
				class="${i == currentPage ? 'active' : ''}">${i + 1}</a>
		</c:forEach>
	</div>
	<div>
		<form action="/posts" method="get">
			<input type="text" name="keyword" placeholder="Search..." value="${keyword}" />
			<button type="submit">Search</button>
		</form>
	</div>
	<div>
		<button type="button" onclick="location.href='/posts/form'">Write</button>
	</div>
</body>
</html>