<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page session="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" type="text/css" href="<s:url value="style_home.css"/>"/>

</head>
<body>
<% request.getSession().invalidate();%> 
<%
response.setHeader("Pragma","no-cache"); // HTTP 1.0
response.setHeader("Cache-Control","no-store"); // HTTP 1.1
response.setDateHeader("Expires", 0);
%> 



<ul class="my-dropdown-menu">
	<li><a href="Admin.jsp">Home</a></li>
	<li>
		<a href="">Account</a>
		<!-- sub menu for account -->
		<ul>
			
			<li><a href="<s:url action="UpdateAccount" />" >Update Account</a></li>
			<li><a href="<s:url action="DeleteAccount" />" >Delete Account</a></li>
			<li><a href="<s:url action="ListAccount" />" >Account List</a></li>
		</ul>
	</li>
	
	<li>
		<a href="<s:url action="Logout" />" >Logout</a>
	</li>
	
</ul>


<br/><br/><h1>Welcome Admin</h1>



</body>
</html>