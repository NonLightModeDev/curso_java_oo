import java.time.*;

public class DataHora5 {
    public static void main(String args[]) {
        // ZoneId.getAvailableZoneIds().stream().filter(c -> c.startsWith("America")).forEach(System.out::println);
        // Pegando os nomes das timezones com começam com "America" para poder especificar no método ZoneId.if()

        LocalDate localDate = LocalDate.now(ZoneId.of("America/Sao_Paulo")); // se não especificar a timezone (chamar now() sem argumentos), pega a data com base na timezone da máquina local, mas sem mostrar no resultado qual timezone usada
        System.out.println("localDate = " + localDate);

        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Taipei")); // se não especificar a timezone, pega a data e hora com base na timezone da máquina local, mas sem mostrar no resultado qual a timezone usada
        System.out.println("localDateTime = " + localDateTime);

        // Tanto LocalDate quanto LocalDateTime, independentemente de especificar ou não a timezone, não mostra no resultado a timezone usada


        Instant instant = Instant.now(); // data e hora com fuso horário (timezone) de Londres. Não tem como espeficiar a timezone, pois é a data e hora global com base no fuso horário de Londres
        System.out.println("instant = " + instant);


        LocalTime localTime = LocalTime.now(); // Parecido com LocalDate e LocalDateTime, porém para horas
        System.out.println("localTime = " + localTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.now(); // Data e hora da máquina local (se não especificar timezone) com fuso horário sendo mostrado no resultado
        System.out.println("zonedDateTime = " + zonedDateTime); // -03:00 indica que a hora mostrada é o resultado da subtração da hora de Londres por 03:00

        YearMonth yearMonth = YearMonth.now(); // Mês e ano da máquina local (se não especificar a timezone), mas não mostra no resultado a timezone usada
        System.out.println("yearMonth = " + yearMonth);
    }
}
