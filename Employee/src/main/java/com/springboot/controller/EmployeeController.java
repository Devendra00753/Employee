package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.springboot.model.Employee;
import com.springboot.service.EmployeeService;


@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/home1")
	public String getHome(){
		
		return "home";
		
	}
	// @GetMapping("/newPage")
	// public String newm(Model model){
	// 	return "Home";
	// }
	
	@GetMapping("/employees")
	public String getEmployees(Model model){
		model.addAttribute("employees",employeeService.getEmployeDetails());
		return "Employees";
	}
	
	@GetMapping("/employees/{id}")
	public String getEmployeesById(@PathVariable("id") Long id,Model model){
		model.addAttribute("employees",employeeService.getEmployeDetails());
		return "Employees";
	}
	
	
	@RequestMapping("/delete/{id}")
	public String delEmployees(@PathVariable("id") Long id,Model model) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
		
	}
	
	@GetMapping("/edit/{id}")
	public String editEmployee(@PathVariable Long id, Model model) {
		  model.addAttribute("employee",employeeService.getEmployeeById(id));
		  return "Edit";
		
	}
	
	@RequestMapping("/update/{id}")
	public String updateEmployee(@PathVariable Long id,@ModelAttribute("employee") Employee employee ,Model model) {
		model.addAttribute("employee", employeeService.updateEmployee(employee,id));
		return "redirect:/employees";
		
	}
	
	@RequestMapping("/createEmployee")
	public String createEmployee(Model model) {
		Employee employee=new Employee();
		model.addAttribute("newEmployee", employee);
		return "Add";
	}
	
	@RequestMapping("/add")
	public String addEmployee(@ModelAttribute("employee") Employee employee,Model model) throws Exception {
		
		model.addAttribute("newEmployee", employeeService.addEmployee(employee));
		return "redirect:/employees";
		
	}
	
}
