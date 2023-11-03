package seminar4.station;


public interface PaymentProvider {
    boolean buyTicket(int orderId, String cardNo, double amount);
}
