package com.hj.www.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hj.www.dao.BDAO;
import com.hj.www.dto.BDTO;
public class BListCommand implements BCommand{
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인터페이스 안에 중괄호 없는 추상메서드 생성. 서블릿과 동일한 파라미터를 받게 한다.	
		BDAO dao = BDAO.getBDAO();
		ArrayList<BDTO> list = dao.listDAO();
		request.setAttribute("list", list);
	}
}