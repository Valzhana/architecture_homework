package seminar4.station;


public interface CustomerProvider {
    Customer getCustomer(String login, String password) throws NoCustomerException;

    void saveCustomer(Customer customer);
}