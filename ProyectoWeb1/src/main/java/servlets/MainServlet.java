package servlets;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import DAO.UsuarioDAOP;
import Entities.RolP;
import Entities.UsuarioP;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.LogTest;
import utils.Titulos;
/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LogManager.getLogger(LogTest.class);
       
    /** 
     * @see HttpServlet#HttpServlet() 
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		LOGGER.info("Entrando en el servlet por consultar");
		//CREACIÓN DEL DAO PARA MOSTRAR EN JSP LISTADO USUARIOS
		UsuarioDAOP userDAO = new UsuarioDAOP();
		

		List<UsuarioP> listaUsuarios = userDAO.consultarTodosUsuarios();
		
		request.setAttribute("AttUsuarios", listaUsuarios);
		RequestDispatcher rd = request.getRequestDispatcher("jsps/listadoUsuarios.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Entramos en el post");
		String campoOculto = request.getParameter("accion");
		
		
//LOGICA PARA INSERCIÓN DE USUARIOS			
		if (campoOculto.equalsIgnoreCase("register")) {
			LOGGER.info("Entramos en el servlet por el register");
			
			//RECOLECCIÓN DE PARAMETROS DEL FORMULARIO
			String objetoRol = request.getParameter("nombreRol");
			//String idUsuarioP = request.getParameter("nombreUsuario");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("Apellido");
			String dni = request.getParameter("DNI");
			RolP rol = new RolP(objetoRol);
			String fechaNacimiento =  request.getParameter("FechaDeNacimiento");
			SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); 
			Date fecha = null;
			try {
				fecha = formato.parse(fechaNacimiento);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			int telefono = Integer.parseInt(request.getParameter("Telefono"));
			String email = request.getParameter("email");
			String contrasenia = request.getParameter("contrasenia");
			String sexo = request.getParameter("sexo");
	
			//CREACIÓN DEL ENTITY
			UsuarioP usuarioAaniadir = new UsuarioP(nombre, apellido, dni, sexo, contrasenia, email, telefono, fecha, rol);
			
			//CREACIÓN DEL DAO E INSERCION EN BBDD
			UsuarioDAOP userDAO = new UsuarioDAOP();
			userDAO.insertaUsuario(usuarioAaniadir);
			LOGGER.info("invocamos al método insertar usuario desde el servlet con el DAO");
			
			List<UsuarioP> listaUsuarios = userDAO.consultarTodosUsuarios();
			//String titulo = Titulos.LISTADO;
	        Titulos valorSeleccionado = Titulos.PRIMERO;
	        String descripcion = valorSeleccionado.getDescripcion();
			request.setAttribute("titulitis", descripcion);
			request.setAttribute("AttUsuarios", listaUsuarios);
			RequestDispatcher rd = request.getRequestDispatcher("jsps/listadoUsuarios.jsp");
			rd.forward(request, response);
		
			
//LOGICA PARA LOGIN DE USUARIOS			
		}else if(campoOculto.equalsIgnoreCase("login")){
			LOGGER.info("Entramos en el servlet por el login");
			
			//RECOLECCIÓN DE PARAMETROS DEL FORMULARIO
			String nombre = request.getParameter("nombreUsuario");
			String password = request.getParameter("contrasenia");
			
			//CREACIÓN DEL DAO Y BUSQUEDA EN BBDD
			UsuarioDAOP userDAO = new UsuarioDAOP();
			UsuarioP usuarioEncontrado = userDAO.consultaUsuario(nombre, password);
			System.out.println(usuarioEncontrado);
			if(usuarioEncontrado==null) {
				LOGGER.info("Usuario no encontrado");
				List<UsuarioP> listaUsuarios = userDAO.consultarTodosUsuarios();
				String nombreUsuarioLogueado = nombre;
		        Titulos valorSeleccionado = Titulos.CUARTO;
		        String descripcion = valorSeleccionado.getDescripcion();
				request.setAttribute("titulitis", descripcion);
				request.setAttribute("AttUsuarios", listaUsuarios);
				RequestDispatcher rd = request.getRequestDispatcher("jsps/usuarioNoLogueado.jsp");
				rd.forward(request, response);
			}else{
				if(usuarioEncontrado.getNombre().equalsIgnoreCase(nombre) && 
						usuarioEncontrado.getContraseña().equalsIgnoreCase(password)) {
					LOGGER.info("Usuario validado correctamente. Bienvenido");
					List<UsuarioP> listaUsuarios = userDAO.consultarTodosUsuarios();
			        Titulos valorSeleccionado = Titulos.SEGUNDO;
			        String descripcion = valorSeleccionado.getDescripcion();
					request.setAttribute("titulitis", descripcion);
					request.setAttribute("AttUsuarios", listaUsuarios);

					RequestDispatcher rd = request.getRequestDispatcher("jsps/usuarioLogueado.jsp");
					rd.forward(request, response);
					//INSERTAR AQUÍ EL JSP DE USUARIO VALIDADO CORRECTAMENTE.
				}else {
					List<UsuarioP> listaUsuarios = userDAO.consultarTodosUsuarios();
					String nombreUsuarioLogueado = nombre;
					request.setAttribute("AttUsuarios", listaUsuarios);
					request.setAttribute("nombre", nombreUsuarioLogueado);
					RequestDispatcher rd = request.getRequestDispatcher("jsps/usuarioNoLogueado.jsp");
					rd.forward(request, response);
					
					LOGGER.info("El nombre de usuario o contraseña no son correctos");
				
				}
			}
			
			
//LOGICA PARA BORRADO DE USUARIOS
		}else if(campoOculto.equalsIgnoreCase("delete")){
			LOGGER.info("Entramos en el servlet por el delete");
			
			//RECOLECCIÓN DE PARAMETROS DEL FORMULARIO
			String nombre = request.getParameter("nombreUsuario");
			String password = request.getParameter("contrasenia");
			
			//CREACIÓN DEL DAO Y BORRADO EN BBDD
			UsuarioDAOP userDAO = new UsuarioDAOP();
			String msgBorrado = userDAO.borraUsuario(nombre, password);
			LOGGER.info("invocamos al método borrar usuario desde el servlet con el DAO");
			
			if (msgBorrado.equalsIgnoreCase("deleteOk")) {
				LOGGER.info("El usuario ha sido borrado correctamente");
				List<UsuarioP> listaUsuarios = userDAO.consultarTodosUsuarios();
		        Titulos valorSeleccionado = Titulos.TERCERO;
		        String descripcion = valorSeleccionado.getDescripcion();
				request.setAttribute("titulitis", descripcion);
				request.setAttribute("AttUsuarios", listaUsuarios);
				RequestDispatcher rd = request.getRequestDispatcher("jsps/usuarioBorrado.jsp");
				rd.forward(request, response);
				//INSERTAR AQUÍ EL JSP DE DELETE OK.
				
			}else if(msgBorrado.equalsIgnoreCase("deleteFail")) {
				LOGGER.info("El usuario no se ha podido eliminar");
				List<UsuarioP> listaUsuarios = userDAO.consultarTodosUsuarios();
				request.setAttribute("AttUsuarios", listaUsuarios);
				RequestDispatcher rd = request.getRequestDispatcher("jsps/usuarioNoBorrado.jsp");
				rd.forward(request, response);
				//INSERTAR AQUÍ EL JSP DE DELETE FAIL.
				
			}else {	
				LOGGER.info("Ha ocurrido un error");
			}
	
			
//LOGICA PARA LA MODIFICACIÓN DE USUARIOS			
		}else if(campoOculto.equalsIgnoreCase("update")){
			LOGGER.info("Entramos en el servlet por el update");
			
			
			
			//RECOLECCIÓN DE PARAMETROS DEL FORMULARIO
			String objetoRol = request.getParameter("nombreRol");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("Apellido");
			String dni = request.getParameter("DNI");
			RolP rol = new RolP(objetoRol);
			String fechaNacimiento =  request.getParameter("FechaDeNacimiento");
			SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); 
			Date fecha = null;
			try {
				fecha = formato.parse(fechaNacimiento);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			int telefono = Integer.parseInt(request.getParameter("Telefono"));
			String email = request.getParameter("email");
			String password = request.getParameter("contrasenia");
			String sexo = request.getParameter("sexo");
			
			//CREACIÓN DEL DAO Y BUSQUEDA Y BORRADO EN BBDD
			UsuarioDAOP userDAO = new UsuarioDAOP();
			UsuarioP usuarioOriginal = userDAO.consultaUsuario(nombre, password);
			int idUsuarioOriginal = usuarioOriginal.getIdUsuarioP();
			userDAO.borraUsuarioID(idUsuarioOriginal);
			UsuarioP usuarioAModificar = new UsuarioP(nombre, apellido, dni, sexo, password, email, telefono, fecha, rol);
			
			try {
				//em.getTransaction().begin();
				usuarioAModificar.setRoles(rol);
				usuarioAModificar.setNombre(nombre);
				usuarioAModificar.setApellidos(apellido);
				usuarioAModificar.setDni(dni);
				usuarioAModificar.setFechaNacimiento(fecha);
				usuarioAModificar.setTelefono(telefono);
				usuarioAModificar.setEmail(email);
				usuarioAModificar.setContraseña(password);
				usuarioAModificar.setSexo(sexo);
			    //em.getTransaction().commit();
				LOGGER.info("El usuario ha sido modificado correctamente");
			}catch (Exception e){
	            //em.getTransaction().rollback();
				LOGGER.info("El usuario no ha podido ser modificado");
	            e.printStackTrace();
			}
			userDAO.editarUsuario(usuarioAModificar);
		}else if (request.getParameter("verLista").equalsIgnoreCase("consultar")) {
			LOGGER.info("Entrando en el servlet por consultar");
			//CREACIÓN DEL DAO PARA MOSTRAR EN JSP LISTADO USUARIOS
			UsuarioDAOP userDAO = new UsuarioDAOP();
			
	
			List<UsuarioP> listaUsuarios = userDAO.consultarTodosUsuarios();
			
			request.setAttribute("AttUsuarios", listaUsuarios);
			RequestDispatcher rd = request.getRequestDispatcher("jsps/listadoUsuarios.jsp");
			rd.forward(request, response);
		
			
			
		}
	}
}
