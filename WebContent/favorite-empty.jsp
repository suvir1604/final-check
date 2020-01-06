<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
  <head>
   <title>movie item list</title>
   <link href="./style/style1.css" rel="stylesheet" type="text/css" />
   <script src="./js/script1.js" type="text/javascript"></script>
    </head>
   <body>
    <header>
    <span id="title">movie cruiser</span>
    <img src="./images/logo.png" alt="logo" id="logo">
    <nav>
	<a class="nav" href="ShowFavorite">favorites</a>
	<a class="nav" href="ShowMovieListCustomer">movies</a> 
    </nav>
    </header>
    <div>
    <h1>favorite</h1>
	<h4>No items in favorite.Use "Add to favorite" option in <a href="ShowMovieListCustomer">movie list</a></h4>
	</div>
	<footer>
	copyright  @ copy 2019
	</footer>