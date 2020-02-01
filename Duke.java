import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Duke {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<String> inputs = new ArrayList<>();

        //greetings
        System.out.println("Harlo Sir, how may i help you?");

        //echo
        String input = sc.next();
        while (!input.equals("bye")) {
            if (input.equals("list")){
                int i = 1;
                for (String ip : inputs) {
                    System.out.println(i + ". " + ip);
                    i++;
                }
            } else {
                inputs.add(input);
                System.out.println("added: " + input);
            }
            input = sc.next();
        }

        //bye
        System.out.println("NOOOOOOOOO dont gooo :(");

    }

}
