package org.example.exo_1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "monServletBrut",value = "/monServletBrut")
public class ServletBrut extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("monServlet est lancé !!!!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Un requete GET a ete envoyée à /monServlet");

        resp.setContentType("text/plain");

        PrintWriter writer = resp.getWriter();

        writer.println("Texte brut pour vous servir");
    }

    @Override
    public void destroy() {
        System.out.println("monServlet est détruit !!!");
    }
}
