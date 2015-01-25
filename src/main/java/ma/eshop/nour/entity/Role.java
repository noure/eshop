package ma.eshop.nour.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity(name="role")
@Data
public class Role {

	@GeneratedValue
	@Id
	private int id;
	
	private String name;

	@ManyToMany(mappedBy="roles")
	List<User> users;
	


}
