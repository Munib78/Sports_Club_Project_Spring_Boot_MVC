<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Update Tournament</title>
<body>
	<h2>Update Tournament</h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<h3>Update Tournament</h3>
	<form method="POST" name="update_tournament"
		action="<%=request.getContextPath()%>/updateTournament/tournament">
		<input hidden="hidden" name="id" value="${id}" type="text" /> 
		Name: <input name="name" value="${tournament.name}" type="text" /> <br /> <br />
		Location: <input name="location" value="${tournament.location}" type="text" /> <br /> <br /> 
		Date: <input name="date" value="${tournament.date}" type="text" /> <br /> <br />
		Time: <input name="time" value="${tournament.time}" type="text" /> <br /> <br /> 
		Tournamentgame_name: <input name="Tournamentgame_name" value="${tournament.getTournamentgame_name()}" type="text" /> <br /> <br /> 
		
		<input value="Update Tournament" type="submit" />
	</form>
</body>
</html>