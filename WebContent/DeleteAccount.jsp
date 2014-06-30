<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Delete Account</title>
<link rel="stylesheet" type="text/css" href="<s:url value="D:/XML/style2.css"/>"/>
</head>
<body>
<br></br>
 <br></br>
 <br></br>
<div align="center">
<b>Delete account:

<br/><br/>
Verify User Name and Password:</b><br/><br/>

<s:form action="AccountDeleteAction">
 
      <s:textfield name="name"  label ="Current User Name"/> 
      <s:password name="password"  label="Current Password"  />
      
      <s:submit/>

</s:form>

</div>

</body>
</html>