package com.gauravpathak.crm.controller;

import com.gauravpathak.crm.entity.Customer;
import com.gauravpathak.crm.repository.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {

    private CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/")
    public String customerList(Model model) {
        model.addAttribute("customers", repository.findAllByOrderByFirstNameAsc());
        return "customer-list";
    }

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        repository.save(customer);
        return "redirect:/";
    }

    @RequestMapping("/updateCustomer")
    public String updateCustomer(@RequestParam("customerId")Long customerId,Model model){
        model.addAttribute("customer",repository.findById(customerId));
        return "customer-form";
    }
    @RequestMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId")Long customerId){
        repository.deleteById(customerId);
        return "redirect:/";
    }
}
