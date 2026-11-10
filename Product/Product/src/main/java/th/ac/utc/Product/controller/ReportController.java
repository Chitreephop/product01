package th.ac.utc.Product.controller;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import th.ac.utc.Product.Service.ProductService;
import th.ac.utc.Product.model.Product;

@RestController
@RequiredArgsConstructor
public class ReportController {

    private final ProductService productService;
    private final NumberFormat priceFormatter;

    @GetMapping("/report")
    public Map<String, Object> report() {
        List<Product> all = productService.findAll();
        double total = all.stream().mapToDouble(Product::getTotalValue).sum();

        return Map.of(
                "count", all.size(),
                "totalValue", priceFormatter.format(total)
        );
    }
}