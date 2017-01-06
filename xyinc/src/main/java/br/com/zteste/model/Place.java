/**
 * 
 */
/**
 * @author arthur
 *
 */
package br.com.zteste.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="places")
public class Place {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull @Size(min=1, max=150)
	@Column(name = "name")
	private String name;
	
	@NotNull @Min(0) @Digits(integer=6, fraction=2)
	@Column(name = "x")
	private Double x;
	
	@NotNull @Min(0) @Digits(integer=6, fraction=2)
	@Column(name = "y")
	private Double y;

	public Place(Long id, String name, Double x, Double y) {
		this.id = id;
		this.name = name;
		this.x = x;
		this.y = y;
	}

	public Place() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

}