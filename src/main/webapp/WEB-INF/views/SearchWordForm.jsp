<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Words in Scrabble</title>
</head>
<body>
	<h1>Words in Scrabble</h1>
	<form method="post">

		<div>
			Wpisz słowo:<input type="text" name="wordAsk" /> <input type="submit"
				value="Sprawdź słowo" />
		</div>
	</form>
	<br>
	<font size="3">${wordAsk}</font>
	<br>
	<br>
	<a href="<c:url value='/'/>">Wróć na główną</a>
	<br>

	<h3>Lista podobnych słów:</h3>
	<c:forEach items="${wordAskList}" var="word">
				${word.word}  <br>
	</c:forEach>



</body>
</html>