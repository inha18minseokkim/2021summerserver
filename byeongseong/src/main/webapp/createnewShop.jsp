<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="byeongseong.*" %>
<%
request.setCharacterEncoding("utf8");
int number = Integer.parseInt(request.getParameter("number"));
String name = request.getParameter("name");
float score = 0;
String menutable = request.getParameter("menutable");
String info = request.getParameter("info");
int category = Integer.parseInt(request.getParameter("category"));
ShopData sdt = new ShopData();
sdt.setNumber(number);
sdt.setName(name);
sdt.setScore(score);
sdt.setMenutable(menutable);
sdt.setInfo(info);
sdt.setCategory(category);
DBManager.insertShopData(sdt);
DBManager.createMenuList(menutable);
response.sendRedirect("makenew.jsp");
%>