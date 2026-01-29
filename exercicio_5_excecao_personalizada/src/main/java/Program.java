import model.entities.Reservation;
import model.entities.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            System.out.print("Room: ");
            int roomNumber = Integer.parseInt(sc.nextLine());
            System.out.print("Check-in date: ");
            LocalDate checkin = LocalDate.parse(sc.nextLine(), fmt);
            System.out.print("Check-out date: ");
            LocalDate checkout = LocalDate.parse(sc.nextLine(), fmt);
            Reservation reservation = new Reservation(roomNumber, checkin, checkout);
            System.out.println("Reservation: " + reservation);

            System.out.println(" ");
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date: ");
            checkin = LocalDate.parse(sc.nextLine(), fmt);
            System.out.print("Check-out date: ");
            checkout = LocalDate.parse(sc.nextLine(), fmt);
            LocalDate now = LocalDate.now();
            reservation.updateDates(checkin, checkout);
            System.out.println("Reservation: " + reservation);
        } catch (DateTimeParseException e) {
            System.out.println("Error: Invalid date format!");
        } catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            sc.close();
        }

    }
}
