package och12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDao {
	private static MemberDao instance;
	private MemberDao() {}
	public static MemberDao getInstance() {
		if(instance == null) {
			instance = new MemberDao();
		}
		return instance;
		
	}
	public Connection getConnection() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	public int check(String id,String passwd) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql1 = "select passwd from member2 where id=?";
		try {
			String dbPasswd = "";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dbPasswd = rs.getString(1);
				System.out.println("��� ����� ��й�ȣ : " +dbPasswd);
				System.out.println("����� �Է��� ��й�ȣ : " +passwd);
				if (dbPasswd.equals(passwd)) {			
					pstmt.setString(1, id);
					result = 1;
				} else result = 0;
			} else result = -1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
			if (rs != null)
				rs.close();
		}
		return result;
	}
	public List<Member> list() throws SQLException {
		List<Member> list = new ArrayList<Member>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		String sql = "select * from member2";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Member board = new Member();
				//���������� ������ board ��ü�� ����
				board.setId(rs.getString("id"));
				//board.setId(rs.getString(1));
				board.setPasswd(rs.getString("passwd"));
				board.setName(rs.getString("name"));
				board.setAddress(rs.getString("address"));
				board.setTel(rs.getString("tel"));
				board.setReg_date(rs.getDate("reg_date")); //
				list.add(board); 
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return list;
	}

}
