package PaymentServices;

public class PhoneOrderService implements OrderRegistrationService, OrderPaymentService {
    @Override
    public void registerOrder(String customerName) {
        System.out.println("Phone order registered for " + customerName);
    }

    @Override
    public void payOrder(int foodPrice) {
        System.out.println("Phone Payment with Price: " + foodPrice + " Tomans!");
    }
}