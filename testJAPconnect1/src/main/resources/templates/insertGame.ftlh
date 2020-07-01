<!DOCTYPE html>
<html>
    <head>
        <title>Games</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
         <!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> 
        <script type="text/javascript" src="js/main.js"></script>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
           <#if add>

            <#assign urlAction>/insertGame</#assign>

            <#assign submitTitle>Create</#assign>

        <#else>

            <#assign urlAction>${'/games/' + game.get().getId() + '/edit'}</#assign>

            <#assign submitTitle>Update</#assign>

        </#if>
    <div class="container">	
        <h2>Add a game</h2>
		<br>
		
	
	    <div id="feedback"></div>
	    <form action="${urlAction}" class="form-horizontal" id="add-form"  method="POST">
		 <div class="form-group">
		  <label for="name">Name:</label>
		  <input type="text" class="form-control" id="name"  value="${(game.get().name)!''}"  >
		</div>
		<div class="form-group">
		  <label for="cost">cost:</label>
		  <input type="text" class="form-control" id="cost" value="${(game.get().cost)!''}">
		</div> 
		<div class="form-group">
		  <label for="catego">category:</label>
		  <input type="text" class="form-control" id="category" value="${(game.get().category)!''}">
		</div> 
		
		<a href="/" type="button" class="btn btn-primary">Back</a>
		<button type="submit" id"addgame" class="btn btn-primary">Add</button>
		
		</form>
	</div>
		
 		
    </body>
</html>