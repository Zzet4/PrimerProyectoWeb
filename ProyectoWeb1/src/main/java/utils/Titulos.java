package utils;

public enum Titulos {

	   	PRIMERO("[-LISTADO USUARIOS-]"),
	    SEGUNDO("[-BIENVENIDO-]"),
	    TERCERO("[-USUARIO BORRADO CON EXITO-]"),
	    CUARTO("[-USUARIO O CONTRASEÑA INCORRECTOS-]");

	    private final String descripcion;

	    Titulos(String descripcion) {
	        this.descripcion = descripcion;
	    }

	    public String getDescripcion() {
	        return descripcion;
	    }
}
