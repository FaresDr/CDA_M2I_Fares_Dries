package org.example.exo_5;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exo_5.model.Dogs;
import org.example.exo_5.repository.DogsService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListServlet", value = "/dogs/list")

public class ListServlet extends HttpServlet {

    public DogsService ds;
    public List<Dogs> dogsList;

    @Override
    public void init() throws ServletException {
        ds = new DogsService();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dogsList = ds.findAll();
        req.setAttribute("dogs",dogsList);


        getServletContext().getRequestDispatcher("/list.jsp").forward(req,resp);
    }


}
