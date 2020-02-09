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
        String[] inputDetails = handleInput(input);
        String typeOfTask = inputDetails[0];
        String detailOfTask = "";
        String dateTime = "";
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
            input = sc.nextLine();
            inputDetails = handleInput(input);
            typeOfTask = inputDetails[0];
        }
        //bye
        try {
            storage.saveTask(fileName, tasksSaved);
        } catch (FileNotFoundException error){
            System.out.println("no file to write to leh");
        }
        System.out.println("See you again NEVER!!");
    }

    public static String[] handleInput(String input){
        String[] task = input.split(" ", 2);
        String[] inputDetails = new String[3];
        inputDetails[0] = task[0];
        if (input.contains(" ")) {
            if (task[1].contains("/by ")){
                String[] taskDetails = task[1].split("/by ");
                inputDetails[1] = taskDetails[0];
                inputDetails[2] = taskDetails[1];
            } else if (task[1].contains("/at ")) {
                String[] taskDetails = task[1].split("/at ");
                inputDetails[1] = taskDetails[0];
                inputDetails[2] = taskDetails[1];
            } else {
                inputDetails[1] = task[1];
                inputDetails[2] = "date/ time not specific";
            }
        }
        return inputDetails;
    }



}
