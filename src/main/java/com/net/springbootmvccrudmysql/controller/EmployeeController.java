package com.net.springbootmvccrudmysql.controller;

import com.net.springbootmvccrudmysql.model.Employee;
import com.net.springbootmvccrudmysql.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String viewIndex(Model model) {
        List<Employee> employeeList = employeeService.getAll();
        model.addAttribute("employees", employeeList);
        System.out.println("Get /");
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("employees", new Employee());
        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employees") Employee employee) {
        employeeService.add(employee);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView EditEmployee(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit");
        Employee employee = employeeService.get(id);
        mav.addObject("employees", employee);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(name = "id") int id) {
        employeeService.delete(id);
        return "redirect:/";
    }

}
