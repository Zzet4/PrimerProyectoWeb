package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_ROLP")
public class RolP {
	

		@Id
		@SequenceGenerator(name = "ROLGEN", sequenceName = "ROL_GEN", initialValue = 1, allocationSize = 1)
		@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ROLGEN")
		private int idRol;
		
		private String nombreRol;
		
		public RolP( ) {

		}
		public RolP(String nombreRol) {
			this.idRol = idRol;
			this.nombreRol = nombreRol;
		}
		public int getIdRol() {
			return idRol;
		}
		public void setIdRol(int idRol) {
			this.idRol = idRol;
		}
		public String getNombreRol() {
			return nombreRol;
		}
		public void setNombreRol(String nombreRol) {
			this.nombreRol = nombreRol;
		}
		@Override
		public String toString() {
			return "RolP [idRol=" + idRol + ", nombreRol=" + nombreRol + "]";
		}
		
		
		

}


