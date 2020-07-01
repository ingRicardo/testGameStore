<!DOCTYPE HTML>

<html>

    <head>

        <meta charset="UTF-8" />

        <title><#if add>Create a Note<#else>Edit a Game</#if></title>

        <link rel="stylesheet" type="text/css" href="/css/style.css"/>

    </head>

    <body>

        <h1><#if add>Create a Note:<#else>Edit a Game:</#if></h1>

        <a href="/gamesTu">Back to Game List</a>

        <br/><br/>

        <#if add>

            <#assign urlAction>/gamesTu/add</#assign>

            <#assign submitTitle>Create</#assign>

        <#else>

            <#assign urlAction>${'/gamesTu/' + gameTu.get().id + '/edit'}</#assign>

            <#assign submitTitle>Update</#assign>

        </#if>

        <form action="${urlAction}" name="gameTu" method="POST">

            <table border="0">

                <#if gameTu.get().id??>

                <tr>

                    <td>ID</td>

                    <td>:</td>

                    <td>${gameTu.get().id}</td>             

                </tr>

                </#if>

                <tr>

                    <td>Name</td>

                    <td>:</td>

                    <td><input type="text" name="name" value="${(gameTu.get().name)!''}" /></td>              

                </tr>

                <tr>

                    <td>Cost</td>

                    <td>:</td>

                    <td><input type="text" name="cost" value="${(gameTu.get().cost)!''}" /></td>

                </tr>

                  <tr>

                    <td>Category</td>

                    <td>:</td>

                    <td><input type="text" name="category" value="${(gameTu.get().category)!''}" /></td>

                </tr>

            </table>

            <input type="submit" value="${submitTitle}" />

        </form>

 

        <br/>

        <!-- Check if errorMessage is not null and not empty -->       

        <#if errorMessage?has_content>

            <div class="error">${errorMessage}</div>

        </#if>       

    </body>

</html>