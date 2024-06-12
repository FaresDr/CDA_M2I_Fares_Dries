package org.example.exo_4.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exo_4.model.Cat;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CatServlet", value = "/cat/list")
public class CatServlet extends HttpServlet {
    private List<Cat> catList;

    @Override
    public void init() throws ServletException {
        catList = new ArrayList<>();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/catForm.jsp").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String breed = req.getParameter("breed");
        String meal = req.getParameter("meal");
        LocalDate date = LocalDate.parse(req.getParameter("birthdate"));
        Cat c = new Cat(name,breed,date,meal);
        catList.add(c);
        for (Cat chat : catList){
            System.out.println(chat.toString());
        }
        System.out.println("--------------------------");
        req.setAttribute("cats",catList);

        getServletContext().getRequestDispatcher("/list.jsp").forward(req,resp);



    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
