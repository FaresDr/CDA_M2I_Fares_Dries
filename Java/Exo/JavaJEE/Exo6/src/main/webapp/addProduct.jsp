<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</head>
<body>

<div class="col-8 offset-2 rounded text-bg-dark p-3">
    <h1 class="fw-light">- Add Product -</h1>
    <hr>
    <form method="post" action="${pageContext.request.contextPath}/product/add" enctype="multipart/form-data">
        <div class="mb-3">
            <label for="nom" class="form-label">Nom Du produit :</label>
            <input type="text" class="form-control" name="nom" id="nom" required>
        </div>
        <div class="mb-3">
            <label for="marque" class="form-label">Marque:</label>
            <input type="text" class="form-control" name="marque" id="marque" required>
        </div>
        <div class="mb-3">
            <label for="reference" class="form-label">Reference :</label>
            <input type="text" class="form-control" name="reference" id="reference" required>
        </div>
        <div class="mb-3">
            <label for="dateAchat" class="form-label">Date d'achat :</label>
            <input type="date" class="form-control" name="dateAchat" id="dateAchat" required>
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Prix :</label>
            <input type="text" class="form-control" name="price" id="price" required>
        </div>
        <div class="mb-3">
            <label for="stock" class="form-label">Stock :</label>
            <input type="number" class="form-control" name="stock" id="stock" required>
        </div>
        <div class="mb-3">
            <label for="image" class="form-label">Image :</label>
            <input type="file" class="form-control" name="image" id="image" required>
        </div>

        <button class="text-end btn btn-outline-success">Ajouter Produit</button>
    </form>
    <tr><a href="/Exo6_war_exploded/product/list"><button class="btn btn-outline-secondary">Page de liste de produit</button></a></tr>
</div>



</body>
</html>