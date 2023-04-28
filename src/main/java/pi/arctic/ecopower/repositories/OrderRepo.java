package pi.arctic.ecopower.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pi.arctic.ecopower.entities.Order;
import pi.arctic.ecopower.entities.Product;

import java.time.LocalDate;
import java.util.Set;

@Repository

public interface OrderRepo extends JpaRepository<Order,Long> {
    Set<Order> findByProducts(Product product);
    Set<Order> findByCreatedDate(LocalDate date);
}
