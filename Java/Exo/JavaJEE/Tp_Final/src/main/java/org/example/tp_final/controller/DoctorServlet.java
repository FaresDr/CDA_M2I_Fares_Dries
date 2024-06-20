package org.example.tp_final.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.tp_final.model.Doctor;
import org.example.tp_final.services.DoctorService;
import org.example.tp_final.util.HibernateSession;

import javax.print.Doc;
import java.io.IOException;

@WebServlet(name = "doctorServlet", value = "/doctor/*")
public class DoctorServlet extends HttpServlet {

    private DoctorService ds;

    @Override
    public void init() throws ServletException {
        ds = new DoctorService(HibernateSession.getSessionFactory());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();


        boolean logged = (session.getAttribute("isLogged") != null) ? (boolean) session.getAttribute("isLogged"): false ;

        if(!logged){
            String action = req.getPathInfo();
            System.out.println(action);
            switch (action){
                case "/login":
                    login(req,resp);
                    break;
                case "/loginform":
                    showLogin(req,resp);
                    break;
                case "/signup":
                    signUp(req,resp);
                    break;
                case "/signupform":
                        showSignup(req,resp);
                    break;
                default:
                    System.out.println("Erreur");
                    break;
            }
        }else {
            resp.sendRedirect(getServletContext().getContextPath()+"/patient/list");
        }

    }

    private void showSignup(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        req.getRequestDispatcher("/formPage.jsp").forward(req,resp);
    }

    private void showLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/loginPage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);

    }

    protected void signUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String mail = req.getParameter("mail");
        Doctor user = ds.getUserByParams(username,password,mail);
        if(user==null) {
            ds.createDoctor(username, password, mail);
        }else{
            System.out.println("Docteur déja existant");
        }
        resp.sendRedirect("loginform");
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        boolean f = false;
        Doctor userToLog = ds.getUserByParams(req.getParameter("username"),req.getParameter("password"),req.getParameter("mail"));

        System.out.println(userToLog);
        if(userToLog!=null){
            f = true;
            HttpSession session = req.getSession();
            session.setAttribute("isLogged",true);
        }

        System.out.println(f);

        if(f){
            System.out.println("User connecté");
            resp.sendRedirect("/Tp_Final_war_exploded/patient/showForm");
        }else{
            resp.sendRedirect("loginform");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
