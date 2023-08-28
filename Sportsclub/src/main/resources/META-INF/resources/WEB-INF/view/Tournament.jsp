<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<title>Tournament Details</title>
<body>
	<h2>Tournament Details</h2>
	Id : ${tournament.id}
	<br /> Name : ${tournament.name}
	<br /> Location : ${tournament.location}
	<br /> Date: ${tournament.date}
	<br /> Time : ${tournament.time}
	<br /> Tournamentgame_name : ${tournament.getTournamentgame_name()}
</body>
</html>