package pi.arctic.ecopower.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    public String orderTrackingNumber;
    int totalQuantity;
    double totalPrice;
    @CreationTimestamp
    LocalDate createdDate;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "order")
    Set<OrderItem> orderItems = new HashSet<>();
    @OneToMany
    Set<Product> products;



    public void add(OrderItem item) {

        if (item != null) {
            if (orderItems == null) {
                orderItems = new HashSet<>();
            }

            orderItems.add(item);
            item.setOrder(this);
        }
    }

}
