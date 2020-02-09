public class UI {

    String input;

    public UI(String input) {
        this.input = input;
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
