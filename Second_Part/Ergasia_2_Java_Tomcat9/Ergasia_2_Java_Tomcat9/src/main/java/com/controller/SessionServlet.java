package com.controller;

//Apostolis Siampanis P20173, Theodoros Koxanoglou P20094, Aimilianos Kourpas Danas P20100, Aggeliki Kaldiri P20069

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //activates only when a user has successfully log in
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        char ch = username.charAt(0);    //Keep the first char which is the role
        switch(ch) {
        case 'S':	//in this case the user is secretary
        	RequestDispatcher view = request.getRequestDispatcher("/secretaryPages/profile.jsp");
            view.forward(request, response);
            break;
        case 'F':	//in this case the user is student
        	RequestDispatcher view1 = request.getRequestDispatcher("/studentPages/profile.jsp");
            view1.forward(request, response);
            break;
        case 'P':	//in this case the user is professor
        	RequestDispatcher view2 = request.getRequestDispatcher("/professorPages/profile.jsp");
            view2.forward(request, response);
            break;
      }
    }
}
