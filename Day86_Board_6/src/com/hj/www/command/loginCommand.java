package com.hj.www.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hj.www.dao.DAO;
import com.hj.www.dto.DTO;

public class loginCommand implements command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao=DAO.getDAO();
		DTO dto = new DTO();
		
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		String name = dao.loginOktoDAO(dto);
		String id=request.getParameter("id");
		
		HttpSession session = request.getSession();
		session.setAttribute("name",name);
		session.setAttribute("id", id);
	}
}