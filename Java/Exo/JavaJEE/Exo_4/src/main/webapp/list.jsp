<jsp:useBean id="cats" type="java.util.ArrayList<org.example.exo_4.model.Cat>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <title>Liste de Chats</title>
</head>
<body>
<main class="container">
    <div class="row my-3">
        <div class="col-8 offset-2 text-bg-dark rounded p-3">
            <h1 class="fw-light">- Liste de Chats -</h1>
            <hr>
            <table class="table table-dark text-center align-middle">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Nom</th>
                    <th>Race</th>
                    <th>Plat préféré</th>
                    <th>Naissance</th>
                </tr>
                </thead>
                <tbody>
                <% for (int i = 0; i < cats.size();i++) { %>
                <tr>
                    <td><%= i+1 %></td>
                    <td><%= cats.get(i).getNom() %></td>
                    <td><%= cats.get(i).getRace() %></td>
                    <td><%= cats.get(i).getPlat() %></td>
                    <td><%= cats.get(i).getNaissance() %></td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>
</main>
</body>
</html>