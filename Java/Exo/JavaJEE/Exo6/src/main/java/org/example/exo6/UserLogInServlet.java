package org.example.exo6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.exo6.model.Users;
import org.example.exo6.services.UserService;
import org.example.exo6.util.HibernateSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "LogInServlet", value = "/users/login")
public class UserLogInServlet extends HttpServlet {

    UserService us;

    List<Users> usersList;

    @Override
    public void init() throws ServletException {
        us = new UserService(HibernateSession.getSessionFactory());
        usersList = us.getUsers();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/loginPage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean f = false;
        Users userToLog = us.getUserByParams(req.getParameter("username"),req.getParameter("password"),req.getParameter("mail"));


        if(userToLog!=null){
            f = true;
            HttpSession session = req.getSession();
            session.setAttribute("isLogged",true);
        }

        System.out.println(f);

        if(f){
            System.out.println("User connecté");
            resp.sendRedirect("/Exo6_war_exploded/product/add");
        }else{
            getServletContext().getRequestDispatcher("/loginPage.jsp").forward(req,resp);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
