package pi.arctic.ecopower.services;

import pi.arctic.ecopower.entities.Product;
import pi.arctic.ecopower.entities.ProductCategory;

import java.util.List;

public interface IProductService {
    void add(Product p);
    Product update(Product p);
    List<Product> getAll();
    Product getById(long id);
    void remove(long id);
    List<Product> getAllProductsByCategory(ProductCategory category);
}
