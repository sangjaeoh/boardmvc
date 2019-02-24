package com.kitri.action.memo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.json.JSONArray;
import org.json.JSONObject;

import com.kitri.action.Action;
import com.kitri.board.model.MemoDto;
import com.kitri.board.model.service.MemoServiceImpl;
import com.kitri.member.model.MemberDto;

public class MemoWriteAction implements Action {
	
	private static MemoWriteAction memoWriteAction;
	private MemoWriteAction() {};
	static {
		memoWriteAction = new MemoWriteAction();
	}
	
	public static MemoWriteAction getMemoWriteAction() {
		return memoWriteAction;
	}


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			MemoDto memoDto = new MemoDto();
			memoDto.setSeq(seq);
			memoDto.setMcontent(request.getParameter("mcontent"));
			memoDto.setId(memberDto.getId());
			memoDto.setName(memberDto.getName());
			MemoServiceImpl.getMemoServiceImpl().writememo(memoDto);
			
			List<MemoDto> list = MemoServiceImpl.getMemoServiceImpl().listMemo(seq);
			
			
			JSONObject mlist = new JSONObject();
			JSONArray jarray = new JSONArray();
			for(MemoDto mDto : list) {
				JSONObject memo = new JSONObject();
				memo.put("mseq",mDto.getMseq());
				memo.put("seq",mDto.getSeq());
				memo.put("id",mDto.getId());
				memo.put("name",mDto.getName());
				memo.put("mcontent",mDto.getMcontent());
				memo.put("mtime",mDto.getMtime());				
				jarray.put(memo);
			}
			mlist.put("memolist", jarray);
			return mlist.toString();
		}				
		return null;
	}

}
