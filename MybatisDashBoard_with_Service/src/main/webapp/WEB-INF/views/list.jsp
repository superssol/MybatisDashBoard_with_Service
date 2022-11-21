<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>Insert title here</title>

<!--  bootstrap css -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" 
integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" 
crossorigin="anonymous">

</head>
<body>

<!--
<nav class="navbar bg-light">
  <div class="container-fluid">
    <form class="d-flex" role="search">
      <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
  </div>
</nav>
-->

<div class="tableWrapper" style="width:100%;height:502px;overflow-y:auto;overflow-x:hidden">
<table class="table table-hover" width="300" cellpadding="0" cellspacing="0" bordor="1">
	<tr class="table-info">
		<td>번호</td>
		<td>작성자</td>
		<td>제목</td>
		<td>삭제</td>
	</tr>
	<c:forEach items="${list}" var="dto">
	<tr>
		<td>${dto.id}</td>
		<td>${dto.writer}</td>
		<td><a href="view?id=${dto.id}">${dto.title}</a></td>
		<td><a href="delete?id=${dto.id}">X</a></td>
	<tr>
	</c:forEach>
</table>
</div>

<p><a href="writeForm">글작성</a></p>
</body>
</html>