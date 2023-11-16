package seminar8.tables.Views;

import seminar8.tables.Models.Table;
import seminar8.tables.Presenters.View;
import seminar8.tables.Presenters.ViewObserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class BookingView implements View {

    private final Collection<ViewObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(ViewObserver observer) {
        observers.add(observer);
    }

    @Override
    public void showTables(Collection<Table> tables) {
        for (Table table : tables){
            System.out.println(table);
        }
    }

    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0)
            System.out.printf("Столик успешно забронирован. Номер резерва #%d\n", reservationNo);
        else
            System.out.println("Невозможно забронировать столик.\nПовторите попытку позже.");
    }

    @Override
    public void showСhangeReservationTable(int newReservationNumber, int newNumberTable) {
        if (newReservationNumber > 0) {
            System.out.printf(
                    "Изменение брони прошло успешно. По номеру брони №%d изменен номер столика. Новый номер столика №%d\n",
                    newReservationNumber, newNumberTable);
        } else {
            System.out.println("Что-то пошло не так, попробуйте повторить попытку позже.");
        }
    }
    @Override
    public void reservationTable(Date reservtionDate, int tableNo, String name) {
        for (ViewObserver observer : observers)
            observer.onReservationTable(reservtionDate, tableNo, name);
    }

    @Override
    public void changeReservationTable(int oldReservation,  Date reservtionDate, int tableNo, String name) {
        for (ViewObserver observer : observers)
            observer.onUpdateReservationTable(oldReservation, reservtionDate, tableNo, name);
    }
}
