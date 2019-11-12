package com.aouini.ProductREST.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;


@Data
@Entity
@Table(name = "product")
public class Product
{
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private String name;
	@NotNull
	private String type;
	@NotNull
	private int price;
	@NotNull
	private int quantity;
	
	private String img;
	
	
	
	public Product() {}
	
	
	
	//Dummy Product Constructor
	public Product(Integer id, String name, String type, int price, int quantity, String img)
	{
		this.id = 0;
		this.name = "";
		this.type = "";
		this.price = 0;
		this.quantity = 0;
		this.img = "";
	}
	
	
	public boolean isValid()
	{
		return this.id != null    &&
			   this.name != null  &&
			   this.type != null  &&
			   this.price >= 0    &&
			   this.quantity >= 0  ;
	}
	
	
}
