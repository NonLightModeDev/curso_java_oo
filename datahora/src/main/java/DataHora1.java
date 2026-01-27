import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataHora1 {
    public static void main(String[] args) {
        // Instanciando data e hora

        LocalDate date1 = LocalDate.now(); // YYYY-MM-DD
        LocalDateTime date2 = LocalDateTime.now(); // YYYY-MM-DDTHH:mm:ss.ms sem fuso (local, da minha máquina)
        Instant date3 = Instant.now(); // YYYY-MM-DDTHH:mm:ss.ms com fuso (global, o horário de Londres)
        LocalDate date4 = LocalDate.parse("2022-07-29"); // texto para objeto LocalDate (somente data)
        LocalDateTime date5 = LocalDateTime.parse("2022-08-29T11:53:59"); // texto para objeto LocalDateTime (data e hora (sem timezone)
        Instant date6 = Instant.parse("2022-08-29T11:53:59.384829348Z"); // texto para Instant (data, hora e timezone)
        Instant date7 = Instant.parse("2022-08-29T11:53:59Z"); // texto para Instant (data, hora e timezone)

        Instant date8 = Instant.parse("2022-08-29T11:53:59-03:00"); // -03:00 especifica que o horário 11:53:59 está 03:00 atrasado, ou seja, 11:53:59 equivale a menos 03:00 do horário de Londres. date8 vai conter o hoarário de Londres (11:53:59+03:00 = 14:53:59Z)


        // https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/time/format/DateTimeFormatter.html
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date9 = LocalDate.parse("20/07/2022", fmt1); // agora é possível utilizar o formato estabelecido na linha anterior para especificar como que o LocalDate.parse vai interpretar a string passada

        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime date10 = LocalDateTime.parse("27/01/2026 11:27", fmt2);


        LocalDate date11 = LocalDate.of(2022, 12, 30);
        LocalDateTime date12 = LocalDateTime.of(2022, 12, 30, 23, 59, 59);

        System.out.println("date1 = " + date1);
        System.out.println("date2 = " + date2);
        System.out.println("date3 = " + date3);
        System.out.println("date4 = " + date4);
        System.out.println("date5 = " + date5);
        System.out.println("date6 = " + date6);
        System.out.println("date7 = " + date7);
        System.out.println("date8 = " + date8);
        System.out.println("date9 = " + date9);
        System.out.println("date10 = " + date10);
        System.out.println("date11 = " + date11);
        System.out.println("date12 = " + date12);
    }
}
