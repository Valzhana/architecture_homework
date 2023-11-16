package seminar8.tables.Models;

import java.util.Date;

public class Reservation {

    public Reservation(Table table, Date date, String name) {
        this.table = table;
        this.date = date;
        this.name = name;
    }


    private static int counter = 1000;
    private final int id;
    private Table table;
    private final Date date;
    private final String name;

    {
        id = ++counter;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    public void setTable(Table table) {
        this.table = table;
    }

}
