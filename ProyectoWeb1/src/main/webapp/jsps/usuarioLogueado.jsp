<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8" import="java.util.List,Entities.UsuarioP,
    Entities.RolP"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>LISTADO DE USUARIOS</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/listadoUsuarios.css">
</head>
<body>

<%
	List<UsuarioP> listaUsuarios =  (List<UsuarioP>)request.getAttribute("AttUsuarios");
	String titulo = (String)request.getAttribute("titulitis");
%>
</table>
<br/>
<p><a href="index.jsp"><img src="img/logos/homeButton.png" width="60px" height="80px"/></a></p>
<div class="container mt-3">
	 <%String nombre = request.getParameter("nombreUsuarioLogueado");%>
  <center><h1 class="display-4"><%=titulo%></h1></center>   
  <br>
   <center><img src="img/logos/YouWin.jpg" width="600px" height="250px" border-radius="8%"></center>

</body>
</html>