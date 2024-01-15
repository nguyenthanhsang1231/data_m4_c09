package com.example.demo_c09.controller;

import com.example.demo_c09.model.Product;
import com.example.demo_c09.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("list", productRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/add")
    public String showFormAdd() {
        return "/product/create";
    }

    @PostMapping("/add")
    public String add(Product product) {
        productRepository.save(product);
        return "redirect:/products";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("product/edit");
        modelAndView.addObject("item", productRepository.findById(id).get());
        return modelAndView;
    }
}
