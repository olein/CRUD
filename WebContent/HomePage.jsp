<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page session="false" %>
<%@ page isThreadSafe="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>

<style>
body
{
background-color:#F5DEB3;
}
h1
{
color:#708090;
font-family:"Times New Roman";
text-align:center;
}
p
{
font-family:"Times New Roman";
font-size:20px;
}

a {text-decoration:none;} 

a:link {color:#4169E1;}      /* unvisited link */
a:visited {color:#4169E1;}  /* visited link */
a:hover {color:#FFFFFF;}  /* mouse over link */
a:active {color:#4169E1;}  /* selected link */ 

a:link {text-decoration:none;}
a:visited {text-decoration:none;}
a:hover {text-decoration:underline;}
a:active {text-decoration:none;}

a:link {background-color:#FFEBCD;}
a:visited {background-color:#FFEBCD;}
a:hover {background-color:#000000;}
a:active {background-color:#FFEBCD;} 

table
{
width:100%;
}
td
{
height:50px;
} 
td
{
text-align:center;
}
.my-dropdown-menu {
		margin: 0;
		padding: 0;
	}
	.my-dropdown-menu li {
		list-style: none;
		background-color: #333;
		float: left;
	}
	.my-dropdown-menu li a {
		margin: 0;
		padding: 7px 10px;
		color: #999;
		text-decoration: none;
		display: block;
	}
	/* style main menu when hovered */
	.my-dropdown-menu li a:hover {
		background-color: #444;
		color: blue;
	}
	/*  
	 * style the sub menu
	 */
	.my-dropdown-menu li ul {
		margin: 0;
		padding: 0;
		position: absolute;
		display: none;
	}
	.my-dropdown-menu li ul li {
		display: block;
		float: none; 
	}
	.my-dropdown-menu li ul li a {
		padding-right: 20px;
	}
	/* style sub menu when hovered */
	.my-dropdown-menu li ul li a:hover {
		color: red;
	}


	/* display submenu when main menu is hoverd */
	.my-dropdown-menu li:hover ul {
		display: block;
	}
	.my-dropdown-menu li:hover > a {
		background-color: #444;
	}


</style>

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
		</ul>
	</li>
	
	<li>
		<a href="<s:url action="Logout" />" >Logout</a>
	</li>
	
</ul>


<br/><br/><h1>Welcome</h1><br/>



</body>
</html>