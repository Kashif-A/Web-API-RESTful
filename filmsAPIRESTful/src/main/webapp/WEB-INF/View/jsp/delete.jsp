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
               <a href="https://filmsRESTful.appspot.com/CRUD"><button class="btn btn-success">Back</button></a>
            </div>
         </div>
         <div class="row delete">
            <div class="col" style="padding: 50px">
               <h3><em><strong>DELETE FILM &nbsp;&nbsp;&nbsp;&nbsp; (HTTP Delete Request)</strong></em></h3><br>
               <p>Use ID to delete film...</p><br><br>
               <div class="col-md-5 text-right">

                  <!-- Delete Film by ID Form -->
                  <form action="deletefilm/id/" id="formDeleteRequest">
                  	<fieldset>
                     	ID		<input type="number" name="id" /><br><br>
                     		<input class="btn btn-primary" type="submit" value="Submit" />
                     </fieldset>
                  </form>
               </div>
            </div>
         </div>
		 <div class="row" id="loading" style="display:none;">
            <div class="col text-center">
                <img src="https://i.redd.it/ounq1mw5kdxy.gif" height=500px alt="Loading..."></img>
            </div>
		</div>
		<div class="row">
            <div class="col">
            	<pre id="messageDisplayArea" style="margin: 30px; padding: 10px; display: none; height: 550px;"></pre>
            </div>
		</div>
        </div>
      
      <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
      <script type="text/javascript">

         // Function to take Form input 'ID' and send AJAX DELETE request to REST URL
         $("#formDeleteRequest" ).submit(function( event ) {
           	event.preventDefault();
           	$(".delete").hide();
           	$("#loading").show();
           	var $form = $( this ),
            url = $form.attr( "action" );
            var results;
			var id = $("#formDeleteRequest").find("input[name=\"id\"]").val();
			console.log(url+id);

          // AJAX DELETE Request
          $.ajax({
             type: 'DELETE',
             url: url+id,
             cache: false,
             success: function (result) {
            	results = result;
                console.log(result);
             },
             error: function(xhr,status,error) {
               console.log(error);
             },
             complete:function(){
             	console.log('AJAX HTTP DELETE request completed without errors!')
             	$("#loading").hide();
             	$("#messageDisplayArea").html("<strong><em><h3>DELETE request sent successfully to REST url: </h3></em></strong>" + url+id + 
						 					  "<br><br><br><strong><em><h3>DELETED MOVIE WITH ID: - </h3></em></strong>" + id + 
						  					  "\n\n<strong><em><h3>AJAX HTTP DELETE request completed without errors!</h3></em></strong>");
             	$("#messageDisplayArea").show();
             }
           });
          }); 
   	  </script>
   </body>
</html>