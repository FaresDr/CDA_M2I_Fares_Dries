package org.example.exo_7.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exo_7.model.Image;
import org.example.exo_7.service.ImageService;
import org.example.exo_7.util.HibernateSession;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "Galery", value = "/galerie")
public class GaleryServlet extends HttpServlet {

    List<Image> imageList;
    ImageService is;

    @Override
    public void init() throws ServletException {
        is = new ImageService(HibernateSession.getSessionFactory());
        imageList = is.getImages();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        imageList = is.getImages();
        req.setAttribute("images",imageList);


        getServletContext().getRequestDispatcher("/galery.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
