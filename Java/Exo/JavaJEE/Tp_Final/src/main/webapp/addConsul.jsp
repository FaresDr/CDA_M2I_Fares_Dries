<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add consultation</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</head>
<body>

<div class="col-8 offset-2 rounded text-bg-dark p-3">
    <h1 class="fw-light">- Add consultation -</h1>
    <hr>
    <form method="post" action="${pageContext.request.contextPath}/consul/add">
        <div class="mb-3">
            <label for="resume" class="form-label">Resume :</label>
            <input type="text" class="form-control" name="resume" id="resume" required>
        </div>


        <button class="text-end btn btn-outline-success">Ajouter</button>
    </form>

</div>



</body>
</html>