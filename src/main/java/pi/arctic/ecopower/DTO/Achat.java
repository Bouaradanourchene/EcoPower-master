package pi.arctic.ecopower.DTO;

import com.stripe.model.Order;
import com.stripe.model.OrderItem;
import com.stripe.model.Source;
import lombok.Data;

import java.util.Set;

@Data
public class Achat {
    public Set<OrderItem> getOrderItems;
    private Order order ;
}
