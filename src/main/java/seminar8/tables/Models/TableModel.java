package seminar8.tables.Models;

import seminar8.tables.Presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {
    private Collection<Table> tables;

    public TableModel() {
    }

    @Override
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }


    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(table, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика");
    }


    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        Reservation newReservation = null;
        for (Table table : tables) {
            for (Reservation reservation : table.getReservations()) {
                if (reservation.getId() == oldReservation) {
                    newReservation = reservation;
                }
            }
            table.getReservations().removeIf(id -> id.getId() == oldReservation);
            if (table.getNo() == tableNo) {
                table.getReservations().add(newReservation);
                return newReservation.getId();
            }
        }
        throw new RuntimeException("Ошибка бронирования столика. Повторите попытку позже.");
    }
}
