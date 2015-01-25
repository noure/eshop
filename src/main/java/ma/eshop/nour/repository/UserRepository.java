package ma.eshop.nour.repository;

import ma.eshop.nour.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Integer> {

}
