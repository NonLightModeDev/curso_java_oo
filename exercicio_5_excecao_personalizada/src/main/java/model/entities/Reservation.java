package model.entities;

import model.entities.exceptions.DomainException;

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

    public Reservation(int roomNumber, LocalDate checkin, LocalDate checkout) throws DomainException {
        if (checkout.isBefore(checkin)){
            throw new DomainException("Check-out date must be after check-in date.");
        }
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

    public void updateDates(LocalDate checkin, LocalDate checkout) throws DomainException {
        LocalDate now = LocalDate.now();
        if(checkin.isBefore(now) || checkout.isBefore(now)) {
            throw new DomainException("Reservation dates for update must be future dates");
        }
        if (checkout.isBefore(checkin)){
            throw new DomainException("Check-out date must be after check-in date.");
        }

        this.checkin = checkin;
        this.checkout = checkout;
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
