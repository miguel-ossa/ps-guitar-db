package com.guitar.db.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;

@Entity
@NamedNativeQuery(name = "Manufacturer.getAllThatSellAcoustics", 
		query = "SELECT m.id, m.name, m.foundedDate, m.averageYearlySales, m.location_id as headquarters_id, m.active "
	    + "FROM Manufacturer m "
		+ "LEFT JOIN Model mod ON (m.id = mod.manufacturer_id) "
		+ "LEFT JOIN ModelType mt ON (mt.id = mod.modeltype_id) "
	    + "WHERE (mt.name = ?)", resultClass = Manufacturer.class)
public class Manufacturer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String name;
	private Date foundedDate;
	private BigDecimal averageYearlySales;
	private Boolean active;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="MANUFACTURER_ID")
	private List<Model> models = new ArrayList<Model>();

	@ManyToOne
	private Location headquarters;

	public Boolean getActive() {
		return active;
	}

	public BigDecimal getAverageYearlySales() {
		return averageYearlySales;
	}

	public Date getFoundedDate() {
		return foundedDate;
	}

	public Location getHeadquarters() {
		return headquarters;
	}

	public Long getId() {
		return id;
	}

	public List<Model> getModels() {
		return models;
	}

	public String getName() {
		return name;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setAverageYearlySales(BigDecimal averageYearlySales) {
		this.averageYearlySales = averageYearlySales;
	}

	public void setFoundedDate(Date foundedDate) {
		this.foundedDate = foundedDate;
	}

	public void setHeadquarters(Location headquarters) {
		this.headquarters = headquarters;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setModels(List<Model> models) {
		this.models = models;
	}

	public void setName(String name) {
		this.name = name;
	}
}
