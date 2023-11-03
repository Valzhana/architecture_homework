package seminar4.station;


public class NoCustomerException extends Exception{
    public NoCustomerException(String login) {
        super(String.format("Клиент не найден: Логин %s", login));
    }
}
