package seminar8.tables;

import seminar8.tables.Models.TableModel;
import seminar8.tables.Presenters.BookingPresenter;
import seminar8.tables.Presenters.Model;
import seminar8.tables.Views.BookingView;

import java.util.Date;

public class Program {

    //TODO: метод changeReservationTable должен заработать
    public static void main(String[] args) {
        Model model = new TableModel();
        BookingView view = new BookingView();
        BookingPresenter presenter = new BookingPresenter(model, view);
        presenter.updateTables();

        view.reservationTable(new Date(), 3, "Станислав");
        view.changeReservationTable(1001, new Date(), 5, "Станислав");
    }

}
