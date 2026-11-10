package th.ac.utc.Product.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import th.ac.utc.Product.model.Product;
import org.springframework.stereotype.Service;
@Service
public class InMemoryProductService implements ProductService {
    private final List<Product> products = new ArrayList<>();
    private long nextId = 1;
    public InMemoryProductService() {
        save(new Product(null, "เมาส์ไร้สาย", 390.0, 25));
        save(new Product(null, "คีย์บอร์ด", 650.0, 10));
        save(new Product(null, "แฟลชไดรฟ์ 64GB", 220.0, 40));
    }
    @Override
    public List<Product> findAll() {
        return products;
    }
    @Override
    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }
    @Override
    public Product save(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }
    @Override
    public List<Product> findByName(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return products;
        }
        return products.stream()
                .filter(p -> p.getName() != null &&
                        p.getName().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }

}