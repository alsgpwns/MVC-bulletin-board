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

import com.hj.www.dto.BDTO;

public class BDAO{
	private static BDAO bDAO = new BDAO();
	private String CONNECTION_POOL_RESOURCE_NAME="jdbc/testdb";
	private final String TABLE_NAME="board";
	private DataSource dataSource;
	private final String SELECT_ALL_FROM_BOARD = "select * from "+TABLE_NAME;
	
	public BDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/"+CONNECTION_POOL_RESOURCE_NAME);
		} catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static BDAO getBDAO() {
		return bDAO;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public void close(ResultSet rs, PreparedStatement ps, Connection conn) {
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(conn !=null) conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BDTO> listDAO(){
		ArrayList<BDTO> list = new ArrayList<BDTO>();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement( SELECT_ALL_FROM_BOARD);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				BDTO dto = new BDTO();
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setName(rs.getString("name"));
				dto.setWtime(rs.getString("wtime"));
				dto.setRcnt(rs.getInt("rcnt"));
				list.add(dto);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs,pstmt,conn);
		}
		return list;
	}
	
	
}