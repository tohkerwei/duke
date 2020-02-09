import java.util.ArrayList;

public class Parser {

    String[] inputDetails;
    ArrayList<Task> listOfTasks;
    ArrayList<String> tasksSaved;

    public Parser(String[] inputDetails, ArrayList<Task> listOfTasks, ArrayList<String> tasksSaved){
        this.inputDetails = inputDetails;
        this.listOfTasks = listOfTasks;
        this.tasksSaved = tasksSaved;
    }

    public static void Parse(String[] inputDetails, ArrayList<Task> listOfTasks, ArrayList<String> tasksSaved) {
        String typeOfTask = inputDetails[0];
        String detailOfTask = "";
        String dateTime = "";
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
                            Todo newTask = new Todo(typeOfTask, detailOfTask, "");
                            listOfTasks.add(newTask);
                            tasksSaved.add(typeOfTask + " /" + newTask.isDone + " /" + detailOfTask + " / ");
                            System.out.println("added: " + newTask);
                        }
                    } catch (NullPointerException error){
                        throw new DukeException("need description for todo to be added la idiot");
                    }
                    break;
                case ("deadline"):
                    try {
                        if (inputDetails[1] == null || inputDetails[2] == null) {
                            throw new NullPointerException("error");
                        } else {
                            detailOfTask = inputDetails[1];
                            dateTime = inputDetails[2];
                            Deadline newTask = new Deadline(typeOfTask, detailOfTask, dateTime);
                            listOfTasks.add(newTask);
                            tasksSaved.add(typeOfTask + " /" + newTask.isDone + " /" + detailOfTask + "/" + dateTime);
                            System.out.println("added: " + newTask);
                        }
                    } catch (NullPointerException error){
                        throw new DukeException("need description and date/ time for deadline to be added la idiot");
                    }
                    break;
                case ("event"):
                    try {
                        if (inputDetails[1] == null || inputDetails[2] == null) {
                            throw new NullPointerException("error");
                        } else {
                            detailOfTask = inputDetails[1];
                            dateTime = inputDetails[2];
                            Event newTask = new Event(typeOfTask, detailOfTask, dateTime);
                            listOfTasks.add(newTask);
                            tasksSaved.add(typeOfTask + " /" + newTask.isDone + " /" + detailOfTask + "/" + dateTime);
                            System.out.println("added: " + newTask);
                        }
                    } catch (NullPointerException error){
                        throw new DukeException("need description and date/ time for event to be added la idiot");
                    }
                    break;
                case ("done"):
                    try {
                        if (inputDetails[1] == null) {
                            throw new NullPointerException("error");
                        } else {
                            detailOfTask = inputDetails[1];
                            int index = Integer.parseInt(detailOfTask) - 1;
                            Task currentTask = listOfTasks.get(index);
                            currentTask.isDone = true;
                            tasksSaved.set(index, currentTask.type + " /" + currentTask.isDone + " /" +
                                    currentTask.description + "/" + currentTask.dateTime);
                            System.out.println("Good job on getting this done!");
                            System.out.println(currentTask);
                        }
                    } catch (NullPointerException error){
                        throw new DukeException("which task are you done with idiot");
                    }
                    break;
                case ("delete"):
                    try {
                        if (inputDetails[1] == null) {
                            throw new NullPointerException("error");
                        } else {
                            detailOfTask = inputDetails[1];
                            Task currentTask = listOfTasks.get(Integer.parseInt(detailOfTask) - 1);
                            System.out.println("alright bye bye task");
                            System.out.println(currentTask);
                            listOfTasks.remove(Integer.parseInt(detailOfTask) - 1);
                            tasksSaved.remove(Integer.parseInt(detailOfTask) - 1);
                        }
                    } catch (NullPointerException error){
                        throw new DukeException("which task do you want to delete idiot");
                    }
                    break;
                default:
                    throw new DukeException("dont anyhow type la idiot");
            }
        } catch (DukeException error) {
            System.out.println(error);
        }
    }

    public static String getTypeOfTask(String[] inputDetails){
        return inputDetails[0];
    }

}
