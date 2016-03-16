<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Bucket</title>
    </head>
    <body>
    	<div align="center">
	        <h1>Items in bucket</h1>
	        <h3><a href="newItem">Add new item</a></h3>
	        <table border="1">
	        	<th>No</th>
	        	<th>Model</th>
	        	<th>Memory</th>
	        	<th>Color</th>
	        	<th>Action</th>
	        	
				<c:forEach var="item" items="${listItem}" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>${item.model}</td>
						<td>${item.memory}</td>
						<td>${item.color}</td>
						<td>
							<a href="editItem?id=${item.id}">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="deleteItem?id=${item.id}">Delete</a>
						</td>
					</tr>
				</c:forEach>	        	
			</table>
    	</div>
    </body>
</html>