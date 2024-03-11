<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
	<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>HOME</title>
<link rel="stylesheet" href="css/indexMain.css">
<script type="text/javascript" src="./src/scripts/JQuery.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">

</head> 
<body>
    <header>
    <hr class="mt-5">
        <div class="botoneraLoginRegister mt-3">
         	<center><img src="img/logos/CapitalGaming.png"  width="180" height="55"></center>
			<a class="BotonRegistro" href="./html/gestionUsuarios/registerPage.jsp" ><img src="./img/logos/RegisterButton.png" width="140" height="50" align="right"></a>
			<a class="BotonInicioSesion" href="./html/gestionUsuarios/loginPage.html" ><img src="./img/logos/LogInButton2.png" width="138" height="54" align="right"></a><br>
		</div>
		<br>
		<div class="botoneraMGRusers">
			<a class="BotonDeleteUser" href="./html/gestionUsuarios/deletePage.html" ><img src="./img/logos/DeleteUserButton.png" width="65" height="65" align="right"></a>
      		<a class="BotonEditUser" href="/ProyectoWeb1/MainServlet?accion=editar" ><img src="./img/logos/EditUserButton.png" width="65" height="65" align="right"></a>
      		<a class="BotonAddUser" href="./html/gestionUsuarios/registerPage.jsp" ><img src="./img/logos/AddUserButton2.png" width="65" height="65" align="right"></a>
      		<a class="BotonSearchUser" href="/ProyectoWeb1/MainServlet?verLista=consultar" ><img src="./img/logos/SearchUserButton.png" width="65" height="65" align="right"></a>
		</div>
		   <div class="col-5">
				<br>
				<a href="html/galeria.html" class="btn btn-secondary galeria">GALERÍA</a>
				<a href="/html/indexPCgaming.html" class="btn btn btn-danger  galeria">PC-GAMING</a>
				<a href="html/indexXbox.html" class="btn btn-secondary galeria">XBOX</a>
				<a href="/html/indexNintendo.html" class="btn btn btn-danger  galeria">NINTENDO</a>
				<a href="html/indexPS.html" class="btn btn-secondary galeria">PLAY STATION</a>
				<a href=http://www.google.com class="btn btn btn-danger  galeria">GOOGLE</a>
		  </div>
       <hr class="mt-2">
    </header>

    <main>
     <div class="col-2 menu">
          <ul>
            <li class="cabecerasMenu"><a href="#" class="btn btn btn-danger  NOTDES">NOTICIAS DESTACADAS</a>
            	<ul class="listasAnidadas mt-2">
            		<li><a href="html/galeria.html" class="btn btn-outline-secondary galeria">Noticias Xbox</a></li>
            		<li class="mt-1"><a href="html/galeria.html" class="btn btn-outline-secondary galeria">Noticias Play Station</a></li>
            		<li class="mt-1"><a href="html/galeria.html" class="btn btn-outline-secondary galeria">Noticias Nintendo</a></li>
            	</ul>
            </li>
            <li class="cabecerasMenu mt-3" ><a href="#" class="btn btn btn-danger  ULTANA">ÚLTIMOS ANÁLISIS CAPITAL GAMING</a>
            	<ul class="listasAnidadas mt-2">
            		<li><a href="html/galeria.html" class="btn btn-outline-secondary galeria">Análisis Periféricos</a></li>
            		<li class="mt-1"><a href="html/galeria.html" class="btn btn-outline-secondary galeria">Análisis [CG]</a></li>
            		<li class="mt-1"><a href="html/galeria.html" class="btn btn-outline-secondary galeria">Análisis Usuarios</a></li>
            	</ul>
            </li>
            <li class="cabecerasMenu mt-3"><a href="#" class="btn btn btn-danger  RANTIT">RANKING DE TÍTULOS</a>
            	<ul class="listasAnidadas">
            		<li class="mt-1"><a href="html/galeria.html" class="btn btn-outline-secondary galeria">XBox</a></li>
            		<li class="mt-1"><a href="html/galeria.html" class="btn btn-outline-secondary galeria">Play Station</a></li>
            		<li class="mt-1"><a href="html/galeria.html" class="btn btn-outline-secondary galeria">Nintendo</a></li>
            	</ul>
            </li>
            <li class="cabecerasMenu mt-2"><a href="#" class="btn btn btn-danger  RANTIT">CERRAR SESIÓN</a></li>
          </ul>
       </div>
    <footer>
<!--         	campoOculto/accion -->
<!--     	<input type="accion" value="consultar" hidden="true" > -->
<!--     	campoOculto/accion -->
    		<div class="col-12">
				<figure class="text-center">
					<blockquote class="blockquote">
						<p>&copy; J053 LU15 P0R7473 813N</p>
					</blockquote>
					<figcaption class="blockquote-footer">
						<cite title="Título de la cita">tlf : H42 3L F4V0R</cite> --
					</figcaption>
						<figcaption class="blockquote-footer">
						<cite title="Título de la cita">C/ GR4C145 D3 4N73M4N0</cite> --
					</figcaption>
				</figure>
			</div>
	</footer> 
</body>
</html>