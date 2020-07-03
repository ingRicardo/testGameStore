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
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <h2>List of games</h2>

        <table class="table table-striped" >
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Cost</th>
                <th>Category</th>
            </tr>

            <#list games as game>
                <tr>
                    <td>${game.id}</td>
                    <td>${game.name}</td>
                    <td>${game.cost}</td>
                    <td>${game.category}</td>
                </tr>
            </#list>
        </table>
        <br>
		<a href="/" type="button" class="btn btn-primary">Back</a>
		 
    </body>
</html>