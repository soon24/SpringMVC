<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn"	uri="http://java.sun.com/jsp/jstl/functions"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD LIST</title>
<script src="/app/web/js/jquery-3.3.1.js"></script>
<script src="/app/web/js/jquery-ui.min.js"></script>
<script src="/app/web/js/dynatree/jquery.dynatree.js"></script>
<script>
function fn_formSubmit(){
	document.searchFrm.submit();	
}
</script>

</head>
<style>
body{
	font-size:9pt;
}
button {
	font-size:9pt;
}
a {
	text-decoration:none;
}
table {
	width:600px;
	border-collapse:collapse;
}
th, td {
	border:1px solid #cccccc;
	padding:3px;
}
caption {
	font-size:15pt;
	font-weight:bold;
	margin-top:10px;
	padding-bottom:5px;
}

.div1 {
	width:600px;
	text-align:center;
	font-size:15pt;
}

.div2 {
	width:600px;
	text-align:left;
	font-size:8pt;
}
.div3 {
	width:300px;
	text-align:right;
	font-size:8pt;
	float:left;
	margin-bottom:5px;
}
.div3 input {
	width:120px;
	font-size:9pt;
}

</style>

<body>

<!-- 번호, 제목, 글쓴이, 등록일, 조회수 -->
<div class="div1">일반게시판 목록</div>
<div class="div2">Total : ${searchVO.totRow }</div>

<table>
	<tr>
		<th width="10%">번호</th>
		<th width="40%">제목</th>
		<th width="15%">글쓴이</th>
		<th width="15%">등록일</th>
		<th width="15%">조회수</th>
	</tr>
	
	<c:set var="cnt" value="${searchVO.totRow }"/>
	
	<c:forEach var="result" items="${listview}" varStatus="status">	
	
	<tr align="center">
		<td><c:out value="${cnt }" /></td>
		<td align="left">
			<a href="boardDetail.do?unq=${result.unq }"><c:out value="${result.title }"/></a>
		</td>
		<td><c:out value="${result.name }" /></td>
		<td><c:out value="${result.rdate }" /></td>
		<td><c:out value="${result.hits }" /></td>
	</tr>
		
		<c:set var="cnt" value="${cnt - 1 }"/>
		
	</c:forEach>

</table>
<div class="div2">
<form name="searchFrm" id="searchFrm" method="post">
	<div style="width:600px;margin-top:5px; text-align:left; ">
		<jsp:include page="/WEB-INF/views/common/pagingforSubmit.jsp" />
	</div>
	<div>
		<input type="checkbox" name="searchType" value="title" <c:if test="${fn:indexOf(searchVO.searchType, 'title')!=-1}">checked="checked"</c:if>/>
		<label class="chkselect" for="searchType1">제목</label>
		<input type="checkbox" name="searchType" value="name" <c:if test="${fn:indexOf(searchVO.searchType, 'name')!=-1}">checked="checked"</c:if>/>
		<label class="chkselect" for="searchType2">글쓴이</label>
		<input type="text" name="searchKeyword" style="width:150px;" maxlength="50" value='<c:out value="${searchVO.searchKeyword}"/>' onkeydown="if(event.keyCode == 13) { fn_formSubmit();}">
		<input name="btn_search" value="검색" type="button" onclick="fn_formSubmit()" />
		
		<button type="button" onclick="location='boardWrite.do'">글쓰기</button>
	</div>
	
 </form>
</div>

</body>
</html>