package PaymentServices;

public class OnlineOrderService implements OrderRegistrationService, OrderPaymentService {
    @Override
    public void registerOrder(String customerName) {
        System.out.println("Online order registered for " + customerName);
    }

    @Override
    public void payOrder(int foodPrice) {
        System.out.println("Online Payment with Price: " + foodPrice + " Tomans!");
    }
}