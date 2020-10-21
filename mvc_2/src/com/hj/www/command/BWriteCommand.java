package com.hj.www.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hj.www.dao.BDAO;
import com.hj.www.dto.BDTO;

public class BWriteCommand extends HttpServlet {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BDAO dao = BDAO.getBDAO();
		BDTO dto = new BDTO();
		dto.setName(request.getParameter("name"));
		dto.setTitle(request.getParameter("title"));
		dto.setContents(request.getParameter("contents"));
		dao.writeOKtoDAO(dto);
	}
}
