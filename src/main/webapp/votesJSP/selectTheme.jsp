<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>deleteThemeView</title>
</head>
<body>
	<h2>
		List <b>Themes</b>
	</h2>
	<c:set var="dView" scope="request" value="${selectThemes}" />
		<div>${dView.update()}</div>
		<table>
			<tr>
				<th>Nombre</th>
				<th>Pregunta</th>
			</tr>
			<c:forEach var="theme" items="${dView.themes}">
				<form action="/JEE_ECP/jsp/voteTheme" method='get'>
					<input name='id' type='hidden' value='${theme.id}'/>
					<tr>
						<td>${theme.name}</td>
						<td>${theme.question}</td>
						<td><input type='submit' value='Vote'/></td>
					</tr>
				</form>
			</c:forEach>
		</table>
	<p>
		<a href="/JEE_ECP/jsp/home">Volver a Home</a>
	</p>
</body>
</html>
