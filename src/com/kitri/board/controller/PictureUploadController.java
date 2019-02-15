package com.kitri.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.board.model.AlbumDto;
import com.kitri.board.model.service.AlbumServiceImpl;
import com.kitri.member.model.MemberDto;
import com.kitri.util.*;
import com.oreilly.servlet.MultipartRequest;


@WebServlet("/uploadcontrol")
public class PictureUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String realPath;
	private int maxPostSize;
	
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext();
		realPath = context.getRealPath("/upload");
		maxPostSize = 5 * 1024 * 1024;
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		String today = df.format(new Date());
		String saveDirectory = realPath + File.separator + today;
		File folder = new File(saveDirectory);
		if(!folder.exists()) {
			folder.mkdirs();
		}
		
				
		MultipartRequest multi = new MultipartRequest(request, saveDirectory, maxPostSize, BoardConstance.ENCODER, new DateFileRenamePolicy());
		
		//썸네일
		
		
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		String path = "/index.jsp";
		if(memberDto != null) {
			AlbumDto albumdDto = new AlbumDto();
			albumdDto.setId(memberDto.getId());
			albumdDto.setName(memberDto.getName());
			albumdDto.setEmail(memberDto.getEmailid() + "@" + memberDto.getEmaildomain());
			albumdDto.setSubject(multi.getParameter("subject"));
			albumdDto.setContent(multi.getParameter("content"));
			albumdDto.setBcode(Integer.parseInt(multi.getParameter("bcode")));
			
			albumdDto.setSaveFolder(today);
			albumdDto.setOrignPicture(multi.getOriginalFileName("picture"));
			albumdDto.setSavePicture(multi.getFilesystemName("picture"));
			
			int seq = AlbumServiceImpl.getAlbumServiceImpl().writeArticle(albumdDto);
			System.out.println(seq);
			request.setAttribute("seq", seq);
			path = "/album/writeok.jsp";
		}		
		PageMove.forward(request, response, path);
		
		
		
	}

}
