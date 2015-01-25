package ma.eshop.nour.repository;

import ma.eshop.nour.entity.Task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {

	Task findByTaskName(String taskName);
	//il y a des regle de nomer ces methode par exemple pour trouver un task par un attribue de sa classe on utiilise ByAtrribue 

}
