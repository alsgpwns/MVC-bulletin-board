package com.hj.www.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.hj.www.dto.ListDTO;

public class ListDAO {
	private static ListDAO listDao = new ListDAO();
	String CONNECTION_POOL_NAME="jdbc/testdb";
	private String TABLE_NAME="hjlist";
	private DataSource dataSource;
	
	public ListDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/"+CONNECTION_POOL_NAME);
		} catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static ListDAO getDAO() {
		return listDao;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn=dataSource.getConnection();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close(ResultSet rs, PreparedStatement ps, Connection conn)
	{
		try {
			if(rs!=null) rs.close();
			if(ps!=null) rs.close();
			if(conn!=null) conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<ListDTO> viewList() {
		ArrayList<ListDTO> list = new ArrayList<ListDTO>();
		Connection conn=getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String VIEW_SQL = "select* from "+TABLE_NAME;
		ListDTO listDTO = null;
		
		try {
			ps=conn.prepareStatement(VIEW_SQL);
			rs=ps.executeQuery();
			while(rs.next())
			{
				listDTO = new ListDTO();
				listDTO.setContents(rs.getString("contents"));
				listDTO.setWrite_time(rs.getString("write_time"));
				listDTO.setId(rs.getString("id"));
				listDTO.setTitle(rs.getString("title"));
				listDTO.setNo(rs.getInt("no"));
				list.add(listDTO);
			}
		} catch(SQLException e)
		{
			e.printStackTrace();
		} finally {
			close(rs,ps,conn);
		}
		return list;
	}
	
	
	
	
	
	
}