package pi.arctic.ecopower.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pi.arctic.ecopower.entities.Product;
import pi.arctic.ecopower.entities.ProductCategory;
import pi.arctic.ecopower.services.IProductService;

import java.util.List;

@RestController
@RequestMapping("product")
@AllArgsConstructor
public class ProductController {
    private IProductService iProductService;

    @PostMapping("/add")
    public void add(@RequestBody Product p) {
        iProductService.add(p);
    }

    @PutMapping("/update")
    public Product update(@RequestBody Product p) {
        return iProductService.update(p);
    }

    @GetMapping("/all")
    public List<Product> getAll() {
        return iProductService.getAll();
    }

    @GetMapping("/get/{id}")
    public Product getById(@PathVariable long id) {
        return iProductService.getById(id);
    }

    @DeleteMapping("delete/{id}")
    public void remove(@PathVariable long id) {
        iProductService.remove(id);
    }

    @GetMapping("getByCat/{category}")
    public List<Product> getAllProductsByCategory(@PathVariable ProductCategory category) {
        return iProductService.getAllProductsByCategory(category);
    }


}
