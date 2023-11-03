package seminar4.station;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class MoscowTicketProvider implements TicketProvider {

    private final TicketRepository repository;
    private final PaymentProvider paymentProvider;

    public MoscowTicketProvider(TicketRepository repository, PaymentProvider paymentProvider){
        this.repository = repository;
        this.paymentProvider = paymentProvider;
    }

    @Override
    public Collection<Ticket> searchTicketsByDate(int clientId, LocalDate date){

        Collection<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket: repository.getTickets()) {
            if (ticket.getCustomerId() == clientId && ticket.getDate().equals(date))
                tickets.add(ticket);
        }
        return tickets;

    }

    @Override
    public Ticket buyTicket(int clientId, String cardNo) throws NoCustomerFundsException {
        System.out.printf("Попытка покупки билета Юзером %s%n", clientId);
        int orderId = repository.createTicketOrder(clientId);
        double amount = repository.getTicketAmount();
        if(paymentProvider.buyTicket(orderId,  cardNo, amount)) {
            System.out.printf("Покупка билета Юзером %s успешна%n", clientId);
            return new Ticket(clientId);
        }
        else throw new NoCustomerFundsException(clientId);
    }

    @Override
    public boolean checkTicket(String qrcode){
        System.out.println("Активация турникета ...");
        System.out.printf("Поиск билета по коду %s ... %n", qrcode);
        for (Ticket ticket: repository.getTickets()) {
            if (ticket.getQrcode().equals(qrcode)){
                System.out.printf("Билета по коду %s найден %n", qrcode);
                if (ticket.isEnable()) {
                    System.out.printf("Билета по коду %s готов к использованию %n", qrcode);
                    ticket.disable();
                    return true;
                } else {
                    System.out.printf("Билета по коду %s неактивен %n", qrcode);
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public void saveTicket(Ticket ticket) {
        System.out.printf("Сохранение билета по коду %s ... %n", ticket.getQrcode());
        this.repository.saveTicket(ticket);
    }
}