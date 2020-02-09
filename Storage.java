import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {

    public String file;
    public ArrayList<String> tasksSaved;

    public Storage(String file, ArrayList<String> tasksSaved) {
        this.file = file;
        this.tasksSaved = tasksSaved;
    }

    public static ArrayList<String> copySavedTasks(String file) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        Scanner scanIn = new Scanner(fileInputStream);
        ArrayList<String> tasksSaved = new ArrayList<>();
        while (scanIn.hasNext()) {
            tasksSaved.add(scanIn.nextLine());
        }
        return tasksSaved;
    }

    public static ArrayList<Task> loadTask(String file) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        Scanner scanIn = new Scanner(fileInputStream);
        ArrayList<Task> listOfTasks = new ArrayList<>();
        while (scanIn.hasNext()){
            String savedTask = scanIn.nextLine();
            String[] splitTask = savedTask.split(" /", 0);
            String task = splitTask[0];
            switch (task) {
                case ("todo"):
                    Todo todo = new Todo(splitTask[0], splitTask[2], "");
                    todo.isDone = Boolean.parseBoolean(splitTask[1]);
                    listOfTasks.add(todo);
                    break;
                case ("deadline"):
                    Deadline deadline = new Deadline(splitTask[0], splitTask[2], splitTask[3]);
                    deadline.isDone = Boolean.parseBoolean(splitTask[1]);
                    listOfTasks.add(deadline);
                    break;
                case ("event"):
                    Event event = new Event(splitTask[0], splitTask[2], splitTask[3]);
                    event.isDone = Boolean.parseBoolean(splitTask[1]);
                    listOfTasks.add(event);
                    break;
            }

        }
        for (Task t : listOfTasks) {

        }
        return listOfTasks;

    }

    public static void saveTask(String file, ArrayList<String> tasksSaved) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        PrintWriter writer = new PrintWriter(fileOutputStream);
        for (String s : tasksSaved) {
            writer.println(s);
        }
        writer.close();
    }
}
