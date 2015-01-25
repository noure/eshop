package ma.eshop.nour.service;

import java.util.List;

import javax.transaction.Transactional;

import ma.eshop.nour.entity.Category;
import ma.eshop.nour.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional //oooh ce n'est pas le cas how stupid am i -_-hhhhhh
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public void save(Category category) {
		categoryRepository.save(category);
	}

	public List<Category> findAll() {

		return categoryRepository.findAll();
	}

	public Category findByName(String name) {
	
		return categoryRepository.findByName(name);
	}

	public Category findById(int catId) {
		return categoryRepository.findOne(catId);
	}

}
