import java.util.ArrayList;

/**
 * Represents a parsed object
 * @author kerwei
 * @version 1.0
 */
public class Parser {

    String[] inputDetails;
    TaskList taskList;
    ArrayList<String> tasksSaved;

    public Parser(String[] inputDetails, TaskList taskList, ArrayList<String> tasksSaved){
        this.inputDetails = inputDetails;
        this.taskList = taskList;
        this.tasksSaved = tasksSaved;
    }

    /**
     * Parse the user input
     * @param inputDetails Array of user input
     * @param taskList List of tasks
     * @param tasksSaved List of tasks saved
     */
    public static String Parse(String[] inputDetails, TaskList taskList, ArrayList<String> tasksSaved) {
        String typeOfTask = inputDetails[0];
        String detailOfTask = "";
        String dateTime = "";
        String response = "";
        try {
            switch (typeOfTask) {
                case ("list"):
                    response = taskList.toString();
                    break;
                case ("todo"):
                    try{
                        if (inputDetails[1] == null) {
                            throw new NullPointerException("error");
                        } else {
                            detailOfTask = inputDetails[1];
                            Todo newTask = new Todo(typeOfTask, detailOfTask, "");
                            taskList.add(newTask);
                            tasksSaved.add(typeOfTask + " /" + newTask.isDone + " /" + detailOfTask + " / ");
                            //System.out.println("added: " + newTask);
                            response = ("added: " + newTask.toString());
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
                            taskList.add(newTask);
                            tasksSaved.add(typeOfTask + " /" + newTask.isDone + " /" + detailOfTask + "/" + dateTime);
                            //System.out.println("added: " + newTask);
                            response = ("added: " + newTask.toString());
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
                            taskList.add(newTask);
                            tasksSaved.add(typeOfTask + " /" + newTask.isDone + " /" + detailOfTask + "/" + dateTime);
                            //System.out.println("added: " + newTask);
                            response = ("added: " + newTask.toString());
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
                            Task currentTask = taskList.get(index);
                            currentTask.isDone = true;
                            tasksSaved.set(index, currentTask.type + " /" + currentTask.isDone + " /" +
                                    currentTask.description + " /" + currentTask.dateTime);
                            //System.out.println("Good job on getting this done!");
                            //System.out.println(currentTask);
                            response = ("Good job on getting this done!" + "\n" + currentTask.toString());
                        }
                    } catch (NullPointerException error){
                        throw new DukeException("type the correct task number you are done with la idiot");
                    }
                    break;
                case ("delete"):
                    try {
                        if (inputDetails[1] == null) {
                            throw new NullPointerException("error");
                        } else {
                            detailOfTask = inputDetails[1];
                            Task currentTask = taskList.get(Integer.parseInt(detailOfTask) - 1);
                            //System.out.println("alright bye bye task");
                            //System.out.println(currentTask);
                            response = ("alright bye bye task" + "\n" + currentTask.toString());
                            taskList.delete(Integer.parseInt(detailOfTask) - 1);
                            tasksSaved.remove(Integer.parseInt(detailOfTask) - 1);
                        }
                    } catch (NullPointerException error){
                        throw new DukeException("type the correct task you want to delete la idiot");
                    }
                    break;
                case ("find"):
                    detailOfTask = inputDetails[1];
                    //System.out.println("these are the matching tasks in your list:");
                    response = "these are the matching tasks in your list:";
                    taskList.find(detailOfTask);
                    break;
                case ("bye"):
                    response = "hope to see you again BYE BYEE!!";
                    break;
                default:
                    throw new DukeException("dont anyhow type la idiot");
            }
        } catch (DukeException error) {
            response = error.getMessage();
        }
        return response;
    }

    /**
     * Returns the type of task
     * @param inputDetails Array of user input
     * @return Type of task
     */
    public static String getTypeOfTask(String[] inputDetails){
        return inputDetails[0];
    }

}
