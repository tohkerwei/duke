import com.sun.source.util.TaskListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

/**
 * Represents a Duke task manager
 * @author kerwei
 * @version 1.0
 */
public class Duke {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> list = new ArrayList<>();
        TaskList taskList = new TaskList(list);
        ArrayList<String> tasksSaved = new ArrayList<>();
        String fileName = "/Users/kerwei/Desktop/Jessica/src/main/tasks/task.txt";
        Storage storage = new Storage(fileName, tasksSaved);

        //greetings
        System.out.println("Harlo Sir, how may i help you?");

        //read in saved tasks
        try {
            taskList.printTask();
            taskList = storage.loadTask(fileName);
            tasksSaved = storage.copySavedTasks(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("no such file la idiot");
        }
        //echo
        String input = sc.nextLine();
        UI ui = new UI(input);
        String[] inputDetails = ui.handleInput(input);
        Parser parser = new Parser(inputDetails, taskList, tasksSaved);

        while (true) {
            parser.Parse(inputDetails, taskList, tasksSaved);
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
