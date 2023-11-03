package seminar4.station;

public class MobileCustomerProvider implements CustomerProvider {

    private CustomerRepository repository;

    public MobileCustomerProvider(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer getCustomer(String login, String password) throws NoCustomerException {
        return repository.getCustomerByLogin(login);
    }

    @Override
    public void saveCustomer(Customer customer) {
        repository.saveCustomer(customer);
    }
}