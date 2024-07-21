package PaymentServices;

public interface OrderService {
    void onSiteOrderRegister(String customerName);
    void onlineOrderRegister(String customerName);
    void phoneOrderRegister(String customerName);
    void onSiteOrderPayment(int foodPrice);
    void onlineOrderPayment(int foodPrice);
    void phoneOrderPayment(int foodPrice);
}
