<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Player Adding Page</title>
<body>
	<h2>ADD THE Player</h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<h3>Add Player</h3>
	<form method="POST" name="add_Player"
		action="<%=request.getContextPath()%>/addPlayer/player">
		Name: <input name="name" value="${name}" type="text" /> <br /> <br />
		mobile_no: <input name="mobile_no" value="${mobile_no}" type="number" />
		<br /> <br />
		game_name: <input name="game_name" value="${game_name}" type="text" /> <br /> <br />
		<input value="Add Player" type="submit" />
	</form>
</body>
</html>