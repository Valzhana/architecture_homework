package seminar4.station;

import java.util.ArrayList;
import java.util.Collection;

public class Customer{

    private static int counter;

    private final int id;
    private final String login;

    private Collection<Ticket> tickets = new ArrayList<>();

    public Customer(String login) {
        this.login = login;
        id = ++counter;
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }
}