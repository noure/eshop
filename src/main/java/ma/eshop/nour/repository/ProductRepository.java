package ma.eshop.nour.repository;

import ma.eshop.nour.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	
}
