package com.hj.www.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hj.www.dao.DAO;
import com.hj.www.dto.DTO;

public class joinCommand implements command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao=DAO.getDAO();
		DTO dto = new DTO();
		
		dto.setName(request.getParameter("name"));
		dto.setId(request.getParameter("id"));
		dto.setNickName(request.getParameter("nickname"));
		dto.setPw(request.getParameter("password"));
		dto.setRepassword(request.getParameter("repassword"));
		dto.setAddress(request.getParameter("address"));
		dto.setBirthDay(request.getParameter("birth"));
		dto.setSex(request.getParameter("sex"));
		dto.setPhoneNumber(request.getParameter("phone"));
		dto.setEmail(request.getParameter("email"));
		
		dao.joinOktoDAO(dto);
	}
}