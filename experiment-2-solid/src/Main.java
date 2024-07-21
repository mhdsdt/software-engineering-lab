import PaymentServices.OnSiteOrderService;
import PaymentServices.OnlineOrderService;
import PaymentServices.OrderPaymentService;
import PaymentServices.OrderRegistrationService;
import PaymentServices.PhoneOrderService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderRegistrationService registrationService = null;
        OrderPaymentService paymentService = null;
        String customerName;
        Order order;
        int customerAnswerForOrder = 0;
        int customerAnswerForPaymentMethod = 0;

        System.out.println("Enter Customer Name: ");
        customerName = scanner.nextLine();
        order = new Order(customerName);

        // Step 1: Select Order Items
        while (customerAnswerForOrder != 3) {
            System.out.println("For Ordering Sandwich enter 1.");
            System.out.println("For Ordering Pizza enter 2.");
            System.out.println("For submit your order enter 3");
            customerAnswerForOrder = scanner.nextInt();

            if (customerAnswerForOrder == 1) {
                order.addItem(new Food("sandwich", 1000));
            } else if (customerAnswerForOrder == 2) {
                order.addItem(new Food("pizza", 2000));
            }
        }

        // Step 2: Select Payment Method
        System.out.println("Enter Your Payment Method (1 for online, 2 for on-site, 3 for phone):");
        customerAnswerForPaymentMethod = scanner.nextInt();
        if (customerAnswerForPaymentMethod == 1) {
            registrationService = new OnlineOrderService();
            paymentService = new OnlineOrderService();
        } else if (customerAnswerForPaymentMethod == 2) {
            registrationService = new OnSiteOrderService();
            paymentService = new OnSiteOrderService();
        } else if (customerAnswerForPaymentMethod == 3) {
            registrationService = new PhoneOrderService();
            paymentService = new PhoneOrderService();
        }

        registrationService.registerOrder(customerName);

        // Step 3: Pay price
        System.out.println("Pay Price:");
        paymentService.payOrder(order.getTotalPrice());

        // Finally Print Bill
        OrderPrinter printer = new OrderPrinter();
        printer.printOrder(order);
    }
}