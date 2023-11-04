package seminar4.station;

import java.util.HashMap;
import java.util.Map;

public class BankPaymentProvider implements PaymentProvider {

    private final Map<String, Double> accounts = new HashMap<>();
    public BankPaymentProvider() {
        accounts.put("1111", 1000000.0);
        accounts.put("2222", 2000000.0);
        accounts.put("3333", 3000000.0);
        accounts.put("4444", 4000000.0);

    }

    public boolean buyTicket(int orderId, String cardNo, double amount){
        System.out.printf("Поиск счета %s ... %n", cardNo);
        if(!accounts.containsKey(cardNo)) {
            System.out.printf("Счет %s не найден%n", cardNo);
            return false;
        }
        System.out.printf("Счет %s найден%n", cardNo);
        if(accounts.get(cardNo)-amount > 0) {
            System.out.printf("Средств на счете %s достаточно для покупки%n", cardNo);
            accounts.put(cardNo, accounts.get(cardNo)-amount);
            return true;
        }
        System.out.printf("Средств на счете %s недостаточно для покупки%n", cardNo);
        return false;
    }

}