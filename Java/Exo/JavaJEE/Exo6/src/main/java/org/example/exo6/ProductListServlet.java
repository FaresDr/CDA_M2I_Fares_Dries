package org.example.exo6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.exo6.model.Product;
import org.example.exo6.services.ProductService;
import org.example.exo6.util.HibernateSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListProductServlet", value = "/product/list")

public class ProductListServlet extends HttpServlet {
    ProductService ps;

    List<Product> productList;

    @Override
    public void init() throws ServletException {
        ps = new ProductService(HibernateSession.getSessionFactory());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        boolean logged = (session.getAttribute("isLogged")!= null) ? (boolean) session.getAttribute("isLogged") : false;

        if(logged){
            productList = ps.getProduct();
            req.setAttribute("products",productList);


            getServletContext().getRequestDispatcher("/listProduct.jsp").forward(req,resp);
        }else {
            resp.sendRedirect("/Exo6_war_exploded/users/login");
        }
    }
}
