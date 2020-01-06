<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>movie item list admin</title>
<link href="./style/style1.css" rel="stylesheet" type="text/css" />
<script src="./js/script2.js" type="text/javascript"></script>
</head>
<body>
	<header>
		<span id="title">Movie cruiser</span> <img src="./images/logo.png"
			alt="logo" id="logo">
		<nav>
			<a class="nav" href="ShowFavorite">favorites</a> <a class="nav"
				href="ShowMovieListCustomer">movies</a>
		</nav>
	</header>
	<div>
		<h1>Movies</h1>
		<h3>${msg}</h3>
		<table>
			<tr>
				<th class="al.left">Title</th>
				<th class="al.right">Box office</th>
				<th class="al.mid">Genre</th> 
				<th class="al.mid">has Teaser</th>
				<th class="al.mid">Action</th>
			</tr>
			<c:forEach items="${movieItemList}" var="movie">
				<tr>
					<td class="al.left">${movie.title}</td>
					<td class="al.right">$${movie.boxoffice}</td>
					<td class="al.mid">${movie.genre}</td>
					<td class="al.mid">${movie.hasTeaser?'Yes' : 'No'}</td>
					<td class="al.mid"><a
						href="AddToFavorite?movieItemId=${movie.id}">Add
							to Favorite</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<footer> copyright  @ copy 2019 </footer>
</body>
</html>
