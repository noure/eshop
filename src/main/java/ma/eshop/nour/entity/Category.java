package ma.eshop.nour.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity(name = "app_category")
@Data
public class Category {
/**bla bla
*/


	


	@Override
	public String toString() {
		return this.name;
}


	@GeneratedValue
	@Id
	private int id;
	@Size(min=3,message="the category name length must be at least 3 chars")
	private String name;
	
	
	@Size(min=5, message="the category description must be at least 5 chars")
	@Column(length=Integer.MAX_VALUE)
	private String description;
	
	
	@OneToMany(mappedBy="category", cascade=CascadeType.ALL)
	private List<Product> products;// ca exiiiiiiiiiiiiiste j'ai rien supprimé 


	
}
