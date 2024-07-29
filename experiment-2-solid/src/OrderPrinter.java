public class OrderPrinter {
    public void printOrder(Order order) {
        String orders = "";
        for (Food food : order.foods) {
            orders += food.foodName + " -> " + food.price + "\n";
        }
        System.out.println("Customer: " + order.customerName + "\nOrders are: \n" + orders + "\nTotal Price: " + order.getTotalPrice());
    }
}