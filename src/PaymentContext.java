

public class PaymentContext {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void pay(String name, String email, String cardNumber, String cvv) {
        if (strategy != null) {
            strategy.pay(name, email, cardNumber, cvv);
        } else {
            System.out.println("ERROR: No payment strategy selected.");
        }
    }

    public boolean hasStrategy() {
        return strategy != null;
    }
}