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

		<!-- MAIN CONTAINER -->
      <div class="container">
         <div class="row">
            <div class="col text-center">
               <a href="https://filmsRESTful.appspot.com/CRUD"><button class="btn btn-success">Back</button></a>
            </div>
         </div>
			<hr>
			
			<!-- Read/Search film and return data in different formats -->
         <div class="row read">
            <div class="col">
               <h3><em><strong>READ FILM &nbsp;&nbsp;&nbsp; (HTTP GET request)</strong></em></h3><br><div class="col-md-12 text-right">
               
                     Search by ID (MUST BE A NUMBER) 		<input type="number" name="id" id="id" />
																			<button class="button-s btn btn-primary" onclick="readFilmById('json', 'id')">JSON</button>
																			<button class="button-s btn btn-primary" onclick="readFilmById('xml', 'id')">XML</button>
																			<button class="button-s btn btn-primary" onclick="readFilmById('csv', 'id')">CSV</button><br><br>
                     										
								Search by Title 						<input type="text" name="title" id="title" />
																			<button class="button-s btn btn-primary" onclick="readFilmByTitle('json', 'title')">JSON</button>
																			<button class="button-s btn btn-primary" onclick="readFilmByTitle('xml', 'title')">XML</button>
																			<button class="button-s btn btn-primary" onclick="readFilmByTitle('csv', 'title')">CSV</button><br><br>
                     								
						Search by Year (MUST BE A NUMBER)		<input type="number" name="year" id="year" />
																			<button class="button-s btn btn-primary" onclick="readFilmByYear('json', 'year')">JSON</button>
																			<button class="button-s btn btn-primary" onclick="readFilmByYear('xml', 'year')">XML</button>
																			<button class="button-s btn btn-primary" onclick="readFilmByYear('csv', 'year')">CSV</button><br><br>
                     											
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
		
			// AJAX for Searcy by ID. GET Request.
         function readFilmById(a, b){
        	 $(".read").hide();
        	 $("#loading").show();
        	 var userInput = $("#id").val();
        	 var url = "https://filmsRESTful.appspot.com/" + a + "/searchfilm/" + b + "/" + userInput;
        	 var results;
        	 $.ajax({
                 type: 'GET',
                 url: url,
                 cache: false,
                 success: function (result) {
               	    results = result;
	               	$(".read").hide();
                 },
                 error: function(xhr,status,error) {
                   console.log(error);
                 },
                 complete:function(){
                 	console.log('AJAX request success!')
                 	$("#loading").hide();
                 	if (a == "json"){
                 		var jsonParsed = JSON.parse(results);
                 		$("#messageDisplayArea").html(
                 				"<strong><em><h3>GET request sent successfully to REST url: </h3></strong></em>" + 
                 				url + "<br><br><br>" + JSON.stringify(jsonParsed, null,7));
                 	} else {
                 		$("#messageDisplayArea").html(
                 				"<strong><em><h3>GET request sent successfully to REST url: </h3></strong></em>" + 
                 				url + "<br><br><br>" + results);
                 	}
	                $("#messageDisplayArea").show();
                 }
               });
         }
         
			// AJAX for Searcy by Title. GET Request.
         function readFilmByTitle(a, b){
        	 $(".read").hide();
        	 $("#loading").show();
        	 var userInput = $("#title").val();
        	 var url = "https://filmsRESTful.appspot.com/" + a + "/searchfilm/" + b + "/" + userInput;
        	 var results;
        	 $.ajax({
                 type: 'GET',
                 url: url,
                 cache: false,
                 success: function (result) {
                   results = result;
                 },
                 error: function(xhr,status,error) {
                   console.log(error);
                 },
                 complete:function(){
                 	console.log('AJAX request success!')
                 	$("#loading").hide();
                 	if (a == "json"){
                 		var jsonParsed = JSON.parse(results);
                 		$("#messageDisplayArea").html(
                 				"<strong><em><h3>GET request sent successfully to REST url: </h3></strong></em>" + 
                 				url + "<br><br><br>" + JSON.stringify(jsonParsed, null,7));
                 	} else {
                 		$("#messageDisplayArea").html(
                 				"<strong><em><h3>GET request sent successfully to REST url: </h3></strong></em>" + 
                 				url + "<br><br><br>" + results);
                 	}
                  	$("#messageDisplayArea").show();
                 }
               });
         }
         
			// AJAX for Searcy by Year. GET Request.
         function readFilmByYear(a, b){
        	 $(".read").hide();
        	 $("#loading").show();
        	 var userInput = $("#year").val();
        	 var url = "https://filmsRESTful.appspot.com/" + a + "/searchfilm/" + b + "/" + userInput;
        	 var results;
        	 $.ajax({
                 type: 'GET',
                 url: url,
                 cache: false,
                 success: function (result) {
                   results = result;
                   console.log(result);
                 },
                 error: function(xhr,status,error) {
                   console.log(error);
                 },
                 complete:function(){
                 	console.log('AJAX request success!')
                 	$("#loading").hide();
                 	if (a == "json"){
                 		var jsonParsed = JSON.parse(results);
                 		$("#messageDisplayArea").html(
                 				"<strong><em><h3>GET request sent successfully to REST url: </h3></em></strong>" + 
                 				url + "<br><br><br>" + JSON.stringify(jsonParsed, null,7));
                 	} else {
                 		$("#messageDisplayArea").html(
                 				"<strong><em><h3>GET request sent successfully to REST url: </h3></em></strong>" + 
                 				url + "<br><br><br>" + results);
                 	}
                  	$("#messageDisplayArea").show();
                 }
               });
         }
   	  </script>
   </body>
</html>