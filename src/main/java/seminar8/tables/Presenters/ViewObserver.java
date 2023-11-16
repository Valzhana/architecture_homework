package seminar8.tables.Presenters;

import java.util.Date;

public interface ViewObserver {

    void onReservationTable(Date reservtionDate, int tableNo, String name);

    void onUpdateReservationTable(int oldReservation, Date reservationDate, int tableNumber,
                                  String nameClients);
}
