import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //greetings
        System.out.println("Harlo Sir, how may i help you?");

        //echo
        ArrayList<Task> listOfTasks = new ArrayList<>();
        String input = sc.nextLine();
        String[] inputDetails = handleInput(input);
        String typeOfTask = inputDetails[0];
        String detailOfTask = "";
        String dateTime = "";
        Task newTask = new Task(typeOfTask);

        while (!typeOfTask.equals("bye")) {
            switch (typeOfTask) {
                case ("list"):
                    int i = 1;
                    for (Task t : listOfTasks) {
                        System.out.println(i + ". " + t);
                        i++;
                    }
                    break;
                case ("todo"):
                    detailOfTask = inputDetails[1];
                    newTask = new Todo(detailOfTask, dateTime);
                    listOfTasks.add(newTask);
                    System.out.println("added: " + newTask);
                    break;
                case ("deadline"):
                    detailOfTask = inputDetails[1];
                    dateTime = inputDetails[2];
                    newTask = new Deadline(detailOfTask, dateTime);
                    listOfTasks.add(newTask);
                    System.out.println("added: " + newTask);
                    break;
                case ("event"):
                    detailOfTask = inputDetails[1];
                    dateTime = inputDetails[2];
                    newTask = new Event(detailOfTask, dateTime);
                    listOfTasks.add(newTask);
                    System.out.println("added: " + newTask);
                    break;
                case ("done"):
                    detailOfTask = inputDetails[1];
                    Task currentTask = listOfTasks.get(Integer.parseInt(detailOfTask) - 1);
                    currentTask.isDone = true;
                    System.out.println("Good job on getting this done!");
                    System.out.println(currentTask);
                default:
                    break;

            }
            input = sc.nextLine();
            inputDetails = handleInput(input);
            typeOfTask = inputDetails[0];

        }
        System.out.println("bye bye :(");

    }

    public static String[] handleInput(String input){
        String[] task = input.split(" ", 2);
        String[] inputDetails = new String[] {task[0], "", ""};
        if (input.contains(" ")) {
            String[] taskDetails = task[1].split("/");
            inputDetails[1] = taskDetails[0];
            if (task[1].contains("/")){
                inputDetails[2] = taskDetails[1];
            }
        }
        return inputDetails;
    }
}
