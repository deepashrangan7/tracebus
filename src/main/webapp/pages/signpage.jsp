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

.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin .checkbox {
	font-weight: normal;
}

.form-signin .form-control {
	position: relative;
	font-size: 16px;
	height: auto;
	padding: 10px;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="text"] {
	margin-bottom: -1px;
	border-bottom-left-radius: 0;
	border-bottom-right-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}

.account-wall {
	margin-top: 20px;
	padding: 40px 0px 20px 0px;
	background-color: #f7f7f7;
	-moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	-webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}

.login-title {
	color: #555;
	font-size: 18px;
	font-weight: 400;
	display: block;
}

.profile-img {
	width: 96px;
	height: 96px;
	margin: 0 auto 10px;
	display: block;
	-moz-border-radius: 50%;
	-webkit-border-radius: 50%;
	border-radius: 50%;
}

.need-help {
	margin-top: 10px;
}

.new-account {
	display: block;
	margin-top: 10px;
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
				<li class="nav-item active text-light"><a
					class="nav-link text-light" href="/">Home <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item"><a class="nav-link text-light"
					href="/help">Help</a></li>
			</ul>
		</div>
	</nav>
	<br />
	<div
		style="margin-bottom: 2ex; text-align: center; justify-content: center; justify-self: center;">
		<br>

		<div class="container">

			<div class="row" style="text-align: center;">
				<div class="col-md-12 col-md-12 col-md-offset-"
					style="text-align: center;">
					<h1 class="text-center login-title" style="font-weight: bolder;">SignUp</h1>
					<div class="account-wall">
						<img class="profile-img" src="person.png" alt="person">
						<f:form class="form-signin" action="/sign" method="POST"
							modelAttribute="sBean">
							<f:input type="text" class="form-control"
								placeholder="Enter Name" autofocus="true" name="name"
								path="name" />
							<br />
							<i style="color: red;"><f:errors path="name"></f:errors> </i>


							<br />

							<f:input type="text" class="form-control"
								placeholder="Enter Email" autofocus="true" name="email"
								path="email" />
							<br />
							<i style="color: red;"><f:errors path="email"></f:errors> </i>
							<i style="color: red;">${uerr}</i>
							<br />
							<!-- here if -->
							<f:input type="text" pattern="[6-9][0-9]{9}" class="form-control"
								placeholder="Enter Mobile Number" autofocus="true" name="phone"
								path="phone" />
							<br />
							<f:input type="password" class="form-control"
								placeholder="Password" name="password1" path="password1" />
							<br />
							<i style="color: red;"><f:errors path="password1"></f:errors></i>
							<br />
							<f:input type="password" class="form-control"
								placeholder="Confirm Password" name="password2" path="password2" />
							<br />
							<i style="color: red;"><f:errors path="password2"></f:errors></i>
							<i style="color: red;">${err}</i>
							<br />

							<button class="btn btn-lg btn-primary btn-block" type="submit">
								SignUp</button>
							<br />

						</f:form>
					</div>


					<a href="/login" class="text-center new-account">Already Have
						an Account ? Login... </a>
				</div>

			</div>

		</div>

	</div>
	<br>
	<br>
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