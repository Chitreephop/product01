package th.ac.utc.Product.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import th.ac.utc.Product.model.Product;
import th.ac.utc.Product.Service.InMemoryProductService;
import th.ac.utc.Product.Service.ProductService;

@RestController
public class Productcontroller {

    //private final ProductService productService = new InMemoryProductService();
    private final ProductService productService;

    public Productcontroller(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> list() {
        return productService.findAll();
    }

    @GetMapping("/product")
    public Product one(@RequestParam Long id) {
        return productService.findById(id).orElse(null);
    }

    @GetMapping("/products/search")
    public List<Product> searchProducts(@RequestParam String keyword) {
        return productService.findByName(keyword);
    }

    @GetMapping("/products/add")
    public Product add(@RequestParam String name,
                       @RequestParam double price,
                       @RequestParam int stock) {
        return productService.save(new Product(null, name, price, stock));
    }
}
