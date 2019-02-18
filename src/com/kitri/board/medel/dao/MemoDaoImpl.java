package com.kitri.board.medel.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.board.model.MemoDto;
import com.kitri.util.DBClose;
import com.kitri.util.DBConnection;

public class MemoDaoImpl implements MemoDao {

	
	private MemoDaoImpl() {};
	private static MemoDaoImpl memoDaoImpl;
	static {
		memoDaoImpl = new MemoDaoImpl();
	}

	public static MemoDaoImpl getMemoDaoImpl() {
		return memoDaoImpl;
	}

	@Override
	public void writememo(MemoDto memoDto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
				
		try {
			DBConnection.getInstance();
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into memo (mseq,seq, id, name, mcontent, mtime) \n");			
			sql.append("values (memo_mseq.nextval, ?, ?, ?, ?, sysdate) \n");			
			
			pstmt=conn.prepareStatement(sql.toString());
			
			int idx = 1;
			pstmt.setInt(idx++, memoDto.getSeq());
			pstmt.setString(idx++, memoDto.getId());
			pstmt.setString(idx++, memoDto.getName());
			pstmt.setString(idx++, memoDto.getMcontent());		
			pstmt.executeUpdate();				
			
		}catch(SQLException e) {			
			e.printStackTrace();
		}finally {
			DBClose.close(conn, pstmt);
		}
		
		

	}

	@Override
	public List<MemoDto> listMemo(int seq) {
		List<MemoDto> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;				
		try {
			DBConnection.getInstance();
			conn = DBConnection.makeConnection();			
			StringBuffer sql = new StringBuffer();
			sql.append("select mseq,seq,id,name,mcontent,mtime \n");			
			sql.append("from memo \n");			
			sql.append("where seq = ? \n");			
			sql.append("order by mseq \n");			
			
			pstmt=conn.prepareStatement(sql.toString());			
			pstmt.setInt(1, seq);	
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemoDto memoDto = new MemoDto();
				memoDto.setMseq(rs.getInt("mseq"));
				memoDto.setSeq(rs.getInt("seq"));
				memoDto.setId(rs.getString("id"));
				memoDto.setName(rs.getString("name"));
				memoDto.setMcontent(rs.getString("mcontent"));
				memoDto.setMtime(rs.getString("mtime"));
				
				list.add(memoDto);				
			}
			
					
			
		}catch(SQLException e) {			
			e.printStackTrace();
		}finally {
			DBClose.close(conn, pstmt);
		}
		
		return list;
	}

	@Override
	public void modifyMemo(MemoDto memoDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMemo(int mseq) {
		// TODO Auto-generated method stub

	}

}
