<%@page import="com.bean.DanhMuc"%>
<%@page import="com.database.DanhMucDao"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 	<table>
 	<a href="ThemDM.jsp">Thêm</a>
 		<thead>
 				<tr>
 					<th>Mã danh mục</th>
 					<th>Tên danh mục</th>
 					<th>Chức năng</th>
 					
 				</tr>
 		</thead>
 			<tbody>
 				<% for(DanhMuc item : DanhMucDao.getDM()){
 					%>
 					<tr>
 	 				 <td><%= item.getMaDM() %></td>	
 	 				 <td><%= item.getTenDM() %></td>
 	 				 <td>
 	 				 	<a href="">Sửa</a>
 	 				 	<a href="">Xóa</a>
 	 				 </td>
 	 				</tr>
 				<% } %>
 				
 			</tbody>
 	</table>
</body>
</html>