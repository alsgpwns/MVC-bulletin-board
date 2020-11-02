package com.hj.www.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hj.www.dao.ListDAO;
import com.hj.www.dto.ListDTO;

public class ModifyContentsCommand implements command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListDAO listdao = ListDAO.getDAO();
		ListDTO dto = new ListDTO();
		String no_str = request.getParameter("no");
		int no=Integer.parseInt(no_str);
		
		dto.setTitle(request.getParameter("title"));
		dto.setContents(request.getParameter("contents"));
		dto.setNo(no);
		
		listdao.modifyContents(dto);
	}
}
