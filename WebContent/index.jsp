<%@page import="com.kitri.member.model.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kitri.util.PageMove"%>
<%
String root = request.getContextPath();

MemberDto memberDto = new MemberDto();
memberDto.setId("sangjaeoh");
memberDto.setName("오상재");
memberDto.setEmailid("helloworld");
memberDto.setEmaildomain("naver.com");

session.setAttribute("userInfo", memberDto);

PageMove.redirect(request, response, "/adminboard?act=boardmenu");
%>    
