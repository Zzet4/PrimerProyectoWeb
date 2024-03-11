package DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Entities.UsuarioP;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import utils.JpaUtil;
import utils.LogTest;
import utils.UtilsHibernate;


public class UsuarioDAOP {

	private EntityManager em;
	private static final Logger LOGGER = LogManager.getLogger(LogTest.class);
	
	public UsuarioDAOP() {
		em = JpaUtil.getEM("ProyectoFinalPablo");
	}
	
	// MÉTODOS DE INTERACCIÓN CON LA BASE DE DATOS.
	
	//METODO PARA VALIDAR UN USUARIO
	public UsuarioP consultaUsuario(String nombre, String password) {
		UsuarioP usuario = null;
		LOGGER.info("Entramos en el metodo consultar usuario del DAO");
		Query query = em.createQuery("from UsuarioP where nombre=?1 and password=?2", UsuarioP.class);
        query.setParameter(1, nombre);
        query.setParameter(2, password);
        //query.setMaxResults(1);
        //em.close();
        
        try {
        	 usuario = (UsuarioP)query.getSingleResult();
             if(usuario.getNombre().equalsIgnoreCase(nombre) && 
            	 usuario.getContraseña().equalsIgnoreCase(password)) {
	        	 LOGGER.info("Usuario devuelto correctamente");
	        }
             return usuario;	
        } catch (Exception ex) {
       	 LOGGER.info("Usuario no encontrado");
        	return usuario;
        }
        

    
	}
	
	//METODO PARA BUSCAR TODOS LOS USUARIOS
	public List<UsuarioP> consultarTodosUsuarios() {
		List<UsuarioP> listadoUsuarios = new ArrayList();
		
		Query query = em.createQuery("from UsuarioP", UsuarioP.class);
        //em.close();
        return listadoUsuarios = query.getResultList();
	}
	
	
	//METODO PARA INSERTAR UN USUARIOS
	public void insertaUsuario(UsuarioP usuario) {
		 LOGGER.info("Entramos en el metodo insertar usuario del DAO");
		 em.getTransaction().begin();
		 try {
			 em.persist(usuario);
			 em.getTransaction().commit();
			 LOGGER.info("Se ha insertado el usuario correctamente");
		 }catch(Exception e) {
			 e.printStackTrace();
			 em.getTransaction().rollback();
			 LOGGER.info("No se ha podido insertar el usuario");
		 }
		 //em.close();
	}
		
	public void borraUsuarioID(int id) {
	
        EntityManager em = JpaUtil.getEM("hibernateMySQL");
        try {
            UsuarioP usuario = em.find(UsuarioP.class, id);
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
	}
	
	public String borraUsuario(String nombre, String password) {
		UsuarioP usuario;
		String msg = "default";
		 LOGGER.info("Entramos en el metodo borrarUsuario usuario del DAO");
		Query query = em.createQuery("from UsuarioP where nombre=?1 and password=?2", UsuarioP.class);
        query.setParameter(1, nombre);
        query.setParameter(2, password);
        //query.setMaxResults(1);
        //em.close();
        usuario = (UsuarioP)query.getSingleResult();
        try {
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();
            msg = "deleteOk";
        } catch (Exception e) {
            em.getTransaction().rollback();
            msg = "deleteFail";
            e.printStackTrace();
        }
		LOGGER.info("Usuario borrado correctamente");
        return msg;
	}
	
	public void editarUsuario( UsuarioP usuarioModificado ) {
		insertaUsuario(usuarioModificado);
		
	}
	
	
}
