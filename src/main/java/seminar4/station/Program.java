package seminar4.station;

import java.util.Date;

public class Program {

/**
 * Разработать контракты и компоненты системы "Покупка онлайн билетов на автобус в час пик".
 * <p>
 * 1.  Предусловия.
 * 2.  Постусловия.
 * 3.  Инвариант.
 * 4.  Определить абстрактные и конкретные классы.
 * 5.  Определить интерфейсы.
 * 6.  Реализовать наследование.
 * 7.  Выявить компоненты.
 * 8.  Разработать Диаграмму компонент использую нотацию UML 2.0. Общая без деталей.
 */
public static void main(String[] args) {

    Customer customer = new Customer("Test User");
    Database database = new Database();
    TicketProvider ticketProvider = new MoscowTicketProvider(database, new BankPaymentProvider());
    CustomerProvider customerProvider = new MobileCustomerProvider(database);
    customerProvider.saveCustomer(customer);

    BusStation busStation = new BusStation(ticketProvider);

    MobileApp mobileApp = new MobileApp(ticketProvider, new MobileCustomerProvider(database));


    try {
        mobileApp.login(customer.getLogin());

        if(mobileApp.getTickets().isEmpty()) {
            mobileApp.buyTicket("1111");
        }
        busStation.checkTicket(mobileApp.getTickets().stream().toList().get(0).getQrcode());
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
}