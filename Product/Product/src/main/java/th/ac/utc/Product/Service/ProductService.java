package th.ac.utc.Product.Service;

import java.util.List;
import java.util.Optional;
import th.ac.utc.Product.model.Product;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    List<Product> findByName(String keyword);
}
