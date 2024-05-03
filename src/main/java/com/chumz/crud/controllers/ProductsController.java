package com.chumz.crud.controllers;

import com.chumz.crud.models.Product;
import com.chumz.crud.models.ProductDto;
import com.chumz.crud.services.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping({"", "/"})
    public String showProductList(Model model) {
        List<Product> products = productRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
        model.addAttribute("products", products);
        return "products/index";
    }

    @GetMapping("/create")
    public String showCreatedPage(Model model) {
        ProductDto productDto = new ProductDto();
        model.addAttribute("products", productDto);
        return "products/createProduct";
    }

}
