<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	BoardVO board = (BoardVO)session.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�� ��</title>
</head>
<body>
<center>
<h1>�� ��</h1>
<a href="logout_proc.jsp">Log_out</a>
<hr>
<form action="updateBoard.do" method="post">
<input name="seq" type="hidden" value="${board.seq }"/>
	<table board="1" cellpadding="0" cellspacing="0">
		<tr>
			<td bgcolor="orange" width="70">����</td>
			<td aligh="left"><input name="title" type="text" value="${ board.title}"/></td>
		</tr>
		<tr>
			<td bgcolor="orange" >�ۼ���</td>
			<td aligh="left">${board.writer }</td>
		</tr>
		<tr>
			<td bgcolor="orange" >����</td>
			<td aligh="left"><textarea name = "content" cols="40" rows="10">${board.content }</textarea></td>
		</tr>
		<tr>
			<td bgcolor="orange" >�����</td>
			<td aligh="left">${board.regDate }</td>
		</tr>
		<tr>
			<td bgcolor="orange" >��ȸ��</td>
			<td aligh="left">${board.cnt }</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="�� ����"/></td>
		</tr>
	</table>
</form>
<hr>
<a href="insertBoard.jsp">�۵��</a>&nbsp;&nbsp;&nbsp;
<a href = "deleteBoard.do?seq=${board.seq }">�ۻ���</a>&nbsp;&nbsp;&nbsp;
<a href = "getBoardList.do">�۸��</a>
</center>
</body>
</html>