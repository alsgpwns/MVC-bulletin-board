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

public class listCommand implements command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListDAO listDAO=ListDAO.getDAO();

		String offsetNum_str = request.getParameter("number");
		int offsetNum= Integer.parseInt(offsetNum_str);
		ArrayList<ListDTO> list = listDAO.viewList(offsetNum);
		request.setAttribute("list", list);
	}
}