import model.entities.Reservation;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws DateTimeParseException {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("Room: ");
        int roomNumber = Integer.parseInt(sc.nextLine());
        System.out.print("Check-in date: ");
        LocalDate checkin = LocalDate.parse(sc.nextLine(), fmt);
        System.out.print("Check-out date: ");
        LocalDate checkout = LocalDate.parse(sc.nextLine(), fmt);
        if(checkout.isBefore(checkin)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date.");
        } else {
            Reservation reservation = new Reservation(roomNumber, checkin, checkout);
            System.out.println(reservation);

            System.out.println(" ");
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date: ");
            checkin = LocalDate.parse(sc.nextLine(), fmt);
            System.out.print("Check-out date: ");
            checkout = LocalDate.parse(sc.nextLine(), fmt);
            LocalDate now = LocalDate.now();
            if(checkin.isBefore(now) || checkout.isBefore(now)) {
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            } else if (checkout.isBefore(checkin)){
                System.out.println("Error in reservation: Check-out date must be after check-in date.");
            } else {
                reservation.updateDays(checkin, checkout);
                System.out.println(reservation);
            }
        }
        sc.close();
    }
}
