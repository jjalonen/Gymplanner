package com.example.Gymplanner.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Exercise {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;
	private double weight;
	private int set;
	private int rep;

	@ManyToOne
	@JsonIgnore

	@JoinColumn(name = "categoryId")
	private Category category;

	public Exercise() {
		super();
	}

	public Exercise(String title, double weight, int set, int rep, Category category) {
		super();
		this.title = title;
		this.weight = weight;
		this.set = set;
		this.rep = rep;
		this.category = category;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getSet() {
		return set;
	}

	public void setSet(int set) {
		this.set = set;
	}

	public int getRep() {
		return rep;
	}

	public void setRep(int rep) {
		this.rep = rep;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if (this.category != null)
			return "Exercise [title=" + title + ", weight= " + weight + ", set= " + set + ", rep= " + rep + "]"
					+ this.getCategory() + "]";
		else
			return "Exercise [title=" + title + ", weight= " + weight + ", set= " + set + ", rep= " + rep + "]";
	}
}
