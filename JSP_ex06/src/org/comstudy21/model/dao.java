package org.comstudy21.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.comstudy21.dbcp.JdbcUtil;

interface sql{
	String SELECT_ALL = "select * from PERSONDB";
	String INSERT = "INSERT INTO PERSONDB VALUES(?,?,?)";
}

public class dao implements sql{	
	static Connection conn = JdbcUtil.getConnection();
	static Statement stmt = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	
	public static ArrayList<Person> selectAll() throws SQLException {
		ArrayList<Person> list = new ArrayList<Person>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_ALL);
			while (rs.next()) {
				Person v = new Person(rs.getString("name"),rs.getString("address"),rs.getInt("age"));
				list.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		return list;
	}
	public static Person selectOne(){
	
		return null;
	}
	public static ArrayList<Person> select(){
		
		return null;
	}
	
	public static void insert(Person p) throws SQLException{
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1,p.getUserName());
			pstmt.setString(2,p.getUserAddr());
			pstmt.setInt(3,p.getAge());
			cnt = pstmt.executeUpdate();
			if(cnt != 1){
				System.out.println("입력에 실패했습니다!");
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt);
		}
	}
	public void delete(Person p){
		
	}
	public void update(Person p){
		
	}
}
