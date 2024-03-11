<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8" import="java.util.List,utils.Titulos,java.lang.String,Entities.UsuarioP,
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

<br/>
<p><a href="index.jsp"><img src="img/logos/homeButton.png" width="60px" height="80px"/></a></p>
<div class="container mt-3 text-center">
  <h1 class="display-5"><%=titulo%></h1>          
  <table class="table table-dark table-hover">
    <thead>
      <tr>
		<th>NOMBRE</th>
		<th>APELLIDOS</th>
		<th>DNI</th>	
		<th>SEXO</th>	
		<th>PASSWORD</th>	
		<th>TELEFONO</th>	
		<th>EMAIL</th>	
		<th>FEHCA NACIMIENTO</th>		
      </tr>
    </thead>
    <tbody>
        <%for (UsuarioP usuario : listaUsuarios){ %>
    <tr>
		<td><%=usuario.getNombre()%></td>
		<td><%=usuario.getApellidos()%></td>
		<td><%=usuario.getDni()%></td>
		<td><%=usuario.getSexo()%></td>
		<td><%=usuario.getContraseña()%></td>
		<td><%=usuario.getTelefono()%></td>
		<td><%=usuario.getEmail()%></td>
		<td><%=usuario.getFechaNacimiento()%></td>
	</tr>
	<% } %>	
    </tbody>
  </table>
</div>



</body>
</html>