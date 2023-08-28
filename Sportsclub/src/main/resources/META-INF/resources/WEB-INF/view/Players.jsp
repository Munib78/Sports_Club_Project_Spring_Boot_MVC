<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Player CRUD Operations</title>
<body>
	<h2>Player CRUD Operations</h2>
	<a href="<%=request.getContextPath()%>/addPlayer">Add</a>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<c:choose>
		<c:when test="${players != null}">
			<h3>List of Players</h3>
			<table cellpadding="5" cellspacing="5">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Mobile_No</th>
						<th>Game_Object</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="p" items="${players}">
						<tr>
							<td>${p.id}</td>
							<td>${p.name}</td>
							<td>${p.getmobile_no()}</td>
							<td>${p.game_name}</td>
							<td><a
								href="<%=request.getContextPath()%>/player/${p.id}">Details</a>
								&nbsp;<a
								href="<%=request.getContextPath()%>/updatePlayer/player/${p.id}">Update</a>
								&nbsp; <a
								href="<%=request.getContextPath()%>/deletePlayer/player/${p.id}"
								onclick="return confirm('Do you really want to delete?')">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
        No Player found in the DB!
        </c:otherwise>
	</c:choose>
</body>
</html>