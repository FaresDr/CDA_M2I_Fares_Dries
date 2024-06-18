package org.example.exo_7.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.example.exo_7.service.ImageService;
import org.example.exo_7.util.HibernateSession;

import java.io.File;
import java.io.IOException;



    @WebServlet(name = "upload",value = "/upload")
    @MultipartConfig(maxFileSize = 1024*1024*10)
    public class ImageServlet extends HttpServlet {

        ImageService im;

        @Override
        public void init() throws ServletException {
            im = new ImageService(HibernateSession.getSessionFactory());
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getRequestDispatcher("form-upload.jsp").forward(req,resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String uploadPath = getServletContext().getRealPath("/")+"image";

            // Utilise pour manipuler les répertoires et les fichiers sur le systeme du serveur
            File file = new File(uploadPath);
            if (!file.exists()){
                file.mkdir();
            }

            Part image = req.getPart("image");

            String fileName = image.getSubmittedFileName();

            image.write(uploadPath+File.separator+fileName);


            im.createImage(req.getContextPath()+"/image/"+fileName);
            resp.sendRedirect("galerie");

        }
    }

