package PaymentServices;

public class OnSiteOrderService implements OrderRegistrationService, OrderPaymentService {
    @Override
    public void registerOrder(String customerName) {
        System.out.println("On-Site order registered for " + customerName);
    }

    @Override
    public void payOrder(int foodPrice) {
        System.out.println("On-Site Payment with Price: " + foodPrice + " Tomans!");
    }
}