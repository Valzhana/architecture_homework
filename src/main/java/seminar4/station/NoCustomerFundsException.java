package seminar4.station;


public class NoCustomerFundsException extends Exception{
    public NoCustomerFundsException(int userId) {
        super(String.format("У Клиента недостаточно средств: Юзер %s", userId));
    }
}