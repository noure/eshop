package ma.eshop.nour.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;
import ma.eshop.nour.validation.UniqueTaskname;


@Entity
@Setter
@Getter 
public class Task {

	@Id
	@GeneratedValue  
	private int id;
	
	@UniqueTaskname(message=" this task already exists ! ")
	@Size(min=3,message="the task name length must be at least 3 characters")
	private String taskName;
	
	@Lob
	@Type(type="org.hibernate.type.StringClobType")
	@Column(length=Integer.MAX_VALUE)
	private String taskDescription;
	
	@Column(nullable=false)
	private String taskPriority;
	
	private String taskStatus;
	
	private boolean taskArchived = false;



}
