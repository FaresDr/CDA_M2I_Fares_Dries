package org.example.exo6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exo6.model.Product;
import org.example.exo6.services.ProductService;
import org.example.exo6.util.HibernateSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteProductServlet", value = "/product/delete/*")

public class DeleteServlet extends HttpServlet {

    public ProductService ps;
    public List<Product> productList;
    @Override
    public void init() throws ServletException {
        ps = new ProductService(HibernateSession.getSessionFactory());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getPathInfo().substring(1);
        System.out.println(id);
        int ids = Integer.parseInt(id);

        System.out.println(ids);

        ps.Delete(ids);

        productList = ps.getProduct();
//        req.setAttribute("products",productList);

        resp.sendRedirect("/Exo6_war_exploded/product/list");
//        getServletContext().getRequestDispatcher("/product/list").forward(req,resp);


    }
}
