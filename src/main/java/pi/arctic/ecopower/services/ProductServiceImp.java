package pi.arctic.ecopower.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pi.arctic.ecopower.entities.Product;
import pi.arctic.ecopower.entities.ProductCategory;
import pi.arctic.ecopower.repositories.ProductRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImp implements IProductService{

    private ProductRepo productRepo;
    @Override
    public void add(Product p) {

        productRepo.save(p);   }

    @Override
    public Product update(Product p) {
        return  productRepo.save(p);
    }

    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Product getById(long id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public void remove(long id) {
        productRepo.deleteById(id);

    }

    @Override
    public List<Product> getAllProductsByCategory(ProductCategory category) {
        return productRepo.findByProductCategory(category);
    }
}
