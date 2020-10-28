package com.hj.www.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.hj.www.dto.DTO;

public class DAO {
	private static DAO dao = new DAO();
	private String CONNECTION_POOL_NAME="jdbc/testdb";
	private String TABLE_NAME="hjboard";
	private DataSource dataSource;
	//private final String LOGIN_SQL = "select name from "+TABLE_NAME+" where id=(?) and password(?)";
	
	public DAO() {
		try {
			Context context = new InitialContext();
			dataSource =(DataSource)context.lookup("java:comp/env/"+CONNECTION_POOL_NAME);

		} catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static DAO getDAO() {
		return dao;
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
	
	public void close(PreparedStatement ps, Connection conn) {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String loginOktoDAO(DTO dto) {
		Connection conn=getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String id=dto.getId();
		String pw= dto.getPw();
		String name="loginError";
		System.out.println("id: "+id+", pw: "+pw);
		String LOGIN_SQL = "select name from "+TABLE_NAME+" where id=? and password=?";

		try {
			
			ps=conn.prepareStatement(LOGIN_SQL);
			ps.setString(1, id);
			ps.setString(2, pw);
			System.out.println(ps);
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				name = rs.getString("name"); 
			} else {
				System.out.println("일치하는 아이디가 없습니다.");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs,ps,conn);
		}
		return name;
	}
	
	public void joinOktoDAO(DTO dto) {
		Connection conn=getConnection();
		PreparedStatement ps = null;
		int rs =0;
		String JOIN_SQL = "insert into "+TABLE_NAME+" values(?,?,?,?,?,?,?,?,?)";
		String pw=dto.getPw();
		String pwcheck=dto.getRePw();

		if(!pw.equals(pwcheck))
		{
			System.out.println("비밀번호가 일치하지 않습니다.");
		} else {
			
			try {
				ps=conn.prepareStatement(JOIN_SQL);
				ps.setString(1, dto.getName());
				ps.setString(2, dto.getId());
				ps.setString(3, dto.getNickName());
				ps.setString(4, dto.getPw());
				ps.setString(5, dto.getEmail());
				ps.setString(6, dto.getAddress());
				ps.setString(7, dto.getBirthday());
				ps.setString(8, dto.getPhoneNumber());
				ps.setString(9, dto.getSex());
				rs=ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(ps,conn);
			}
			
		}
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
}
