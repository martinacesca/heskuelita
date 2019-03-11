
<!DOCTYPE html>
<html>

<head>

  <meta charset="US-ASCII">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
  <link rel="stylesheet" href="css/reg.css">

  <title>Sign Up </title>

</head>


<body>

  <div>

    <!--  Main title  -->
  	<header class="font-title">
  		<h2><b>Heskuelita</b> </h2>
  		<p>Welcome to Heskuelita!</p>
  	</header>

	<!-- LOGN IN FORM  -->
    <form action="register" method="post" >
    	<!--    form Title  -->
    	<header class="font-subtitle">
          <h2><b>Sign Up</b> </h2>
          <p>Complete the form with your personal information</p>
      	</header>

      	<!--  Field  -->
      	<div class="field-set">

      		<!--   PERSONAL INFORMATION -->
	      	<h3><b>Personal information</b></h3>

	      	<!--   NAME and LAST NAME row-->
	      	<div class="row">
	      		<!--   Name -->
		        <div class="font-style col-xs-6" >
		          	<label for="first_name">First Name:</label>
		          	<input type="text"  class="form-control" id="name" placeholder="Enter your name" name="name" required>
		        </div>
		        <!--   Last name -->
		        <div class="font-style col-xs-6" >
		          	<label for="last_name">Last Name:</label>
		          	<input type="text"  class="form-control" id="last_name" placeholder="Enter your last name" name="last_name" required>
		        </div>
		    </div>

		    <!--   BIRTHDATE and SEX row -->
	      	<div class="row">
	      		<!--   Birthdate -->
		        <div class="font-style col-xs-6" >
		        	<label>Birthdate:</label>
		          	<input type="date"  class="form-control" id="birthdate" name="birthdate" required>
		        </div>
		        <!--   Sex -->
		        <div class="font-style col-xs-6" >
		          	<label>Sex:</label><br>
		          	<input type="radio" id="sex" name="sex" value="male"> Male
		          	<input type="radio" id="sex" name="sex" value="female"> Female
		          	<input type="radio" id="sex" name="sex" value="other"> Other
		        </div>
		    </div>

		    <!--   DOCUMENT row -->
		    <div class="row">
		    	<!--   Document type -->
		        <div class="font-style col-xs-6" >
			        <label for="document">Document type:</label> <br>
			        <input type="radio" id="document_type" name="document_type" value="dni"> DNI
			        <input type="radio" id="document_type" name="document_type" value="pasaporte"> Pasaporte
			        <input type="radio" id="document_type" name="document_type" value="cedula">Cedula
			        <input type="radio" id="document_type" name="document_type" value="other"> Other
			        <!--   Document numbrer -->
			        <input type="text"  class="col-xs-6 form-control " id="document" placeholder="Enter your document" name="document" required>
		        </div>
		        <!--   other document type -->
		        <div class="font-style col-xs-6 " ><br>
		          <label for="document">In case of other specify document type:</label> <br>
		          <input type="text"  class="form-control " id="document_s" placeholder="Specify document type" name="document_s">
		        </div>
		    </div>

		    <!--   PHONE NUMBER row -->
	      	<div class="row">
	        	<div class="font-style col-xs-6">
	          		<label for="telephone">Telephone number:</label>
	          		<input type="text" class="form-control"  name="telphone" maxlength="20"   placeholder="000-000-000"  required/>
	        	</div>
	      	</div>

	      	<!--   CITY, ADRESS and ZIPCODE row -->
	      	<div class="row">
	      		<!--   City -->
	        	<div class="font-style col-xs-5">
		          	<label for="city">City:</label>
	          		<input type="text"  class="form-control" id="city" placeholder="Enter your city " name="city" required>
		        </div>
		        <!--   Adress -->
		        <div class="font-style col-xs-5">
	          		<label for="street">Adress:</label>
		          	<input type="text"  class="form-control" id="street" placeholder="Enter your street " name="street">
		        </div>
		        <!--   Zipcode -->
		        <div class="font-style col-xs-2">
		          	<label for="zip">ZipCode:</label>
	          		<input type="text"  class="form-control" id="zip" maxlength="10"placeholder="Enter Zip Code " name="zip">
		        </div>
	      	</div>


	      	<!--   USER INFORMATION -->
	      	<br><br>
		    <h3 class="font"><b>User Information</b></h3>

		    <!--   PROFILE IMAGE -->
		    <div class="row">
		        <div class="font-style ">
		          	<label for="pic">Upload a profile image:</label>
		          	<input type="file"  name="pic" accept="image/*">
		        </div>
		    </div>

		    <!--   USERNAME row -->
	      	<div class="row">
	        	<div class="font-style ">
	          		<label for="username">Username (your email):</label>
	          		<input type="email" class="form-control" id="username" placeholder="Username (email)" name="username" required>
	        	</div>
	      	</div>

	      	<!--   PASSWORD row -->
	      	<div class="row">
	        	<div class="font-style " >
	          		<label  for="password">Password:</label>
	          		<input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd" required>
	        	</div>
	      	</div>

	      	<!--   REPEAT PASSWORD -->
	      	<div class="row">
	        	<div class="font-style " >
	          		<label for="password">Repeat password:</label>
	          		<input type="password" class="form-control" id="pwd" placeholder="Repeat password" name="pwd" required>
	        	</div>
	      	</div>


	      	<!--   BUTTON -->
	        <button class="sign-up btn btn-primary btn-lg btn-block"><b>Sign Up</b>
				<!--         Sign Up font icon -->
	      		<i class="fa fa-user-plus" aria-hidden="true"></i>
	      	</button>

	    <!--   close field -->
	    </div>

	<!-- End Form -->
    </form>

  <!-- End Form Container -->
  </div>


</body>
</html>


