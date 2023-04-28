package pi.arctic.ecopower.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pi.arctic.ecopower.entities.Order;
import pi.arctic.ecopower.entities.Product;
import pi.arctic.ecopower.repositories.OrderRepo;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class OrderServiceImp implements IOrderService {
    private OrderRepo orderRepo;

    @Override
    public void add(Order o) {
        orderRepo.save(o);
    }

    @Override
    public Order update(Order o) {
        return orderRepo.save(o);
    }

    @Override
    public List<Order> getAll() {
        return orderRepo.findAll();
    }

    @Override
    public Order getById(long id) {
        return orderRepo.findById(id).orElse(null);
    }

    @Override
    public void remove(long id) {
        orderRepo.deleteById(id);
    }

    @Override
    public Set<Order> getOrdersContainingProduct(Product product) {
        return orderRepo.findByProducts(product);
    }

    @Override
    public Set<Order> getOrdersByDate(LocalDate date) {
        return orderRepo.findByCreatedDate(date);
    }
}
