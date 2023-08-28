<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Tournament Adding Page</title>
<body>
	<h2>ADD THE Tournament</h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<h3>Add Tournament</h3>
	<form method="POST" name="add_Tournament"
		action="<%=request.getContextPath()%>/addTournament/tournament">
		Name: <input name="name" value="${name}" type="text" /> <br /> <br />
		Location: <input name="location" value="${location}" type="text" />
		<br /> <br />
		Date: <input name="date" value="${date}" type="text" />
		<br /> <br />
		Time: <input name="time" value="${time}" type="text" />
		<br /> <br />
		Tournamentgame_Name: <input name="Tournamentgame_name" value="${Tournamentgame_name}" type="text" />
		<br /> <br />
		<input value="Add Tournament" type="submit" />
	</form>
</body>
</html>