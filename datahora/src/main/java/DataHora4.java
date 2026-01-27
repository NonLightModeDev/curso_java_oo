import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DataHora4 {
    public static void main(String[] args) {
        // Cálculos com data-hora

        LocalDate date1 = LocalDate.parse("2026-01-27");
        LocalDateTime date2 = LocalDateTime.parse("2026-01-27T11:41");
        Instant date3 = Instant.parse("2026-01-27T01:41:29Z"); // horário de Londres

        LocalDate pastWeekLocalDate = date1.minusDays(7); // data de date1 menos 7 dias
        LocalDate nextWeekLocalDate = date1.plusDays(7); // data de date1 mais 7 dias

        System.out.println("-----------------------------------");
        System.out.println("date1 = " + date1);
        System.out.println("pastWeekLocalDate = " + pastWeekLocalDate);
        System.out.println("nextWeekLocalDate = " + nextWeekLocalDate);
        System.out.println("-----------------------------------\n");

        LocalDateTime pastWeekLocalDateTime = date2.minusDays(7); // data-hora de date2 menos 7 dias
        LocalDateTime nextWeekLocalDateTime = date2.plusDays(7); // data-hora de date2 mais 7 dias

        System.out.println("-----------------------------------");
        System.out.println("date2 = " + date2);
        System.out.println("pastWeekLocalDateTime = " + pastWeekLocalDateTime);
        System.out.println("nextWeekLocalDateTime = " + nextWeekLocalDateTime);
        System.out.println("-----------------------------------\n");

        Instant pastWeekInstant = date3.minus(7, ChronoUnit.DAYS); // data-hora de date3 menos 7 dias
        Instant nextWeekInstant = date3.plus(7, ChronoUnit.DAYS); // data-hora de date3 mais 7 dias

        System.out.println("-----------------------------------");
        System.out.println("date3 = " + date3);
        System.out.println("pastWeekInstant = " + pastWeekInstant);
        System.out.println("nextWeekInstant = " + nextWeekInstant);
        System.out.println("-----------------------------------\n");


        // Calcular duração
        System.out.println("\n\n-----------------------------------\n\n");

        Duration t1 = Duration.between(pastWeekLocalDate.atTime(0, 0, 0), date1.atTime(0, 0, 0)); // como LocalDate não tem hora, é preciso definir uma hora qualquer para poder calcular a duração já que, por debaixo dos panos, é calculado utilizando milissegundos (e, para ter os milissegundos precisos, faz-se necessário definir a hora). Pode-se utlizar o método atStartOfDay(), que define o dia para o primeiro horário do dia (00:00:00)
        Duration t2 = Duration.between(pastWeekLocalDateTime, date2);
        Duration t3 = Duration.between(date3, pastWeekInstant);
        System.out.println("-----------------------------------");
        System.out.println("t1 dias = " + t1.toDays());
        System.out.println("t2 dias = " + t2.toDays());
        System.out.println("t3 dias = " + t3.toDays());
        System.out.println("-----------------------------------\n");
    }
}
