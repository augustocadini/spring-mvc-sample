package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.Employee;

@Controller
public class SpringMVCHelloWorld {
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>Hello World, Spring MVC sample</h3>This message is coming from SpringMVCHelloWorld.java</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}
	
	@RequestMapping("/page1")
	public ModelAndView showPage1() {
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>Some argument</h3></div><br><br>";
		return new ModelAndView("page1", "message", message);
	}
	
	@GetMapping("/page2")
	public String showPage2(Model model) {
		model.addAttribute("attribute1","Argument 1");
		return "page2";
	}
	
	@RequestMapping("/page3")
	public ModelAndView showPage3() {
		return new ModelAndView();
	}
	
	// Employee
	@GetMapping("/employee")
	public ModelAndView showForm() {
		return new ModelAndView("employeeHome", "employee", new Employee());
	}
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String submit(@ModelAttribute("employee") Employee employee, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			return "error";
		}
		if (employee.getName().isEmpty()) {
			return "error";
		}
		if (employee.getContactNumber().isEmpty()) {
			return "error";
		}
		model.addAttribute("name",employee.getName());
		model.addAttribute("contactNumber",employee.getContactNumber());
		model.addAttribute("id",employee.getId());		
		return "employeeView";
	}
	
}


