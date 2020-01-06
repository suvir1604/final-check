<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>edit movie item</title>
<link href="./style/style1.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="./js/script2.js"></script>
</head>
<body>
	<header>
		<span id="title">movie cruiser</span> <img src="./images/logo.png"
			alt="logo" id="logo">
		<nav>
			<a class="nav" href="ShowMovieListAdmin">Movies</a>
		</nav>
	</header>
	<div>
		<h1>movies</h1>
		<h3>${msg}</h3>
		<form name="Form" method="post" action="EditMovieList?movieItemId=${movieItem.id}"
			onSubmit="return validate()">
			<table>
				<tr> 
					<th>Title</th>
				</tr>
				<tr>
					<td><input type="text" name="name" id="txtname" value="${movieItem.title}" /></td> 
				</tr>
				<tr>
					<th>Gross</th>
					<th>Active</th>
					<th>datelaunch</th>
					<th>Genre</th>
				</tr>
				<tr>
					<td><input type="text" name="Gross" id="txtGross" value="${movieItem.boxoffice}" />
					</td>
					<td><input type="radio" name="rb" value="yes" <c:if test="${movieItem.active eq 'true'}">checked="checked"</c:if> /><label
						for="rb1">Yes</label>
						<input type="radio" name="rb" value="No" <c:if test="${movieItem.active eq 'false'}">checked="checked"</c:if> /><label
						for="rb1">No</label></td>
					<td><input type="text" name="datelaunch" id="Launch" value="<fmt:formatDate pattern="dd/MM/yyyy"
							value="${movie.dateofLaunch}"></fmt:formatDate>" />
					</td>
					<td><select type="text" name="genre">
							<option <c:if test="${movieItem.genre eq 'sciencefiction'}">selected</c:if>>sciencefiction
							</option>
							<option <c:if test="${movieItem.genre eq 'superhero'}">selected</c:if>>superhero
							</option>
							<option <c:if test="${movieItem.genre eq 'romance'}">selected</c:if>>romance
							</option> 
							<option <c:if test="${movieItem.genre eq 'comedy'}">selected</c:if>>comedy
							</option>
							<option <c:if test="${movieItem.genre eq 'adventure'}">selected</c:if>>adventure
							</option>
							<option <c:if test="${movieItem.genre eq 'thriller'}">selected</c:if>>thriller
							</option>
					</select></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="check" ><c:if test="${movieItem.hasTeaser eq 'true'}">checked="checked"</c:if>
					<c:if test="${movieItem.hasTeaser eq 'false'}">checked="checked"</c:if>Has Teaser</td>
				</tr>
				<tr>
					<td><input type="submit" name="sav" value="save" /></td>
				</tr>
			</table>
		</form>
	</div>
	<footer> copyright  @ copy 2019 </footer>
</body>
</html>