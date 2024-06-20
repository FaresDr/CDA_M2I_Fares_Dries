<%@ page import="org.example.tp_final.services.PatientService" %>
<%@ page import="org.example.tp_final.util.HibernateSession" %>
<jsp:useBean id="patient" type="java.util.ArrayList<org.example.tp_final.model.Patient>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <title>Liste de Patients</title>
</head>
<body>
<main class="container">
    <div class="row my-3">
        <div class="col-8 offset-2 text-bg-dark rounded p-3">
            <h1 class="fw-light">- Patient List -</h1>
            <% PatientService ps = new PatientService(HibernateSession.getSessionFactory());%>
            <% if (!patient.isEmpty()){%>
            <hr>
            <table class="table table-dark text-center align-middle">
                <thead>
                <tr>
                    <th>Image</th>
                    <th>#</th>
                    <th>Nom</th>
                    <th>Prenom</th>

                    <th>Date de Naissance</th>

                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <% for (int i = 0; i < patient.size();i++) { %>
                <tr>
                    <td> <img src="<%= patient.get(i).getUrl() %>" alt="Card image cap" width="250" height="250"></td>
                    <td><%= patient.get(i).getId() %></td>
                    <td><%= patient.get(i).getNom() %></td>
                    <td><%= patient.get(i).getPrenom() %></td>
                    <td><%= patient.get(i).getDate_de_naissance() %></td>
                    <td><a href="delete?id=<%= patient.get(i).getId() %>"><button class="btn btn-outline-danger" >Delete</button></a></td>
                    <td><a href="details?id=<%= patient.get(i).getId() %>"><button class="btn btn-outline-secondary" >Details</button></a></td>


                </tr>
                <% } %>
                <td><a href="${pageContext.request.contextPath}/patient/showForm"><button class="btn btn-outline-secondary">Retour à la page d'ajout</button></a></td>
                </tbody>



                </tfoot>
            </table>
            <% } else { %>
            <p>Aucun Patient dans la liste</p>
            <td><a href="/Exo6_war_exploded/product/add"><button class="btn btn-outline-secondary">Retour à la page d'ajout</button></a></td>
            <% }  %>
        </div>
    </div>
</main>
</body>
</html>