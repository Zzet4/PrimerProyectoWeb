package Entities;


import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_USUARIOSP")
public class UsuarioP {
	
	@Id
	@SequenceGenerator(name = "USUARIOGEN", sequenceName = "USUARIOGEN", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "USUARIOGEN")
	private int idUsuarioP;
	
	@Column(length=30)
	private String nombre;
	
	@Column(length=40)
	private String apellidos;
	
	@Column(name="dniUsuario", length=9, unique = true)
	private String dni;
	
	@Column(length=10)
	private String sexo;
	
	private String password;
	
	@Column(length=40)
	private String email;
	
	@Column(length=10)
	private int telefono;
	
	private Date fechaNacimiento;
	
	@ManyToOne(targetEntity = RolP.class, fetch = FetchType.EAGER ,cascade= {CascadeType.ALL})
	//@JoinColumn(name = "FK_PERSONA", nullable = false, updatable = false)
    @JoinTable(name="TB_USUARIOS_ROLES")
    private RolP rol;

		

	//CONSTRUCTORES
	public UsuarioP() {
		super();
	}

	
	//CONSTRUCTOR COMPLETO
	public UsuarioP(String nombre, String apellidos, String dni, String sexo, String idUsuarioP, String contraseña,
		   String email, int telefono, Date fechaNacimiento, RolP rol) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sexo = sexo;
		this.password = contraseña;
		this.email = email;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.rol = rol;
	}

	
	//CONSTRUCTOR SIN ROL
	public UsuarioP(String idUsuarioP, String nombre, 
			String apellidos, String dni, 
			Date fechaNacimiento, 
			int telefono, String email, 
			String contraseña, String sexo
			){
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.email = email;
		this.password = contraseña;
		this.sexo = sexo;	
	}
	
	
	//CONSTRUCTOR SIN IDUSURARIO
	public UsuarioP(String nombre, String apellidos, String dni, String sexo, String contraseña,
			String email, int telefono, Date fechaNacimiento, RolP rol) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sexo = sexo;
		this.password = contraseña;
		this.email = email;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.rol = rol;
	}
	
	
	//GETTERS & SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getContraseña() {
		return password;
	}

	public void setContraseña(String contraseña) {
		this.password = contraseña;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public RolP getRol() {
		return rol;
	}

	public void setRoles(RolP rol) {
		this.rol = rol;
	}

	
	
	public int getIdUsuarioP() {
		return idUsuarioP;
	}


	//TO STRING
	@Override
	public String toString() {
		return "UsuarioP [idUsuarioP=" + idUsuarioP + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni
				+ ", sexo=" + sexo + ", contraseña=" + password + ", email=" + email + ", telefono=" + telefono
				+ ", fechaNacimiento=" + fechaNacimiento + ", rol=" + rol + "]";
	}
	




}
