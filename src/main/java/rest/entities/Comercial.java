package rest.entities;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "comerciales")
@NamedQuery(name = "Comercial.findAll", query = "SELECT c FROM Comercial c")
public class Comercial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "id_comercial")
	private int idComercial;

	private String apellido1;
	private String apellido2;
	private double comision;
	private String nombre;

}