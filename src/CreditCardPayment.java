

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(String name, String email, String cardNumber, String cvv) {
        System.out.println("=== CREDIT CARD PAYMENT ===");
        System.out.println("Processing payment...");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Card Number: " + maskCardNumber(cardNumber));
        System.out.println("CVV: ***");
        System.out.println("Payment Status: SUCCESS");
        System.out.println("Transaction ID: CC-" + System.currentTimeMillis());
        System.out.println("============================");
    }

    private String maskCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.length() < 4) {
            return "****";
        }
        return "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
    }
}