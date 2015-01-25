package ma.eshop.nour.repository;

import ma.eshop.nour.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Category findByName(String name);
	 // voir la couche DAO ne contien que des interfaces je n'ai ecris aucun aucun code ici tout est généré par springDATA JPA 
	
}
