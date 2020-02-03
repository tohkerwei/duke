public class Event extends Task {

    public Event(String type, String description, String dateTime){
        super(type, description,dateTime);
    }

    @Override
    public String toString(){
        return "[E]" + super.toString() + " (at: " + dateTime + ")";
    }
}
