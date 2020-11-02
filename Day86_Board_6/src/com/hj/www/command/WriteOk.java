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

public class WriteOk implements command  {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String title=request.getParameter("title");
		String contents=request.getParameter("contents");
		
		ListDAO listDAO = new ListDAO();
		ListDTO dto = new ListDTO();
		
		dto.setId(id);
		dto.setTitle(title);
		dto.setContents(contents);
		
		listDAO.wirteOk(dto);
	}
}
