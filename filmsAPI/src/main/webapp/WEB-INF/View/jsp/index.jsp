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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" />
    
    <!-- CSS STYLES -->
    <style>
        button, a{
        	height: 40px; 
        	line-height: 20px; 
        	text-align: center;
        	margin: 10px;
        	width: 180px;
        }
    </style>
</head>
<body>

    <!-- MAIN Container -->
    <div class="container">
        <div class="row">
        	<div class="col-md-1"></div>
	        <div class="col-md-2">
	       		<a href="http://films-env.awferji7yy.us-east-2.elasticbeanstalk.com/" class="cloudLink btn btn-primary">Amazon AWS</a>
	            <a href="https://filmsapi.appspot.com/" class="cloudLink btn btn-primary">Google Cloud</a>
			</div>
            <div class="col-md-8 text-center">
                <h3>Ajax XML, JSON and TEXT/CSV data retrieval from Google Cloud and Amazon AWS</h3><br>
            </div>
        </div>
        <hr>
		<div class="row text-center">

            <!-- Homepage Links to different AJAX requests -->
            <div class="col-md-3">
				<a href="https://filmsapi.appspot.com/listfilms?datatype=xml" class="btn btn-success">XML</a>
			</div>
			<div class="col-md-3">
                <button type="button" class="btn btn-success" onclick="getData('text')">TEXT</button>
                <button type="button" class="btn btn-success" onclick="getData('csv')">CSV</button>
            </div>
            <div class="col-md-3">
            	<button type="button" class="btn btn-success" onclick="getData('json')">JSON RAW</button>
				<button type="button" class="btn btn-success" onclick="getData('formattedJSON')">JSON FORMATTED</button>
			</div>
		   <div class="col-md-3">
           		<a href="CRUD"><button class="btn btn-primary"><em><strong>CRUD</strong></em></button></a>
           </div>
        </div>        
        
        <!-- Loading Animation widget -->
        <div class="row" id="loading" style="display:none;">
            <div class="col text-center">
                <img src="https://i.redd.it/ounq1mw5kdxy.gif" height=500px alt="Loading..." />
            </div>
        </div>
        
        <!-- DIV to hold retrieved data from AJAX request -->
        <div class="row">
            <div class="col">
                <pre id="dataDisplayArea" style="margin: 30px; padding: 10px; display: none; height: 550px;"></pre>
            </div>
		</div>
    </div>
    
    <!-- JQUERY -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        
        // AJAX using dynamically generated URL to carry out requests to different URLs
        function getData(dataType){
            $("#dataDisplayArea").hide();
            $("#loading").show();
            setTimeout(() => { $("#loading").hide(); }, 3500);
            if (dataType === 'formattedJSON'){
            	$.ajax({
                    url: "https://filmsapi.appspot.com/listfilms?datatype=json",
                    success: handler,
                    dataType: "json",
                    cache: false
                });
            	function handler(data) {
                    $("#dataDisplayArea").html(JSON.stringify(data, null, 7));
                }
            } else {
            	$("#dataDisplayArea").load("https://filmsapi.appspot.com/listfilms/?datatype=" + dataType);
            	console.log("https://filmsapi.appspot.com/listfilms/?datatype=" + dataType);
            }
            setTimeout(() => { $("#dataDisplayArea").show(); }, 3500);
		}
    </script>
</body>
</html>