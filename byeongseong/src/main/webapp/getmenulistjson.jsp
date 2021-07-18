<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="byeongseong.*" %>
<%@ page import ="org.json.*" %>
<%@ page import = "java.io.*"%>
<%
request.setCharacterEncoding("utf8");
String key = request.getParameter("key");
JSONUtil byeongseong = new JSONUtil();
JSONObject res = byeongseong.searchMenuList(key);
response.setContentType("application/json");
String output = res.toString();
PrintWriter writer = response.getWriter();
writer.write(output);
writer.close();
%>