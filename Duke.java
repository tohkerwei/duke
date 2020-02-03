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
            try {
                switch (typeOfTask) {
                    case ("list"):
                        int i = 1;
                        for (Task t : listOfTasks) {
                            System.out.println(i + ". " + t);
                            i++;
                        }
                        break;
                    case ("todo"):
                        try{
                            if (inputDetails[1] == null) {
                                throw new NullPointerException("error");
                            } else {
                                detailOfTask = inputDetails[1];
                                newTask = new Todo(detailOfTask, dateTime);
                                listOfTasks.add(newTask);
                                System.out.println("added: " + newTask);
                            }
                        } catch (NullPointerException error){
                            throw new DukeException("need description for todo to be added la idiot");
                        }
                        break;
                    case ("deadline"):
                        try {
                            if (inputDetails[1] == null) {
                                throw new NullPointerException("error");
                            } else {
                                detailOfTask = inputDetails[1];
                                dateTime = inputDetails[2];
                                newTask = new Deadline(detailOfTask, dateTime);
                                listOfTasks.add(newTask);
                                System.out.println("added: " + newTask);
                            }
                        } catch (NullPointerException error){
                            throw new DukeException("need description for deadline to be added la idiot");
                        }
                        break;
                    case ("event"):
                        try {
                            if (inputDetails[1] == null) {
                                throw new NullPointerException("error");
                            } else {
                                detailOfTask = inputDetails[1];
                                dateTime = inputDetails[2];
                                newTask = new Event(detailOfTask, dateTime);
                                listOfTasks.add(newTask);
                                System.out.println("added: " + newTask);
                            }
                        } catch (NullPointerException error){
                            throw new DukeException("need description for event to be added la idiot");
                        }
                        break;
                    case ("done"):
                        detailOfTask = inputDetails[1];
                        Task currentTask = listOfTasks.get(Integer.parseInt(detailOfTask) - 1);
                        currentTask.isDone = true;
                        System.out.println("Good job on getting this done!");
                        System.out.println(currentTask);
                        break;
                    default:
                        throw new DukeException("dont anyhow type la idiot");
            }
            } catch (DukeException error) {
                    System.out.println(error);
            }
            input = sc.nextLine();
            inputDetails = handleInput(input);
            typeOfTask = inputDetails[0];
        }
        //bye
        System.out.println("See you again NEVER!!");
    }

    public static String[] handleInput(String input){
        String[] task = input.split(" ", 2);
        String[] inputDetails = new String[3];
        inputDetails[0] = task[0];
        if (input.contains(" ")) {
            String[] taskDetails = task[1].split("/");
            inputDetails[1] = taskDetails[0];
            if (task[1].contains("/")){
                inputDetails[2] = taskDetails[1];
            } else {
                inputDetails[2] = "date/ time not specific";
            }
        }
        return inputDetails;
    }
}
