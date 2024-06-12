package org.example.exo_5;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exo_5.repository.DogsService;

import java.io.IOException;

@WebServlet(name = "ListServlet", value = "/dogs/list")

public class ListServlet extends HttpServlet {

    public DogsService ds;

    @Override
    public void init() throws ServletException {
        ds = new DogsService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("dogs",ds.findAll());


        getServletContext().getRequestDispatcher("/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/add");
    }
}
