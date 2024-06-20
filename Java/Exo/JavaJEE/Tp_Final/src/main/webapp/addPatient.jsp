<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add patient</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</head>
<body>

<div class="col-8 offset-2 rounded text-bg-dark p-3">
    <h1 class="fw-light">- Add Patient -</h1>
    <hr>
    <form method="post" action="${pageContext.request.contextPath}/patient/addPatient" enctype="multipart/form-data">
        <div class="mb-3">
            <label for="name" class="form-label">Nom Du Patient :</label>
            <input type="text" class="form-control" name="name" id="name" required>
        </div>
        <div class="mb-3">
            <label for="prenom" class="form-label">Prénom du patient:</label>
            <input type="text" class="form-control" name="prenom" id="prenom" required>
        </div>

        <div class="mb-3">
            <label for="birthdate" class="form-label">Date de naissance :</label>
            <input type="date" class="form-control" name="birthdate" id="birthdate" required>
        </div>
        <div class="mb-3">
            <label for="image" class="form-label">Image :</label>
            <input type="file" class="form-control" name="image" id="image" required>
        </div>

        <button class="text-end btn btn-outline-success">Ajouter Patient</button>
    </form>
    <tr><a href="${pageContext.request.contextPath}/patient/list"><button class="btn btn-outline-secondary">Page de liste de Patient</button></a></tr>
</div>



</body>
</html>