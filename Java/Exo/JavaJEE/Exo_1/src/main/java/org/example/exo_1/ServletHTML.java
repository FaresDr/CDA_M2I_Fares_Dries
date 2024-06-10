package org.example.exo_1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "monServletHTML",value = "/monServletHTML")
public class ServletHTML extends HttpServlet {

    private String prenom;
    private String nom;

    @Override
    public void init() throws ServletException {
        prenom = "Fares";
        nom = "Dries";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();
        writer.println("<h1>Je suis  : "+nom+ " " + prenom+"</h1>");
    }
}
