<%@page import="java.io.PrintWriter"%>
<%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="byeongseong.JSONUtil" %>

<%
request.setCharacterEncoding("utf8");
int key = Integer.parseInt(request.getParameter("key"));
JSONUtil byeongseong = new JSONUtil();
JSONObject js = byeongseong.searchShopList(key);
//JSONObject js = byeongseong.getAllShopList();
response.setContentType("application/json");
String output = js.toString();
response.setCharacterEncoding("utf8");
PrintWriter writer = response.getWriter();
writer.write(output);
writer.close();
%>
