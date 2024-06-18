<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 18/06/2024
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="images" type="java.util.ArrayList<org.example.exo_7.model.Image>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <title>Liste de Produits</title>
</head>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <% if (!images.isEmpty()) {%>
    <div>
    <div class="container">
        <div class="row row-cols-4">


    <% for (int i = 0; i < images.size();i++) { %>



                <div class="col my-4">
                    <div class="card" style="width: 18rem;">
                        <img class="card-img-top" src="<%= images.get(i).getUrl() %>" alt="Card image cap" width="250" height="250">
                        <div class="card-body">
                            <h5 class="card-title">Id de l'image : <%= images.get(i).getId() %></h5>

                            <a href="#" class="btn btn-danger">Delete</a>
                        </div>
                    </div>
                </div>










    <% } %>

        </div>

    </div>
    </div>




    <% } else { %>
    <p>Aucune Image dans la liste</p>

    <%}%>
</head>
<body>

</body>
</html>