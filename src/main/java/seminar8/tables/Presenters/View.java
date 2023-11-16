package seminar8.tables.Presenters;

import seminar8.tables.Models.Table;

import java.util.Collection;
import java.util.Date;

public interface View {

    void registerObserver(ViewObserver observer);

    void showTables(Collection<Table> tables);

    void showReservationTableResult(int reservationNo);

    void showСhangeReservationTable(int reservationNumber, int numberTable);

    void reservationTable(Date reservtionDate, int tableNo, String name);

    void changeReservationTable(int oldReservation, Date reservtionDate, int tableNo, String name);
}

