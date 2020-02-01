import java.util.Scanner;

public class Duke {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //greetings
        System.out.println("Harlo Sir, how may i help you?");

        //echo
        String input = sc.next();
        while(!input.equals("bye")) {
            System.out.println(input);
            input = sc.next();
        }

        //bye
        System.out.println("NOOOOOOOOO dont gooo :(");

    }

}
