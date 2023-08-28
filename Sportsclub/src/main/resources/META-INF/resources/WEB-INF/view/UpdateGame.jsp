<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Update Game</title>
<body>
	<h2>Update Game</h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<h3>Update Game</h3>
	<form method="POST" name="update_game" action="<%=request.getContextPath()%>/updateGame/game">
		<input hidden="hidden" name="id" value="${id}" type="text" /> 
		Name: <input name="name" value="${game.name}" type="text" /> <br /> <br />
		Fees: <input name="minimum_fees" value="${game.minimum_fees}" type="text" /> <br /> <br /> 
		<input value="Update Game" type="submit" />
	</form>
</body>
</html>