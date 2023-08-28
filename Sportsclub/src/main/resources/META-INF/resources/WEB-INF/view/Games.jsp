<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Games CRUD Operations</title>
<body>
	<h2>Games CRUD Operations</h2>
	<a href="<%=request.getContextPath()%>/addGame">Add</a>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<c:choose>
		<c:when test="${games != null}">
			<h3>List of Games</h3>
			<table cellpadding="5" cellspacing="5">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Fees</th>
						<th>Player_Objects</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="g" items="${games}">
						<tr>
							<td>${g.id}</td>
							<td>${g.name}</td>
							<td>${g.minimum_fees}</td>
							<td>${g.players}</td>
							<td><a
								href="<%=request.getContextPath()%>/game/${g.id}">Details</a>
								&nbsp;<a
								href="<%=request.getContextPath()%>/updateGame/game/${g.id}">Update</a>
								&nbsp; <a
								href="<%=request.getContextPath()%>/deleteGame/game/${g.id}"
								onclick="return confirm('Do you really want to delete?')">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
        No Games found in the DB!
        </c:otherwise>
	</c:choose>
</body>
</html>