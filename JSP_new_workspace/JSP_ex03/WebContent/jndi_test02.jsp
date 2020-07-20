<%@page import="java.sql.SQLException"%>
<%@page import="java.util.Vector"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.comstudy21.dbcp.JdbcUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String sql ="select * from PERSONDB";
		Connection conn = JdbcUtil.getConnection();
		out.println("conn => " + conn);
		Statement stmt = null;
		ResultSet rs = null;
		
		Vector<Vector> list = new Vector<Vector>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("name"));
				v.add(rs.getString("address"));
				v.add(rs.getInt("age"));
				list.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
		}
		
		for(int i=0;i<list.size();i++){
			out.println(list.get(i).toString());
		}
	%>
</body>
</html>