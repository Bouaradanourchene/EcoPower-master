package pi.arctic.ecopower.services;

import pi.arctic.ecopower.entities.Order;
import pi.arctic.ecopower.entities.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IOrderService {
    void add(Order o);
    Order update(Order o);
    List<Order> getAll();
    Order getById(long id);
    void remove(long id);
    Set<Order> getOrdersContainingProduct(Product product);
    public Set<Order> getOrdersByDate(LocalDate date);
}
