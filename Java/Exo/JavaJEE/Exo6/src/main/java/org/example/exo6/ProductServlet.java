package org.example.exo6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.exo6.model.Product;
import org.example.exo6.services.ProductService;
import org.example.exo6.util.HibernateSession;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
@MultipartConfig(maxFileSize = 1024*1024*10)
@WebServlet(name = "AddProductServlet", value = "/product/add")

public class ProductServlet extends HttpServlet {

    ProductService ps;

    @Override
    public void init() throws ServletException {
        ps = new ProductService(HibernateSession.getSessionFactory());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        boolean logged = (session.getAttribute("isLogged")!= null) ? (boolean) session.getAttribute("isLogged") : false;

        if(logged){
            getServletContext().getRequestDispatcher("/addProduct.jsp").forward(req,resp);
        }else {
            resp.sendRedirect("/Exo6_war_exploded/users/login");
        }
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
        String productName = req.getParameter("nom");
        String marque = req.getParameter("marque");
        String reference = req.getParameter("reference");
        LocalDate dateAchat =LocalDate.parse(req.getParameter("dateAchat"));
        double price = Double.parseDouble(req.getParameter("price"));
        int stock = Integer.parseInt(req.getParameter("stock"));

        resp.sendRedirect("list");


        ps.createProduct(productName,marque,reference,dateAchat,price,stock,req.getContextPath()+"/image/"+fileName);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
