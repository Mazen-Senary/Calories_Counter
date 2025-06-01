package Strategy;

public class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(String name, String email, String cardNumber, String cvv) {
        System.out.println("=== PAYPAL PAYMENT ===");
        System.out.println("Redirecting to PayPal...");
        System.out.println("Account Name: " + name);
        System.out.println("PayPal Email: " + email);
        System.out.println("Payment Status: SUCCESS");
        System.out.println("Transaction ID: PP-" + System.currentTimeMillis());
        System.out.println("======================");
    }
}