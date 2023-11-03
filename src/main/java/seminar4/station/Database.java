package seminar4.station;
import java.util.ArrayList;
import java.util.Collection;

/**
 * База данных
 */
public class Database implements TicketRepository, CustomerRepository{

    private static int counter;
    private Collection<Ticket> tickets = new ArrayList<>();
    private Collection<Customer> customers = new ArrayList<>();

    public Database() {
    }
    @Override
    public Collection<Ticket> getTickets() {
        return tickets;
    }
    @Override
    public Collection<Customer> getCustomers() {
        return customers;
    }

    @Override
    public Customer getCustomerByLogin(String login) throws NoCustomerException {
        return customers.stream().filter(customer -> customer.getLogin().equals(login)).findFirst().orElseThrow(() -> new NoCustomerException(login));
    }

    @Override
    public void saveCustomer(Customer customer) {
        customers.add(customer);
    }

    /**
     * Получить актуальную стоимость билета
     * @return
     */
    @Override
    public double getTicketAmount(){
        return 45;
    }

    /**
     * Получить идентификатор заявки на покупку билета
     * @return
     */
    @Override
    public int createTicketOrder(int clientId){
        return ++counter;
    }

    @Override
    public void saveTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }
}