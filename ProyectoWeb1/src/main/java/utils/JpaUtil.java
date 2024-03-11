package utils;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil { 
    private static EntityManager em = null;


    public static void getEM(){ 
    	getEM("ProyectoFinalPablo");
    }
    
    public static EntityManager getEM (String persistenceUnit) {
    	System.out.println("Entramos en el getEM con parametro");
    	if(em==null) {
    		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
    		em = emf.createEntityManager();
    		System.out.println("Ya tenemos el EM");
    	}else {System.out.println("Ya teniamos de antes el EM");}
    	
    	return em;
    }
}
