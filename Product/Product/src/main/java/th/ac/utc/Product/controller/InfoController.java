package th.ac.utc.Product.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    private final String shopName;
    private final double vatRate;
    private final Environment env;

    public InfoController(@Value("${shop.name}") String shopName,
                          @Value("${shop.vat-rate}") double vatRate,
                          Environment env) {
        this.shopName = shopName;
        this.vatRate = vatRate;
        this.env = env;
    }

    @GetMapping("/info")
    public Map<String, Object> info() {
        return Map.of(
                "shopName", shopName,
                "vatRate", vatRate,
                "profiles", env.getActiveProfiles()
        );
    }
}