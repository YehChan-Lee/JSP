//package org.comstudy21.model;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import org.comstudy21.dbcp.JdbcUtil;
//
//public class Dao {
//	Connection conn = null;
//	Statement stmt = null;
//	PreparedStatement pstmt = null;
//	String sql = "insert into account values(?,?,?)";
//	
//	public Dao() {
//		conn = JdbcUtil.getConnection();
//	}
//
//	public void addInfo(String userId, String passwd, String age) {
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, userId);
//			pstmt.setString(2, passwd);
////			pstmt.setInt(3, age);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//	
//}
