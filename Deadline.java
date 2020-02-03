public class Deadline extends Task {

    public Deadline(String type, String description, String dateTime){
        super(type, description, dateTime);
    }

    @Override
    public String toString(){
        return "[D]" + super.toString() + " (by: " + dateTime + ")";
    }
}
