package com.hj.www.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hj.www.command.command;
import com.hj.www.command.loginCommand;


@WebServlet({ "/frontController", "*.do" })
public class frontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public frontController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}
	
	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String sPath = request.getServletPath();
		String viewPage = null;
		command cmd = null;
		
		if(sPath.equals("/login.do"))
		{
			cmd = new loginCommand();
			cmd.excute(request, response);
			String name = (String) session.getAttribute("name");
			if(name.equals("loginError")) viewPage="loginError.jsp";	
			else viewPage="loginOk.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}

}
