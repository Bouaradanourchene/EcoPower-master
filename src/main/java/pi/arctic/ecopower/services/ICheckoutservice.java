package pi.arctic.ecopower.services;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import pi.arctic.ecopower.DTO.Achat;
import pi.arctic.ecopower.DTO.Payment;
import pi.arctic.ecopower.DTO.Reponseachat;

public interface ICheckoutservice {
    PaymentIntent createPaymentIntent(Payment paymentInfo) throws StripeException;
    Reponseachat placeOrder(Achat purchase) ;


}
