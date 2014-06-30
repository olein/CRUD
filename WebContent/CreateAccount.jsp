<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

<title>Create New Account</title>
<style type="text/css">
body {background-color: #F5DEB3}
</style>

</head>
<body>
<br></br>
 <br></br>
 <br></br>
<div align="center">
 <b>Please Enter User Name And Password:</b><br/><br/>
 
 <s:form action = "AccountCreateAction">

  	  <s:textfield name="name"  label ="User Name"/> 
      <s:password name="password"  label="Password"  />
      <s:password name="passwordConfirm"  label="Confirm Password"  />
      
       
    <s:submit/>

 </s:form>
 
 </div>
 </body>
 </html>
