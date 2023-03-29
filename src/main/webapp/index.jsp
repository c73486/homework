<%@page import="java.util.List"%>
<%@page import="homework.model.seek"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page session="true" %>
<% 
	request.setCharacterEncoding("UTF-8");
    List<seek> l = (List<seek>)session.getAttribute("s");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Seek</title>
</head>
<body>
	<form action="seek" method="post">
			<tr>多筆查詢<br>
			<tr><input type="text" name="name"> <input type="submit" value="查詢">
	</form><br>
	<legend>查詢結果</legend>
		<table border="1">
		<thead>
			<tr>
				<th style="align-items: center;">ID</th>
				<th style="align-items: center;">商品名稱</th>
				<th style="align-items: center;">價格</th>
				<th style="align-items: center;">數量</th>
			</tr>
		</thead>
		<tbody>
			<% if(l != null){ %>
				<% for(int i=0;i<l.size();i++){ %>
					<tr> 
					<td style="align-items: center;"><%= l.get(i).getId() %></td>
					<td style="align-items: center;"><%= l.get(i).getName() %></td>
					<td style="align-items: center;"><%= l.get(i).getPrice() %></td>
					<td style="align-items: center;"><%= l.get(i).getRemain() %></td>
					</tr>
				<% } %>
			<% } %>
		</tbody>
			
		</table>
</body>
</html>