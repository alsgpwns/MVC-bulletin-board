package com.hj.www.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hj.www.dao.ListDAO;
import com.hj.www.dto.ListDTO;

public class viewContentsCommand implements command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ListDAO listDAO = ListDAO.getDAO();
		String no = request.getParameter("no");
		ListDTO listDTO = listDAO.viewContents(no);
		request.setAttribute("dto", listDTO);
	}
}