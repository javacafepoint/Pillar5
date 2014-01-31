package org.pillar.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Size;

@Entity
@Table(name="5P_Area")
public class Area {
	
	private int areaId;
	private String areaName;
	private States state;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getAreaId() {
		return areaId;
	}
	
	@NotEmpty
	@NotNull
	@Size(min=3,message="Area Name Cannot be so small")
	public String getAreaName() {
		return areaName;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stateId", nullable = false)
	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	
	

}