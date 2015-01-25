package ma.eshop.nour.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity(name = "app_user")
@Data
public class User {

	@GeneratedValue
	@Id
	private int id;
	
	private String name;
	
	private String password;

	boolean enabled;
	
	@ManyToMany
	@JoinTable
	List<Role> roles;
	
	
	

}
