<!DOCTYPE HTML>

<html>

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> 
        <title>Game List</title>
        <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    </head>
    <body>
		<div class="container">
        <h1>Game List</h1>
        <div>
            <nobr>
                <a href="/gamesTu/add">Add Game</a> |
                <a href="/indexTu">Back to Index</a>
            </nobr>
        </div>
        <br/><br/>
        <div>
            <table border="1">
                <tr>
                    <th>Id</th>
                    <th>Game</th>
                    <th>Cost</th>
                    <th>Category</th>
                    <th>Edit</th>                    
                </tr>
                <#list gamesTu as game>
                    <tr>
                        <td><a href="${'gamesTu/' + game.id}">${game.id}</a></td>
                        <td><a href="${'gamesTu/' + game.id}">${game.name}</a></td>
                        <td>${game.cost}</td>
                        <td>${(game.category)}</td>
                        <td><a href="${'gamesTu/' + game.id + '/edit'}">Edit</a></td>
                    </tr>
                </#list>
            </table>          
        </div>
        <br/><br/>
	</div>
    </body>
</html>