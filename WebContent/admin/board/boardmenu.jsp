<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style type="text/css">

.menu_list {
	width: 200px;
}
.menu_header {
	padding: 5px 10px;
	cursor: pointer;
	position: relative;
	font-weight: bold;
	background-color: gray;
}
.menu_body {
	display: none;
	text-align: left;
}

.menu_body a {
	display: block;
	background-color: magenta;
	padding: 10px;
	text-decoration: none;
}

.menu_body a:hover {
	background-color: #ffffff;
	text-decoration: underline;
}

.test {
	text-decoration: underline;
}

</style>

<script type="text/javascript">
$(document).ready(function() {
	$("#menu p.menu_header").click(function(){
		$(this).next("div.menu_body").addClass("test").slideDown(500).siblings("div.menu_body").slideUp("slow");
	});
});
</script>

</head>
<body>
<div class="menu_list" id="menu">
<c:set var="root" value="${pageContext.request.contextPath}"/>
<c:set var="preCcode" value="0"/>
<c:if test="${boardmenu != null}">
	<c:forEach varStatus="i" var="boardListDto" items="${boardmenu}">
		<c:if test="${preCcode != boardListDto.ccode}">		
			<p class="menu_header">${boardListDto.cname}</p>		
			<div class="menu_body">	
		<c:set var="preCcode" value="${boardListDto.ccode}"/>	
		</c:if>
			<a href="${root}/${boardListDto.control}?act=listarticle&bcode=${boardListDto.bcode}&pg=1&key=&word=">
			${boardListDto.bname}
			</a>
		<c:if test="${i.index < boardmenu.size() - 1}">
			<c:if test="${preCcode != boardmenu.get(i.index + 1).ccode}">
			</div>
			</c:if>
		</c:if>
	</c:forEach>
</c:if>
</div>
</body>
</html>




























<%--
<%
List<BoardListDto> boardmenu = (List<BoardListDto>)application.getAttribute("boardmenu");
if(boardmenu != null){
//	for(BoardListDto boardListDto : boardmenu){
	int len = boardmenu.size();
	int ccode = 0;
	for(int i=0;i<len;i++){			
	
		BoardListDto boardListDto = boardmenu.get(i);
		if(ccode!=boardListDto.getCcode()){
		ccode = boardListDto.getCcode();
		%>		
<p class="menu_header"><%=boardListDto.getCname()%></p>		
<div class="menu_body">		
<%}%>
<a href=""><%=boardListDto.getBname()%></a>
<%
if(i < len-1){
if(ccode != boardmenu.get(i+1).getCcode()){
%>
</div>
<%
	}
	}
	}
}
%>
</div>
</body>
</html>
 --%>
