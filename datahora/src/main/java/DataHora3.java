import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DataHora3 {
    public static void main(String[] args) {
        // Convertendo data-hora global para local

        LocalDate date1 = LocalDate.parse("2026-01-27");
        LocalDateTime date2 = LocalDateTime.parse("2026-01-27T11:41");
        Instant date3 = Instant.parse("2026-01-27T01:41:29Z"); // horário de Londres

        // Retorna os nomes das timezones disponíveis.
//        for(String timezone : ZoneId.getAvailableZoneIds()) {
//            System.out.println(timezone);
//        }


        LocalDate r1 = LocalDate.ofInstant(date3, ZoneId.systemDefault()); // converte um objeto Instant para um LocalDate considerando o fuso horário da minha máquina local
        LocalDate r2 = LocalDate.ofInstant(date3, ZoneId.of("Portugal"));

        LocalDateTime r3 = LocalDateTime.ofInstant(date3, ZoneId.systemDefault());
        LocalDateTime r4 = LocalDateTime.ofInstant(date3, ZoneId.of("Portugal"));

        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);
        System.out.println("r3 = " + r3);
        System.out.println("r4 = " + r4);


        // Pegar dia, hora, mês... de um data-hora
        System.out.println("\n\n");
        System.out.println("date1 dia = " + date1.getDayOfMonth());
        System.out.println("date1 mês = " + date1.getMonth());
        System.out.println("date1 ano = " + date1.getYear());
        System.out.println("date1 dia do ano = " + date1.getDayOfYear()); // dia dos 365 (ou 366) dias do ano
        System.out.println("date2 hora = " + date2.getHour());

    }
}
