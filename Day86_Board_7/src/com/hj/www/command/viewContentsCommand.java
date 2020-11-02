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
		request.setCharacterEncoding("UTF-8");

		//id 가져오기
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("id");
		
		ListDAO listDAO = ListDAO.getDAO();		
		String no = request.getParameter("no");
		String writerId = request.getParameter("id");
		
		listDAO.updateViews(no,writerId,sessionId);
		
		ListDTO listDTO = listDAO.viewContents(no);
		request.setAttribute("dto", listDTO);
	}
}