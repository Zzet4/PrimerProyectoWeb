<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"> 
<title>Registrate</title>
<link rel="stylesheet" href="../../css/gestionUsuarios/registerPageStyle.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="../../js/gestionUsuarios/registerPageJQuery.js"></script>
</head>
<body>
    <!-- Body -->
    <p><a href="../../index.jsp"><img src="../../img/logos/homeButton.png" width="60px" height="80px"/></a></p>
  	<div class="container">
     <form method="post" action="/ProyectoWeb1/MainServlet?accion=register"
      autocomplete="on" id="formSubmitted">
     
     <!-- ROL -->
       	<div class="box">
        	<label for="rol" class="fl fontLabel"> Elija un ROL: </label>
    		<div class="new iconBox">
            	<i class="fa fa-user" aria-hidden="true"></i>
        	</div>
    		<div class="fr">
		     <select name="nombreRol" class="textBox" required autofocus onchange="">
		     	<option value="0">Seleccione un rol</option>
				<option value="usuario">Usuario</option>
				<option value="administrador">Administrador</option>
			</select>
		 </div>
    		<div class="clr"></div>
    	</div>
		 <br>
		 <!-- ROL --> 
	 	<!--Nombre Usuario-->
		<div>
      		<label for="Nombre_Usuario" class="fl fontLabel">  Nombre Usuario </label>
			<div class="new iconBox">
			<i class="fa fa-user" aria-hidden="true"></i></div>
			<div class="fr">
			<input type="text" required name="nombreUsuario"
						value="<%=request.getParameter("nombreUsuario")!=null?request.getParameter("nombreUsuario"):""%>"
          				placeholder="Nombre de Usuario" 
          				class="textBox"
          				id="campoNombre">
		</div>
			<div class="clr"></div>
		</div>
		<!--Nombre Usuario-->
		 
		  
        <!--Nombre-->
    	<div class="box">
        	<label for="Nombre" class="fl fontLabel"> Nombre: </label>
    		<div class="new iconBox">
            	<i class="fa fa-user" aria-hidden="true"></i>
        	</div>
    		<div class="fr">
    			<input type="text" name="nombre" 
    			value="<%=request.getParameter("nombre")!=null?request.getParameter("nombre"):""%>"
    			placeholder="Nombre"
             	class="textBox"  required>
    		</div>
    		<div class="clr"></div>
    	</div>
    	<!--Nombre-->

        <!--Apellido-->
    	  <div class="box">
          <label for="Apellido" class="fl fontLabel"> Apellido: </label>
    			<div class="fl iconBox"><i class="fa fa-user" aria-hidden="true"></i></div>
    			<div class="fr">
    					<input type="text" name="Apellido"
    					value="<%=request.getParameter("apellido")!=null?request.getParameter("apellido"):""%>"
              			placeholder="Apellido" 
              			class="textBox" required>
    	<!--Apellido-->
    		
    	<!--DNI-->
    		<div class="box">
          	<label for="DNI" class="fl fontLabel"> DNI: </label>
    			<div class="fl iconBox"><i class="numeric" ="true"></i></div>
    			<div class="fr">
    			<input type="text" 
    			required name="DNI" 
    			maxlength="10"
    			value="<%=request.getParameter("dni")!=null?request.getParameter("dni"):""%>"
              	placeholder="DNI" 
              	class="textBox">
    			</div>
    			<div class="clr"></div>
    		</div>
    	<!--DNI-->

		<!---Fecha de Nacimiento-->
    		<div class="box">
            <label for="fecha_Nacimiento" class="fl fontLabel"> Fecha Nacimiento </label>
    			<div class="fl iconBox"><i class="dateBoxText" aria-hidden="true"></i></div>
    			<div class="fr">
    				<input type="date" 
    					   required name="FechaDeNacimiento"
              				value="<%=request.getParameter("fechaNacimiento")!=null?request.getParameter("fechaNacimiento"):""%>"
              			   placeholder="Fecha de Nacimiento" 
              			   class="textBox">
    			</div>
    			<div class="clr"></div>
    		</div>
    	<!---Fecha de Nacimiento-->
    		

    	<!---TelÃ©fono-->
    		<div class="box">
          <label for="telefono" class="fl fontLabel"> Telefono.: </label>
    			<div class="fl iconBox"><i class="fa fa-phone-square" aria-hidden="true"></i></div>
    			<div class="fr">
    			<input type="text" required name="Telefono" maxlength="10" 
    			placeholder="Telefono" class="textBox">
    			</div>
    			<div class="clr"></div>
    		</div>
    		<!---Teléfono-->


    	<!---Email ---->
    		<div class="box">
          <label for="email" class="fl fontLabel"> Email: </label>
    			<div class="fl iconBox"><i class="fa fa-envelope" aria-hidden="true"></i></div>
    			<div class="fr">
    				<input type="email" required name="email" placeholder="Email" class="textBox">
    			</div>
    			<div class="clr"></div>
    		</div>
    		<!--Email ----->


    	<!---Contrasenia------>
    		<div class="box">
          <label for="contrasenia" class="fl fontLabel"> Contrasenia </label>
    			<div class="fl iconBox"><i class="fa fa-key" aria-hidden="true"></i></div>
    			<div class="fr">
    					<input type="Contrasenia" required name="contrasenia" 
    					placeholder="Contrasenia" class="textBox">
    			</div>
    			<div class="clr"></div>
    		</div>
    	<!---Contrasenia-->
    	
    	<!---Contrasenia------>
    		<div class="box">
          <label for="contrasenia2" class="fl fontLabel"> Confirmacion </label>
    			<div class="fl iconBox"><i class="fa fa-key" aria-hidden="true"></i></div>
    			<div class="fr">
    					<input type="Contrasenia2" required name="contrasenia2" 
    					placeholder="Confirmar Contrasenia" class="textBox">
    			</div>
    			<div class="clr"></div>
    		</div>
    	<!---Contrasenia-->

    	<!---Sexo-->
    		<div class="box radio">
          <label for="sexo" class="fl fontLabel"> Genero: </label>
    				<input type="radio" name="sexo" value="H" required
    				<%-- %>	<%=sexo.equals("Masculino")?"checked":"" %> --%>
    					> Masculino &nbsp; &nbsp;
    				<input type="radio" name="sexo" value="M" required 
    				<%--	<%=sexo.equals("Femenino")?"checked":"" %>--%>
    					> Femenino &nbsp; &nbsp;
    				<input type="radio" name="sexo" value="Otro" required
    				<%--	<%=sexo.equals("Otro")?"checked":"" %> --%>
    					> Otro
    		</div>
    	<!---Sexo-->


    	<!--Terminos y Condiciones de Uso -->
    		<div class="box terms">
				<!--https://terminosycondicionesdeusoejemplo.com/-->
    				<input type="checkbox" name="Terminos y Condiciones de Uso" required>
    				 &nbsp; Acepto los Terminos y Condiciones de Uso
    		</div>
    	<!--Terminos y Condiciones de Uso-->


    	<!---Submit ------>
    		<div class="box" style="background: rgb(35, 0, 70)">
    				<input type="Submit" name="Submit" class="submit" value="REGISTRARSE">
    		</div>
    		<br>
    		&nbsp;&nbsp;&nbsp;&nbsp;<a class="termsLink" href="#">* Consultar los Terminos y Condiciones de Uso </a>
    	<!---Submit----->
    	<!-- campoOculto/accion -->
    	<input type="accion" value="register" hidden="true" >
    	<!-- campoOculto/accion -->
      </form>
  </div>
  <!--Body --->
</body>
</html>