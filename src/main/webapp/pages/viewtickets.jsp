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
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-light  text-light"
		style="background-color: navy;">
		<a class="navbar-brand text-light" href="#">Trace</a>
		<button class="navbar-toggler  bg-light " type="button"
			data-toggle="collapse" data-target="#navbarTogglerDemo02"
			aria-controls="navbarTogglerDemo02" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon "></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active text-light">
					<!-- Button trigger modal --> <a type="button"
					class="nav-link text-light" data-toggle="modal"
					data-target="#exampleModalLong"> Profile </a> <!-- Modal -->
					<div class="modal fade" id="exampleModalLong" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalLongTitle"
						aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLongTitle">Profile</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">

									<center>
										<a href="/changepic"><img alt="profile pic" src="${pimg}"
											height="22%" width="22%"> </a>
									</center>
									<br /> <br /> <br />
									<table>
										<tr>
											<th><i style="color: black;">Email : </i></th>
											<td><i style="color: black;">${user}</i></td>
										</tr>
										<tr>
											<th><i style="color: black;">Name : </i></th>
											<td><i style="color: black;">${name}</i></td>
										</tr>
									</table>

								</div>
								<div class="modal-footer">

									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
				</li>
				<li class="nav-item"><a class="nav-link text-light"
					href="/userhome">Home</a></li>
				</li>
				<li class="nav-item"><a class="nav-link text-light"
					href="/logout">Logout</a></li>
				<li class="nav-item"><a class="nav-link text-light"
					href="/help">Help</a></li>


			</ul>
		</div>
	</nav>
	<br />
	<div style="text-align: center;">
		<div class="container">
			<h3 style="font-family: cursive; margin-bottom: 2em;">Your
				Tickets</h3>

			<br />
			<div style="text-align: right;">
				<f:form method="post" action="viewtickets" modelAttribute="filt">
					<div class="form-row">

						<div class="form-group col-md-4" style="text-align: right;">
							<f:select class="form-control" name="filter" path="filter">
								<f:option value="yes" selected="true">Active</f:option>
								<f:option value="no">Not Active</f:option>
								<f:option value="all">All</f:option>

							</f:select>
						</div>
						<div>
							<input type="submit" class="btn btn-primary btn-md"
								value="filter">
						</div>
					</div>
				</f:form>
			</div>

		</div>

	</div>
	<hr />

	<table class="table table-hover">

		<thead>
			<tr>
				<th scope="col">Ticket Id</th>
				<th scope="col">Active</th>
				<th scope="col">Date</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${tickets}" var="t">

				<tr>
					<th scope="row">${t.tid}</th>
					<td>${t.active}</td>
					<td>${t.date}</td>
					<td><a href="/viewp?tid=${t.tid}" class="btn btn-primary">View</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
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