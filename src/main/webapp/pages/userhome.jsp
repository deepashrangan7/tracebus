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
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
    integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
    integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
    crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
    integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
    crossorigin="anonymous"></script>
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <!------ Include the above in your HEAD tag ---------->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
    .carousel-inner>.item>img,
    .carousel-inner>.item>a>img {
      width: 70%;
      margin: auto;
    }
  </style>

  <style>
    body {
      margin-top: 50px;
      background-color: #f1f1f1;
    }

    .nav-pills .nav-link.active,
    .nav-pills .show>.nav-link {
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

    @media (max-width: 640px) {
      .dropdown-menu {
        top: 50px;
        left: -16px;
        width: 290px;
      }

      .nav {
        display: block;
      }

      .nav .nav-item,
      .nav .nav-item a {
        padding-left: 0px;
      }

      .message {
        font-size: 13px;
      }
    }
  </style>


</head>

<body>
  <nav class="navbar navbar-expand-lg navbar-light  text-light" style="background-color: navy;margin-top: -50px;">
    <a class="navbar-brand text-light" href="#">Trace</a>
    <button class="navbar-toggler  bg-light " type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02"
      aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon "></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
      <ul class="navbar-nav mr-auto mt-2 mt-lg-0">



        <li class="nav-item active text-light">
          <!-- Button trigger modal --> <a type="button" class="nav-link text-light" data-toggle="modal"
            data-target="#exampleModalLong"> Profile </a> <!-- Modal -->
          <div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog"
            aria-labelledby="exampleModalLongTitle" aria-hidden="true">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLongTitle">Profile</h5>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>
                <div class="modal-body">
    
                  <center>
                    <a href="/changepic"><img alt="profile pic" src="${pimg}" height="22%" width="22%"> </a>
                  </center>
     <br />
                  <br />
                  <br />
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

                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
              </div>
            </div>
          </div>
        </li>

        <li class="nav-item active text-light"><a class="nav-link text-light" href="/help">Help <span
              class="sr-only">(current)</span></a></li>
        <li class="nav-item"><a class="nav-link text-light" href="/logout">Logout</a></li>
        <!--here-->

        <li class="nav-item dropdown" style="padding-left: 25%;">
          <a class="nav-link text-light" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
            aria-haspopup="true" aria-expanded="false">
            <i class="fa fa-bell">Notification</i>
          </a>
          <ul class="dropdown-menu">
            <li class="head text-light bg-dark">
              <div class="row">
                <div class="col-lg-12 col-sm-12 col-12">
                  <span>Notifications (3)</span>
                  <a href="" class="float-right text-light">Mark all as read</a>
                </div>
            </li>
            <li class="notification-box">
              <div class="row">
                <div class="col-lg-3 col-sm-3 col-3 text-center">
                  <img src="news.jpg" class="w-50 rounded-circle">
                </div>
                <div class="col-lg-8 col-sm-8 col-8">
                  <strong class="text-info">David John</strong>
                  <div>
                    Lorem ipsum dolor sit amet, consectetur
                  </div>
                  <small class="text-warning">27.11.2015, 15:00</small>
                </div>
              </div>
            </li>
            <li class="notification-box bg-gray">
              <div class="row">
                <div class="col-lg-3 col-sm-3 col-3 text-center">
                  <img src="pic2.jpg" class="w-50 rounded-circle">
                </div>
                <div class="col-lg-8 col-sm-8 col-8">
                  <strong class="text-info">David John</strong>
                  <div>
                    Lorem ipsum dolor sit amet, consectetur
                  </div>
                  <small class="text-warning">27.11.2015, 15:00</small>
                </div>
              </div>
            </li>

            <li class="footer bg-dark text-center">
              <a href="" class="text-light">View All</a>
            </li>
          </ul>

        </li>







      </ul>
      <!--here-->
    </div>
  </nav>
  <h4 style="text-align: center;">Welcome ${name}</h4>

<c:if test="${can==1}">
<div class="alert alert-success alert-dismissible fade show" role="alert">
  <strong>Ticket cancelled successfully</strong> 
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
</c:if>
  <div class="container">

    <!--Carousel Wrapper-->
    <div id="carousel-example-2" class="carousel slide carousel-fade" data-ride="carousel">
      <!--Indicators-->
      <ol class="carousel-indicators">
        <li data-target="#carousel-example-2" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-2" data-slide-to="1"></li>
        <li data-target="#carousel-example-2" data-slide-to="2"></li>
      </ol>
      <!--/.Indicators-->
      <!--Slides-->
      <div class="carousel-inner" role="listbox">
        <div class="carousel-item active">
          <div class="view">
            <img class="d-block w-100" src="track1.jpg" alt="First slide">
            <div class="mask rgba-black-light"></div>
          </div>
          <div class="carousel-caption">
            <h3 class="h3-responsive" style="color: black;">Now Track Your Busses</h3>
            <p style="color: black;">Trace enable to get location of the bus and track it . Even you can get notified
              when bus reaches your stop ! Happy Tracking!!!</p>
          </div>
        </div>
        <div class="carousel-item">
          <!--Mask color-->
          <div class="view">
            <img class="d-block w-100" src="track2.jpg" alt="Second slide">
            <div class="mask rgba-black-strong"></div>
          </div>
          <div class="carousel-caption">
            <h3 class="h3-responsive">Book Your Tickets Online</h3>
            <p>now you can book your bus tickets even before riding. You can cancel the tickets at any time before
              boarding!!!</p>
          </div>
        </div>
        <div class="carousel-item">
          <!--Mask color-->
          <div class="view">
            <img class="d-block w-100" src="track3.jpg" alt="Third slide">
            <div class="mask rgba-black-slight"></div>
          </div>
          <div class="carousel-caption">
            <h3 class="h3-responsive">Happy Tracking</h3>
            <p>Our Trace app reached over 1.2million user in past one month. Thank you for your contributions !!!Happy
              Tracing!!!</p>
          </div>
        </div>
      </div>
      <!--/.Slides-->
      <!--Controls-->
      <a class="carousel-control-prev" href="#carousel-example-2" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="carousel-control-next" href="#carousel-example-2" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
      <!--/.Controls-->
    </div>
    <!--/.Carousel Wrapper-->

  </div>
  <br /><br />
  <div class="card-group">
    <div class="card">
      <img class="card-img-top" src="pic.jfif" alt="Card image cap">
      <div class="card-body">
        <h5 class="card-title">Locate a Bus</h5>
        <p class="card-text">Enter the bus number which you want to know the location and get the location of your
          bus.This will help you to reduce your waiting time. </p>
      </div>
      <div class="card-footer">
        <a class="btn btn-primary active btn-md" href="/locate">Locate</a>
      </div>
    </div>
    <div class="card">
      <img class="card-img-top" src="pic2.jpg" alt="Card image cap">
      <div class="card-body">
        <h5 class="card-title">Book your Ticket</h5>
        <p class="card-text">Book your Bus ticket at a click. Book now and get peaceful journey. Don't worry you can
          cancel your tickets at any point of time before boarding...</p>
      </div>
      <div class="card-footer">
        <a class="btn btn-primary active btn-md" href="/booktickets">Book</a>
      </div>
    </div>
    <div class="card">
      <img class="card-img-top" src="calc.jpg" alt="Card image cap">
      <div class="card-body">
        <h5 class="card-title">Fare calculator</h5>
        <p class="card-text">Know your fare before you board . You can calculate the amount and keep exact change to
          make life easier</p>
      </div>
      <div class="card-footer">
        <a class="btn btn-primary active btn-md" href="/calculatefare">Calculate Fare</a>
      </div>
    </div>
  </div>
  <br />
  <div class="card-group">
    <div class="card">
      <img class="card-img-top" src="book.png" alt="Card image cap">
      <div class="card-body">
        <h5 class="card-title">View your bookings</h5>
        <p class="card-text">Get complete details of your bookings. check the status of your bookings.</p>
      </div>
      <div class="card-footer">
        <a class="btn btn-primary active btn-md" href="/viewtickets">View</a>
      </div>
    </div>

    <div class="card">
      <img class="card-img-top" src="ques.png" alt="Card image cap">
      <div class="card-body">
        <h5 class="card-title">want to know your Busses ? </h5>
        <p class="card-text">enter your stop of boarding and the location where you want to go and find your suitable
          busses with timings...</p>
      </div>
      <div class="card-footer">
        <a class="btn btn-primary active btn-md" href="/locatebusses">Proceed</a>
      </div>
    </div>
    <div class="card">
      <img class="card-img-top" src="news.jpg" alt="Card image cap">
      <div class="card-body">
        <h5 class="card-title">News Feed</h5>
        <p class="card-text">Get the latest information about our app and the new updates which is yet to be released
        </p>
      </div>
      <div class="card-footer">
        <a class="btn btn-primary active btn-md" href="/newsfeed">Get to know</a>
      </div>
    </div>
  </div>
<br/><br/><br/>
  <div class="footer" style="margin-top: 3em;">
    <div>
      <span style="text-align: left; font-size: large; padding-right: 5em;">Copyright
        &copy; 2020</span> <a href="#"><span style="float: right; font-size: large;">Goto Top</span></a>
      <!-- <a href="https://github.com/deepashrangan7/TransportTracker" target="_blank"><span style="float: right;font-size: large;">Source Code</span></a> -->
    </div>
  </div>
</body>

</html>