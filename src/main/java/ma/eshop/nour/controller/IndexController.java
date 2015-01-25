package ma.eshop.nour.controller;

import ma.eshop.nour.service.CategoryService;
import ma.eshop.nour.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	
	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;
	@RequestMapping("/index")
	public String index(Model model) {
		
		model.addAttribute("products", productService.findAll());
		return "index";
	}

}
