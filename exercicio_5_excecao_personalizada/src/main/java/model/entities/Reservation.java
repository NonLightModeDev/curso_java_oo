package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private int roomNumber;
    private LocalDate checkin;
    private LocalDate checkout;

    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation() {
        super();
    }

    public Reservation(int roomNumber, LocalDate checkin, LocalDate checkout) {
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public long duration() {
        return Duration.between(checkin.atStartOfDay(), checkout.atStartOfDay()).toDays();
    }

    public String updateDates(LocalDate checkin, LocalDate checkout) {
        LocalDate now = LocalDate.now();
        if(checkin.isBefore(now) || checkout.isBefore(now)) {
            return "Error in reservation: Reservation dates for update must be future dates";
        }
        if (checkout.isBefore(checkin)){
            return "Error in reservation: Check-out date must be after check-in date.";
        }

        this.checkin = checkin;
        this.checkout = checkout;

        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Room: " + roomNumber);
        sb.append(", check-in: " + checkin.format(fmt));
        sb.append(", check-out: " + checkout.format(fmt));
        sb.append(", " + duration() + " nights");

        return sb.toString();
    }
}
