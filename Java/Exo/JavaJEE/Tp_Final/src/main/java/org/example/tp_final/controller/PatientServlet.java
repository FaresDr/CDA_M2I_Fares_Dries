package org.example.tp_final.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.tp_final.model.Patient;
import org.example.tp_final.services.ConsulService;
import org.example.tp_final.services.PatientService;
import org.example.tp_final.util.HibernateSession;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@MultipartConfig(maxFileSize = 1024*1024*10)

@WebServlet(name = "patientServlet", value = "/patient/*")
public class PatientServlet extends HttpServlet {

    private PatientService ps;
    private ConsulService cs;
    private List<Patient> patientList;


    @Override
    public void init() throws ServletException {
        ps = new PatientService(HibernateSession.getSessionFactory());
        cs = new ConsulService(HibernateSession.getSessionFactory());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();


        boolean logged = (session.getAttribute("isLogged") != null) ? (boolean) session.getAttribute("isLogged"): false ;

        if(logged){
            String action = req.getPathInfo();
            System.out.println(action);
            switch (action){
                case "/addPatient":
                    addPatient(req,resp);
                    break;
                case "/showForm":
                    showForm(req,resp);
                    break;
                case "/list":
                    showList(req,resp);
                    break;
                case "/delete":
                    deletePatient(req,resp);
                    break;
                case "/details":
                    showDetail(req,resp);
                    break;
                default:
                    System.out.println("Erreur");
                    break;
            }
        }else {
            resp.sendRedirect(getServletContext().getContextPath()+"/doctor/signupform");
        }


    }

    private void showDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        int patientId = Integer.parseInt(req.getParameter("id"));
        Patient patient = ps.getPatient(patientId);
        patient.setConsultations(cs.getConsulByParams(patientId));
        req.setAttribute("patient",patient);

        req.getRequestDispatcher("/patientDetails.jsp").forward(req,resp);
    }

    private void deletePatient(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        Patient product = ps.getPatient(id);
        if(product != null){
            ps.Delete(id);
        }
        resp.sendRedirect("/list");
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        HttpSession session = req.getSession();

        boolean logged = (session.getAttribute("isLogged")!= null) ? (boolean) session.getAttribute("isLogged") : false;

        if(logged){
            patientList = ps.getAllPatient();
            req.setAttribute("patient",patientList);


            getServletContext().getRequestDispatcher("/listPatient.jsp").forward(req,resp);
        }else {
            resp.sendRedirect("/Tp_Final_war_exploded/doctor/signup");
        }

    }

    private void showForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        req.getRequestDispatcher("/addPatient.jsp").forward(req,resp);
    }

    private void addPatient(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        String uploadPath = getServletContext().getRealPath("/")+"image";

        // Utilise pour manipuler les répertoires et les fichiers sur le systeme du serveur
        File file = new File(uploadPath);
        if (!file.exists()){
            file.mkdir();
        }

        Part image = req.getPart("image");

        String fileName = image.getSubmittedFileName();

        image.write(uploadPath+File.separator+fileName);
        String name  = req.getParameter("name");
        String prenom = req.getParameter("prenom");
        LocalDate birthdate =LocalDate.parse(req.getParameter("birthdate"));


        resp.sendRedirect("list");

        ps.createPatient(name,prenom,req.getContextPath()+"/image/"+fileName,birthdate);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);

    }
}
