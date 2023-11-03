package seminar4.station;


import java.util.Collection;

public interface TicketRepository {
    Collection<Ticket> getTickets();
    double getTicketAmount();
    int createTicketOrder(int clientId);

    void saveTicket(Ticket ticket);
}
