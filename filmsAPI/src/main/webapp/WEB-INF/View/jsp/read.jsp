<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% response.setContentType("text/html");
   response.setStatus(HttpServletResponse.SC_OK);
   response.setCharacterEncoding("UTF-8");
   response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
   response.setHeader("Cache-Control", "no-cache");
   response.setHeader("Pragma", "no-cache"); %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
   <head>
      <meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Spring/Hibernate Film Database Web Application</title>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
      
      <!-- CSS STYLES -->
      <style>
	      .btn {
	         font-size: 20px; width: 60%; height: 60px;
	      }
	      input{
	         width: 250px; height: 35px; margin-bottom: 5px; margin-left: 5px; margin-right: 30px;
	      }
	      .addForm{
	         padding: 10px;
	      }
	      input::-webkit-outer-spin-button, input::-webkit-inner-spin-button {
			    -webkit-appearance: none; margin: 0; 
		  }
		  input[type=number] {
			    -moz-appearance:textfield;
		  }
		  .button-s {
		  		width: 80px; height: 40px; margin-right: 10px;
		  }
      </style>
   </head>
   <body>

      <!-- MAIN Container -->
      <div class="container">
         <div class="row">
            <div class="col text-center">
               <a href="https://filmsapi.appspot.com/CRUD"><button class="btn btn-success">Back</button></a>
            </div>
         </div>
         <hr>
         <div class="row read">
            <div class="col" style="padding: 50px">
               <h3><em><strong>READ FILM &nbsp;&nbsp;&nbsp;&nbsp; (HTTP GET request)</strong></em></h3><br><br>

                  <!-- Read Film By Title Form -->
                  <form method="GET" action="searchfilm" name="testform">
                  	<fieldset>
	                     <h3>FILM TITLE: </h3>			<input type="text" name="title" /><br><br>
	                     								<input class="btn btn-primary" type="submit" value="Submit" />
	                </fieldset>
                  </form>
            </div>
         </div>
      </div>
   </body>
</html>