<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>addThemeView</title>
</head>
<body>
	<h2>
		Agregar <b>Tema</b>
	</h2>
	<c:set var="aView" scope="request" value="${addTheme}" />
	<form action="/JEE_ECP/jsp/addTheme" method="post">
		<p>${aView.message}</p>
		<p>
			Name: <input name="nombre" type="text"
				value="${aView.theme.name}" />
		</p>
		<p>
			Question: <input name="question" type="text" value="${aView.theme.question}" />
		</p>
		<p>
			<input type="submit" value="Enviar" />
		</p>
	</form>
	<p>
		<a href="/JEE_ECP/v1/home">Volver a Home</a>
	</p>
</body>
</html>
