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
        <title>View Game</title>
        <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    </head>
    <body>
    	<div class ="container">
        <h1>View Game</h1>
        <a href="/gamesTu">Back to Game List</a>
        <br/><br/>
        <#if gameTu??>
            <table border="0">
                <tr>
                    <td>ID</td>
                    <td>:</td>
                    <td>${gameTu.get().id}</td>          
                </tr>
                <tr>
                    <td>Name</td>
                    <td>:</td>
                    <td>${gameTu.get().name}</td>             
                </tr>
                <tr>
                    <td>Cost</td>
                    <td>:</td>
                    <td>${gameTu.get().cost}</td>              

                </tr>
                <tr>
                    <td>Category</td>
                    <td>:</td>
                    <td>${(gameTu.get().category)}</td>              
                </tr>
            </table>
            <br/><br/>
            <#if allowDelete>
                <form action="${'/gamesTu/' + gameTu.get().id + '/delete'}" method="POST">
                    Delete this game? <input type="submit" value="Yes" />
                </form>
            <#else>
                <div>
                    <a href="${'/gamesTu/' + gameTu.get().id + '/edit'}">Edit</a> |
                    <a href="${'/gamesTu/' + gameTu.get().id + '/delete'}">Delete</a>
                </div>
            </#if>
        </#if>
        <#if errorMessage?has_content>
            <div class="error">${errorMessage}</div>
        </#if>
	</div>
    </body>
</html>