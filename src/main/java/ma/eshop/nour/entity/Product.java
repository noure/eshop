package ma.eshop.nour.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import lombok.Data;
import ma.eshop.nour.validation.PositivePrice;

@Entity(name = "app_product")
@Data
public class Product {

	@GeneratedValue
	@Id
	private int id;
	
	@Size(min=3,message="the product name length must be at least 3 chars")
	private String name;
	
	@PositivePrice(message="the product's price must be positive ")
	private double price;
	
	
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
// je crois lombok n'arrive pas à ecrire getter et setter de category ici je vais faire un test sur la page 
	// de cat en listant les categories existant si ça marchera donc ici le probleme sinon c pas ici mais dans 
	// l'entite category ou autre chos
	//hibernate cherche bien les category de la base tu es sur q on a b1 configurer le lombok ?
	
	
	
}
