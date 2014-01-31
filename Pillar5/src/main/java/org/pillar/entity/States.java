package org.pillar.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Index;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Size;


@Entity
@Table(name="5P_States")
public class States {

	private int stateId;
	private String stateName;
	private Set<Area> areas = new HashSet<Area>();
	
	
	public States(String stateName, Set<Area> areas) {
		super();
		this.stateName = stateName;
		this.areas = areas;
	}
	public States(String stateName) {
		super();
		this.stateName = stateName;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	
	@NotEmpty
	@NotNull
	@Size(min=3,message="State Name Cannot be so small")
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	public Set<Area> getAreas() {
		return areas;
	}
	public void setAreas(Set<Area> areas) {
		this.areas = areas;
	}
	
	
	
	
	
}
