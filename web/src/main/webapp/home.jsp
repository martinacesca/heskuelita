<%@ page import="com.capgemini.heskuelita.data.entity.UserAnnotation" contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>

  <meta charset="US-ASCII">
  <link rel="stylesheet" href="css/home.css">

  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

  <title>Home</title>

</head>



<body>

  <div>

    <!--  Main title  -->
    <header class="font-title ">
      <h2>Heskuelita</h2>
      <p>Welcome to Heskuelita!</p>
    </header>

    <!-- WELCOME MESSAGE -->

       <!--   Container  message -->
       <div class="con">
       		<%UserAnnotation us = (UserAnnotation)session.getAttribute ("user");%>
            <header class="head-form">
              <h2 class="mes">Welcome </h2><br>
              <h2 class="mes"><%=us.getUserName() %> </h2>
           </header>
           <br>

       <!--   End Conrainer  -->
       </div>


  <!-- End Message contaner -->
  </div>

</body>
</html>