package pe.edu.upc.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Convocatoria")
public class Convocatoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", length = 50, nullable = false)
	private String name;
	
	@Column(name = "description", length = 50, nullable = false)
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dateStart", nullable = false)
	private Date dateStart;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dateFinish", nullable = false)
	private Date dateFinish;
	
	@Column(name = "tipolugartrabajo", length = 50, nullable = false)
	private String tipolugartrabajo;
	
	@Column(name = "address", length = 50, nullable = false)
	private String address;
	
	@Column(name = "tipoEmpleo", length = 50, nullable = false)
	private String tipoEmpleo;
	
	@ManyToOne
	@JoinColumn(name="idDistrito", nullable=false)
	private Distrito distrito;
	
	@ManyToOne
	@JoinColumn(name="idEmpresa", nullable=false)
	private Distrito empresa;

	public Convocatoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Convocatoria(int id, String name, String description, Date dateStart, Date dateFinish,
			String tipolugartrabajo, String address, String tipoEmpleo, Distrito distrito, Distrito empresa) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.dateStart = dateStart;
		this.dateFinish = dateFinish;
		this.tipolugartrabajo = tipolugartrabajo;
		this.address = address;
		this.tipoEmpleo = tipoEmpleo;
		this.distrito = distrito;
		this.empresa = empresa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateFinish() {
		return dateFinish;
	}

	public void setDateFinish(Date dateFinish) {
		this.dateFinish = dateFinish;
	}

	public String getTipolugartrabajo() {
		return tipolugartrabajo;
	}

	public void setTipolugartrabajo(String tipolugartrabajo) {
		this.tipolugartrabajo = tipolugartrabajo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTipoEmpleo() {
		return tipoEmpleo;
	}

	public void setTipoEmpleo(String tipoEmpleo) {
		this.tipoEmpleo = tipoEmpleo;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public Distrito getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Distrito empresa) {
		this.empresa = empresa;
	}
	
	
}