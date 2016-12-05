package com.niit.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID=request.getParameter("USER_ID");
		String password=request.getParameter("PASSWORD");
		
		LoginDAO loginDAO=new LoginDAO();
		
        RequestDispatcher dispatcher;
        if(loginDAO.isvaliduser(userID , password)==true)
        {
        	//navigate to home page.
        	//dispatch to home page with the same req and res
        	dispatcher=request.getRequestDispatcher("Home.html");
        	dispatcher.forward(request, response);
        }
        else
        {
        	
        	//navigate to Login
        	//I have include error message
        	System.out.println("Invalid credentials");
        	PrintWriter writer=response.getWriter();
        	writer.println("please enter valid credentials");
        	dispatcher=request.getRequestDispatcher("Login.html");
        	dispatcher.include(request, response);


        	
        }
        
		
	}

}
