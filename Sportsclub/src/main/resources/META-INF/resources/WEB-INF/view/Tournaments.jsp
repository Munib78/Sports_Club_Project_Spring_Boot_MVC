<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Tournaments CRUD Operations</title>
<body>
	<h2>Tournaments CRUD Operations</h2>
	<a href="<%=request.getContextPath()%>/addTournament">Add</a>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<c:choose>
		<c:when test="${tournaments != null}">
			<h3>List of tournaments</h3>
			<table cellpadding="5" cellspacing="5">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Location</th>
						<th>Date</th>
						<th>Time</th>
						
						<th>Tournamentgame_name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="t" items="${tournaments}">
						<tr>
							<td>${t.id}</td>
							<td>${t.name}</td>
							<td>${t.location}</td>
							<td>${t.date}</td>
							<td>${t.time}</td>
							
							<td>${t.getTournamentgame_name()}</td>
							<td><a
								href="<%=request.getContextPath()%>/tournament/${t.id}">Details</a>
								&nbsp;<a
								href="<%=request.getContextPath()%>/updateTournament/tournament/${t.id}">Update</a>
								&nbsp; <a
								href="<%=request.getContextPath()%>/deleteTournament/tournament/${t.id}"
								onclick="return confirm('Do you really want to delete?')">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>                     
		</c:when>
		<c:otherwise>
        No Tournaments found in the DB!
        </c:otherwise>
	</c:choose>
</body>
</html>