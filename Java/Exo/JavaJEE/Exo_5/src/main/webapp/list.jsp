<jsp:useBean id="dogs" type="java.util.ArrayList<org.example.exo_5.model.Dogs>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <title>Liste de Chiens</title>
</head>
<body>
<main class="container">
    <div class="row my-3">
        <div class="col-8 offset-2 text-bg-dark rounded p-3">
            <h1 class="fw-light">- Dogs List -</h1>
            <% if (!dogs.isEmpty()){%>
            <hr>
            <table class="table table-dark text-center align-middle">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Nom</th>
                    <th>Race</th>
                    <th>Naissance</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <% for (int i = 0; i < dogs.size();i++) { %>
                <tr>
                    <td><%= dogs.get(i).getId() %></td>
                    <td><%= dogs.get(i).getNom() %></td>
                    <td><%= dogs.get(i).getRace() %></td>
                    <td><%= dogs.get(i).getDateofbirth() %></td>
                    <td><button class="btn btn-outline-secondary">Details</button></td>
                </tr>
                <% } %>

                </tbody>


                <td><a class="text-end btn btn-outline-success" href="add" target="_self">Add a dog</a></td>
                </tfoot>
            </table>
            <% } else { %>
            <p>Vous n'avez aucun Chien !!!!</p>
            <% }  %>
        </div>
    </div>
</main>
</body>
</html>