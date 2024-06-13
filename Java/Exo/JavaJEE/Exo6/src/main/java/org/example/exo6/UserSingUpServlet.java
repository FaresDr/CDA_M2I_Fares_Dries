package org.example.exo6;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exo6.model.Users;
import org.example.exo6.services.UserService;
import org.example.exo6.util.HibernateSession;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "SignUpServlet", value = "/users/signup")

public class UserSingUpServlet extends HttpServlet {

    private UserService us;

    @Override
    public void init() throws ServletException {
        us = new UserService(HibernateSession.getSessionFactory());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/formPage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String mail = req.getParameter("mail");
      Users user = us.getUserByParams(username,password,mail);
        if(user==null) {
            us.createUser(username, password, mail);
        }else{
            System.out.println("User déja existant");
        }
        resp.sendRedirect("login");
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
