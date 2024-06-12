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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DogServlet", value = "/dogs/add")

public class DogsServlet extends HttpServlet {



    public DogsService ds;





    @Override
    public void init() throws ServletException {
        ds = new DogsService();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String breed = req.getParameter("breed");
        LocalDate date = LocalDate.parse(req.getParameter("birthdate"));
        Dogs d = Dogs.builder().nom(name).race(breed).dateofbirth(date).build();
        ds.create(d);
        resp.sendRedirect("list");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/addDog.jsp").forward(req,resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
