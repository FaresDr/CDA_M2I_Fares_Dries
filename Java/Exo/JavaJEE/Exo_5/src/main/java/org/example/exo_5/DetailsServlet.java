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

@WebServlet(name = "DetailsServlet", value = "/dogs/details/*")

public class DetailsServlet extends HttpServlet {

    public DogsService ds;
    @Override
    public void init() throws ServletException {
        ds = new DogsService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getPathInfo().substring(1);
        System.out.println(id);
        int ids = Integer.parseInt(id);
        Dogs dog = ds.findById(ids);
        System.out.println(dog.toString());
        req.setAttribute("Dogs",dog);


        getServletContext().getRequestDispatcher("/dogDetails.jsp").forward(req,resp);
    }



    @Override
    public void destroy() {
        super.destroy();
    }
}
