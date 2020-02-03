public class Todo extends Task {

    public Todo(String type, String description, String dateTime) {
        super(type, description, dateTime);
    }

    @Override
    public String toString(){
        return "[T]" + super.toString();
    }
}
