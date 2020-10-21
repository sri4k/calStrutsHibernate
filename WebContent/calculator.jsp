<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="/struts-tags" prefix="S" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculator</title>
</head>
<body>
 <div align="center">
  <h1>Online Calculator</h1>
  <form>
   <table style="with: 80%">
    <tr>
     <td>Enter Number1</td>
     <td><input type="text" name="number1" /></td>
    </tr>
    <tr>
     <td>Enter an Operation [+, -, *, /]</td>
     <td><input type="text" name="operator" /></td>
    </tr>
    <tr>
     <td>Enter Number2</td>
     <td><input type="text" name="number2" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>