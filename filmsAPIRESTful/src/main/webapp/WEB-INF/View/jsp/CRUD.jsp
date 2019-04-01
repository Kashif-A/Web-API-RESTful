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
	         width: 300px; height: 35px; margin-bottom: 5px; margin-left: 5px; margin-right: 30px;
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
      </style>
   </head>
   <body>

      <!-- MAIN CONTAINER -->
      <div class="container">
         <div class="row">
            <div class="col text-center">
               <a href="https://filmsRESTful.appspot.com/"><button class="btn btn-success">Home</button></a>
            </div>
         </div>

         <!-- CRUD Links -->
         <div class="row" style="margin-top: 40px">
            <div class="col-md-3">
               <a href="create"><button class="btn btn-primary">Create</button></a>
            </div>
            <div class="col-md-3">
               <a href="read"><button class="btn btn-primary">Read</button></a>
            </div>
            <div class="col-md-3">
               <a href="update"><button class="btn btn-primary">Update</button></a>
            </div>
            <div class="col-md-3">
               <a href="delete"><button class="btn btn-primary">Delete</button></a>
            </div>
         </div>
      </div>
   </body>
</html>