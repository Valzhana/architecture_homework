package seminar4.station;

import java.time.LocalDate;
import java.util.Collection;

/**
 * Мобильное приложение
 */
public class MobileApp{

    private Customer customer;
    private final TicketProvider ticketProvider;
    private final CustomerProvider customerProvider;


    public MobileApp(TicketProvider ticketProvider, CustomerProvider customerProvider) {
        this.ticketProvider = ticketProvider;
        this.customerProvider = customerProvider;
    }

    public void login(String login) {
        try {
            System.out.printf("Пользователь %s попытка логина в приложение ... %n", login);
            this.customer = customerProvider.getCustomer(login, "<password>");
            System.out.printf("Логин в приложение успешен%n", login);
        } catch (NoCustomerException e) {
            System.out.println(e.getMessage());
        }
    }

    public Collection<Ticket> getTickets(){
        System.out.printf("Проверка наличие активного билета у Пользователя %s%n", customer.getLogin());
        return customer.getTickets();
    }

    public Collection<Ticket> searchTicketsWithDate(LocalDate date){
        return ticketProvider.searchTicketsByDate(customer.getId(), date);
    }

    public void buyTicket(String cardNo) throws NoCustomerFundsException {
        System.out.printf("Попытка покупки билета Пользователем %s%n", customer.getLogin());
        Ticket newTicket= ticketProvider.buyTicket(customer.getId(), cardNo);
        this.ticketProvider.saveTicket(newTicket);
        this.customer.addTicket(newTicket);
    }

}