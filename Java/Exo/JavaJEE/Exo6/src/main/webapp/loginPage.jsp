<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log In</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</head>
<body>

<div class="col-8 offset-2 rounded text-bg-dark p-3">
    <h1 class="fw-light">- Log In -</h1>
    <hr>
    <form method="post" action="${pageContext.request.contextPath}/users/login">
        <div class="mb-3">
            <label for="username" class="form-label">Nom D'utilisateur :</label>
            <input type="text" class="form-control" name="username" id="username" required>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Mot de passe :</label>
            <input type="password" class="form-control" name="password" id="password" required>
        </div>
        <div class="mb-3">
            <label for="mail" class="form-label">Email :</label>
            <input type="email" class="form-control" name="mail" id="mail" required>
        </div>

        <button class="text-end btn btn-outline-success">Connexion</button>
    </form>
    <a href="/Exo6_war_exploded/users/signup"><button class="btn btn-outline-secondary">Inscription</button></a>
</div>



</body>
</html>