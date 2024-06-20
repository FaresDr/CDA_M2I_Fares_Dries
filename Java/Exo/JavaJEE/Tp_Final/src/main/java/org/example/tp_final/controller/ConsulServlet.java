package org.example.tp_final.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.tp_final.model.Consul;
import org.example.tp_final.services.ConsulService;
import org.example.tp_final.util.HibernateSession;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "consul", value = "/consul/add")
public class ConsulServlet extends HttpServlet {


    private ConsulService cs;
    private List<Consul> allconsul;

    private List<Consul> consulsId;
    int patientId = 0;
    @Override
    public void init() throws ServletException {

        cs = new ConsulService(HibernateSession.getSessionFactory());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();


        boolean logged = (session.getAttribute("isLogged") != null) ? (boolean) session.getAttribute("isLogged"): false ;

        if(logged) {

            patientId = Integer.parseInt(req.getParameter("id"));
            if (patientId != 0) {
                req.getRequestDispatcher("/addConsul.jsp").forward(req, resp);
            }
        }else {
            resp.sendRedirect("http://localhost:8080/Tp_Final_war_exploded/doctor/signupform");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String resume  = req.getParameter("resume");

        cs.createConsul(resume,patientId);
        resp.sendRedirect("/Tp_Final_war_exploded/patient/list");







    }
}
