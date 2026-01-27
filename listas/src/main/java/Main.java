import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> list;
        list = new ArrayList<>();
        list.add("João");
        list.add("Maria");
        list.add("Josué");
        list.add("Marcos");
        for(String nome : list) {
            System.out.printf("%s\n", nome);
        }
        System.out.printf("\n\n%d\n", list.size());
        list.remove("Josué");
        System.out.printf("%d\n", list.size());
//        list.removeIf(e -> e.startsWith("M"));
        System.out.printf("%d\n\n", list.size());
        for(String nome : list) {
            System.out.printf("%s\n", nome);
        }
        System.out.printf("Index of João: %d\n\n", list.indexOf("João"));
        List<String> result = list.stream().filter(e -> e.startsWith("M")).collect(Collectors.toList());
        result.forEach(System.out::println);
        String name = list.stream().filter(x -> x.startsWith("M")).findFirst().orElse(null);
        System.out.printf("\n%s", name);
        name = list.stream().filter(x -> x.startsWith("A")).findFirst().orElse(null);
        System.out.printf("\n%s", name);
    }
}
