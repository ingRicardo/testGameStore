<!DOCTYPE HTML>

<html>
    <head>
        <meta charset="UTF-8" />
        <title>View Game</title>
        <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    </head>

    <body>
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

    </body>

</html>