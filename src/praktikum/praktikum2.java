package praktikum;
import java.util.Iterator;
import java.util.Stack;
public class praktikum2 {
    public static void main(String[] args) {
        Stack<String> fruits = new Stack<>();
        fruits.push("Banana");
        fruits.push("Orange");
        fruits.push("Watermelon");
        fruits.push("Leci");
        fruits.push("Salak");
        for (String fruit : fruits) {
            System.out.printf("%s ", fruit);
        }
        System.out.println("\n" + fruits.toString());
        while (!fruits.empty()) {
            System.out.printf("%s ", fruits.pop());
        }
        System.out.println("\nSetelah Dikosongkan");
        fruits.push("Melon");
        fruits.push("Starwberry");
        fruits.push("Mango");
        fruits.push("Guava");
        fruits.push("Avocado");
        System.out.println("");
        for (Iterator<String> it = fruits.iterator(); it.hasNext();) {
            String fruit = it.next();
            System.out.printf("%s ", fruit);
        }
        System.out.println("");
        fruits.stream().forEach(e -> {
            System.out.printf("%s ", e);
        });
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println();
        }
        fruits.sort((String a, String b) -> a.compareTo(b));
        System.out.println("Setelah Sorting");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.print(fruits.get(i) + " - ");
        }
    }
}
