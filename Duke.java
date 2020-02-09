import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class Duke {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> listOfTasks = new ArrayList<>();
        ArrayList<String> tasksSaved = new ArrayList<>();
        String fileName = "/Users/kerwei/Desktop/Jessica/src/main/tasks/task.txt";
        Storage storage = new Storage(fileName, tasksSaved);

        //greetings
        System.out.println("Harlo Sir, how may i help you?");

        //read in saved tasks
        try {
            listOfTasks = storage.loadTask(fileName);
            tasksSaved = storage.copySavedTasks(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("no such file la idiot");
        }
        //echo
        String input = sc.nextLine();
        UI ui = new UI(input);
        String[] inputDetails = ui.handleInput(input);
        Parser parser = new Parser(inputDetails, listOfTasks, tasksSaved);

        while (true) {
            parser.Parse(inputDetails, listOfTasks, tasksSaved);
            input = sc.nextLine();
            inputDetails = ui.handleInput(input);
            if (inputDetails[0].equals("bye")){
                break;
            }
        }

        //save task
        try {
            storage.saveTask(fileName, tasksSaved);
        } catch (FileNotFoundException error){
            System.out.println("no file to write to leh");
        }
        System.out.println("See you again NEVER!!");
    }

}
