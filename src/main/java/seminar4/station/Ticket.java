package seminar4.station;

import java.rmi.server.UID;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class  Ticket{

    private int id;

    private int customerId;

    private LocalDate date;

    private String qrcode;

    private boolean enable = true;

    public Ticket(int customerId) {
        this.qrcode = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.date = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getQrcode() {
        return qrcode;
    }

    public boolean isEnable() {
        return enable;
    }

    public void disable() {
        this.enable = false;
    }
}