package pi.arctic.ecopower.controllers;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pi.arctic.ecopower.DTO.Achat;
import pi.arctic.ecopower.DTO.Payment;
import pi.arctic.ecopower.DTO.Reponseachat;
import pi.arctic.ecopower.services.CheckoutserviceImp;
import pi.arctic.ecopower.services.ICheckoutservice;

@RestController
@RequestMapping("/checkout")
public class Checkoutcontroller {
    @Autowired
    CheckoutserviceImp checkoutservice ;
    @PostMapping("/achat")
    //passer uen commande et la triater
 public Reponseachat placeorder(@RequestBody Achat achat ) throws Exception {
        Reponseachat repenseachat = checkoutservice.placeOrder(achat);
        return repenseachat;
    }
    @PostMapping("/payment")
    public ResponseEntity<String>createPaymentIntent(@RequestBody Payment payment )throws StripeException{
        PaymentIntent paymentIntent =checkoutservice.createPaymentIntent(payment);
        String payments = paymentIntent.toJson();
        return new ResponseEntity<>(payments , HttpStatus.OK);
    }

}
