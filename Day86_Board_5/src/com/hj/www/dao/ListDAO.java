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
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close(PreparedStatement ps, Connection conn)
	{
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch(SQLException e)
		{
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
	
	public ListDTO viewContents(String no) {
		String VIEW_CONTENTS_SQL ="select* from "+TABLE_NAME+" where no=? ";
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ListDTO listDTO = null;
		
		try {
			ps=conn.prepareStatement(VIEW_CONTENTS_SQL);
			ps.setString(1, no);
			rs=ps.executeQuery();
			while(rs.next())
			{
				listDTO = new ListDTO();
				listDTO.setContents(rs.getString("contents"));
				listDTO.setWrite_time(rs.getString("write_time"));
				listDTO.setId(rs.getString("id"));
				listDTO.setTitle(rs.getString("title"));
				listDTO.setNo(rs.getInt("no"));
			}
		} catch(SQLException e)
		{
			e.printStackTrace();
		} finally {
			close(rs,ps,conn);
		}
		return listDTO;
	}

	public void modifyContents(ListDTO dto){
		String MODIFY_CONTENTS_SQL ="update "+TABLE_NAME+" set contents=?, title=?, write_time=current_time where no=?";
		Connection conn = getConnection();
		PreparedStatement ps = null;
		int rs=0;
		
		try {
			ps=conn.prepareStatement(MODIFY_CONTENTS_SQL);
			ps.setString(1, dto.getContents());
			ps.setString(2, dto.getTitle());
			ps.setInt(3, dto.getNo());
			rs=ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps,conn);
		}
	}
	
	public void deleteOk(String no) {
		String DELETE_SQL = "delete from "+TABLE_NAME+" where no=?";
		Connection conn = getConnection();
		PreparedStatement ps = null;
		int rs = 0;
		
		try {
			ps= conn.prepareStatement(DELETE_SQL);
			ps.setString(1, no);
			rs=ps.executeUpdate();
		} catch(SQLException e)
		{
			e.printStackTrace();
		} finally{
			close(ps,conn);
		}
	}
	
	public void wirteOk(ListDTO dto) {
		String WRITE_CONTENTS_SQL ="insert into "+TABLE_NAME+" (id,contents,title) values(?,?,?)";
		Connection conn = getConnection();
		PreparedStatement ps = null;
		int rs= 0;
		
		try {
			ps=conn.prepareStatement(WRITE_CONTENTS_SQL);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getContents());
			ps.setString(3, dto.getTitle());
			rs=ps.executeUpdate();
		} catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			close(ps,conn);
		}
	}
	
	
	
	
}