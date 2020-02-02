import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Duke {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();

        //greetings
        System.out.println("Harlo Sir, how may i help you?");

        //echo
        Task input = new Task(sc.nextLine());

        while (!input.description.equals("bye")) {
            if (input.description.equals("list")){
                int i = 1;
                for (Task task : tasks) {
                    System.out.println(i + ". " + task);
                    i++;
                }
            } else if(input.description.contains("done")){
                String[] strArray = input.description.split(" ");
                int index = Integer.parseInt(strArray[1]) -1;
                Task task = tasks.get(index);
                task.isDone = true;
                System.out.println("Good job on getting this done!");
                System.out.println(task);
            } else {
                tasks.add(input);
                System.out.println("added: " + input.description);
            }
            input = new Task(sc.nextLine());
        }

        //bye
        System.out.println("NOOOOOOOOO dont gooo :(");

    }

}
