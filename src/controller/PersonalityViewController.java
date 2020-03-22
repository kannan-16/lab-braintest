package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import service.PersonalityCalculator;

// Do not edit or modify this class unless required.
// This file acts as a controller class
// Instructions would be given at specific places to create or modify the existing code

@WebServlet(urlPatterns= {"/personality"})
public class PersonalityViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PersonalityViewController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entering do get");
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/personalityView.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String options=request.getParameter("selectedOptions");
		
		// write a code to create an object for the PersonalityCalculator
		
		
		// call the findYourBrainType method using the object created above and pass options as argument.
		// The value returned from the method is of type string.
		//Name the string literal as message
		// string value can be rightbrained, leftbrained or well balanced
		PersonalityCalculator personality=new PersonalityCalculator();
		
		String message=personality.findYourBrainType(options);
		System.out.println(message);
		request.setAttribute("message", message);
		
		
		/* Un the below lines to test your code l*/
		request.setAttribute("message", message);
		
		if(message!=null)
		{
			if(message.equals("rightbrained")) {
				RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/rightBrainView.jsp");
				rd.forward(request, response);
			}
			else if(message.equals("leftbrained")) {
				RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/leftBrainView.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/neutralView.jsp");
				rd.forward(request, response);
			}
		
		}
		}
	}


