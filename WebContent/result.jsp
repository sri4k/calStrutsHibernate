<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="S" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Calculator</title>
</head>
<body>
	<h2>Results</h2>
	<S:iterator value = "list" var = "calculator">
	
	</S:iterator>
	
	<table>
		<c:forEach items = "${list}" var = "calculator">
			<tr>
				<td><S:property value="number1"/></td>
				<td><S:property value="operator"/></td>
				<td><S:property value="number2"/></td>
				<td>  =  </td>
				<td><S:property value="result"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>