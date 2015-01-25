package ma.eshop.nour.controller;

import javax.validation.Valid;

import ma.eshop.nour.entity.Category;
import ma.eshop.nour.entity.Product;
import ma.eshop.nour.service.CategoryService;
import ma.eshop.nour.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@ModelAttribute("product")
	Product prodConstruct() {

		return new Product();
	}

	@RequestMapping("/prod")
	String showProduct(Model model) { 

		model.addAttribute("categories", categoryService.findAll());

		model.addAttribute("products", productService.findAll());
		return "prod";
	}

	@RequestMapping(value = "/prod", method = RequestMethod.POST)
	String addCategory(@Valid @ModelAttribute("product") Product product,
			BindingResult result, Model m) {

		if (result.hasErrors()) {
			return "prod";
		}
		int catId = product.getCategory().getId();
		Category categoryOfProduct = categoryService.findById(catId);
		product.setCategory(categoryOfProduct);
		productService.save(product);
		m.addAttribute("categories", categoryService.findAll());
		return "redirect:/prod.html?CatOperation=success";
	}

}
