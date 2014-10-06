<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Welcome to system</title>
<style type="text/css">
body {background-color: #444444}
</style>

</head>
<body>
<% request.getSession().invalidate();%> 
<%
response.setHeader("Pragma","no-cache"); // HTTP 1.0
//response.setHeader("Cache-Control","no-store"); // HTTP 1.1
response.setDateHeader("Expires", 0);
%> 

<br></br>
<div align="center" style="border:2px solid;border-radius:25px">
<h1><strong>CRUD System</strong></h1>
 </div>
 <br></br>
 <br></br>
 <br></br>
 <div align="center">
 <h3>Login</h3>
<s:form action="Login" method="POST">
 
      <s:textfield name="name"  label ="User email"/> 
      <s:password name="password"  label="Password"  />
             
      <s:submit label="Login"/>

</s:form>

<a href="<s:url action="createAccount" />" >Create New Account</a>

</div>
 
</body>
</html>
 
 
