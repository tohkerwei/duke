import java.util.ArrayList;

public class TaskList {
    public static ArrayList<Task> taskList;

    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public static void add(Task task) {
        taskList.add(task);
    }

    public static void delete(int index) {
        taskList.remove(index);
    }

    public static Task get(int index) {
        return taskList.get(index);
    }

    public static void printTask(){
        int i = 1;
        for (Task t : taskList) {
            System.out.println(i + "." + t);
            i++;
        }
    }

}
