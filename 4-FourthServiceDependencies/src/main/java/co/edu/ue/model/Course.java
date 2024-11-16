package co.edu.ue.model;

import java.util.ArrayList;

public class Course implements Cloneable{
	//1.Atributos -> nombres de atributos significativos
	//Atributos encapsulados
	private String name;
	private String description;
	private double duration;
	private double cost;
	
	//Constructor Generico
	public Course(String name, String description, double duration, double cost) {
		super();
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.cost = cost;
	}
	
	//3.Metodos de acceso

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

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	

	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		try {
			return super.clone();
		} catch (Exception e) {
			return new Course(this.name,this.description,this.duration,this.cost);
		}
		
	}

	@Override
	public String toString() {
		return "Course [name=" + name + ", description=" + description + ", duration=" + duration + ", cost=" + cost
				+ "]";
	}


		
}


