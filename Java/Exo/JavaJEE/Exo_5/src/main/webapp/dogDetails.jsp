<jsp:useBean id="Dogs" class="org.example.exo_5.model.Dogs" scope="request"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details Chien</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</head>
<body>

<div class="col-8 offset-2 rounded text-bg-dark p-3">
    <h1 class="fw-light">- View Dog -</h1>
    <hr>
    <form method="post" action="${pageContext.request.contextPath}/dogs/list">
        <div class="mb-3">
            <label for="name" class="form-label">Nom :</label>
            <input type="text" class="form-control" name="name" id="name" readonly value="<%= Dogs.getNom()%>">
        </div>
        <div class="mb-3">
            <label for="breed" class="form-label">Race :</label>
            <input type="text" class="form-control" name="breed" id="breed" readonly value="<%= Dogs.getRace()%>">
        </div>
        <div class="mb-3">
            <label for="birthdate" class="form-label">Date de naissance :</label>
            <input type="date" class="form-control" name="birthdate" id="birthdate" readonly value="<%= Dogs.getDateofbirth()%>">
        </div>



    </form>
    <a href="/Exo_5_war_exploded/dogs/list"><button class=" btn btn-outline-secondary">Return</button></a>
</div>



</body>
</html>