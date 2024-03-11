package utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UtilsHibernate {
	//VAMOS A CREAR UNA CLASE DE UTILIDADES PARA HIBERNATE.
	//EN ESTA CLASE VAMOS A CREARNOS TODOS LOS ATRIBUTOS ESTÁTICOS PARA QUE SE INICIALICEN 
	//AUTOMÁTICAMENTE EN EL MOMENTO DEL ARRANQUE DEL PROGRAMA
	//LOS MÉTODOS BUSCAN CREAR UN OBJETO DE LA CLASE ENTITY MANAGER QUE UTILIZAREMOS PARA 
	//TRABAJAR CON HIBERNATE.
	
	
	
	//DEBEMOS CREAR EL ATRIBUTO PRIVATE STATIC FINAL QUE NECESITAREMOS PARA LOS MÉTODOS DE LA UTILIDAD.
	//AL SER ESTATICO SE CREA AL ARRANCAR LA APLICACIÓN Y LOS MÉTODOS QUE HAGAMOS ESTÁTICOS PODRÁN DISPONER
	//DEL ATRIBUTO TAMBIÉN AUTOMÁTICAMENTE AL ARRANCAR LA APLICACIÓN.
	
//	private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();
//	private String persistenceUnit;
	
	// CREAMOS EL MÉTODO QUE NOS GENERA EL ENTITY MANAGER FACTORY PARA PODER CREAR LUEGO EL ENTITY MANAGER Y TRABAJAR CON HIBERNATE.
	// LE PASAMOS DENTRO COMO LA PERSISTENCE UNIT QUE TENEMOS POR DEFECTO EN EL EJERCICIO 1. "HIBERNATE 1"
	
//	private static EntityManagerFactory buildEntityManagerFactory() {
//		return buildEntityManagerFactory("EjemploOracle");
//	}

	
	// OBRECARGAMOS EL MÉTODO QUE NOS CONSTRUYE EL ENTITY MANAGER FÁCTORY PASÁNDOLE AL MÉTODO EL PARAMETRO 
	// DE LA PERSISTENCE UNIT A LA QUE QUEREMOS QUE ACUDA HIBERNATE PARA VER SU CONFIGURACIÓN.
	public static EntityManager getEM(String persistenceUnit) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
		EntityManager em = emf.createEntityManager();		
		return em;
	}
	
	
	//MÉTODO PARA CREAR EL ENTITY MANAGER QUE UTILIZAREMOS PARA TRABAJAR CON HIBERNATE.
	
//	public static EntityManager getentityManager() {
//		return entityManagerFactory.createEntityManager();
//	}
	
}
