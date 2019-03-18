
<!DOCTYPE html>
<html>

<head>


  <meta charset="US-ASCII">
  <link rel="stylesheet" href="css/index.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

  <title>Login</title>

</head>


<body>

  <div>

    <!--  Main title  -->
    <header class="font-title ">
      <h2>Heskuelita</h2>
      <p>Welcome to Heskuelita!</p>
    </header>

    <!-- LOGN IN FORM  -->
    <form action="login" method="post">
       <!--   con = Container  for items in the form-->
       <div class="con">
           <!--    form Title  -->
            <header class="head-form">
              <h2>Log In</h2>
              <p>login here using your username and password</p>
           </header>
           <br>

          <!--  Field  -->
          <div class="field-set">

              <!--   USERNAME -->
              <span class="input-item">
                <i class="fa fa-user-circle"></i>
              </span>
              <!--   user name Input-->
              <input class="form-input" id="txt-input" type="text" placeholder="UserName" name="userName"required>
              <br>

              <!--   PASSWORD -->
              <span class="input-item">
                <i class="fa fa-key"></i>
              </span>
              <!--   Password Input-->
              <input class="form-input" type="password" placeholder="Password"  name="password" required>

              <!--      Show/hide password  -->
              <span>
                <i class="fa fa-eye" aria-hidden="true"  type="button" id="eye"></i>
              </span>
              <br>

              <!--  LOGIN BUTTONS -->
              <button class="log-in"> Log In </button>

          <!--   close field -->
          </div>


          <!--  SIGN UP BUTTON -->
          <div class="other">
              <!--    button -->
              <a href="form.jsp">
                <button class="log-in sign-up">Sign Up
                <!--     font icon -->
                <i class="fa fa-user-plus" aria-hidden="true"></i>
              </a>

              </button>
          </div>

       <!--   End Conrainer  -->
       </div>

    <!-- End Form -->
    </form>

  <!-- End Form contaner -->
  </div>

</body>
</html>