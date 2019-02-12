package com.kitri.board.medel.dao;

import java.sql.*;

import com.kitri.util.DBClose;
import com.kitri.util.DBConnection;

public class CommonDaoImpl implements CommonDao {

	private static CommonDao commonDao;

	static {
		commonDao = new CommonDaoImpl();
	}

	private CommonDaoImpl() {

	}

	public static CommonDao getCommonDao() {
		return commonDao;
	}

	@Override
	public int getNextSeq() {
		int seq = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			DBConnection.getInstance();
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select board_seq.nextval \n");
			sql.append("from dual");
			pstmt=conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			rs.next();
			seq = rs.getInt(1);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return seq;
	}

	@Override
	public void updateHit(int seq) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			DBConnection.getInstance();
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update board \n");
			sql.append("set hit = hit +1 \n");
			sql.append("where seq = ?");
			pstmt=conn.prepareStatement(sql.toString());			
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(conn, pstmt);
		}
		
	}

}
