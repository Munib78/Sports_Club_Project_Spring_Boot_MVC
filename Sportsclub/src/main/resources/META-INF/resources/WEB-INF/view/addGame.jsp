<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Game Adding Page</title>
<body>
	<h2>ADD THE GAME</h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<h3>Add Game</h3>
	<form method="POST" name="add_Game"
		action="<%=request.getContextPath()%>/addGame/game">
		Name: <input name="name" value="${name}" type="text" /> <br /> <br />
		Fees: <input name="minimum_fees" value="${minimum_fees}" type="number" />
		<br /> <br />
		<input value="Add Game" type="submit" />
	</form>
</body>
</html>