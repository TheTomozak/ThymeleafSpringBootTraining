package pl.tomozak.warsztaty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.tomozak.warsztaty.models.Product;
import pl.tomozak.warsztaty.services.ProductService;


@Controller
class ProductController {


    private ProductService productService;


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/hello")
    public String sayMyName(Model model, @RequestParam(required = false, defaultValue = "Heisenberg") String name ){
        model.addAttribute("name", name);
        return "helloName";
    }


    @GetMapping("/getProducts")
    public String getProducts(Model model){
        model.addAttribute("productLists", productService.showListOfProduct());
        return "listProducts";
    }




}
