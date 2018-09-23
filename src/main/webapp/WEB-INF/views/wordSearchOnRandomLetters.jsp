<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Słowo na podstawie posiadanych liter</title>
</head>
<body>
	<h3>Sprawdź jakie słowa można ułożyć z posiadanych liter:</h3>
	<form method="post">
		Wpisz posiadane litery w dowolnej kombinacji. Jeśli masz do dyspozycji
		dodatkowe litery na planszy, wpisz ich ilość, a poszukam możliwych
		kombinacji. <br>Jeśli chcesz tylko sprawdzić jakie włowo może
		powstać z Twoich liter, wpisz 0. <br><br>
		<div>
			Wpisz litery<input type="text" name="wordAsk" /> Wpisz ilość
			dodatkowych liter<input type="text" name="numberOfAdditionalLetters" />
			<input type="submit" value="Szukaj" />
		</div>
	</form>

	<br>
	<font size="3">${wordAsk}</font>
	<br>
	<a href="<c:url value='/'/>">Wróć na główną</a>
	<br>

	<h3>Podane litery możesz użyć w poniższych przykładach:</h3>
	<c:forEach items="${wordAskList}" var="word">
				${word.word}  <br>
	</c:forEach>



</body>
</html>