package com.hj.www.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hj.www.command.DeleteCommand;
import com.hj.www.command.ModifyContentsCommand;
import com.hj.www.command.WriteCommand;
import com.hj.www.command.WriteOkCommand;
import com.hj.www.command.command;
import com.hj.www.command.joinCommand;
import com.hj.www.command.listCommand;
import com.hj.www.command.logOutcommand;
import com.hj.www.command.loginCommand;
import com.hj.www.command.modifyCommand;
import com.hj.www.command.modifyOkCommand;
import com.hj.www.command.viewContentsCommand;


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
			if(name.equals("loginError")) viewPage="alertpage/loginError.jsp";	
			else viewPage="loginOk.jsp";
		}
		else if(sPath.equals("/logout.do"))
		{
			cmd = new logOutcommand();
			viewPage="alertpage/logOut.jsp";
		}
		else if(sPath.equals("/join.do"))
		{
			cmd = new joinCommand();
			cmd.excute(request, response);
			viewPage="joinOk.jsp";
		}
		else if(sPath.equals("/modify.do"))
		{
			cmd=new modifyCommand();
			cmd.excute(request, response);
			viewPage="modify.jsp";
		}
		else if(sPath.equals("/modifyOk.do"))
		{
			cmd = new modifyOkCommand();
			cmd.excute(request, response);
			viewPage="alertpage/modifyOk.jsp";
		}
		else if(sPath.equals("/list.do"))
		{
			cmd = new listCommand();
			cmd.excute(request, response);
			viewPage="list.jsp";
		}
		else if(sPath.equals("/viewContents.do")) 
		{
			String no = request.getParameter("no");
			cmd = new viewContentsCommand();
			cmd.excute(request, response);
			viewPage="viewContents.jsp";
		}
		else if(sPath.equals("/ModifyContents.do"))
		{
			cmd = new ModifyContentsCommand();
			cmd.excute(request, response);
			viewPage="list.do";
		}
		else if(sPath.equals("/delete.do"))
		{
			cmd = new DeleteCommand();
			cmd.excute(request, response);
			viewPage="alertpage/Delete.jsp";
		}
		else if(sPath.equals("/write.do"))
		{
			cmd = new WriteOkCommand();
			cmd.excute(request, response);
			viewPage="alertpage/writeOk.jsp";
		}

		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}

}
