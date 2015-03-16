<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>VotesView</title>
</head>
<body>
	<h2>
		List <b>Votes</b>
	</h2>
	<c:set var="dView" scope="request" value="${seeVotes}" />
		<table>
			<c:forEach var="groupVote" items="${dView.groupVotes}">
			<tr>
				<td>${groupVote.theme.name}</td>
				<td>${groupVote.valoration}</td>
			</tr>
			<tr>
				<c:forEach var="groupEducation" items="${groupVote.educationAverageList}">
					<table>
						<tr>
							<td>${groupEducation.average}</td>
							<td>${groupEducation.ed}</td>
						</tr>
					</table>
				</c:forEach>
			</tr>
			<tr><br></br></tr>
			</c:forEach>
		</table>
	<p>
		<a href="/JEE_ECP/jsp/home">Volver a Home</a>
	</p>
</body>
</html>
