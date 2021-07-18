<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="byeongseong.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="createnewShop.jsp" method="post">
	사업자등록번호 : <input type="text" name = "number"><br>
	상호명 : <input type="text" name = "name"><br>
	메뉴테이블 : <input type="text" name = "menutable"><br>
	정보 : <input type="text" name = "info"><br>
	카테고리 : <input type="text" name = "category"><br>
	<input type="submit" value="제출">
</form>
<table>
<%
Connection con = DBManager.getConnection();
String sql = "SELECT * FROM shoplist";
PreparedStatement pstmt = con.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery();
while(rs.next()){
%>
<tr>
<td><%=rs.getInt("number") %></td>
<td><%=rs.getString("name") %></td>
<td><%=rs.getFloat("score") %></td>
<td><a href="menulist.jsp?name=<%=rs.getString("menutable")%>"><%=rs.getString("menutable") %></a></td>
<td><%=rs.getString("info") %></td>
<td><%=rs.getInt("category") %></td>
<td><a href="">삭제</a></td>
</tr>
<%
}
%>
</table>
</body>
</html>