
<%@ page import="org.example.tp_final.util.HibernateSession" %>
<jsp:useBean id="patient" type="org.example.tp_final.model.Patient" scope="request" />
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


            <hr>
            <table class="table table-dark text-center align-middle">
                <thead>
                <tr>
                    <th>Image</th>
                    <th>#</th>
                    <th>Nom</th>
                    <th>Prenom</th>
                    <th>Date de consultation</th>


                    <th>Action</th>
                </tr>
                </thead>
                <tbody>

                <tr>
                    <td> <img src="<%= patient.getUrl() %>" alt="Card image cap" width="250" height="250"></td>
                    <td><%= patient.getId() %></td>
                    <td><%= patient.getNom() %></td>
                    <td><%= patient.getPrenom() %></td>
                    <td><%= patient.getDate_de_naissance() %></td>



                </tr>
                <tr>

                    <th>Id de consultations</th>
                    <th>-</th>
                    <th>Resume</th>
                    <th>-</th>
                    <th>Date de consultation</th>




                </tr>
                <% for (int i = 0; i < patient.getConsultations().size();i++) { %>
                <tr>

                    <td><%= patient.getConsultations().get(i).getId() %></td>
                    <td>-</td>
                    <td><%= patient.getConsultations().get(i).getResume() %></td>
                    <td>-</td>
                    <td><%= patient.getConsultations().get(i).getDateDeCreation() %></td>




                </tr>
                <% } %>
                <td><a href="${pageContext.request.contextPath}/patient/list"><button class="btn btn-outline-secondary">Retour à la liste</button></a></td>
                <td><a href="${pageContext.request.contextPath}/consul/add?id=<%= patient.getId() %>"><button class="btn btn-outline-secondary" >Ajouter Une consultation</button></a></td>

                </tbody>



                </tfoot>
            </table>




        </div>
    </div>
</main>
</body>
</html>