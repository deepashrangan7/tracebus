<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>

<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Trace</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="style1.css" ref="stylesheet">
<style>
.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	background-color: navy;
	color: white;
}
</style>

<style>
body {
	margin-top: 50px;
	background-color: #f1f1f1;
}

.nav-pills .nav-link.active, .nav-pills .show>.nav-link {
	background-color: #17A2B8;
}

.dropdown-menu {
	top: 60px;
	right: 0px;
	left: unset;
	width: 460px;
	box-shadow: 0px 5px 7px -1px #c1c1c1;
	padding-bottom: 0px;
	padding: 0px;
}

.dropdown-menu:before {
	content: "";
	position: absolute;
	top: -20px;
	right: 12px;
	border: 10px solid #343A40;
	border-color: transparent transparent #343A40 transparent;
}

.head {
	padding: 5px 15px;
	border-radius: 3px 3px 0px 0px;
}

.footer {
	padding: 5px 15px;
	border-radius: 0px 0px 3px 3px;
}

.notification-box {
	padding: 10px 0px;
}

.bg-gray {
	background-color: #eee;
}

@media ( max-width : 640px) {
	.dropdown-menu {
		top: 50px;
		left: -16px;
		width: 290px;
	}
	.nav {
		display: block;
	}
	.nav .nav-item, .nav .nav-item a {
		padding-left: 0px;
	}
	.message {
		font-size: 13px;
	}
}
</style>


</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-light  text-light"
		style="background-color: navy; margin-top: -50px;">
		<a class="navbar-brand text-light" href="#">Trace</a>
		<button class="navbar-toggler  bg-light " type="button"
			data-toggle="collapse" data-target="#navbarTogglerDemo02"
			aria-controls="navbarTogglerDemo02" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon "></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li><a href="/ad">Home</a></li>
			</ul>
		</div>
	</nav>
	<br />

	<div style="text-align: center;">
		<div class="container">

			<h5 style="font-family: cursive;">Choose bus</h5>
			<f:form action="/changeloc" method="POST" modelAttribute="changel">
				<f:select name="bus_no" path="bus_no" list="busstops"
					items="${particularbus}" class="custom-select my-4 mr-sm-4"
					style="margin-left: 1em;margin-right: 1em;">

				</f:select>

				<button type="submit" class="btn btn-primary">Choose</button>
			</f:form>

			<hr />
			<hr />
			<br />
			<c:choose>
				<c:when test="${changel.bus_no==null || changel.bus_no==0}">
					<h6 style="font-family: cursive; text-align: center;">Choose a
						Bus</h6>
				</c:when>
				<c:otherwise>

					<h6 style="font-family: cursive;">Bus No : ${changel.bus_no}</h6>
					<table class="table table-hover">

						<tbody>
							<tr>
								<td>Direction</td>
								<td>${bb.direction}</td>
							</tr>
							<tr>
								<td>Current Location</td>
								<td>${bb.loc}</td>
							</tr>
							<tr>
								<td>NextLocation</td>
								<td>${nextloc}</td>

							</tr>
							<tr>
								<td></td>
								<td></td>
								<td><a href="/change?bus_no=${bb.bus_no}"
									class="btn btn-primary">Change Location Manually </a></td>
							</tr>
						</tbody>
					</table>

				</c:otherwise>


			</c:choose>
		</div>
	</div>

	<br />
	<br />
	<br />
	<div class="footer" style="margin-top: 3em;">
		<div>
			<span style="text-align: left; font-size: large; padding-right: 5em;">Copyright
				&copy; 2020</span> <a href="#"><span
				style="float: right; font-size: large;">Goto Top</span></a>
			<!-- <a href="https://github.com/deepashrangan7/TransportTracker" target="_blank"><span style="float: right;font-size: large;">Source Code</span></a> -->
		</div>
	</div>
</body>

</html>