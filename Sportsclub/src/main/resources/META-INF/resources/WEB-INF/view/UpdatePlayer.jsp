<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Update Player</title>
<body>
	<h2>Update Player</h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<h3>Update Player</h3>
	<form method="POST" name="update_player"
		action="<%=request.getContextPath()%>/updatePlayer/player">
		<input hidden="hidden" name="id" value="${id}" type="text" />
		 Name: <input name="player_name" value="${player.name}" type="text" /> <br /> <br />
		Mobile_No: <input name="mobile_no" value="${player.mobile_no}"
			type="number" /> <br /> <br />
		Game_Name: <input name="game_name" value="${player.game_name}"
			type="number" /> <br /> <br />  
		<input value="Update Player" type="submit" />
	</form>
</body>
</html>