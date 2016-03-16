<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Add/Edit Item</title>
	</head>
	<body>
		<div align="center">
			<h1>Add/Edit Item</h1>
			<form:form action="saveItem" method="post" modelAttribute="item">
				<table>
					<form:hidden path="id"/>
					<form:form method="POST" commandName="item" autocomplete="true">
					<tr>
						<td>Model:</td>
						<td>
							<ul>
								<form:select path="model">
									<form:option value="" label="--Select model"/>
									<form:option value="iPod">iPod</form:option>
									<form:option value="iWatch">iWatch</form:option>
									<form:option value="iPhone">iPhone</form:option>
									<form:option value="iPad">iPad</form:option>
									<form:option value="iMac">iMac</form:option>
								</form:select>
							</ul>
						</td>
						<td colspan="2" style="color: red; font-size: small;">
							<form:errors path="model"/>
						</td>
					</tr>
					<tr>
						<td>Memory:</td>
						<td>
							<ul>
								<form:select path="memory">
									<form:option value="" label="--Select memory"/>
									<form:option value="16GB">16GB</form:option>
									<form:option value="32GB">32GB</form:option>
									<form:option value="64GB">64GB</form:option>
									<form:option value="128GB">128GB</form:option>
								</form:select>
							</ul>
						</td>
						<td colspan="2" style="color: red; font-size: small;">
							<form:errors path="memory"/>
						</td>
					</tr>
					<tr>
						<td>Color:</td>
						<td>
							<ul>
								<form:select path="color">
									<form:option value="" label="--Select color"/>
									<form:option value="Black">Black</form:option>
									<form:option value="White">White</form:option>
									<form:option value="Gold">Gold</form:option>
								</form:select>
							</ul>
						</td>
						<td colspan="2" style="color: red; font-size: small;">
							<form:errors path="color"/>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit" value="Add to bucket"></td>
					</tr>
					</form:form>
				</table>
			</form:form>
		</div>
	</body>
</html>