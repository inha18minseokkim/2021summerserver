<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="byeongseong.*" %>
<%
request.setCharacterEncoding("utf8");
String res = request.getParameter("name");
System.out.println("ASDFASDFASDFASDFASDFADSF"+res);
Connection con = DBManager.getConnection();	
String sql = "SELECT idx,name,price,img FROM "+res;
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1, res);
ResultSet rs = pstmt.executeQuery();
%>
<table>
<%
while(rs.next()){
	int idx = rs.getInt("idx");
	String name = rs.getString("name");
	int price = rs.getInt("price");
	String img = rs.getString("img");
%>
<tr>
<td><%=idx %></td>
<td><%=name %></td>
<td><%=price %></td>
<td></td>

</tr>
<%
}
%>
</table>