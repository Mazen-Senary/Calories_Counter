

public interface PaymentStrategy {
    void pay(String name, String email, String cardNumber, String cvv);
}
