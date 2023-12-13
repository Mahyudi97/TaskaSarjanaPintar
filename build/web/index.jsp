<%-- 
    Document   : index
    Created on : Jul 1, 2019, 6:21:03 PM
    Author     : Ahmad Mahyudi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/stylesheet.css">
<html>


<title> Taska Sarjana Pintar</title>
  <body>
    <head>
        <div class="navbar">
            <h1 class="w3-center"><b><img src="css/logo.png" style="width:5%">Taska Sarjana Pintar</b></h1>
            <a href="index.jsp">Home</a>
            <a href="ourInfo.jsp">Our Info</a>
            <a href="register.jsp">Register</a>
            <a href="studentProfile.jsp">Student Profile</a>
            <a href="login.jsp">User</a>
          </div>
    </head>

      
    
      <br><br><br><br><br><br><br><br><br><br>
        <div class="mySlides w3-display-container w3-center">
            <img src="css/img1.jpeg" class="w3-round w3-border w3-card-4" style="width:50%">
            <div class="w3-display-middle w3-container w3-text-white w3-padding-32 w3-hide-small">
                <img src="css/logo.png" style="width:30%"><br>
                <font size="7"><b>Taska Sarjana Pintar</b></font>
                <p><b>“Once you learn how to read, you will be free forever”</b></p>
            </div>
            </div>
            <div class="mySlides w3-display-container w3-center">
              <img src="css/img2.jpeg" class="w3-round w3-border w3-card-4" style="width:50%">
              <div class="w3-display-middle w3-container w3-text-white w3-padding-32 w3-hide-small">
                <img src="css/logo.png" style="width:30%"><br>
                <font size="7"><b>Taska Sarjana Pintar</b></font>
                <p><b>“Once you learn how to read, you will be free forever”</b></p>
              </div>
            </div>
            <div class="mySlides w3-display-container w3-center">
              <img src="css/img3.jpeg" class="w3-round w3-border w3-card-4" style="width:50%">
              <div class="w3-display-middle w3-container w3-text-white w3-padding-32 w3-hide-small">
                <img src="css/logo.png" style="width:30%"><br>
                <font size="7"><b>Taska Sarjana Pintar</b></font>
                <p><b>“Once you learn how to read, you will be free forever”</b></p>
              </div>
            </div>




    <footer>
        <p class="w3-medium">Powered by UiTM</p>
    </footer>

  </body>

</html>

<script language="javascript">
        // Automatic Slideshow - change image every 2 seconds
        var myIndex = 0;
        carousel();

        function carousel() {
            var i;
            var x = document.getElementsByClassName("mySlides");
            for (i = 0; i < x.length; i++) {
               x[i].style.display = "none";
            }
            myIndex++;
            if (myIndex > x.length) {myIndex = 1}
            x[myIndex-1].style.display = "block";
            setTimeout(carousel, 2000);
        }
</script>
