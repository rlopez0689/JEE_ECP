<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Vote Theme</title>
</head>
<body>
	<h2>
		Vote <b>Theme</b>
	</h2>
	<c:set var="dView" scope="request" value="${voteTheme}" />
		<div>${dView.update()}</div>
		<table>
			<tr>
				<th>Name</th>
				<th>Question</th>
				<th>Educational Level</th>
				<th>Valoration</th>
			</tr>
				<form action="/JEE_ECP/jsp/voteTheme" method='post'>
					<input name='id' type='hidden' value='${dView.theme.id}'/>
					<tr>
						<td>${dView.theme.name}</td>
						<td>${dView.theme.question}</td>
						<td>
							<select name="education_level">
							<c:forEach var="educationLevel" items="${dView.ed}">
								<option value="${educationLevel}">${educationLevel}</option>
							</c:forEach>
							</select>
						</td>
						<td>
							<select name="valoration">
							<c:forEach var="val" items="${dView.valorations}">
								<option value="${val}">${val}</option>
							</c:forEach>
							</select>
						</td>
					</tr>
					<input type="submit" value="vote"/>
				</form>
		</table>
	<p>
		<a href="/JEE_ECP/jsp/home">Volver a Home</a>
	</p>
</body>
</html>
