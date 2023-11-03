package seminar4.station;

import java.util.Collection;

public interface CustomerRepository {
    Collection<Customer> getCustomers();
    Customer getCustomerByLogin(String login) throws NoCustomerException;
    void saveCustomer(Customer login);
}
