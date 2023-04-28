package pi.arctic.ecopower.services;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Order;
import com.stripe.model.PaymentIntent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pi.arctic.ecopower.DTO.Achat;
import pi.arctic.ecopower.DTO.Payment;
import pi.arctic.ecopower.DTO.Reponseachat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Slf4j
public class CheckoutserviceImp implements  ICheckoutservice {
    @Autowired
    IProductService productService;
    public CheckoutserviceImp(IProductService productService, @Value("${stripe.key.secret}") String secretKey) {
        this.productService = productService;
        Stripe.apiKey = secretKey;
    }

    @Override
    public PaymentIntent createPaymentIntent(Payment payment) throws StripeException {
        List<String> paymentMethodTypes = new ArrayList<>();
        paymentMethodTypes.add("card");

        Map<String, Object> params = new HashMap<>();
        params.put("amount", payment.getAmount());
        params.put("currency", payment.getCurrency());
        params.put("payment_method_types", paymentMethodTypes);
        params.put("description", "achat");
        params.put("receipt_email", payment.getEmailrecu());

        return PaymentIntent.create(params);
    };

    @Override
    public Reponseachat placeOrder(Achat achat) {
        // recuperation des info de la commande
        Order order = achat.getOrder();
        // generer un num de suivie de la commande
        String orderTrackingNumber = generateOrderTrackingNumber();
        return new Reponseachat(orderTrackingNumber);
/*


        // Création de l'enregistrement d'historique d'achat
        HistoriqueAchat historiqueAchat = new HistoriqueAchat();
        historiqueAchat.setDateAchat(LocalDateTime.now());
        historiqueAchat.setUser(order.getUser());

        // Enregistrement de l'historique d'achat
        userService.addHistoriqueAchat(order.getUser().getId(), historiqueAchat);
*/
    }

    private static int orderCount = 0;

    private String generateOrderTrackingNumber() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String orderNumber = String.format("%06d", orderCount);
        orderCount++;
        return timestamp + orderNumber;
    }
}

