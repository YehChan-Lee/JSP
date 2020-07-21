package org.comstudy21.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.comstudy21.dbcp.JdbcUtil;
import org.comstudy21.dto.Person;

public class dao {
	static String sql = "select * from PERSONDB";
	static Connection conn = JdbcUtil.getConnection();
	static Statement stmt = null;
	static ResultSet rs = null;

	public static ArrayList<Person> selectAll() throws SQLException {
		ArrayList<Person> list = new ArrayList<Person>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Person v = new Person();
				v.setUserName(rs.getString("name"));
				v.setUserAddr(rs.getString("address"));
				v.setAge(rs.getInt("age"));
				list.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
			conn.close();
		}
		return list;
	}

}
