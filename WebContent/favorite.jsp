<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
	<head>
	<title>movie item list admin</title>
	<link href="./style/style1.css" rel="stylesheet" type="text/css" />
	<script src="./js/script1.js" type="text/javascript"></script>
	</head>
	<body>
		<header>
			<span id="title">Movie cruiser</span>
			<img src="./images/logo.png" alt="logo" id="logo">
		<nav>
			<a class="nav" href="ShowFavorite">favorites</a> 
			<a class="nav" href="ShowMovieListCustomer">movies</a>
		</nav>
		</header>
		<div>
			<h1>Favorites</h1>
			<h3>${msg}</h3> 
		<table>
			<tr>
				<th>Title</th>
				<th>Box office</th>
				<th>Genre</th>
				<th>Has Teaser</th>
			</tr>
			<c:forEach items="${movieList}" var="movie"> 
				<tr>
					<td class="al.left">${movie.title}</td>
					<td class="al.right">${movie.boxoffice}</td> 
					<td class="al.mid">${movie.genre}</td> 
					<td class="al.mid">${movie.hasTeaser?'Yes' : 'No'}</td>
					<td><a href="RemoveFavorite?movieItemId=${movie.id}">Delete</a></td>
				</tr>
			</c:forEach>
			<tr>
				<th>No of favorites: ${fn:length(movieList)}</th>
				
		</table>
		</div>
		<footer>
			copyright @  copy 2019
			</footer>
	</body>
</html>