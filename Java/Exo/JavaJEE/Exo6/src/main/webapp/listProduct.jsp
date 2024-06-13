<jsp:useBean id="products" type="java.util.ArrayList<org.example.exo6.model.Product>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <title>Liste de Produits</title>
</head>
<body>
<main class="container">
    <div class="row my-3">
        <div class="col-8 offset-2 text-bg-dark rounded p-3">
            <h1 class="fw-light">- Product List -</h1>
            <% if (!products.isEmpty()){%>
            <hr>
            <table class="table table-dark text-center align-middle">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Nom</th>
                    <th>Marque</th>
                    <th>Reference</th>
                    <th>DateAchat</th>
                    <th>Prix</th>
                    <th>stock</th>
                </tr>
                </thead>
                <tbody>
                <% for (int i = 0; i < products.size();i++) { %>
                <tr>
                    <td><%= products.get(i).getId() %></td>
                    <td><%= products.get(i).getNom() %></td>
                    <td><%= products.get(i).getMarque() %></td>
                    <td><%= products.get(i).getReference() %></td>
                    <td><%= products.get(i).getDateAchat() %></td>
                    <td><%= products.get(i).getPrice() %></td>
                    <td><%= products.get(i).getStock() %></td>


                </tr>
                <% } %>
                <td><a href="/Exo6_war_exploded/product/add"><button class="btn btn-outline-secondary">Retour à la page d'ajout</button></a></td>
                </tbody>



                </tfoot>
            </table>
            <% } else { %>
            <p>Aucun Produit dans la liste</p>
            <% }  %>
        </div>
    </div>
</main>
</body>
</html>