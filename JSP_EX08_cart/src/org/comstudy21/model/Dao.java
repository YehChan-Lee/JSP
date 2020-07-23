package org.comstudy21.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.comstudy21.dbcp.JdbcUtil;

interface SQL{
	String SQL_SELECT_ALL = "SELECT * FROM CARLIST";
	String SQL_SELECT_ONE = "SELECT * FROM CARLIST WHERE NO=?";
	String SQL_SELECT_CART_ALL = "SELECT * FROM CART";
	String SQL_ADD_CART = "INSERT INTO CART VALUES(?,?,?,?)";
	String SQL_DELETE_CART = "DELETE FROM CART WHERE NO=?";
}

public class Dao implements SQL {	
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	private static Dao instance;
	
	public Dao() {}
	
	public static Dao getInstance() {
		if (instance == null) {
			instance = new Dao();
		}
		return instance;
	}
	
	Connection conn;
	
	public void setConnection(Connection conn){
		this.conn = conn;
	}
	public ArrayList<Dto> selectAll(){
		ArrayList<Dto> list = new ArrayList<Dto>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL_SELECT_ALL);
			while(rs.next()){
				Dto dto = new Dto(rs.getInt("no"),rs.getString("name"),rs.getString("company"),rs.getInt("year"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs,stmt,conn);
		}
		return list;
	}
	public Dto selectOne(int no){
		Dto dto = new Dto();
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_ONE);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			while(rs.next()){
				dto.setNo(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setCompany(rs.getString(3));
				dto.setYear(rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs, pstmt, conn);
		}		
		return dto;
	}

	public ArrayList<Dto> loadCart() {
		ArrayList<Dto> list = new ArrayList<Dto>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL_SELECT_CART_ALL);
			while(rs.next()){
				Dto dto = new Dto(rs.getInt("no"),rs.getString("name"),rs.getString("company"),rs.getInt("year"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs,stmt,conn);
		}
		return list;
	}

	public void addcart(Dto dto) {
		try {
			pstmt = conn.prepareStatement(SQL_ADD_CART);
			pstmt.setInt(1, dto.getNo());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getCompany());
			pstmt.setInt(4, dto.getYear());
			int cnt = pstmt.executeUpdate();
			if(cnt > 0){
				System.out.println("입력 성공");
			}else{
				System.out.println("입력 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	public void cartDelete(int number) {		
		try {
			pstmt = conn.prepareStatement(SQL_DELETE_CART);
			pstmt.setInt(1, number);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(null, pstmt, conn);
		}		
	}
}
