package seminar8.tables.Presenters;

import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.registerObserver(this);
    }
    public void updateTables(){
        view.showTables(model.loadTables());
    }

    private void showReservationTableResult(int reservationNo){
        view.showReservationTableResult(reservationNo);
    }
    public void showСhangeReservationTable(int reservationNumber, int numberTable) {
        view.showСhangeReservationTable(reservationNumber, numberTable);
    }

    @Override
    public void onReservationTable(Date reservtionDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(reservtionDate, tableNo, name);
            showReservationTableResult(reservationNo);
        }
        catch (RuntimeException e){
            showReservationTableResult(-1);
        }
    }
    @Override
    public void onUpdateReservationTable(int oldReservation, Date reservationDate, int tableNumber,
                                         String nameClients) {
        try {
            int newReservationNumber = model.changeReservationTable(oldReservation, reservationDate, tableNumber,
                    nameClients);
            showСhangeReservationTable(newReservationNumber, tableNumber);
        } catch (RuntimeException e) {
            showСhangeReservationTable(-1, -1);
        }
    }
}
