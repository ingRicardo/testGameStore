<!DOCTYPE html>
<html>
    <head>
        <title>Cities</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <h2>List of games</h2>

        <table>
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
    </body>
</html>