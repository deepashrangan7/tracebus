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


    tbody {
      display: block;
      height: 400px;
      overflow: auto;
    }

    thead,
    tbody tr {
      display: table;
      width: 100%;
      table-layout: fixed;
    }

    thead {}
  </style>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>

<body>
  <nav class="navbar navbar-expand-lg navbar-light  text-light" style="background-color: navy;">
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
<li class="nav-item"><a class="nav-link text-light" href="/userhome">Home</a></li>
        </li>
        <li class="nav-item"><a class="nav-link text-light" href="/logout">Logout</a></li>
        <li class="nav-item"><a class="nav-link text-light" href="/help">Help</a></li>


      </ul>
    </div>
  </nav>
  <br />

  <h3 style="text-align: center;margin-top: 2em;font-family:cursive;color: navy;">NewsFeed</h3>
  <div class="card-group" style="margin-bottom: 2em;">
  
    <div class="card">
      <img src="pic.jfif" height="50% "; width="50%"  class="card-img-top" alt="3A">
      <div class="card-body">
        <h5 class="card-title">Busses With security camera's</h5>
        <p class="card-text">TN Government has planned to place CCTV Camera's to overcome the robbery's and other problems.</p>
        <a href="https://timesofindia.indiatimes.com/city/chennai/all-govt-buses-to-be-fitted-with-2-sets-of-cctv-cameras/articleshow/74143501.cms" class="btn btn-primary" target="_blank">Get More Info.</a>
 
      </div>
      <div class="card-footer">
        <small class="text-muted">Last updated 1 min ago</small>
      </div>
    </div>
    <div class="card">
      <img src="pic2.jpg" height="50%"; width="50%" class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">Pre-Booking</h5>
        <p class="card-text">Now You can book your tickets before on-boarding and can beat the change problem</p>
      <a href="https://timesofindia.indiatimes.com/city/chennai/now-track-mtc-buses-on-phone-with-chalo-app/articleshow/74567715.cms" target="_blank" class="btn btn-primary">Get More Info.</a>
      </div>
      <div class="card-footer">
        <small class="text-muted">Last updated 2 mins ago</small>
      </div>
    </div>
    <div class="card">
      <img src="pic4.jpg" height="50%"; width="50%" class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">Bus gets stopped until Apr 21.</h5>
        <p class="card-text">Busses between cities get stopped until April 21st informed by Transport Minister.Due to corona virus spreading.</p>
 <a class="btn btn-primary" href="https://www.polimernews.com/dnews/104654/%E0%AE%AE%E0%AE%BE%E0%AE%A8%E0%AE%BF%E0%AE%B2%E0%AE%99%E0%AF%8D%E0%AE%95%E0%AE%B3%E0%AF%81%E0%AE%95%E0%AF%8D%E0%AE%95%E0%AF%81-%E0%AE%87%E0%AE%9F%E0%AF%88%E0%AE%AF%E0%AF%87%E0%AE%87%E0%AE%AF%E0%AE%95%E0%AF%8D%E0%AE%95%E0%AE%AA%E0%AF%8D%E0%AE%AA%E0%AE%9F%E0%AF%81%E0%AE%AE%E0%AF%8D-%E0%AE%AA%E0%AF%87%E0%AE%B0%E0%AF%81%E0%AE%A8%E0%AF%8D%E0%AE%A4%E0%AF%81%E0%AE%9A%E0%AF%87%E0%AE%B5%E0%AF%88%E0%AE%95%E0%AE%B3%E0%AF%8D-%E0%AE%A8%E0%AE%BF%E0%AE%B1%E0%AF%81%E0%AE%A4%E0%AF%8D%E0%AE%A4%E0%AE%AE%E0%AF%8D" target="_blank">Get More Info.</a>
      </div>
      <div class="card-footer">
        <small class="text-muted">Last updated 3 mins ago</small>
      </div>
    </div>
  </div>
<br/>
  <div class="footer" style="margin-top: 3em;">
    <div>
    <span style="text-align: left;font-size: large;padding-right: 5em;">Copyright 	&copy; 2020</span>
    <a href="#" ><span style="float: right;font-size: large;">Goto Top</span></a>
    <!-- <a href="https://github.com/deepashrangan7/TransportTracker" target="_blank"><span style="float: right;font-size: large;">Source Code</span></a> -->  
  </div>
  </div>
</body>

</html>