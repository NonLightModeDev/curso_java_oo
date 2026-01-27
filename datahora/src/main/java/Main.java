import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.now(); // YYYY-MM-DD
        LocalDateTime date2 = LocalDateTime.now(); // YYYY-MM-DDTHH:MM:SS.MS sem fuso (local, da minha máquina)
        Instant date3 = Instant.now(); // YYYY-MM-DDTHH:MM:SS.MS com fuso (global, o horário de Londres)
        LocalDate date4 = LocalDate.parse("2022-07-29"); // texto para objeto LocalDate (somente data)
        LocalDateTime date5 = LocalDateTime.parse("2022-08-29T11:53:59"); // texto para objeto LocalDateTime (data e hora (sem timezone)
        Instant date6 = Instant.parse("2022-08-29T11:53:59.384829348Z"); // texto para Instant (data, hora e timezone)
        Instant date7 = Instant.parse("2022-08-29T11:53:59Z"); // texto para Instant (data, hora e timezone)
        System.out.println("date1 = " + date1);
        System.out.println("date2 = " + date2);
        System.out.println("date3 = " + date3);
        System.out.println("date4 = " + date4);
        System.out.println("date5 = " + date5);
        System.out.println("date6 = " + date6);
        System.out.println("date7 = " + date7);
    }
}
