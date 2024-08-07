package calculator;

public class Calculator {
    public int sqrt(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return (int) Math.sqrt(a / b);
    }
}
