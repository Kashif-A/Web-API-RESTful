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
         <hr>
         <div class="row create text-center">
         	<div class="col-md-3"></div>
            <div class="col-md-6 text-center" style="padding: 25px; background-color: #fcdfb3;">
               <h4><em><strong>(HTTP POST Request -JSON DATA-)</strong></em></h4>
               <p>Fill fields to add film by sending data to server as JSON...</p><br>
               <div class="addForm text-right" style="margin-right: 20px;">

                  <!-- Create Film POST Request Form -->
                  <form method="POST" action="/createfilmJSON" id="JSONPost">
                  	<fieldset>
	                     Title 			<input type="text" name="title" /><br>
	                     Year 			<input type="number" name="year" required /><br>
	                     Director 		<input type="text" name="director" /><br>
	                     Stars 			<input type="text" name="stars" /><br>
	                     Review 		<input type="text" name="review" /><br><br>
	                     				<input class="btn btn-primary" type="submit" value="Submit" />
	                 </fieldset>
                  </form>
               </div>
            </div>
         </div>
		<div class="row">
            <div class="col">
            	<div id="linkUsed" style="margin: 10px; padding: 10px; display: none; height: 20px;"></div>
            </div>
		</div>
        </div>
      
      <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
      <script type="text/javascript">

         // Transform the Form Inputs into JSON object and send it to server
         // to add film using the JSON object.
         $( "#JSONPost" ).submit(function( event ) {
          	event.preventDefault();
          	var $form = $( this ),
            url = $form.attr( "action" );
          
         	var formDataAsJsonArray = $("#JSONPost").serializeArray();
            var finalJSONArray = {};
            
            $.each(formDataAsJsonArray, function() {
            	finalJSONArray[this.name] = this.value || '';
            });
         var JSONForServer = JSON.stringify(finalJSONArray);
         console.log(JSONForServer);
         console.log(url);
         
         // AJAX Post call.
         $.ajax({
            type: 'POST',
            url: url,
            cache: false,
            data: JSONForServer,
            dataType: "json",
            contentType: "application/json; charset=utf-8;",
            success: function (result) {
              $(".create").hide();
              $("#linkUsed").show();
              $("#linkUsed").html("<strong><em><h3>JSON Object sent: </h3></strong></em>" + JSONForServer +
            		  			  "<br><br><hr><strong><em><h3>POST request sent successfully to REST url: </h3></em></strong>" + url + 
            		  			  "<br><br><hr><strong><em><h3>Response from server: </h3></em></strong>" + JSON.stringify(result));
            },
            error: function(xhr,status,error) {
              console.log(error);
            },
            complete:function(){
            	console.log('AJAX POST request successfully completed!')
            }
          });
         }); 
   	  </script>
   </body>
</html>