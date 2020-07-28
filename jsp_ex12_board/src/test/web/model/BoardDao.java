package test.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.comstudy21.dbcp.JdbcUtil;

interface SQL{
	String SQL_SELECT_ALL = "SELECT * FROM BOARD";
	String SQL_SELECT_ONE = "SELECT * FROM BOARD WHERE NUM=?";
	String SQL_DELETE = "DELETE FROM BOARD WHERE NUM=?";
	//author,email,title,content,passwd
	String SQL_INSERT = "insert into board values(seq_board.nextval,?,?,?,?,?,sysdate,0,0,0,0)";
}

public class BoardDao implements SQL {	
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	private static BoardDao instance;
	
	public BoardDao() {}
	
	public static BoardDao getInstance() {
		if (instance == null) {
			instance = new BoardDao();
		}
		return instance;
	}
	
	Connection conn;

	public ArrayList<BoardTO> list(){
		ArrayList<BoardTO> list = new ArrayList<BoardTO>();
		try {
			conn = JdbcUtil.getConnection();//JNDI 커넥션 풀
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL_SELECT_ALL);
			while(rs.next()){
				int num = rs.getInt("num");
				String author = rs.getString("author");
				String email = rs.getString("email");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String passwd = rs.getString("passwd");
 				Timestamp writeday = rs.getTimestamp("writeday");
 				int readcnt = rs.getInt("readcnt");
 				int reproot = rs.getInt("rep_root");
 				int repstep = rs.getInt("rep_step");
 				int repindent = rs.getInt("rep_indent");
 				BoardTO data = new BoardTO(num, author, email, title, content, passwd, writeday, readcnt, reproot, repstep, repindent);
 				list.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs,stmt,conn);
		}
		return list;
	}
	
	public void insert(BoardTO dto){
		ArrayList<BoardTO> list = new ArrayList<BoardTO>();
		try {
			conn = JdbcUtil.getConnection();//JNDI 커넥션 풀
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1,dto.getAuthor());
			pstmt.setString(2,dto.getEmail());
			pstmt.setString(3,dto.getTitle());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5, dto.getPasswd());
			int cnt = pstmt.executeUpdate();
			if(cnt<=0){
				conn.rollback();
			}else{
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs,pstmt,conn);
		}
	}
	public BoardTO selectOne(int no){
		BoardTO dto = new BoardTO();
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(SQL_SELECT_ONE);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			while(rs.next()){
				dto.setNum(rs.getInt("num"));
				dto.setTitle(rs.getString("title"));
				dto.setAuthor(rs.getString("author"));
				dto.setEmail(rs.getString("email"));
				dto.setContent(rs.getString("content"));
				dto.setPasswd(rs.getString("passwd"));
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs, pstmt, conn);
		}		
		return dto;
	}
	public void delete(int no){
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs, pstmt, conn);
		}		
	}
}