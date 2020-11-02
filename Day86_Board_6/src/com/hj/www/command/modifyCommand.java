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

public class modifyCommand implements command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao=DAO.getDAO();
		DTO dto = null;
		
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		dto = dao.loadtoDAO(id);
		request.setAttribute("dto", dto);
	}
}