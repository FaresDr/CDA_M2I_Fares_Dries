<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 11/06/2024
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/Exo_4_war_exploded/cat/list">
    <div>
        <label for="name">  Name :</label>
        <input type="text" name="name" id="name">
    </div>
    <div>
        <label for="breed">  Breed :</label>
        <input type="text" name="breed" id="breed">
    </div>
    <div>
        <label for="meal">  Meal :</label>
        <input type="text" name="meal" id="meal">
    </div>
    <div>
        <label for="birthdate">  Age :</label>
        <input type="date"  name="birthdate" id="birthdate">
    </div>
    <button>Ajouter</button>


</form>
</body>
</html>
