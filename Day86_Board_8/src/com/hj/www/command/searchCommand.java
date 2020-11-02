package com.hj.www.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hj.www.dao.ListDAO;
import com.hj.www.dto.ListDTO;

public class searchCommand implements command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchType =request.getParameter("searchType");
		String searchText = request.getParameter("searchText");
		
		ListDAO listDAO = ListDAO.getDAO();
		ArrayList<ListDTO> list = listDAO.search(searchType, searchText);
		request.setAttribute("list", list);
	}
}