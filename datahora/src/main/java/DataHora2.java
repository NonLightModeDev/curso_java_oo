import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DataHora2 {
    public static void main(String[] args) {
        // Convertendo data-hora para texto

        LocalDate date1 = LocalDate.parse("2026-01-27");
        LocalDateTime date2 = LocalDateTime.parse("2026-01-27T11:41");
        Instant date3 = Instant.parse("2026-01-27T11:41:29Z"); // horário de Londres

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
        DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter fmt5 = DateTimeFormatter.ISO_INSTANT;

        System.out.println("date1 = " + date1.format(fmt1));
        System.out.println("date1 = " + fmt1.format(date1));
        System.out.println("date2 = " + date2.format(fmt2));
        System.out.println("date2 = " + date2.format(fmt1));
        System.out.println("date2 = " + date2.format(fmt4));
        System.out.println("date3 = " + fmt3.format(date3)); // horário da máquina local
        System.out.println("date3 = " + fmt5.format(date3));


    }
}
