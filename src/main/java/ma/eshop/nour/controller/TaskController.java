package ma.eshop.nour.controller;

import javax.validation.Valid;

import ma.eshop.nour.entity.Task;
import ma.eshop.nour.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TaskController {
	// mais attention HAfida ce code ne suit pas les bonnes pratiques par exemple faut pas ecrire des string comme ça dans le vide 
	

	@Autowired
	TaskService taskService;

	@RequestMapping("/task")// apres je vais regrouper ces entrer de requestmapping dans une interface s'appelle ROute
	String addTask(Model model) {
		init(model);
		return "task";// ici we return the views for exemple because i am nothing any resftful api so it s better to use as before a VIEWS interface ainsi le code sera cleaaan ok et y pas de commentaire si tu vois :p 
		// car je vais factoriser mnt tout ça et utiliser une biblio pour rendre le code bien propre par exemple les getter et setter je ne vais pas à chaquer fois les generer remqarque 
	}

	public void init(Model model) {

		String[] stt = new String[] { "ACTIVE", "SUSPENDED", "DESACTIVE" };
		String[] pr = new String[] { "HIGHT", "MEDIUM", "LOW" };

		model.addAttribute("priorities", pr);
		model.addAttribute("stt", stt);
		model.addAttribute("tasks", taskService.findAll());
	}

	@ModelAttribute("task")
	Task taskConstruct() {
		return new Task();
	}

	@RequestMapping(value = "/task.do", method = RequestMethod.POST)
	String actionTask(@Valid @ModelAttribute("task") Task task,
			BindingResult result, @RequestParam String action, Model model) {
		if (result.hasErrors()) {
			return "task";
		}
		Task resultTask;
		switch (action.toLowerCase()) {
		case "add":
			taskService.add(task);
			resultTask = task;
			init(model);
			model.addAttribute("task", resultTask);
			return "redirect:/task.html?add=succes";
		case "edit":
			taskService.update(task);
			System.out.println("id task editing = " + task.getId());
			resultTask = task;
			init(model);
			model.addAttribute("task", resultTask);
			return "redirect:/task.html?update=succes";

		case "delete":
			taskService.delete(task.getId());
			init(model);
			return "redirect:/task.html?delete=succes";

		case "search":
			Task searchedTask = taskService.findByTaskName(task.getTaskName());
			init(model);
			resultTask = searchedTask != null ? searchedTask : new Task();
			model.addAttribute("task", resultTask);
			return "task";
		}
		return null;
	}

	@RequestMapping("/task/available")
	@ResponseBody
	public String isAvailable(@RequestParam String taskName) {

		Boolean available = taskService.findByTaskName(taskName) == null;
		return available.toString();

	}

}
