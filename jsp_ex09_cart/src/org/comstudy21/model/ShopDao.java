package org.comstudy21.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.comstudy21.dbcp.JdbcUtil;

interface SQL {
	String SQL_ACCOUNT_CHECK = "SELECT PW FROM ACCOUNT WHERE ID=?";
	String SQL_ACCOUNT_ADD = "INSERT INTO ACCOUNT VALUES(?,?)";
	String SQL_SELECT_ALL = "SELECT * FROM PRODUCT";
	String SQL_SELECT_ONE = "SELECT * FROM PRODUCT WHERE NO=?";		
	
}

public class ShopDao implements SQL {
	private static final ArrayList<Product> pList = new ArrayList<>();
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	static String tableName = null;
	String SQL_MAKE_CART = "CREATE TABLE"+ tableName+"(NO NUMBER(3),NAME VARCHAR2(20),PRICE NUMBER(5))";
	String SQL_ADD_CART = "INSERT INTO "+tableName+"VALUES(?,?,?)";
	String SQL_SELECT_CART_ALL = "SELECT * FROM "+tableName+"CART";
	String SQL_DELETE_CART = "DELETE FROM "+tableName+" WHERE NO=?";
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public ArrayList<Product> selectAll() {
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL_SELECT_ALL);
			while(rs.next()){
				Product dto = new Product(rs.getInt("no"),rs.getString("name"),rs.getInt("price"));
				pList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			JdbcUtil.close(rs,stmt,conn);
		}
		return pList;
	}

	public Product selectByIdx(Product p) {
		Product dto = new Product();
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_ONE);
			pstmt.setInt(1, p.getIdx());
			rs = pstmt.executeQuery();
			while(rs.next()){
				dto.setIdx(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setPrice(rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			JdbcUtil.close(rs, pstmt, conn);
		}		
		return dto;
	}
	public void delete(Product dto,String id) {
		int idx = dto.getIdx();
		tableName = id+"_cart";
		SQL_DELETE_CART = "DELETE FROM "+tableName+" WHERE NO=?";
		try {
			pstmt = conn.prepareStatement(SQL_DELETE_CART);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();			
		}finally{
			JdbcUtil.close(rs, pstmt, conn);
		}		
	}

	public boolean checkAccount(String id, String pw) {
		try {
			pstmt = conn.prepareStatement(SQL_ACCOUNT_CHECK);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getString("PW").equals(pw)){
					return true;
				}else{
					return false;
				}
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs, pstmt, conn);
		}
		return false;
	}

	public void addAccount(String id, String pw) {
		try {
			pstmt = conn.prepareStatement(SQL_ACCOUNT_ADD);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(null, pstmt, null);
		}
	}
	public ArrayList<Product> CartList(String id){
		ArrayList<Product> list = new ArrayList<>();
		tableName = id;
		SQL_SELECT_CART_ALL = "SELECT * FROM "+tableName+"_CART";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL_SELECT_CART_ALL);
			while(rs.next()){
				Product p = new Product(rs.getInt("no"),rs.getString("name"),rs.getInt("price"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			JdbcUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	public void addCart(String id, Product p) {
		try {
			tableName = id + "_cart";
			SQL_ADD_CART = "INSERT INTO "+tableName+" VALUES(?,?,?)";
			pstmt = conn.prepareStatement(SQL_ADD_CART);
			pstmt.setInt(1, p.getIdx());
			pstmt.setString(2, p.getTitle());
			pstmt.setInt(3, p.getPrice());
			pstmt.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally{
			JdbcUtil.close(null, pstmt, null);
		}
		
	}

	public void makeCart(String id) {
		try {
			tableName = id +"_cart";
			SQL_MAKE_CART = "CREATE TABLE "+ tableName+"(NO NUMBER(3) PRIMARY KEY,NAME VARCHAR2(20),PRICE NUMBER(5))";
			stmt = conn.createStatement();
			stmt.executeUpdate(SQL_MAKE_CART);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(null, pstmt, conn);
		}		
	}

}
